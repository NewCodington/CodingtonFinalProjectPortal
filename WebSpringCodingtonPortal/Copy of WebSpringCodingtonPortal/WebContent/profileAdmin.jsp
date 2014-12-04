<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="springcodingtonportal.model.domain.Event"%>
<%@page import="springcodingtonportal.model.domain.Place"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<html>
	
	<head>
		<link rel="stylesheet" type="text/css" media="screen" href="css/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="session.js"></script>
		<title>Bienvenido <%=session.getAttribute("Admin") %></title>
	</head>

<body>


	
	
	<div id="wrap">
	 
		<div id="header">				
			
		<h1 id="logo">New<span class="green">Codington</span></h1>	
		<h2 id="slogan">One of the World's Best Cities 2014</h2> 
		
			
		<!-- Menu Tabs -->
			<ul>
				<li><a href="siteMap.jsp"><span>Site Map</span></a></li>
				<li><a href="about.jsp"><span>About</span></a></li>
		
			</ul>	
													
		</div>
		
		
	<div id="content-wrap">
		
	<img src="image.htm?name=headerphoto" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
		<div id="sidebar" >							
				
			<h1><%=session.getAttribute("Admin") %></h1>
			<ul class="sidemenu">
				<li><a href="profileAdmin.htm">My Page</a></li>
				<li><a href=<%="registerPlace.htm"%>>Register Place</a></li>
				<li><a href=<%="registerEvent.htm"%>>Register Event</a></li>
				<li><a href="logout.htm">Logout</a></li>

			</ul>		
						
		
		</div>
		
		<div id="main">
			
			<div id = "content">
				
				<div id="error">${ErrorPriv}</div><div id="error">${RegisterVisitorError}</div>
				<div id="message">${RegisterMessage}</div><div id="message">${UpdateMessage}</div><div id="message">${DeleteMessage}</div>
				<% session.removeAttribute("ErrorPriv"); %>
				
				<div class="section">
			
					<h1>EVENTS</h1><hr />
	
					<%
						ArrayList<Event> eventList = null;
						if (request.getAttribute("EVENTLIST") == null){
					%>
					
						<div class="message"><p>Not Exit Events</p></div>

					<%	
						}
						else {	
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
							<th>Actions</th>
						</tr>
			
						<%
							eventList = (ArrayList<Event>) request.getAttribute("EVENTLIST");
							ApplicationContext appContext = (ApplicationContext) session.getAttribute("appContext");
							for (Event event : eventList) {
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
							<td><a href = <%="getEvent.htm?update=" + event.getEventId() %>>Update</a></td>
							<td><a href = <%="deleteEvent.htm?delete=" + event.getEventId() %>>Delete</a></td>
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
					<h1>PLACES</h1><hr />
			
					<%
						ArrayList<Place> placeList = null;
						if (request.getAttribute("PLACELIST") == null){
					%>
						<div class="message"><p>Not Exit Places</p></div>
					<%	
						}
						else {	
					%>
									
			  		<table>
						<tr>
							<th>Image</th>
							<th>Place Name</th>
							<th>Region</th>
							<th>Type Place</th>
							<th>Address</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
			
						<%
							placeList = (ArrayList<Place>) request.getAttribute("PLACELIST");
							ApplicationContext appContext = (ApplicationContext) session.getAttribute("appContext");
							for (Place place : placeList) {
								session.setAttribute("inputImag", place.getImage());
						%>				
						<tr>
							<td><a href =<%= "imagePlace.htm?id=" +  place.getIdPlace()%>><img src = <%="imagePlace.htm?id=" + place.getIdPlace() %> width = 20px height = 20px/></a></td>
							<td><%=place.getName()%></td>
							<td><%=place.getRegionString(appContext, place.getTypePlace())%></td>
							<td><%=place.getTypePlaceString(appContext)%></td>								
							<td><%=place.getAddress()%></td>
							<td><%=place.getDescription()%></td>
							<td><a href = <%="getPlace.htm?update=" + place.getIdPlace() %>>Update</a></td>
							<td><a href = <%="deletePlace.htm?delete=" + place.getIdPlace() %>>Delete</a></td>
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
		</div>
		
		<!-- content-wrap ends here -->		
	</div>

<!-- footer starts here -->	
<div id="footer">

	<p>New Codignton Portal - December, 2014</p>
	
</div>
	
</div>
<!-- footer ends here -->
	
<!-- wrap ends here -->
</div>

</body>
</html>
