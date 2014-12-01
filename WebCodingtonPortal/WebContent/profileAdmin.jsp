<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Event"%>
<%@page import="codingtonportal.model.domain.Place"%>

<html>
	
	<head>
		<link rel="stylesheet" type="text/css" media="screen" href="images/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="session.js"></script>
		<title>Bienvenido <%=session.getAttribute("Admin") %></title>
	</head>

<body>

	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login");
		return;
	}
	else if (session.getAttribute("Visitor")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("visitor");
		return;
	}
	%> 
	
	<div id="wrap">
	 
		<div id="header">				
			
		<h1 id="logo">New<span class="green">Codington</span></h1>	
		<h2 id="slogan">One of the World's Best Cities 2014</h2> 
		
			
		<!-- Menu Tabs -->
		<ul>
			<li id="current"><a href="history.jsp"><span>History</span></a></li>
			<li><a href="siteMap.jsp"><span>Site Map</span></a></li>
			<li><a href="about.jsp"><span>About</span></a></li>
	
		</ul>	
													
		</div>
		
		
	<div id="content-wrap">
		
	<img src="images/ciudad2.jpg" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
		<div id="sidebar" >							
				
			<h1><%=session.getAttribute("Admin") %></h1>
			<ul class="sidemenu">
				<li><a href="admin">My Page</a></li>
				<li><a href="events.jsp">Town Events</a></li>
				<li><a href=<%="registerPlace"%>>Register Place</a></li>
				<li><a href=<%="registerEvent"%>>Register Event</a></li>
				<li><a href="logout">Logout</a></li>

			</ul>		
						
		
		</div>
		
		<div id="main">
			
			<div id = "content">
				
				<div id="error"><%= session.getAttribute("ErrorPriv")!=null?session.getAttribute("ErrorPriv").toString():""%></div>
				<div id="message"><%= session.getAttribute("Success")!=null?session.getAttribute("Success").toString():""%></div>
										
				
				
				<div class="section">
			
					<div id="error"><%= session.getAttribute("ErrorPriv")!=null?session.getAttribute("ErrorPriv").toString():""%></div>
					<div id="message"><%= session.getAttribute("Success")!=null?session.getAttribute("Success").toString():""%></div>
			
					<div class="title">EVENTS <hr /></div>
	
					<%
						ArrayList<Event> eventList = null;
						if (session.getAttribute("EVENTLIST") == null){
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
							<th>Place</th>
							<th>Date</th>
							<th>Duration</th>
							<th>Event Type</th>
							<th>Seats Available</th>
							<th>Start Time</th>
							<th>Actions</th>
						</tr>
			
						<%
							eventList = (ArrayList<Event>) session.getAttribute("EVENTLIST");
							for (Event event : eventList) {
						%>				
						<tr>
							<td><%=event.getName()%></td>
							<td><%=event.getDescription()%></td>
							<td><%=event.getPlaceString()%></td>
							<td><%=event.getDate_eventString()%></td>
							<td><%=event.getDuration()%></td>
							<td><%=event.getEventType()%></td>
							<td><%=event.getSeatsAvailable()%></td>
							<td><%=event.getStartTime()%></td>
							<td><a href = <%="updateEvent?updateEvent=" + event.getEventId() %>>Update</a></td>
							<td><a href = <%="admin?deleteEvent=" + event.getEventId() %>>Delete</a></td>
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
					<div class="title">PLACES<hr /></div>
			
					<%
						ArrayList<Place> placeList = null;
						if (session.getAttribute("PLACELIST") == null){
					%>
						<div class="message"><p>Not Exit Places</p></div>
					<%	
						}
						else {	
					%>
									
			  		<table>
						<tr>
							<th>Place Name</th>
							<th>Region</th>
							<th>Type Place</th>
							<th>Image</th>
							<th>Address</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
			
<%
							placeList = (ArrayList<Place>) session.getAttribute("PLACELIST");
							for (Place place : placeList) {
						%>				
						<tr>
							<td><%=place.getName()%></td>
							<td><%=place.getRegionString(place.getTypePlace())%></td>
							<td><%=place.getTypePlaceString()%></td>
							<td><%=place.getImage()%></td>
							<td><%=place.getAddress()%></td>
							<td><%=place.getDescription()%></td>
							<td><a href = <%="updatePlace?updatePlace=" + place.getIdPlace() %>>Update</a></td>
							<td><a href = <%="admin?deletePlace=" + place.getIdPlace() %>>Delete</a></td>
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
		
	</body>
</html>
