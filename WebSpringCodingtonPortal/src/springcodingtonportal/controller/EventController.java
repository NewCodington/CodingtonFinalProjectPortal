package springcodingtonportal.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
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
import springcodingtonportal.model.domain.Visitor;
import springcodingtonportal.model.services.EventServiceJDBC;
import springcodingtonportal.model.services.PlaceServiceJDBC;
import springcodingtonportal.model.services.VisitorServiceJDBC;
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
		
	
	
	@RequestMapping("/registerEvent.htm")
	public ModelAndView registerEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		
		ModelAndView mv = load(request,response);
		
		if(eventService.insertEvent(event) > 0){
			mv.addObject("RegisterMessage", "¡¡¡  Successfully EVENT created  !!!");
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
		request.setAttribute("update", idEventU);
		
		return loadEvent(request, response, idEventU);		
	}
	
	
	
	@RequestMapping("/updateEvent.htm")
	public ModelAndView updateVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		EventServiceJDBC eventService =  (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		Event event=new Event();
		
		event.setEventId(idEventU);
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
		
		return mv;
	}
	
	
	
	
	private ModelAndView load(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		List<Place> placesList=null;
		List<Event> eventsList=null;
		
		EventServiceJDBC eventService 		= (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		PlaceServiceJDBC placeService 		= (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		
		
		eventsList = eventService.viewEvent();
		session.setAttribute("EVENTLIST", eventsList);
		
		placesList = placeService.viewPlace();
		session.setAttribute("PLACELIST", placesList);

		return new ModelAndView("/profileAdmin.jsp");
	}
	
	
	
	private ModelAndView loadEvent(HttpServletRequest request, HttpServletResponse response, Integer idEvent) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		EventServiceJDBC eventService =  (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		Event event=new Event();

		event.setEventId(idEvent);
		Event eventUpdate=new Event(eventService.selectEvent(event));
		
		request.setAttribute("EVENT", eventUpdate);
		
		return new ModelAndView("/updateEvent.jsp");	
	}
}
