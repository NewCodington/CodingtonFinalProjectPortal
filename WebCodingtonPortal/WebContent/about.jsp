<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/codington.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>About</title>
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
	<p class = "menuVerticalTitulos"><%= session.getAttribute("Visitor")!=null && !session.getAttribute("Visitor").toString().equals("")?session.getAttribute("Visitor").toString():session.getAttribute("Admin").toString() %>'s Menu</p>
	<hr size=10 />
	<p><a class="link" href=<%= session.getAttribute("Visitor")!=null && !session.getAttribute("Visitor").toString().equals("")?"visitor":"admin" %>>My Page </a></p>
	<hr />
	<p><a href="logout" class="link">Logout </a></p>
</div>


<div class="footer">
	<p>New Codignton Portal - December, 2014</p>
</div>

</body>
</html>