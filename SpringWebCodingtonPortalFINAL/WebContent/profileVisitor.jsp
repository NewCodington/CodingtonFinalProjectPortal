<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="springcodingtonportal.model.domain.Event"%>
<%@page import="springcodingtonportal.model.domain.Place"%>
<%@page import="springcodingtonportal.model.domain.Visitor"%>
<%@page import="springcodingtonportal.model.services.PlaceServiceJDBC"%>
<%@page import="org.springframework.context.ApplicationContext"%>


<html>

	<head>

		<title>New Codington</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
		<link rel="stylesheet" type="text/css" media="screen" href="css/BrightSide.css" />
		<title>Bienvenido <%=session.getAttribute("Visitor")%></title>
		
	</head>

	<body>

		
	<!-- wrap starts here -->
	<div id="wrap">
		
		<div id="header">				
				
			<h1 id="logo">New<span class="green">Codington</span></h1>	
			<h2 id="slogan">One of the World's Best Cities 2014</h2> 
			
						
			<!-- Menu Tabs -->
			<ul>
				<li><a href="events.jsp"><span>Event Catalog</span></a></li>
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
				
				<div id="content">

					<div id="error">${ErrorPriv}</div><div id="error">${VisitorRegisterEventError}</div>
					<div id="message">${VisitorRegisterEventMessage}</div>
					<% session.removeAttribute("ErrorPriv"); %>
								
					
						<div class="search">		
							<form class="searchform" method="post" action="searchEvents.htm">	
								<input class = "textbox" type = "text" name="search" id="search" placeholder="Search" />
								<input type= "submit" value="Search" />
							</form>
						</div>
						
								
					
					<div class = "section">
				
						<h1>Events Registered</h1><hr />

					<%
						ArrayList<Event> eventRegisterList = null;
						if (request.getAttribute("EVENTREGISTERLIST") == null){
					%>
						
						<div class="message"><p>There are no Events Registered for you</p></div>	
						
					<%	
						}
						else {	
							eventRegisterList = (ArrayList<Event>) request.getAttribute("EVENTREGISTERLIST");
							ApplicationContext appContext = (ApplicationContext) session.getAttribute("appContext");
					%>
						
						<table>
							<tr>
								<th>Event Name</th>
								<th>Description</th>
								<th>Event Type</th>
								<th>Place</th>
								<th>Date</th>
								<th>Start Time</th>
								<th>Duration</th>
								<th>Seats Available</th>
								<th>Action</th>
							</tr>

							<%
								for (Event event : eventRegisterList) {
							%>
							<tr>
								<td><%=event.getName()%></td>
								<td><%=event.getDescription()%></td>
								<td><%=event.getEventType()%></td>
								<td><%=event.getPlaceString(appContext)%></td>
								<td><%=event.getDate_eventString()%></td>
								<td><%=event.getStartTime()%></td>
								<td><%=event.getDuration()%></td>
								<td><%=event.getSeatsAvailable()%></td>
								<td><a href = "<%="unregisterEventForVisitor.htm?unregister=" + event.getEventId() %>">Unregister</a></td>
							</tr>
								<%
									}
								%>
						</table>						
						<%
							}
						%>					
					</div>		
					<div class = "section">
					
						<h1>User Information </h1><hr></hr></div>			
					<%
						Visitor visitor=(Visitor)session.getAttribute("VISITOR");
					%>
		
				<div class = "section">
				
						<br />
						
						<h2>First name:<%= visitor.getFirstName() %></h2>
						<br />  
						
						<h2>Last name:<%= visitor.getLastName() %></h2>
						<br/>

						<h2>DNI:<%= visitor.getDni() %></h2>
						<br />

						<h2>Phone Number:<%= visitor.getPhoneNumber() %></h2>
							<br />

						<h2>Email:<%= visitor.getEmail() %></h2>
							<br />
		
						<h2>Address:<%= visitor.getAddress() %></h2>
						<br />							  
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
