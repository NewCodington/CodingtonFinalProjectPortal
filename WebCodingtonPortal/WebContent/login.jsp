<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	  
	<head>
		
		<link rel="stylesheet" type="text/css" href="css/codington.css">
		<script language="javascript" src="Register.js"></script>
		<title>New Codington Portal</title>
	</head>


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
	
</div>


<div class="nav_log">
	<br><b><a style="color:red"><%= session.getAttribute("ErrorLogin")!=null?session.getAttribute("ErrorLogin").toString():""%></a></b>
	<form method="post" action="login">
		<p class = "title">
		Sign In </p>
		<p class = "title"><br>
		  <input type="text" id = "uname" name="username" placeholder="Username" required/>
		  <br>
	      <input type="password" id = "pass" name="password" placeholder="Password" required/>
	      <br>
	  </p>
	  <p class = "input">
			<INPUT type="submit" value="Submit">
			<INPUT type="button" value="Cancel">
	  </p>
		
		<a href="registerVisitor" > Register New Visitor </a>
	</form>
</div>





<div class ="footer">
New Codignton Portal - December, 2014
</div>

</body>
</html>

</html>