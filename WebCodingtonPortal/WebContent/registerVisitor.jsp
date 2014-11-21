<!DOCTYPE html>
<html>
	  
	<head>
	<link rel="stylesheet" type="text/css" href="css/codington.css">
	<script language="javascript" src="js/Register.js"></script>
	<title>New Codington Portal</title>
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
</div>

<div class = "nav_log">

<br><b><a style="color:red"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
	<form method="post" action="registerVisitor">
		<p class = "title">
        New User</p>
		
		  <p>First name: 
		    <br>
		    <input type="text" name="fname" id = "fname" pattern="\S{1,30}" title="Enter a valid first name (length between 1-30)" placeholder="First name"  required>
	    </p>
		  <p>
		  
	    Last name: 
		    <br>
		    <input type="text" name="lname" id = "lname" pattern="\S{1,30}" title="Enter a valid last name (length between 1-30)" placeholder="Last name"required>
	      </p>
		  <p>Username:
		    <br>
		    <input type="text" name="uname" id = "uname" pattern="\S{6,12}" title="Enter a valid username (length between 6-12)" placeholder="Username" required>
	      </p>
		  <p>Password: 
		    <br>
		    <input type="password" name="pass" id = "pass" pattern="\S{6,15}" title="Enter a valid password (length between 6-15)" placeholder="Password" required>
	      </p>
		  <p>Confirm Password: 
		    <br>
		    <input type="password" name="cpass" id = "cpass" pattern="\S{6,15}" title="Enter a valid password (length between 6-15)" placeholder="Confirm Password" required>
	      </p>
		  <p>DNI:
		    <br>
		    <input type="text" name="dni" id = "dni" title="Enter a valid dni(XX.XXX.XXX-L)" placeholder="Dni (XX.XXX.XXX-L)" >
	      </p>
		  <p>Phone Number:
		    <br>
		    <input type="tel" name="phone" id = "phone" placeholder="Phone Number">
	      </p>
		  <p>Email: 
		    <br>
		    <input type="email" name="email" id = "email" pattern="\S{3,200}" title="Enter a valid email (length between 3-200)" placeholder="Email" required >
	    </p>
		  <p>Address: 
		    <br>
		    <input type="text" name="adress" id = "adress" placeholder="Address">
	  </p>
	    <p class = "input">
		  <INPUT type="SUBMIT" value="Submit" onclick = "return validateForm()">
		  <INPUT type="BUTTON" value="Cancel" onclick = "javascript:window.location='login';">
	  </p>
	  

	</form>

</div>




<div class ="footer">
New Codignton Portal - December, 2014
</div>

</body>
</html>

</html>