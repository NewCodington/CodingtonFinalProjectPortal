<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	  
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/codington.css">
	<title>New Codington Portal</title>
</head>



<div class="header">
	<p class="cabecera">New Codington Portal</p>
	<p class="cabecera2">One of the World's Best Cities 2014</p>
</div>


<div class="nav_log">

	<br><b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
	
	<form  method = "post" action = "SigninServlet">
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
			<INPUT type="SUBMIT" value="Cancel">
	  </p>
	</form>
		
	<a href="Regist.html" > Register New Visitor </a>
		
</div>





<div class ="footer">
Copyright © W3Schools.com
</div>

</body>
</html>
