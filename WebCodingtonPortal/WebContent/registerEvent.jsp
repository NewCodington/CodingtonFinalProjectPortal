<!DOCTYPE html>
<html>
	  
	<head>
	<link rel="stylesheet" type="text/css" href="css/codington.css">
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
</div>

<div class = "nav_log">

<br><b><a style="color:blue"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
	
	<form method="post" action="RegistEventServlet">
		<p class = "title">
        New Event </p>
		    <p>
		  Event name: 
		  <br>
		  <input type="text" id="eventName" name="eventName" pattern="\S{1,45}" title="Enter a valid event name (length between 1-45)"  placeholder="Event name"required >
		    </p>
		  
		    <p>Description: 
		  <br>
		  <textarea id="description" name="description" title="1 to 45 characters" pattern="\S{1,45}" placeholder="Description" required></textarea>
		    </p>
		  
		    <p>Place:
		  <br>
		  <input type="text" id="place" name="place" pattern="\S{1,45}" title="Enter a valid place (length between 1-45)" placeholder="Place" required/>
		    </p>
			 <p>Date:
		  <br>
		  <input type="text" id="date" name="date" pattern="\S{1,45}" title="Enter a valid place (length between 1-45)" placeholder="Date" required/>
		    </p>
		  
		 Duration: 
		  <br>
		  <input type="text" id="duration" name="duration"  pattern="\S{1,45}" title="Enter a valid Duration (length between 1-45)" placeholder="Duration" required/><br>
		  
		    <p>Type of Event: 
		  <br>
		  <input type="text"  id="typeOfEvent"name="typeOfEvent"  pattern="\S{1,45}" title="Enter a valid Type of event (length between 1-45)"  placeholder="Type of Event" required/>
		    </p>
		  
	 
	    <p>Seats Avalaible:
		  <br>
		  <input type="text" id="seats" name="seats" required title="Field required" placeholder="Seats Avalaible"/>
	    </p>
	  
		</p>
		<p class = "input">
		 
			<INPUT type="SUBMIT" value="Submit">
			<INPUT type="SUBMIT" value="Cancel"  onclick = "javascript:window.location='admin.jsp';">
		</p>
	  

	</form>

</div>




<div class ="footer">
New Codignton Portal - December, 2014
</div>

</body>
</html>

</html>