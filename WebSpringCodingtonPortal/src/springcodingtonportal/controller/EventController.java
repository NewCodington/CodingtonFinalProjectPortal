package springcodingtonportal.controller;


import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springcodingtonportal.model.domain.Place;
import springcodingtonportal.model.domain.Event;
import springcodingtonportal.model.services.EventServiceJDBC;
import springcodingtonportal.model.services.PlaceServiceJDBC;
import springcodingtonportal.utils.Constants;
import springcodingtonportal.utils.Exceptions;


@Controller
public class EventController {
	@Autowired
	private ApplicationContext appContext;
	
	private static Logger log = Logger.getLogger(EventController.class);
	
	
	
	
	@RequestMapping("/profileAdmin.htm")
	public ModelAndView profileAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENT METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
	
		return load(request, response);
	}
		
	
	
	
	
	@RequestMapping("/eventsForPlace.htm")
	public ModelAndView eventsForPlace(HttpServletRequest request, HttpServletResponse response, @RequestParam("typePlace") Integer typePlace) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for LISTEVENT FOR PLACE METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
	
		List<Event> eventList=null;
		EventServiceJDBC eventService =  (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		Constants constants =  (Constants) appContext.getBean("beanCONSTANTS");
		
		eventList = eventService.eventForPlace(typePlace);
		request.setAttribute("EVENTLIST", eventList);
		
		if (typePlace == constants.getBUSSINES()) {
			return new ModelAndView("/business.jsp");
		}
		else if (typePlace == constants.getMARKET()) {
			return new ModelAndView("/market.jsp");
		}
		else if (typePlace == constants.getMUSEUM()) {
			return new ModelAndView("/museum.jsp");
		}
		else if (typePlace == constants.getPARK()) {
			return new ModelAndView("/park.jsp");
		}
		else if (typePlace == constants.getSTADIUM()) {
			return new ModelAndView("/stadium.jsp");
		}
		else if (typePlace == constants.getTHEATER()) {
			return new ModelAndView("/theater.jsp");
		}
		else if (typePlace == constants.getTOURISM()) {
			return new ModelAndView("/tourism.jsp");
		}
		else if (typePlace == constants.getZOO()) {
			return new ModelAndView("/zoo.jsp");
		}
		
		return new ModelAndView("/events.jsp");	
	}
	
	
	
	
	
	@RequestMapping("/registerEvent.htm")
	public ModelAndView registerEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTER METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		List<Place> placesList=null;
		PlaceServiceJDBC placeService = (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
				
		placesList = placeService.viewPlace();
		request.setAttribute("LISTPLACE", placesList);

		return new ModelAndView("/registerEvent.jsp");
	}
	
	
	@RequestMapping("/registEvent.htm")
	public ModelAndView registEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENT METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		Event event=new Event();
		
		EventServiceJDBC eventService =  (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		
		event.setName(request.getParameter("eventName"));
		event.setDescription(request.getParameter("description"));
		event.setPlace(Integer.parseInt(request.getParameter("place")));
	
		SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dateInput = null;
		dateInput = originalFormat.parse(request.getParameter("date").toString());
		   
		event.setDate_event(dateInput);
		event.setStartTime(request.getParameter("startTime"));
		event.setDuration(request.getParameter("duration"));
		event.setEventType(request.getParameter("typeOfEvent"));
		event.setSeatsAvailable(Integer.parseInt(request.getParameter("seats")));
				
		boolean success = false;
		if(eventService.insertEvent(event) > 0){
			success  = true;
		}
		
		ModelAndView mv = load(request, response);
		if(success) {
			 mv.addObject("UpdateMessage", "¡¡¡  Successfully EVENT updated  !!!");
		}
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping("/getEvent.htm")
	public ModelAndView updateEvent(HttpServletRequest request, HttpServletResponse response, @RequestParam("update") Integer idEventU) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENT METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		return loadEvent(request, response, idEventU);		
	}
	
	
	@RequestMapping("/updateEvent.htm")
	public ModelAndView updateVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		EventServiceJDBC eventService =  (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		Event event=new Event();
		
		event.setEventId(Integer.parseInt(session.getAttribute("idEvent").toString()));
		event.setName(request.getParameter("eventName"));
		event.setDescription(request.getParameter("description"));
		event.setPlace(Integer.parseInt(request.getParameter("place")));
	
		SimpleDateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dateInput = null;
		dateInput = originalFormat.parse(request.getParameter("date").toString());
	    event.setDate_event(dateInput);
		event.setStartTime(request.getParameter("startTime"));
		event.setDuration(request.getParameter("duration"));
		event.setEventType(request.getParameter("typeOfEvent"));
		event.setSeatsAvailable(Integer.parseInt(request.getParameter("seats")));

		boolean success = false;
		if(eventService.updateEvent(event) > 0){
			success = true;
		}
		
		ModelAndView mv = load(request, response);
		if(success) {
			 mv.addObject("UpdateMessage", "¡¡¡  Successfully EVENT updated  !!!");
		}
		
		session.removeAttribute("idEvent");
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping("/deleteEvent.htm")
	public ModelAndView unregisterEventVisitor(HttpServletRequest request, HttpServletResponse response, @RequestParam("delete") Integer idEvent) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		EventServiceJDBC event 	= (EventServiceJDBC) appContext.getBean("EventServiceJDBC");

		boolean success = false;
		if(event.deleteEvent(idEvent) != null) {
			success = true;
		}
		
		ModelAndView mv = load(request, response);
		if(success) {
			 mv.addObject("DeleteMessage", "¡¡¡  Succesfully Delete  EVENT  !!!");
		}
		
	 return mv;
	
	}
	
	
	
	
	
	private ModelAndView load(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		List<Place> placesList=null;
		List<Event> eventsList=null;
		
		EventServiceJDBC eventService 		= (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		PlaceServiceJDBC placeService 		= (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		
		
		eventsList = eventService.viewEvent();
		request.setAttribute("EVENTLIST", eventsList);
		
		placesList = placeService.viewPlace();
		request.setAttribute("PLACELIST", placesList);

		return new ModelAndView("/profileAdmin.jsp");
	}
	
	

	
	private ModelAndView loadEvent(HttpServletRequest request, HttpServletResponse response, Integer idEvent) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		EventServiceJDBC eventService =  (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		PlaceServiceJDBC placeService =  (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		Event event=new Event();

		event.setEventId(idEvent);
		Event eventUpdate=new Event(eventService.selectEvent(event));
		
		List<Place> listPlace = placeService.viewPlace();
		
		request.setAttribute("idEvent", idEvent);
		request.setAttribute("EVENT", eventUpdate);
		request.setAttribute("LISTPLACE", listPlace);
		
		return new ModelAndView("/updateEvent.jsp");	
	}
	
}
