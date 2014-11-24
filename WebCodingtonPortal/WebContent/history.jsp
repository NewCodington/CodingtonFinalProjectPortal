<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/codington.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>History</title>
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



<div class = "section">
	
  <div id="event">
    <table width=100% border="0">
          <tr>
            <td width="10">&nbsp;</td>
            <td width="676" colspan="3"><h1>History of New Codignton</h1></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td colspan="3"><p align="justify">New Codington a new city is formed by the union of two small towns separated by the New Codington River that formerly was called the River Coder. Each of the zones has a tower and various public spaces. In the north are the Museum, the Theater, the Large Business and Stadium. While in the south, are the open spaces as well as the Zoo, the typical Markets, Tourist Attractions and the Park. </p>
              <p align="justify"> It is an annual festival held during the summer to celebrate the founding of the city. During the festival, various events are held in different places. Each year these events will vary. </p>
            </p></td>
          </tr>
        </table>
		<p>&nbsp;</p>
	<p align="justify">&nbsp;</p>
	</div>

</div>

<div class="footer">
	<p>New Codignton Portal - December, 2014</p>
</div>





</body>
</html>
