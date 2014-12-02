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
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="session.js"></script>
		<title>Bienvenido <%=session.getAttribute("Admin") %></title>
	</head>

	<body id="body">
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login.jsp");
		return;
	}
	else if (session.getAttribute("Visitor")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("visitorProfile.htm");
		return;
	}
	%> 
	
		<div id="header">
			<table>
		    	<tr>
		      		<td class="colum1" rowspan="2">
		        		<img src="logo.gif" width="130" height="130" vspace="30" hspace="75" align="middle" />
		        	</td>
		        	<td class="colum2">
		        		<div class="title">New Codington Portal</div>
		        	</td>	
		        	<td class="colum3">&nbsp;</td>
		      		</tr>
		      	<tr>
		        	<td>
		        		<div class="subtitle">One of the World's Best Cities 2014</div>
		        	</td>
		        	<td>&nbsp;</td>
		      	</tr>
		    </table>
		    <div class="menuHorizontal"> <a href="history.jsp" class="link" > History </a> | <a href="siteMap.jsp" class="link">Site Map </a> | <a href="about.jsp" class="link">About </a> </div>
		</div>
		
		
		<div id="content">
		
			<div class = "left_nav">
				<div class = "title"><p><%=session.getAttribute("Admin") %>'s Menu</p></div>
				<hr size=10 />
				
				<div class = content>	
					<p><a href="profileAdmin.htm" class="link">My Page </a></p>
					<hr />
					<p ><a class="link"  href=<%="registerPlace.htm"%>>Register Place </a></p>
					<p ><a class="link" href=<%="registerEvent.htm"%>>Register Event </a></p>
					<hr />
					<p><a href="logout.htm" class="link">Logout </a></p>
				</div>
			</div>
		
			<div class="right_nav">
			
				<div class="section">
					<div class="error"><%= session.getAttribute("ErrorPriv")!=null?session.getAttribute("ErrorPriv").toString():""%></div>
					<div class="message">${RegisterMessage}</div><div class="message">${UpdateMessage}</div><div class="message">${DeleteMessage}</div>
			
					<div class="title">EVENTS <hr /></div>
	
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
							<th>Place</th>
							<th>Date</th>
							<th>Duration</th>
							<th>Event Type</th>
							<th>Seats Available</th>
							<th>Start Time</th>
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
							<td>
							<%=event.getPlaceString(appContext)%>
							</td>
							<td><%=event.getDate_eventString()%></td>
							<td><%=event.getDuration()%></td>
							<td><%=event.getEventType()%></td>
							<td><%=event.getSeatsAvailable()%></td>
							<td><%=event.getStartTime()%></td>
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
					<div class="title">PLACES<hr /></div>
			
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
							<th>Place Name</th>
							<th>Region</th>
							<th>Type Place</th>
							<th>Image</th>
							<th>Address</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
						<%
							placeList = (ArrayList<Place>) request.getAttribute("PLACELIST");
							ApplicationContext appContext = (ApplicationContext) session.getAttribute("appContext");
							for (Place place : placeList) {
						%>				
						<tr>
							<td><%=place.getName()%></td>
							<td><%=place.getRegionString(appContext, place.getTypePlace())%></td>
							<td><%=place.getTypePlaceString(appContext)%></td>
							<td><%=place.getImage()%></td>
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
		
		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
		
	</body>
</html>
