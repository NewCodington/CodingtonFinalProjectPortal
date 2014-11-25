<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Event"%>
<%@page import="codingtonportal.model.domain.Place"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Bienvenido <%=session.getAttribute("Admin") %></title>
	</head>

	<body>
	
<div class="header">
	<table width="100%" border="0">
      <tr>
        <td width="20%" rowspan="2"><img src="logo.gif" width=130 height=130 border=2 vspace=30 hspace=75 align=middle /></td>
        <td width="60%"><div align="center" class="cabecera">New Codington Portal</div></td>
        <td width="20%">&nbsp;</td>
      </tr>
      <tr>
        <td><p class="cabecera2">One of the World's Best Cities 2014</p></td>
        <td>&nbsp;</td>
      </tr>
    </table>
	
<div class="menuHorizontal"> <a href="history.jsp" class="link" > History </a> | <a href="siteMap.jsp" class="link">Site Map </a> | <a href="about.jsp" class="link">About </a> </div>
</div>
		
	<div class = "left_nav">
		<p class = "menuVerticalTitulos"><%=session.getAttribute("Admin") %>'s Menu</p>
		<hr size=10 />
		<p><a href="admin" class="link">My Page </a></p>
		<hr />
		<p ><a class="link"  href=<%="registerPlace"%>>Register Place </a></p>
		<p ><a class="link" href=<%="registerEvent"%>>Register Event </a></p>
		<hr />
		<p><a href="logout" class="link">Logout </a></p>
		
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
				<td><a href = <%="updateEvent?updateEvent=" + event.getEventId() %>>Update</a></td>
				<td><a href = <%="admin?deleteEvent=" + event.getEventId() %>>Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
		 
	<div class = "section">
		<div id="Estilo1">PLACES<hr></div>
		
		<%
		ArrayList<Place> placeList = new ArrayList<Place>();
		placeList = (ArrayList<Place>) session.getAttribute("PLACELIST");
		%>
								
		  <table class="events">
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
				for (Place place : placeList) {
			%>				
			<tr>
				<td><%=place.getName()%></td>
				<td><%=place.getRegion()%>    </td>
				<td><%=place.getTypePlace()%></td>
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
		  
	</div>
		
		<div class="footer">
		  <p>New Codignton Portal - December, 2014  </p>
		</div>
	</body>
</html>
