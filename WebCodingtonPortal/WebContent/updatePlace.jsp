<!DOCTYPE html>
<html>
	 
	<head>
	 <%@page import="codingtonportal.model.domain.Place"%>
	<link rel="stylesheet" type="text/css" href="css/codington.css">
	</head>

<body>

<%
			Place place = new Place();
			place=(Place)session.getAttribute("PLACE");
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

<br><b><a style="color:red"><%= session.getAttribute("Error")!=null?session.getAttribute("Error"):""%></a></b>
	
	<form method="post" action="updatePlace">

		<p class = "title">
        	Update Place	    
        </p>
		
		  Place name: 
		  <br>
		  <input type="text" name="placeName"  value="<%= place.getName() %>" pattern="\S{1,45}" title="1 to 45 characters" required >
	      </p>
		 
		    <p>Description: 
		  <br>
		  <input type="text" name="description" title="1 to 45 characters"  value="<%= place.getDescription() %>" pattern="\S{1,45}" required="required"></input>
		    </p>
		 
		    <p>Region:
		  <br>
		  <input type="text" name="region" value="<%= place.getRegion() %>" pattern="\S{1,45}" title="1 to 45 characters" required/>
		    </p>
		    <p>Image: 
		      <br>
		      <input type="file" name="image" value="<%= place.getImage() %>" id="image"  />
		      <br>
		  
		   
	  
		  Address: <br>
		    <input type="text" name="address"  value="<%= place.getAddress() %>" pattern="\S{1,45}" title="1 to 45 characters" required/>
	  </p>
		    <p>Type Place  : <br>
	          <input type="text" name="typePlace" value="<%= place.getTypePlace() %>"required title="Field required"/>
   
		      </p>
		        </p>
		    <p class = "input">
				<input type="submit" value="Submit">
				<input type="button" value="Cancel"  onclick = "javascript:window.location='admin';">
		</p>
	  

	</form>
	
	

</div>




<div class ="footer">
New Codignton Portal - December, 2014
</div>

</body>
</html>

</html>