<!DOCTYPE html>
<html>
	  
	<head>
	<link rel="stylesheet" type="text/css" href="css/codington.css">
	<title>Event Register Page</title>
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
	
	
<div class = "nav_log">

	<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
	
	<form method="post" action="registerEvent">
		<p class = "title">
        New Event </p>
		    <p>
		  Event name: 
		  <br>
		  <input type="text" id="eventName" name="eventName" pattern="\S{1,45}" title="Enter a valid event name (length between 1-45)"  placeholder="Event name"required >
		    </p>
		  
		    <p>Description: 
		  <br>
		  <input type="text" id="description" name="description" title="1 to 45 characters" pattern="\S{1,45}" placeholder="Description" required></input>
		    </p>
		  
		    <p>Place:
		  <br>
		  <input type="text" id="place" name="place" pattern="\S{1,45}" title="Enter a valid place (length between 1-45)" placeholder="Place" required/>
		    </p>
		  <p>Date:
		  <br>
		  <input type="text" id="date" name="date" pattern="\S{1,45}" title="Enter a valid place (length between 1-45)" placeholder="Date" required/>
		    </p>
		  
		 <p>Start Time:
		  <br>
		  <input type="text" id="startTime" name="startTime" pattern="\S{1,45}" title="Enter a valid place (length between 1-45)" placeholder="Date" required/>
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

		<p class = "input">
		 
			<INPUT type="submit" value="Submit">
			<INPUT type="button" value="Cancel"  onclick = "javascript:window.location='admin';">
		
		</p>
	  

	</form>

</div>




<div class ="footer">
New Codignton Portal - December, 2014
</div>

</body>
</html>

</html>