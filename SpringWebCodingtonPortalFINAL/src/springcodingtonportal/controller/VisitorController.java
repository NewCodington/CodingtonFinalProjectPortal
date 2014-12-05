package springcodingtonportal.controller;

import java.util.ArrayList;
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
import springcodingtonportal.model.domain.EventSign;
import springcodingtonportal.model.domain.Visitor;
import springcodingtonportal.model.services.EventServiceJDBC;
import springcodingtonportal.model.services.EventSignUpServiceJDBC;
import springcodingtonportal.model.services.VisitorServiceJDBC;
import springcodingtonportal.utils.Exceptions;

/**
 * 	Visitor controller handles all the visitor related transactions
 *  with the data classes and triggered by visitormain.jsp 
 */

@Controller
public class VisitorController {
	@Autowired
	private ApplicationContext appContext;
	
	private static Logger log = Logger.getLogger(VisitorController.class);
	
	/**
	 * Method will register new Visitor into FERS system by accepting registration details and load into database.
	 * jsp call this function by the name "login.htm". If the request or response is null, it sends an exception.
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws Exception
	 */	
	@RequestMapping("/login.htm")
	public ModelAndView loginVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for LOGINVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		Visitor v = new Visitor();
		Visitor visitor = null;
		
		v.setUserName(request.getParameter("username"));
		v.setPassword(request.getParameter("password"));
		
		log.info("Login visitor with UserName :"+v.getUserName());
		
		VisitorServiceJDBC visitorService =  (VisitorServiceJDBC) appContext.getBean("VisitorServiceJDBC");

		visitor = visitorService.loginVisitor(v);
		
		ModelAndView mv=new ModelAndView();
		
		if(visitor != null)
		{
			session.setAttribute("appContext", appContext);
			if(visitorService.isAdmin(visitor)){
				
				session.setAttribute("idAdmin", visitor.getIdVisitor());
				session.setAttribute("Admin", visitor.getUserName());
				
				log.info("Succesfully login Administrator "+ visitor.getUserName());
				mv.setViewName("/profileAdmin.htm");
				return mv;
			}
			else {
				session.setAttribute("idVisitor", visitor.getIdVisitor());
				session.setAttribute("Visitor", visitor.getUserName());
				
				log.info("Succesfully login visitor "+ visitor.getUserName());
				
				session.setAttribute("VISITOR", visitor);
				
				return loadEvents(request, response);
			}
		}
		else
		{
			mv.addObject("VisitorLoginMessage", "¡¡¡  USERNAME and PASSWORD incorrect  !!!");
			log.info("Username "+v.getUserName()+" or PASSWORD incorrect ...");
			
			mv.setViewName("/login.jsp");
			return mv;
		}		
	}
	
	
	
	/**
	 * jsp call this function by the name "registerVisitor.htm". If the request or response is null, it sends an exception.
	 * If they are non null, a new visitor is created and added to the database.
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/registerVisitor.htm")
	public ModelAndView registerVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for LOGINVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		Visitor visitor=new Visitor();
		VisitorServiceJDBC visitorService =  (VisitorServiceJDBC) appContext.getBean("VisitorServiceJDBC");
		
		visitor.setUserName(request.getParameter("uname"));
		visitor.setFirstName(request.getParameter("fname"));
		visitor.setLastName(request.getParameter("lname"));
		visitor.setPassword(request.getParameter("pass"));
		visitor.setEmail(request.getParameter("email"));
		visitor.setDni(request.getParameter("dni"));
		visitor.setPhoneNumber(request.getParameter("phone"));
		visitor.setAddress(request.getParameter("adress"));
		visitor.setAdmin(false);
		
		ModelAndView mv=new ModelAndView();
		
		if((visitorService.exitsUsernameVisitor(visitor)) != -1) {
			request.setAttribute("VisitorInfo", visitor);
			
			mv.addObject("RegisterVisitorError", "¡¡¡ USERNAME already exists !!!");
			mv.setViewName("/registerVisitor.jsp");
			return mv;
		}
		else {
			if(visitorService.insertVisitor(visitor) > 0){
				mv.addObject("RegisterVisitorMessage", "¡¡¡ Successfully VISITOR created !!!");
				mv.setViewName("/login.jsp");
			}
			return mv;
		}
	}
	
	
	/**
	 * jsp call this function by the name "profileVisitor.htm". If the request or response is null, it sends an exception.
	 * @param request
	 * @param response
	 * @return loadEvents(request, response)
	 * @throws Exception
	 */
	@RequestMapping("/profileVisitor.htm")
	public ModelAndView profileVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		return loadEvents(request, response);
	}
		
		
		
	/**
	 * jsp call this function by the name "searchEvents.htm". If the request or response is null, it sends an exception.
	 * If they are non null, the event list and the eventSignUp list are taken from the database and display on "profileVisitor.jsp"
	 * @param request
	 * @param response
	 * @param nameEvent
	 * @return return new ModelAndView("/profileVisitor.jsp");
	 * @throws Exception
	 */	
	@RequestMapping("/searchEvents.htm")
	public ModelAndView searchEvent(HttpServletRequest request, HttpServletResponse response, @RequestParam("search") String nameEvent) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for SEARCHEVENT METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		EventServiceJDBC eventService =  (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		List<Event> eventsList = null;
		
		
		eventsList = eventService.searchEvent(nameEvent);
		
		request.setAttribute("EVENTLIST", eventsList);
		
		return new ModelAndView("/search.jsp");	
	
	}
	
	
	/**
	 * jsp call this function by the name "registerEventForVisitor.htm". If the request or response is null, it sends an exception.
	 * If they are non null, the eventSignUp list is taken from the database to check if a visitor is registered in an event to make logging.
	 * @param request
	 * @param response
	 * @param idEventR
	 * @return ModelAndView
	 * @throws Exception
	 */	
	@RequestMapping("/registerEventForVisitor.htm")
	public ModelAndView registerEventVisitor(HttpServletRequest request, HttpServletResponse response, @RequestParam("register") Integer idEventR) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		EventSignUpServiceJDBC eventSignUp 	= (EventSignUpServiceJDBC) appContext.getBean("EventSignUpServiceJDBC");
		
		Integer idVisitor = Integer.parseInt(session.getAttribute("idVisitor").toString());
		
		boolean success = false;
		
		if(eventSignUp.registerForNewEvent(idVisitor, idEventR) != null) {
			success = true;
		}
		
		ModelAndView mv = loadEvents(request, response);
		if(success) {
			 mv.addObject("VisitorRegisterEventMessage", "¡¡¡  Succesfully registered in this EVENT  !!!");
		}
		else {
			mv.addObject("VisitorRegisterEventError", "¡¡¡  You're already registered in this EVENT  !!!");
		}
		
		return mv;
	}
	
		
	
	/**
	 * jsp call this function by the name "unregisterEventForVisitor.htm". If the request or response is null, it sends an exception.
	 * If they are non null, the eventSignUp list is taken from the database to check if a visitor is registered in an event to unregister.
	 * @param request
	 * @param response
	 * @param idEventR
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/unregisterEventForVisitor.htm")
	public ModelAndView unregisterEventVisitor(HttpServletRequest request, HttpServletResponse response, @RequestParam("unregister") Integer idEventR) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		EventSignUpServiceJDBC eventSignUp 	= (EventSignUpServiceJDBC) appContext.getBean("EventSignUpServiceJDBC");
		
		Integer idVisitor = Integer.parseInt(session.getAttribute("idVisitor").toString());
		
		boolean success = false;
		if(eventSignUp.unregisterForEvent(idVisitor, idEventR) != null) {
			success = true;
		}
		
		ModelAndView mv = loadEvents(request, response);
		if(success) {
			 mv.addObject("VisitorRegisterEventMessage", "¡¡¡  Succesfully unregistered in this EVENT  !!!");
		}
		
		return mv;
	
	}
	
	
	/**
	 * jsp call this function by the name "getVisitor.htm". If the request or response is null, it sends an exception.
	 * It is used to show the visitor list existing in the database.
	 * @param request
	 * @param response
	 * @return loadVisitor(request, response)
	 * @throws Exception
	 */
	@RequestMapping("/getVisitor.htm")
	public ModelAndView getVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		return loadVisitor(request, response);
	}
	
	
	/**
	 * jsp call this function by the name "updateVisitor.htm". If the request or response is null, it sends an exception.
	 * It is used to update an existing visitor from the database.
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/updateVisitor.htm")
	public ModelAndView updateVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		Visitor visitor=new Visitor();
		VisitorServiceJDBC visitorService =  (VisitorServiceJDBC) appContext.getBean("VisitorServiceJDBC");
		
		visitor.setIdVisitor(Integer.parseInt(session.getAttribute("idVisitor").toString()));
		visitor.setFirstName(request.getParameter("fname"));
		visitor.setLastName(request.getParameter("lname"));
		visitor.setEmail(request.getParameter("email"));
		visitor.setDni(request.getParameter("dni"));
		visitor.setPhoneNumber(request.getParameter("phone"));
		visitor.setAddress(request.getParameter("adress"));
		visitor.setAdmin(false);
		
		boolean success = false;
		if(visitorService.updateVisitor(visitor) > 0){
			success = true;
		}
		
		ModelAndView mv = loadEvents(request, response);
		if(success) {
			 mv.addObject("VisitorRegisterEventMessage", "¡¡¡  Successfully VISITOR updated  !!!");
			 session.setAttribute("VISITOR", visitor);
		}
		
		return mv;
	}
	
	
	
	/**
	 * jsp call this function by the name "updatePasswordVisitor.htm". If the request or response is null, it sends an exception.
	 * It is used to update the password of an existing visitor from the database.
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/updatePasswordVisitor.htm")
	public ModelAndView updatePasswordVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		Visitor visitor=new Visitor();
		
		VisitorServiceJDBC visitorService =  (VisitorServiceJDBC) appContext.getBean("VisitorServiceJDBC");
		visitor.setIdVisitor(Integer.parseInt(session.getAttribute("idVisitor").toString()));
		visitor.setPassword(request.getParameter("pass"));
		
		boolean success = false;
		if(visitorService.updatePassword(visitor) > 0){
			success = true;
		}
		
		ModelAndView mv = loadEvents(request, response);
		if(success) {
			 mv.addObject("VisitorRegisterEventMessage", "¡¡¡  Successfully VISITOR PASSWORD updated  !!!");
		}
		
		return mv;
	}
	
	
	
	
	/**
	 * jsp call this function by the name "logout.htm". If the request or response is null, it sends an exception.
	 * It is used to logout the FERS system.
	 * @param request
	 * @param response
	 * @return ModelAndView("/login.jsp")
	 * @throws Exception
	 */
	@RequestMapping("/logout.htm")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTEREVENTVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		session.removeAttribute("appContext");
		session.removeAttribute("idVisitor");
		session.removeAttribute("Visitor"); 
		session.removeAttribute("idAdmin"); 
		session.removeAttribute("Admin"); 
	
		session.invalidate();
		
		return new ModelAndView("/login.jsp");
	}
	
	
	
	
	/**
	 * This function gets the data from the database related to Event and EventSignUp and reload the page "profileAdmin.jsp"
	 * @param request
	 * @param response
	 * @return ModelAndView("/profileVisitor.jsp");
	 * @throws Exception
	 */
	private ModelAndView loadEvents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		List<EventSign> listIdEvent = null;
		List<Event> eventsRegisterList = null;
		List<Event> eventsList=null;
		
		EventServiceJDBC eventService 		= (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		EventSignUpServiceJDBC eventSignUp 	= (EventSignUpServiceJDBC) appContext.getBean("EventSignUpServiceJDBC");
		
		String idVisitor=null;
		idVisitor=session.getAttribute("idVisitor").toString();
		
		
		eventsList = eventService.viewEvent();
		listIdEvent = eventSignUp.selectEventForVisitor(Integer.parseInt(idVisitor));
	
		if(listIdEvent != null){
			eventsRegisterList = new ArrayList <Event>();
			
			for (EventSign element : listIdEvent){
				Event data = new Event();
				data.setEventId(element.getIdEvent());
				
				eventsRegisterList.add(eventService.selectEvent(data));
			}
			
		}
		
		request.setAttribute("EVENTREGISTERLIST", eventsRegisterList);
		request.setAttribute("EVENTLIST", eventsList);
		
		return new ModelAndView("/profileVisitor.jsp");	
	}
	
	
	/**
	 * This function gets the data from the database related to Visitor and reload the page "updateVisitor.jsp"
	 * @param request
	 * @param response
	 * @return ModelAndView("/updateVisitor.jsp");
	 * @throws Exception
	 */
	private ModelAndView loadVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		
		VisitorServiceJDBC visitorService =  (VisitorServiceJDBC) appContext.getBean("VisitorServiceJDBC");
		Visitor visitor=new Visitor();

		visitor.setIdVisitor(Integer.parseInt(session.getAttribute("idVisitor").toString()));
		Visitor visitorUpdate=new Visitor(visitorService.selectVisitor(visitor));
		
		request.setAttribute("VISITOR", visitorUpdate);
		
		return new ModelAndView("/updateVisitor.jsp");	
	}
	
}
