<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Event"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Administrator</title>
	</head>

	<body>
	
		<div class="header">
			<p class="cabecera">
			<table width="100%" border="0">
		      <tr>
		        <td width="284" rowspan="2"><img src="logo.gif" width=130 height=130 border=2 vspace=30 hspace=75 align=middle /></td>
		        <td><p class="cabecera">New Codington Portal</p></td>	
		        <td width="151">&nbsp;</td>
		        <td width="6"></p>
		      </tr>
		      <tr>
		        <td><p class="cabecera2"><strong><em>One of the World's Best Cities 2014</em></strong></p>
		      </td>
		        <td>&nbsp;</td>
		      </tr>
		    </table>
			
			<div class="menuHorizontal"> 
				<a href="home.html" class="link">Home </a> | <a href="History.html" class="link" > History </a> | <a href="SiteMap.html" class="link">Site Map </a> | <a class="link" href="Events.html"> Events </a> | <a href="myprofile.html" class="link">My Profile </a> | <a href="logout" class="link">Logout </a> 
			</div>
	</div>
		
	<div class = "left_nav">
		<p class = "menuVerticalTitulosAdmin"> Register</p>
		<hr>
		<p class = "regionadmin"><a class="linkMenuVertical"  href=<%="registerPlace"%>>Register Place </a></p>
		<p class = "regionadmin"><a class="linkMenuVertical" href=<%="registerEvent"%>>Register Event </a></p>
		</hr>
		
	</div>
		
	<div class = "section">
			
		<br><b><a style="color:blue"><%= session.getAttribute("Success")!=null?session.getAttribute("Success").toString():""%></a></b>
			
		<div id="Estilo1">EVENTS <hr></hr></div>
	
		<%
			ArrayList<Event> eventList = new ArrayList<Event>();
			eventList = (ArrayList<Event>) session.getAttribute("EVENTLIST");
		%>
								
		  <table class="events">
			<tr>
				<th>Event Name</th>
				<th>Description</th>
				<th>Duration</th>
				<th>Event Type</th>
				<th>Seats Available</th>
				<th>Start Time</th>
				<th>Actions</th>
			</tr>
			<%
				for (Event event : eventList) {
			%>				
			<tr>
				<td><%=event.getName()%></td>
				<td><%=event.getDescription()%></td>
				<td><%=event.getDuration()%></td>
				<td><%=event.getEventType()%></td>
				<td><%=event.getSeatsAvailable()%></td>
				<td><%=event.getStartTime()%></td>
				<td><a href = <%="admin?update=" + event.getEventId() %>>Update</a></td>
				<td><a href = <%="admin?delete=" + event.getEventId() %>>Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
		 
	<div class = "section">
		<div id="Estilo1">PLACES<hr></div>
		
		<%
		ArrayList<Event> placeList = new ArrayList<Event>();
		placeList = (ArrayList<Event>) session.getAttribute("EVENTLIST");
		%>
								
		  <table class="events">
			<tr>
				<th>Event Name</th>
				<th>Description</th>
				<th>Duration</th>
				<th>Event Type</th>
				<th>Seats Available</th>
				<th>Start Time</th>
				<th>Actions</th>
			</tr>
			<%
				for (Event event : placeList) {
			%>				
			<tr>
				<td><%=event.getName()%></td>
				<td><%=event.getDescription()%></td>
				<td><%=event.getDuration()%></td>
				<td><%=event.getEventType()%></td>
				<td><%=event.getSeatsAvailable()%></td>
				<td><%=event.getStartTime()%></td>
				<td><a href = <%="admin?update=" + event.getEventId() %>>Update</a></td>
				<td><a href = <%="admin?delete=" + event.getEventId() %>>Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
		  
	</div>
		
		<div class="footer">
		  <p>New Codignton Portal - December, 2014  </p>
		</div>
	</body>
</html>