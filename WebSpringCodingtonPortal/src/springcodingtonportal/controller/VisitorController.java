package springcodingtonportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springcodingtonportal.model.domain.Visitor;
import springcodingtonportal.model.services.VisitorServiceJDBC;

/**
 * 	Visitor controller handles all the visitor related transactions
 *  with the data classes and triggered by visitormain.jsp 
 */

@Controller
public class VisitorController {

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
	@RequestMapping("/loginVisitor.htm")
	public ModelAndView newVisitor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			//log.info("Request or Response failed for NEWVISITOR METHOD..");
			//throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("CodingtonPortal-servlet.xml");
		
		Visitor v = new Visitor();
		v.setUserName(request.getParameter("username"));
		v.setPassword(request.getParameter("password"));
		
		log.info("creating new visitor with UserName :"+v.getUserName());
		
		VisitorServiceJDBC visitorService =  (VisitorServiceJDBC) context.getBean("VisitorServiceJDBC");
		Integer result= visitorService.loginVisitor(v);
				
				
		ModelAndView mv=new ModelAndView();
		if(result == 0)
		{
			mv.addObject("VisitorLoginMessage", "¡¡¡  Succesfully Visitor in database  !!!");
			log.info("Succesfully created visitor "+ v.getUserName());
			mv.setViewName("/login.jsp");
		}
		else
		{
			mv.addObject("VisitorLoginMessage", "¡¡¡  USERNAME and PASSWORD incorrect  !!!");
			//log.info("Username "+username+" already exists and visitor creation failed..");
			mv.setViewName("/login.jsp");
		}		
		return mv;
	}
}
