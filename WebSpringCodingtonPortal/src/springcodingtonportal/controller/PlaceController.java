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
import springcodingtonportal.model.domain.TypePlace;
import springcodingtonportal.model.services.EventServiceJDBC;
import springcodingtonportal.model.services.PlaceServiceJDBC;
import springcodingtonportal.model.services.TypePlaceServiceJDBC;
import springcodingtonportal.utils.Exceptions;

/**
 * 	Place controller handles all the place related transactions
 *  with the data classes. 
 */
@Controller
public class PlaceController {
	@Autowired
	private ApplicationContext appContext;
	
	private static Logger log = Logger.getLogger(PlaceController.class);


	/**
	 * jsp call this function by the name "registerPlace.htm". If the request or response is null, it sends an exception.
	 * If they are non null, a list of existing type of place is taken from the database and adds to the form to create a new place.
	 * @param request
	 * @param response
	 * @return ModelAndView("/registerPlace.jsp");
	 * @throws Exception
	 */
	@RequestMapping("/registerPlace.htm")
	public ModelAndView regisertPlace(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTER METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		List<TypePlace> typesPlaceList=null;
		TypePlaceServiceJDBC placeService = (TypePlaceServiceJDBC) appContext.getBean("TypePlaceServiceJDBC");
				
		typesPlaceList = placeService.viewTypePlace();
		request.setAttribute("LISTTYPEPLACE", typesPlaceList);

		return new ModelAndView("/registerPlace.jsp");
	}
	
	/**
	 * jsp call this function by the name "registPlace.htm". If the request or response is null, it sends an exception.
	 * Else a new place is created and inserted into the place list existing.
	 * @param request
	 * @param response
	 * @return load(request, response);
	 * @throws Exception
	 */
	@RequestMapping("/registPlace.htm")
	public ModelAndView registPlace(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENT METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		PlaceServiceJDBC placeService = (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		Place place=new Place();

		place.setName(request.getParameter("placeName"));
		place.setDescription(request.getParameter("description"));		
		//place.setImage(request.getParameter("image"));
		place.setAddress(request.getParameter("address"));
		place.setTypePlace(Integer.parseInt(request.getParameter("typePlace")));
		

		boolean success = false;
		if(placeService.insertPlace(place) > 0){
			success = true;
		}
		
		ModelAndView mv = load(request, response);
		if(success) {
			 mv.addObject("UpdateMessage", "¡¡¡  Successfully PLACE created  !!!");
		}
		
		return mv;
	}
	
	
	
	
	/**
	 * jsp call this function by the name "deletePlace.htm". If the request or response is null, it sends an exception.
	 * It is used to remove an existing place from the database.
	 * @param request
	 * @param response
	 * @param idPlace
	 * @return load(request, response);
	 * @throws Exception
	 */
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
	
	/**
	 * jsp call this function by the name "updatePlace.htm". If the request or response is null, it sends an exception.
	 * It is used to update an existing event from the database.
	 * @param request
	 * @param response
	 * @return load(request, response);
	 * @throws Exception
	 */
	@RequestMapping("/updatePlace.htm")
	public ModelAndView updatePlace(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		PlaceServiceJDBC placeService = (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		Place place=new Place();

		place.setIdPlace(Integer.parseInt(session.getAttribute("idPlace").toString()));
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
		
		session.removeAttribute("idPlace");
		
		return mv;
	}
	

	/**
	 * jsp call this function by the name "getPlace.htm". If the request or response is null, it sends an exception.
	 * It is used to show the place list existing in the database
	 * @param request
	 * @param response
	 * @param idPlace
	 * @return loadPlace(request, response,idPlace);
	 * @throws Exception
	 */
	@RequestMapping("/getPlace.htm")
	public ModelAndView getPlace(HttpServletRequest request, HttpServletResponse response, @RequestParam("update") Integer idPlace) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		return loadPlace(request, response,idPlace);
	}
	
	
	/**
	 * This function gets the data from the database related to place and TypePlace and reload the page "updatePlace"
	 * @param request
	 * @param response
	 * @param idPlace
	 * @return ModelAndView("/updatePlace.jsp");
	 * @throws Exception
	 */
	private ModelAndView loadPlace(HttpServletRequest request, HttpServletResponse response,Integer idPlace) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		TypePlaceServiceJDBC typeplaceService =  (TypePlaceServiceJDBC) appContext.getBean("TypePlaceServiceJDBC");
		PlaceServiceJDBC placeService =  (PlaceServiceJDBC) appContext.getBean("PlaceServiceJDBC");
		Place place=new Place();

		place.setIdPlace(idPlace);
		Place placeUpdate=new Place(placeService.selectPlace(place));
		List<TypePlace> listTypePlace = typeplaceService.viewTypePlace();
		
		request.setAttribute("LISTTYPEPLACE", listTypePlace);
		request.setAttribute("idPlace", placeUpdate.getIdPlace());
		request.setAttribute("PLACE", placeUpdate);
		
		return new ModelAndView("/updatePlace.jsp");	
	}

	/**
	 * This function gets the data from the database related to events and place and reload the page "profileAdmin"
	 * @param request
	 * @param response
	 * @return ModelAndView("/profileAdmin.jsp");
	 * @throws Exception
	 */
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


}
