<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	  
	<head>
		
		<link rel="stylesheet" type="text/css" href="css/codington.css">
		<script language="javascript" src="Register.js"></script>
		<title>New Codington Portal</title>
	</head>


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
			<INPUT type="SUBMIT" value="Submit">
			<INPUT type="BUTTON" value="Cancel">
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