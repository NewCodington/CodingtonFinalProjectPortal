<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/codington.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Administrator</title>
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
	<p class = "menuVerticalTitulosAdmin"> Register</p>
	<hr>
	<p class = "regionadmin"><a class="linkMenuVertical"  href=<%="registerPlace"%>>Register Place </a></p>
	<p class = "regionadmin"><a class="linkMenuVertical" href=<%="registerEvent"%>>Register Event </a></p>
	</hr>
	
</div>
<br><b><a style="color:blue"><%= session.getAttribute("Success")!=null?session.getAttribute("Success").toString():""%></a></b>





<div class="footer">
New Codignton Portal - December, 2014
</div>





</body>
</html>
