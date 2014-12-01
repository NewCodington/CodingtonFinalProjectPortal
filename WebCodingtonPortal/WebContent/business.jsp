<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Event"%>


<head>

	<title>New Codington</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<link rel="stylesheet" type="text/css" media="screen" href="images/BrightSide.css" />

</head>

<body>
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login");
		return;
	}
	else if (session.getAttribute("Admin")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("admin");
		return;
	}
	else
	%> 
	
<!-- wrap starts here -->
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

	<!-- content-wrap starts here -->
	<div id="content-wrap">		
											
	<img src="images/ciudad2.jpg" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
		<div id="sidebar" >							
				
			<h1><%=session.getAttribute("Visitor") %></h1>
			<ul class="sidemenu">
				<li><a href="visitor">My Page</a></li>
				<li><a href="events.jsp">Town Events</a></li>
				<li><a href="updateVisitor">Update Information</a></li>
				<li><a href="updatePasswordVisitor">Update Password</a></li>
				<li><a href="logout">Logout</a></li>

			</ul>		
						
		
		</div>
			
		<div id="main">	
			
			<div id="content">

				<div id="error"><%= session.getAttribute("ErrorPriv")!=null?session.getAttribute("ErrorPriv").toString():""%></div>
				<div id="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
				<div id="message"><%= session.getAttribute("Success")!=null?session.getAttribute("Success").toString():""%></div>
							
				
					<div class="search">		
						<form class="searchform" method="post" action="visitor">	
							<input class = "textbox" type = "text" name="search" id="search" placeholder="Search" />
							<input type= "submit" value="Search" />
						</form>
					</div>
					
				<div class = "section">
				
			
					<div class="title">EVENTS <hr></hr></div>
					
					<%
						ArrayList<Event> eventList = null;
						if (session.getAttribute("EVENTLIST") == null){
					%>

					<div id="message"><p>Not found Events</p></div>

					<%	
						}
						else {
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
			
					<div class="title">EVENTS REGISTERED<hr /></div>

					<%
					ArrayList<Event> eventRegisterList = null;
					if (session.getAttribute("EVENTREGISTERLIST") == null){
					%>
					
					<div class="message"><p>There are no Events Registered for you</p></div>	
					
					<%	
					}
					else {	
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
tml>