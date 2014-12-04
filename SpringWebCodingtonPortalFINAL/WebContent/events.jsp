<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="springcodingtonportal.model.domain.Event"%>
<%@page import="springcodingtonportal.model.domain.Visitor"%>
<%@page import="springcodingtonportal.utils.Constants"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<html>
<head>

	<title>New Codington</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<link rel="stylesheet" type="text/css" media="screen" href="css/BrightSide.css" />

</head>

	<body>

	
		<!-- wrap starts here -->
		<div id="wrap">
			
			<div id="header">				
					
				<h1 id="logo">New<span class="green">Codington</span></h1>	
				<h2 id="slogan">One of the World's Best Cities 2014</h2> 
				
							
				<!-- Menu Tabs -->
				<ul>
					<li id="current"><a href="events.jsp"><span>Event Catalog</span></a></li>
					<li><a href="siteMap.jsp"><span>Site Map</span></a></li>
					<li><a href="about.jsp"><span>About</span></a></li>
		
				</ul>	
															
			</div>	
		
			<!-- content-wrap starts here -->
			<div id="content-wrap">		
													
			<img src="image.htm?name=headerphoto" width="100%" height="120" alt="headerphoto" class="header-photo" />
				
				<div id="sidebar" >							
						
					<h1><%=session.getAttribute("Visitor") %></h1>
					<ul class="sidemenu">
						<li><a href="profileVisitor.htm">My Page</a></li>
						<li><a href="getVisitor.htm">Update Information</a></li>
						<li><a href="updatePasswordVisitor.jsp">Update Password</a></li>
						<li><a href="logout.htm">Logout</a></li>
					</ul>		
								
				
				</div>
					
				<div id="main">	
					
							<div class="search">		
								<form class="searchform" method="post" action="searchEvents.htm">	
									<input class = "textbox" type = "text" name="search" id="search" placeholder="Search" />
									<input type= "submit" value="Search" />
								</form>
							</div>
	
						
						<%
							ApplicationContext appContext = (ApplicationContext) session.getAttribute("appContext");
							Constants constants =  (Constants) appContext.getBean("beanCONSTANTS");
						%>
						
						<div class = "section2">
							<h1>North Town</h1>
							<div class = "subsection1">
								<h2>Business</h2>
								<a href ="eventsForPlace.htm?typePlace=<%=constants.getBUSSINES()%>"><img src="image.htm?name=business"  style = "width: 250px; height:180px"/></a>
							</div>
							<div class = "subsection1">
								<h2>Museum</h2>
								<a href = "eventsForPlace.htm?typePlace=<%=constants.getMUSEUM()%>"><img src="image.htm?name=museum" style = "width: 250px; height:180px"/></a>
							</div>
						</div>
						
						<div class = "section2">
							
							<div class = "subsection1">
								<h2>Theater</h2>
								<a href = "eventsForPlace.htm?typePlace=<%=constants.getTHEATER()%>"><img src="image.htm?name=theater" style = "width: 250px; height:180px"/></a>
							</div>
							<div class = "subsection1">
								<h2>Stadium</h2>
								<a href ="eventsForPlace.htm?typePlace=<%=constants.getSTADIUM()%>"><img src="image.htm?name=stadium" style = "width: 250px; height:180px"/></a>
							</div>
							
						</div>
								
						
						
						<div class = "section2">	
						<h1>South Town</h1>				
											
							<div class = "subsection1">
								<h2>Parks</h2>
								<a href ="eventsForPlace.htm?typePlace=<%=constants.getPARK()%>"><img src="image.htm?name=park" style = "width: 250px; height:180px"/></a>
							</div>
							
							<div class = "subsection1">
								<h2>Tourism</h2>
								<a href ="eventsForPlace.htm?typePlace=<%=constants.getTOURISM()%>"><img src="image.htm?name=tourism" style = "width: 250px; height:180px"/></a>
							</div>
							
						</div>
						
						<div class = "section2">
							<div class = "subsection1">
								<h2>Zoos</h2>
								<a href ="eventsForPlace.htm?typePlace=<%=constants.getZOO()%>"><img src="image.htm?name=zoo" style = "width: 250px; height:180px"/></a>
							</div>
							
							<div class = "subsection1">
								<h2>Markets</h2>
								<a href ="eventsForPlace.htm?typePlace=<%=constants.getMARKET()%>"><img src="image.htm?name=market" style = "width: 250px; height:180px"/></a>
							</div>
						
						</div>
				</div>
								
			
							
			<!-- content-wrap ends here -->		
			</div>
		
		
		<!-- footer starts here -->	
		<div id="footer">		
			<p>New Codignton Portal - December, 2014</p>		
		</div>
		<!-- footer ends here -->
			
		<!-- wrap ends here -->
		</div>
	</body>
</html>
