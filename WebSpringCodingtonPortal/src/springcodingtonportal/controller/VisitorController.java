package springcodingtonportal.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;



import springcodingtonportal.model.domain.Event;
import springcodingtonportal.model.domain.Visitor;
import springcodingtonportal.model.services.EventServiceJDBC;
import springcodingtonportal.model.services.EventSignUpJDBC;
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
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * method will register new Visitor into FERS system
	 * by accepting registration details and load into database
	 */
	@RequestMapping("/login.htm")
	public ModelAndView newVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for NEWVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		Visitor v = new Visitor();
		v.setUserName(request.getParameter("username"));
		v.setPassword(request.getParameter("password"));
		
		log.info("Login visitor with UserName :"+v.getUserName());
		
		VisitorServiceJDBC visitorService =  (VisitorServiceJDBC) appContext.getBean("VisitorServiceJDBC");

		Integer result= visitorService.loginVisitor(v);
		
		ModelAndView mv=new ModelAndView();
		if(result == 0)
		{
			ModelMap mp = new ModelMap();
			
			mp.addAttribute("idUser", v.getIdVisitor());
			mp.addAttribute("UserName", v.getUserName());
			
			if(visitorService.isAdmin(v)){
				
				mp.addAttribute("idAdmin", v.getIdVisitor());
				mp.addAttribute("Admin", v.getUserName());
				
				log.info("Succesfully login Administrator "+ v.getUserName());
				return new ModelAndView("/profileAdmin.jsp", mp);
			}
			else {
				mp.addAttribute("idVisitor", v.getIdVisitor());
				mp.addAttribute("Visitor", v.getUserName());
				
				log.info("Succesfully login visitor "+ v.getUserName());
				
				
				return new ModelAndView("/profileVisitor.htm",mp);
			}
		}
		else
		{
			mv.addObject("VisitorLoginMessage", "¡¡¡  USERNAME and PASSWORD incorrect  !!!");
			log.info("Username "+v.getUserName()+" or password incorrect ...");
			return new ModelAndView("/login.jsp");
		}		
	}
	
	
	@RequestMapping("/profileVisitor.htm")
	public ModelAndView profileVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for NEWVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		
		
		ArrayList<Integer> listIdEvent = null;
		ArrayList<Event> eventsRegisterList = null;
		ArrayList<Event> eventsList=null;
		
		EventServiceJDBC eventService=new EventServiceJDBC();
		EventSignUpJDBC eventSignUp=new EventSignUpJDBC();
		
		//Params of jsp for get
		String register=null;
		register=request.getParameter("register");
		
		String unregister=null;
		unregister=request.getParameter("unregister");
		
		String idVisitor=null;
		idVisitor=request.getAttribute("idVisitor").toString();
		
		//si vienen los parametros meto el nuevo evento a ese visitor
		if(register!=null){ 
			if(eventSignUp.registerForNewEvent(Integer.parseInt(idVisitor), Integer.parseInt(register)) == null) {
				request.setAttribute("Error", "You're already registered in this event");
				request.setAttribute("ViewError", "YES");
			}
			else {
				request.setAttribute("Success", "Succesfully registered in this event");
				request.setAttribute("ViewSuccess", "YES");
			}
		}
		if(unregister!=null){ 
			if(eventSignUp.unregisterForEvent(Integer.parseInt(idVisitor), Integer.parseInt(unregister)) == null) {
				request.setAttribute("Error", "You're already registered in this event");
				request.setAttribute("ViewError", "YES");
			}
			else {
				request.setAttribute("Success", "Succesfully unregistered in this event");
				request.setAttribute("ViewSuccess", "YES");
			}
		}
		
		listIdEvent = eventSignUp.selectEventForVisitor(Integer.parseInt(idVisitor));
	
		if(listIdEvent != null){
			eventsRegisterList = new ArrayList <Event>();
			
			for (Integer element : listIdEvent){
				Event data = new Event();
				data.setEventId(element);
				eventsRegisterList.add(eventService.selectEvent(data));
			}
			
		}
	
		eventsList = eventService.viewEvent();
		
		request.setAttribute("EVENTREGISTERLIST", eventsRegisterList);
		request.setAttribute("EVENTLIST", eventsList);
		
		
		if (request.getAttribute("ViewErrorPriv")!= null && request.getAttribute("ViewErrorPriv").toString().equals("YES")) {
			request.setAttribute("ViewErrorPriv", null);
			request.setAttribute("Error", null);
			request.setAttribute("Success", null);
		}
		else {	
			if(request.getAttribute("ViewSuccess")!=null && request.getAttribute("ViewSuccess").toString().equals("YES")) {
				request.setAttribute("ViewSuccess", null);
				request.setAttribute("Error", null);
				request.setAttribute("ErrorPriv", null);
			}
			else {
				if(request.getAttribute("ViewError")!=null && request.getAttribute("ViewError").toString().equals("YES")) {
					request.setAttribute("ViewError", null);
					request.setAttribute("Success", null);
					request.setAttribute("ErrorPriv", null);
				}
				else { 
					request.setAttribute("Error", null);
					request.setAttribute("ErrorPriv", null);
					request.setAttribute("Success", null);
				}
			}
		}
		
		
		return new ModelAndView("/profileVisitor.jsp");
		
		
		
		
		
		

		
	
		
		
	}
	
	
	
}
