<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Event"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/codington.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Bienvenido <%=session.getAttribute("Visitor") %></title>
</head>

<body>

<%
	//Recojo el id del Evento
	String idEv=request.getParameter("idEv");								
%>	


<div class="header">
	<p class="cabecera">
	<table width="100%" border="0">
      <tr>
        <td width="284" rowspan="2"><img src="logo.gif" width=130 height=130 border=2 vspace=30 hspace=75 align=middle /></td>
        <td width="499"><div align="center">New Codington Portal</div></td>	
        <td width="151">&nbsp;</td>
        <td width="6"></p>
      </tr>
      <tr>
        <td><p class="cabecera2">One of the World's Best Cities 2014</p></td>
        <td>&nbsp;</td>
      </tr>
    </table>
	
<p class="menuHorizontal"><a href="myprofile.html" class="link">My Profile </a> | <a href="home.html" class="link">Home </a> | <a href="History.html" class="link" > History </a> | <a class="link" href="Events.html"> Events </a> | <a href="logout" class="link">Logout </a> </p>
</div>



<div class = "left_nav">
	
	<p class = "menuVerticalTitulos"> North Town</p>
	<hr>
	<p class = "region"><a class="linkMenuVertical"  href="LargueBusiness.html" >Large Business </a></p>
	<p class = "region"><a class="linkMenuVertical" href="Museum.html">Museum </a></p>
	<p class = "region"><a class="linkMenuVertical" href="Theater.html">Theater </a></p>
	<p class = "region"><a class="linkMenuVertical" href="Stadium.html">Stadium </a></p>
	<hr>
	<p class = "menuVerticalTitulos">  South Town</p>
	<hr>
	<p class = "region"> <a class="linkMenuVertical" href="Zoo.html">Zoo </a></p>
	<p class = "region"><a class="linkMenuVertical" href="Park.html">Park </a></p>
	<p class = "region"><a  class="linkMenuVertical" href="Markets.html">Markets </a></p>
	<p class = "region"><a  class="linkMenuVertical" href="Tourist.html">Tourist Attractions </a></p>
</div>



<div class = "section">
	
	<div id="event">
		
	<br><b><a style="color:red"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></a></b>
	
	<table>
							<tr>
								<td style="font-weight: bold">Events<b></b></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td>
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
										<th>Action</th>
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
										<td><a href = <%="visitor?register=" + event.getEventId() %>>Register</a></td>
									</tr>
									<%
										}
									%>
								</table>
							<tr>
								<td style="font-weight: bold">Events Resgistration<b></b></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td>
								<%
									ArrayList<Event> eventRegisterList = new ArrayList<Event>();
									eventRegisterList = (ArrayList<Event>) session.getAttribute("EVENTREGISTERLIST");
									if (eventRegisterList == null){
									
									%>
										<hr>
										<p class="mensaje">There are no Events Registered for you</p>	
									<%	
									}
									else
									{	
											%>
											<table class="events" >
												<tr>
													<th>Event Name</th>
													<th>Description</th>
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
								</td>
							</tr>

						</table>
						
						
	</div>

</div>

<div class="footer">
New Codignton Portal - December, 2014
</div>





</body>
</html>
