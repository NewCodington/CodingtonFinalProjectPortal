<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/codington.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SiteMap</title>

</head>

<body>

	<div class="header">
		<table width="100%" border="0">
	      <tr>
	        <td width="284" rowspan="2"><img src="logo.gif" width=130 height=130 border=2 vspace=30 hspace=75 align=middle /></td>
	        <td><p class="cabecera">New Codington Portal</p></td>	
	        <td width="151">&nbsp;</td>
	        <td width="6"></p>
	      </tr>
	      <tr>
	        <td><p class="cabecera2"><strong><em>One of the World's Best Cities 2014</em></strong></p>
	      </td>
	        <td>&nbsp;</td>
	      </tr>
	    </table>
		
		<div class="menuHorizontal"> <a href="history.jsp" class="link" > History </a> | <a href="siteMap.jsp" class="link">Site Map </a> | <a href="about.jsp" class="link">About </a> </div>
		
	</div>



	<div class = "left_nav">
		
		<p><a class="link" href=<%= session.getAttribute("Visitor")!=null && !session.getAttribute("Visitor").toString().equals("")?"visitor":"admin" %>>My Page </a></p>
		<hr />
		<p><a href="logout" class="link">Logout </a></p>
	</div>



	<div class = "section">
	  	<p><a href="login" class="link">Login </a></p>
	  	<blockquote><a href="register" class="link">Register Visitor Page</a></blockquote>
	  	<blockquote><a href="visitor" class="link">Visitor's Page </a></blockquote>
	  	<blockquote><a href="admin" class="link">Admin's Page </a></blockquote>
	  	<blockquote><blockquote><a href="registerEvent" class="link">Event's Registration Page </a></blockquote></blockquote>
	  	<blockquote><blockquote><a href="registerPlace" class="link">Place's Registration Page </a></blockquote></blockquote>
	  	<blockquote><a href="history.jsp" class="link">History Page</a></blockquote>
	  	<blockquote><a href="siteMap.jsp" class="link">SiteMap Page</a></blockquote>
	  	<blockquote><a href="admin" class="link">About Page</a></blockquote>
	</div>



	<div class="footer">
		<p>New Codignton Portal - December, 2014</p>
	</div>





</body>
</html>
