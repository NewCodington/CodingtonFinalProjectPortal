<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="codingtonportal.model.domain.Event"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Place"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Event Update Page</title>
	</head>

	<body id="body">
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login");
	}
	else if (session.getAttribute("Visitor")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("visitor");
	}
	else {
		if(session.getAttribute("idEvent") == null) {
			session.setAttribute("ErrorPriv", "You have not got selected an Event to update.");
			session.setAttribute("ViewErrorPriv", "YES");
			
			response.sendRedirect("admin");
			return;
		}
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
					<p><a href="admin" class="link">My Page </a></p>
					<hr />
					<p ><a class="link"  href=<%="registerPlace"%>>Register Place </a></p>
					<p ><a class="link" href=<%="registerEvent"%>>Register Event </a></p>
					<hr />
					<p><a href="logout" class="link">Logout </a></p>
				</div>
			</div>
	
	
			<div class="center_nav">
				
				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
	
				<% 
					if (session.getAttribute("idEvent") != null) {
						Event event=(Event)session.getAttribute("EVENT");
						ArrayList<Place> placeList = (ArrayList<Place>) session.getAttribute("LISTPLACE");
				%>
				<form method="post" action="updateEvent">
					<div class="title">Update Event</div>
					<br />
					    
					<div class="field"><p>Event name:</p> 
					  	<input type="text" id="eventName" name="eventName" value="<%= event.getName() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){45}" title="Enter a valid event name (length between 1-45)"  placeholder="Event name"required />
					  	<br />
					</div>
					  
					<div class="field"><p>Description:</p>
					  <input type="text" id="description" name="description" value="<%= event.getDescription() %>" title="1 to 45 characters" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){45}" placeholder="Description" required />
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
					  	<input type="text" id="startTime" name="startTime" value="<%= event.getStartTime() %>" pattern="()[a-zA-Z0-9]| |/|\|@|#|$|%|&){1,15}" title="Enter a valid place (length between 1-45)" placeholder="Date" required />
					 	<br />
					 </div>
					    
					 <div class="field"><p>Duration:</p> 
					  	<input type="text" id="duration" name="duration" value="<%= event.getDuration() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){1,45}" title="Enter a valid Duration (length between 1-45)" placeholder="Duration" required />
					  	<br />
					 </div>
					 
					 <div class="field"><p>Type of Event:</p> 
					  	<input type="text"  id="typeOfEvent"name="typeOfEvent" value="<%= event.getEventType() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){1,45}" title="Enter a valid Type of event (length between 1-45)"  placeholder="Type of Event" required />
					    <br />
					 </div>
					  
				 
				    <div class="field"><p>Seats Avalaible:</p>
					  	<input type="text" id="seats" name="seats" value="<%= event.getSeatsAvailable() %>" required title="Field required" placeholder="Seats Avalaible" />
					  	<br />
				    </div>
			
					<div class="input">
						<input type="submit" value="Submit" />
						<input type="button" value="Cancel"  onclick = "javascript:window.location='admin';" />
						<br />
					</div> 
				</form>
				<%
					}
				%>
			</div>
		</div>


		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	
	</body>
</html>