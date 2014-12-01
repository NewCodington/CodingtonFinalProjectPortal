package springcodingtonportal.controller;

import java.util.ArrayList;
import java.util.List;

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
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * method will register new Visitor into FERS system
	 * by accepting registration details and load into database
	 */
	@RequestMapping("/login.htm")
	public ModelAndView loginVisitor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for LOGINVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		Visitor v = new Visitor();
		v.setUserName(request.getParameter("username"));
		v.setPassword(request.getParameter("password"));
		
		log.info("Login visitor with UserName :"+v.getUserName());
		
		VisitorServiceJDBC visitorService =  (VisitorServiceJDBC) appContext.getBean("VisitorServiceJDBC");

		v.setIdVisitor(visitorService.loginVisitor(v));
		
		
		ModelAndView mv=new ModelAndView();
		if(v.getIdVisitor() != -1)
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
				
				return profileVisitor(request, response, mp);
			}
		}
		else
		{
			mv.addObject("VisitorLoginMessage", "¡¡¡  USERNAME and PASSWORD incorrect  !!!");
			log.info("Username "+v.getUserName()+" or PASSWORD incorrect ...");
			return new ModelAndView("/login.jsp");
		}		
	}


	private ModelAndView profileVisitor(HttpServletRequest request, HttpServletResponse response, ModelMap mp) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for PROFILEVISITOR METHOD..");
			throw new Exceptions("Error in Transaction, Please re-Try. for more information check Logfile in C:\\CodingtonLOG folder", new NullPointerException());
		}
		
		List<EventSign> listIdEvent = null;
		List<Event> eventsRegisterList = null;
		List<Event> eventsList=null;
		
		EventServiceJDBC eventService 		= (EventServiceJDBC) appContext.getBean("EventServiceJDBC");
		EventSignUpServiceJDBC eventSignUp 	= (EventSignUpServiceJDBC) appContext.getBean("EventSignUpServiceJDBC");
		
		String idVisitor=null;
		idVisitor=mp.get("idVisitor").toString();
		
		
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
		
		return new ModelAndView("/profileVisitor.jsp", mp);	
	}
	
	
	
}
