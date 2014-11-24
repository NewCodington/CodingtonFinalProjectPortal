<!DOCTYPE html>
<html>
	 
	<head>
	 <%@page import="codingtonportal.model.domain.Event"%>
	<link rel="stylesheet" type="text/css" href="css/codington.css">
	</head>

<body>

<%
			Event event = new Event();
			event=(Event)session.getAttribute("EVENT");
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
</div>

<div class = "nav_log">

<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
	
	<form method="post" action="updateEvent">
		<p class = "title">
       Update Event </p>
		    <p>
		  Event name: 
		  <br>
		  <input type="text" id="eventName" name="eventName"  value="<%= event.getName() %>" pattern="\S{1,45}" title="Enter a valid event name (length between 1-45)"  placeholder="Event name"required >
		    </p>
		  
		    <p>Description: 
		  <br>
		  <input type="text" id="description" name="description" value="<%= event.getDescription() %>" title="1 to 45 characters" pattern="\S{1,45}" placeholder="Description" required></input>
		    </p>
		  
		    <p>Place:
		  <br>
		  <input type="text" id="place" name="place" pattern="\S{1,45}" value="<%= event.getPlace() %>" title="Enter a valid place (length between 1-45)" placeholder="Place" required/>
		    </p>
		  <p>Date:
		  <br>
		  <input type="text" id="date" name="date" pattern="\S{1,45}" value="<%= event.getDate_eventString() %>"title="Enter a valid date (length between 1-45)" placeholder="Date" required/>
		    </p>
		  
		 <p>Start Time:
		  <br>
		  <input type="text" id="startTime" name="startTime" value="<%= event.getStartTime() %>" pattern="\S{1,45}" title="Enter a valid place (length between 1-45)" placeholder="Date" required/>
		 </p>
		    
		 Duration: 
		  <br>
		  <input type="text" id="duration" name="duration" value="<%= event.getDuration() %>"  pattern="\S{1,45}" title="Enter a valid Duration (length between 1-45)" placeholder="Duration" required/><br>
		  
		    <p>Type of Event: 
		  <br>
		  <input type="text"  id="typeOfEvent"name="typeOfEvent"  value="<%= event.getEventType() %>" pattern="\S{1,45}" title="Enter a valid Type of event (length between 1-45)"  placeholder="Type of Event" required/>
		    </p>
		  
	 
	    <p>Seats Avalaible:
		  <br>
		  <input type="text" id="seats" name="seats" value="<%= event.getSeatsAvailable() %>" required title="Field required" placeholder="Seats Avalaible"/>
	    </p>

		<p class = "input">
		 
			<INPUT type="SUBMIT" value="Submit">
			<INPUT type="BUTTON" value="Cancel"  onclick = "javascript:window.location='admin';">
		
		</p>
	  

	</form>

</div>




<div class ="footer">
New Codignton Portal - December, 2014
</div>

</body>
</html>

</html>