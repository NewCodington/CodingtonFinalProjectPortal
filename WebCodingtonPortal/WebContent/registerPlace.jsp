<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	  
	<head>
	<link rel="stylesheet" type="text/css" href="css/codington.css">
	<title>Place Register Page</title>
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
	<div class="message"><%= session.getAttribute("Error")!=null?session.getAttribute("Error"):""%></div>
	
	<form method="post" action="RegistPlaceServlet">
		<p class = "title">
        New Place	    </p>
		
		  Place name: 
		  <br>
		  <input type="text" name="placeName" pattern="\S{1,45}" title="1 to 45 characters" required >
	      </p>
		 
		    <p>Description: 
		  <br>
		  <textarea name="description" title="1 to 45 characters" pattern="\S{1,45}" required="required"></textarea>
		    </p>
		 
		    <p>Region:
		  <br>
		  <input type="text" name="region" pattern="\S{1,45}" title="1 to 45 characters" required/>
		    </p>
		    <p>Image: 
		      <br>
		      <input type="file" name="image" id="image" required />
		      <br>
		  
		   
	  
		  Address: <br>
		    <input type="text" name="address"  pattern="\S{1,45}" title="1 to 45 characters" required/>
	  </p>
		    <p>Type Place  : <br>
	          <input type="text" name="typePlace" required title="Field required"/>
   
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