package springcodingtonportal.controller;

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

import springcodingtonportal.model.domain.Event;
import springcodingtonportal.model.domain.Place;
import springcodingtonportal.model.domain.Visitor;
import springcodingtonportal.model.services.EventServiceJDBC;
import springcodingtonportal.model.services.PlaceServiceJDBC;
import springcodingtonportal.model.services.VisitorServiceJDBC;
import springcodingtonportal.utils.Exceptions;


@Controller
public class PlaceController {
	@Autowired
	private ApplicationContext appContext;
	
	private static Logger log = Logger.getLogger(PlaceController.class);



	@RequestMapping("/deletePlace.htm")
	public ModelAndView deletePlace(HttpServletRequest request, HttpServletResponse response, @RequestParam("delete") Integer idPlace) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		PlaceServiceJDBC place 	= (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		
		
		
		boolean success = false;
		if(place.deletePlace(idPlace) != null) {
			success = true;
		}
		
		ModelAndView mv =load(request, response);
		if(success) {
			 mv.addObject("DeleteMessage", "¡¡¡  Succesfully Delete  PLACE  !!!");
		}
		
	 return  mv;
	
	}
	
	
	@RequestMapping("/updatePlace.htm")
	public ModelAndView updatePlace(HttpServletRequest request, HttpServletResponse response, @RequestParam("update") Integer idPlace) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		PlaceServiceJDBC placeService	= (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		Place place=new Place();

		place.setIdPlace(idPlace);
		place.setName(request.getParameter("placeName"));
		place.setDescription(request.getParameter("description"));		
		//place.setImage(request.getParameter("image"));
		place.setAddress(request.getParameter("address"));
		place.setTypePlace(Integer.parseInt(request.getParameter("typePlace")));
		

		boolean success = false;
		if(placeService.updatePlace(place) > 0){
			success = true;
		}
		
		ModelAndView mv = load(request, response);
		if(success) {
			 mv.addObject("UpdateMessage", "¡¡¡  Successfully PLACE updated  !!!");
		}
		
		return mv;
	}
	
	
	
	private ModelAndView loadPlace(HttpServletRequest request, HttpServletResponse response,Integer idPlace) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		
		PlaceServiceJDBC placeService =  (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		Place place=new Place();

		place.setIdPlace(idPlace);
		Place placeUpdate=new Place(placeService.selectPlace(place));
		
		request.setAttribute("PLACE", placeUpdate);
		
		return new ModelAndView("/updatePlace.jsp");	
	}
	
	
	
	@RequestMapping("/getPlace.htm")
	public ModelAndView getPlace(HttpServletRequest request, HttpServletResponse response, @RequestParam("update") Integer idPlace) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		
		
		
		return loadPlace(request, response,idPlace);
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


}
