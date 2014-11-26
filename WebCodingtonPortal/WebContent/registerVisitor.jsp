<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="codingtonportal.model.domain.Visitor"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="Register.js"></script>
		<title>Visitor Register Page</title>
	
	</head>


<body id="body">
	<%
	if (session.getAttribute("Visitor")!=null) {
		//session.setAttribute("Error", "You do not have administrator privileges. You will be redirected to your profile page");
		response.sendRedirect("visitor");
		return;
	}
	else if(session.getAttribute("Admin")!=null) {
		response.sendRedirect("admin");
		return;
	}
	%> 
		<div id="header">
			<table>
		    	<tr>
		      		<td class="colum1" rowspan="2">
		        		<img src="logo.gif" width="130" height="130" vspace="30" hspace="75" align="middle" />
		        	</td>
		        	<td class="colum2">
		        		<div class="title">New Codington Portal</div>
		        	</td>	
		        	<td class="colum3">&nbsp;</td>
		      		</tr>
		      	<tr>
		        	<td>
		        		<div class="subtitle">One of the World's Best Cities 2014</div>
		        	</td>
		        	<td>&nbsp;</td>
		      	</tr>
		    </table>
		</div>
		
		
		<div id="content">

			<div class = "center_nav">

				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>

				<%
					Visitor visitor = null;
					if (session.getAttribute("VisitorInfo") != null) {
						visitor = (Visitor) session.getAttribute("VisitorInfo");
					}
				%>				
				<form method="post" id="f" name="f" action="registerVisitor" onsubmit = "return validateForm();">
					<div class="title">New User</div>
			        <br />
					
					<div class="field"><p>First name:</p>
						<input type="text" name="fname" id = "fname" value="<%= visitor!=null?visitor.getFirstName():""%>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){30}" title="Enter a valid first name (length between 1-30)" placeholder="First name"  required />
						<br />
				    </div>
					  
				    <div class="field"><p>Last name:</p> 
					   	<input type="text" name="lname" id = "lname" value="<%= visitor!=null?visitor.getLastName():""%>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){30}" title="Enter a valid last name (length between 1-30)" placeholder="Last name"required />
				    	<br />
				    </div>
				    
				    <div class="error"><%= session.getAttribute("ErrorUser")!=null?session.getAttribute("ErrorUser").toString():""%></div>
					<div class="field"><p>Username:</p>
					    <input type="text" name="uname" id = "uname" value="<%= visitor!=null?visitor.getUserName():""%>" pattern="\S{6,12}" title="Enter a valid username (length between 6-12)" placeholder="Username" required />
					    <br />
				    </div>
					
					<div class="field"><p>Password:</p> 
					    <input type="password" name="pass" id = "pass" value="" pattern="\S{6,15}" title="Enter a valid password (length between 6-15)" placeholder="Password" required />
					    <br />
				    </div>
				    
					<div class="field"><p>Confirm Password:</p> 
					    <input type="password" name="cpass" id = "cpass" value="" pattern="\S{6,15}" title="Enter a valid password (length between 6-15)" placeholder="Confirm Password" required />
					    <br />
				    </div>
				    
					<div class="field"><p>DNI:</p>
					    <input type="text" name="dni" id = "dni" value="<%= visitor!=null?visitor.getDni():""%>" title="Enter a valid dni(XX.XXX.XXX-L)" placeholder="Dni (XX.XXX.XXX-L)" />
					    <br />
				   	</div>
					
					<div class="field"><p>Phone Number:</p>
					    <input type="tel" name="phone" id = "phone" value="<%= visitor!=null?visitor.getPhoneNumber():""%>" placeholder="Phone Number" />
					    <br />
				    </div>
					
					<div class="field"><p>Email:</p> 
					    <input type="email" name="email" id = "email" value="<%= visitor!=null?visitor.getEmail():""%>" pattern="\S{3,200}" title="Enter a valid email (length between 3-200)" placeholder="Email" required />
				    	<br />
				    </div>
				    
					<div class="field"><p>Address:</p> 
					    <input type="text" name="adress" id = "adress" value="<%= visitor!=null?visitor.getAddress():""%>" placeholder="Address" />
					    <br />
				  	</div>
				  
				  	<div class="input">
						<input type="submit" value="Submit"  />
						<input type="button" value="Cancel"  onclick = "javascript:window.location='login';" />
						<br />
					</div>  
				</form>
			</div>
		</div>


		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	
	</body>
</html>