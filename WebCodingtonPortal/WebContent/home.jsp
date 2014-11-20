<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Event"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/codington.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Documento sin t&iacute;tulo</title>
</head>

<body>

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
	
<p class="menuHorizontal"><a href="myprofile.html" class="link">My Profile </a> | <a href="home.html" class="link">Home </a> | <a href="History.html" class="link" > History </a> | <a class="link" href="Events.html"> Events </a> | <a href="Signin.html" class="link">Logout </a> </p>
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
								<table border="2">
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
										<td align="center"><%=event.getName()%></td>
										<td align="center"><%=event.getDescription()%></td>
										<td align="center"><%=event.getDuration()%></td>
										<td align="center"><%=event.getEventType()%></td>
										<td align="center"><%=event.getSeatsAvailable()%></td>
										<td align="center"><%=event.getStartTime()%></td>
										<td align="center"><a href = "">Regist</a><a href = "">Unregist</a></td>
									</tr>
									<%
										}
									%>
								</table>
								
																<td>
								<%
									ArrayList<Event> eventRegisterList = new ArrayList<Event>();
									eventRegisterList = (ArrayList<Event>) session.getAttribute("EVENTREGISTERLIST");
								%>
								<table border="2">
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
										<td align="center"><%=event.getName()%></td>
										<td align="center"><%=event.getDescription()%></td>
										<td align="center"><%=event.getDuration()%></td>
										<td align="center"><%=event.getEventType()%></td>
										<td align="center"><%=event.getSeatsAvailable()%></td>
										<td align="center"><%=event.getStartTime()%></td>
										<td align="center"><a href = "">Regist</a><a href = "">Unregist</a></td>
									</tr>
									<%
										}
									%>
								</table>

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
