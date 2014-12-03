<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="springcodingtonportal.model.domain.Event"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<html>

	<head>

	<title>New Codington</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<link rel="stylesheet" type="text/css" media="screen" href="css/BrightSide.css" />

	</head>

<body>
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login.jsp");
		return;
	}
	else if (session.getAttribute("Admin")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("profileAdmin.htm");
		return;
	}
	%> 
	
	<!-- wrap starts here -->
	<div id="wrap">
		
		<div id="header">				
				
			<h1 id="logo">New<span class="green">Codington</span></h1>	
			<h2 id="slogan">One of the World's Best Cities 2014</h2> 
			
						
			<!-- Menu Tabs -->
			<ul>
				<li><a href="history.jsp"><span>History</span></a></li>
				<li><a href="siteMap.jsp"><span>Site Map</span></a></li>
				<li><a href="about.jsp"><span>About</span></a></li>
		
			</ul>	
														
		</div>	
	
		<!-- content-wrap starts here -->
		<div id="content-wrap">		
												
		<img src="images/ciudad2.jpg" width="100%" height="120" alt="headerphoto" class="header-photo" />
			
			<div id="sidebar" >							
					
				<h1><%=session.getAttribute("Visitor") %></h1>
				<ul class="sidemenu">
					<li><a href="profileVisitor.htm">My Page</a></li>
					<li><a href="events.jsp">Town Events</a></li>
					<li><a href="getVisitor.htm">Update Information</a></li>
					<li><a href="updatePasswordVisitor.jsp">Update Password</a></li>
					<li><a href="logout.htm">Logout</a></li>
				</ul>		
							
			
			</div>
				
			<div id="main">	
				
				<div id="content">
	
					<div id="error"><%= session.getAttribute("ErrorPriv")!=null?session.getAttribute("ErrorPriv").toString():""%></div>
					<div id="error">${VisitorRegisterEventError}</div>
					<div id="message">${VisitorRegisterEventMessage}</div>			
					
						<div class="search">		
							<form class="searchform" method="post" action="searchEvents.htm">	
								<input class = "textbox" type = "text" name="search" id="search" placeholder="Search" />
								<input type= "submit" value="Search" />
							</form>
						</div>
						
					<div class = "section">
				
						<h1>EVENTS MARKET</h1><hr />
						<%
							ArrayList<Event> eventList = null;
							if (request.getAttribute("EVENTLIST") == null){
						%>
	
						<div id="message"><p>Not found Events</p></div>
						<%	
							}
							else {
								eventList = (ArrayList<Event>) request.getAttribute("EVENTLIST");
								ApplicationContext appContext = (ApplicationContext) session.getAttribute("appContext");
						%>
						<table>
							<tr>
								<th>Event Name</th>
								<th>Description</th>
								<th>Place</th>
								<th>Date</th>
								<th>Duration</th>
								<th>Event Type</th>
								<th>Seats Available</th>
								<th>Start Time</th>
								<th>Action</th>
							</tr>
			
							<%
								for (Event event : eventList) {
							%>
										
							<tr>
								<td><%=event.getName()%></td>
								<td><%=event.getDescription()%></td>
								<td><%=event.getPlaceString(appContext)%></td>
								<td><%=event.getDate_eventString()%></td>
								<td><%=event.getDuration()%></td>
								<td><%=event.getEventType()%></td>
								<td><%=event.getSeatsAvailable()%></td>
								<td><%=event.getStartTime()%></td>
								<td><a href = <%="registerEventForVisitor.htm?register=" + event.getEventId() %>>Register</a></td>
							</tr>
							<%
								}
							%>
						</table>
						<%
							}
						%>
					</div>					
			</div>	
						
			<!-- content-wrap ends here -->		
			</div>
		</div>
	</div>


	<!-- footer starts here -->	
	<div id="footer">
		<p>New Codignton Portal - December, 2014</p>
	</div>
	
	
</body>
</html>