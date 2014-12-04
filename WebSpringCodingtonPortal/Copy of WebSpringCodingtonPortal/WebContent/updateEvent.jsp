<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="springcodingtonportal.model.domain.Event"%>
<%@page import="java.util.ArrayList"%>
<%@page import="springcodingtonportal.model.domain.Place"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/BrightSide.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Event Update Page</title>
	</head>

<body>
 
	
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

		<div id="content-wrap">
		
		
		<img src="image.htm?name=headerphoto" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
			
			<div id="sidebar">							
				
				<h1><%=session.getAttribute("Admin") %></h1>
				<ul class="sidemenu">
					<li><a href="profileAdmin.htm">My Page</a></li>
					<li><a href=<%="registerPlace.htm"%>>Register Place</a></li>
					<li><a href=<%="registerEvent.htm"%>>Register Event</a></li>
					<li><a href="logout.htm">Logout</a></li>

				</ul>		
						
		
			</div>
	
	
		<div id="main">	
				<% 
					if (request.getAttribute("idEvent") != null) {
						session.setAttribute("idEvent", request.getAttribute("idEvent"));
						Event event=(Event)request.getAttribute("EVENT");
						ArrayList<Place> placeList = (ArrayList<Place>) request.getAttribute("LISTPLACE");
				%>
				
			<div class = "section">
				
				<form class = "Rform" method="post" action="updateEvent.htm">
					<h1>Update Event</h1>
					<br />
					    
					<div class="field"><p>Event name:</p> 
					  	<input type="text" id="eventName" name="eventName" value="<%= event.getName() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){45}" title="Enter a valid event name (length between 1-45)"  placeholder="Event name"required />
					  	<br />
					</div>
					  
					<div class="field"><p>Description:</p>
					  <input type="text" id="description" name="description" value="<%= event.getDescription() %>" title="1 to 45 characters" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){45}" placeholder="Description" required />
					  <br />
					</div>
					
					<div class="field"><p>Date:</p>
					  	<input type="text" id="date" name="date" value="<%= event.getDate_eventString() %>" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" title="Enter a valid place (length between 1-45)" placeholder="Date" required />
						<br />
					</div>
					
					<div class="field"><p>Place:</p>
						<select id="place" name="place" required>
							<%
								for (Place place : placeList) {
							%>
							<option value="<%= place.getIdPlace()%>" <%=place.getIdPlace() == event.getPlace()?"selected":"" %>><%=place.getName()%></option>
							<%
								}
							%>
						</select>
					</div>
					  
					 <div class="field"><p>Start Time:</p>
					  	<input type="text" id="startTime" name="startTime" value="<%= event.getStartTime() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){1,15}" title="Enter a valid place (length between 1-45)" placeholder="Date" required />
					 	<br />
					 </div>
					    
					 <div class="field"><p>Duration:</p> 
					  	<input type="text" id="duration" name="duration" value="<%= event.getDuration() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){1,45}" title="Enter a valid Duration (length between 1-45)" placeholder="Duration" required />
					  	<br />
					 </div>
					 
					 <div class="field"><p>Type of Event:</p> 
					  	<input type="text"  id="typeOfEvent"name="typeOfEvent" value="<%= event.getEventType() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){1,45}" title="Enter a valid Type of event (length between 1-45)"  placeholder="Type of Event" required />
					    <br />
					 </div>
					  
				 
				    <div class="field"><p>Seats Avalaible:</p>
					  	<input type="text" id="seats" name="seats" value="<%= event.getSeatsAvailable() %>" required title="Field required" placeholder="Seats Avalaible" />
					  	<br />
				    </div>
			
					<div class="input">
						<input type="submit" value="Submit" />
						<input type="button" value="Cancel"  onclick = "javascript:window.location='profileAdmin.htm';" />
						<br />
					</div> 
				</form>
				<%
					}
				%>
				</div>
			</div>
		</div>
		
		
		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	</div>
	</body>
</html>