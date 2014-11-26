<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Event"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Bienvenido <%=session.getAttribute("Visitor") %></title>
	</head>

	
	<body id="body">
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		response.sendRedirect("login");
		return;
	}
	else if (session.getAttribute("Admin")!=null) {
		//session.setAttribute("Error", "You do not have administrator privileges. You will be redirected to your profile page");
		response.sendRedirect("admin");
		return;
	}
	else
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
				<div class = "title"><p><%=session.getAttribute("Visitor") %>'s Menu</p></div>
				<hr size=10 />
				<div class = content>
					<p><a href="visitor" class="link">My Page </a></p>
					<hr />
					<p><a href="updateVisitor" class="link">Update Information </a></p>
					<p><a href="updatePasswordVisitor" class="link">Update Password </a></p>
					<hr />
					<p><a href="logout" class="link">Logout </a></p>
				</div>
			</div>

			<div class="right_nav">
				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
				<div class="message"><%= session.getAttribute("Success")!=null?session.getAttribute("Success").toString():""%></div>
				
				<div class = "section">
				
					<div class="search">		
						<form method="post" action="visitor">	
							<input type = "text" name="search" id="search" placeholder="Search" />
							<input type= "submit" value="Search" />
						</form>
					</div>

					<div class="title">EVENTS <hr></hr></div>
					
					<%
						ArrayList<Event> eventList = null;
						if (session.getAttribute("EVENTLIST") == null){
					%>
						
					<div class="message"><p>Not found Events</p></div>
					
					<%	
						}
						else {
							eventList = new ArrayList<Event>();
							eventList = (ArrayList<Event>) session.getAttribute("EVENTLIST");
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
							<td><%=event.getPlaceString()%></td>
							<td><%=event.getDate_eventString()%></td>
							<td><%=event.getDuration()%></td>
							<td><%=event.getEventType()%></td>
							<td><%=event.getSeatsAvailable()%></td>
							<td><%=event.getStartTime()%></td>
							<td><a href = <%="visitor?register=" + event.getEventId() %>>Register</a></td>
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
				<div class="title">Events Resgistration<hr /></div>

				<%
					ArrayList<Event> eventRegisterList = null;
					if (session.getAttribute("EVENTREGISTERLIST") == null){
				%>
						
				<div class="message"><p>There are no Events Registered for you</p></div>	
						
				<%	
					}
					else {	
						eventRegisterList = new ArrayList<Event>();
						eventRegisterList = (ArrayList<Event>) session.getAttribute("EVENTREGISTERLIST");
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
							for (Event event : eventRegisterList) {
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
						<td><a href = "<%="visitor?unregister=" + event.getEventId() %>">Unregister</a></td>
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
