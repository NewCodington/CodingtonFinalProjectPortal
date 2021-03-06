<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="codingtonportal.model.domain.Visitor"%>
<%@ page import = "codingtonportal.utils.ImageConversion" %>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" media="screen" href="images/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="Register.js"></script>
		<title>Visitor Register Page</title>
		
	</head>


<body>

		<%
	if (session.getAttribute("Visitor")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("visitor");
		return;
	}
	else if(session.getAttribute("Admin")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("admin");
		return;
	}
	%> 
	
<div id="wrap">
	
	<div id="header">				
			
		<h1 id="logo">New<span class="green">Codington</span></h1>	
		<h2 id="slogan">One of the World's Best Cities 2014</h2> 
		
					
		<!-- Menu Tabs -->
		<ul>
			<li id="current"><a href="history.jsp"><span>History</span></a></li>
			<li><a href="siteMap.jsp"><span>Site Map</span></a></li>
			<li><a href="about.jsp"><span>About</span></a></li>
	
		</ul>	
													
	</div>	

	<!-- content-wrap starts here -->
	<div id="content-wrap">		
	
	<%ImageConversion nev= new ImageConversion(); %>										
	<!--<img src="images/ciudad2.jpg" width="100%" height="120" alt="headerphoto" class="header-photo" />  -->
	<img src="<%=nev.showImage_Page("headerphoto")%>"width="100%" height="120" alt="headerphoto" class="header-photo" />
		
		
		<div id="content-wrap">
			<div id = "main2">
				

				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>

				<%
					Visitor visitor = null;
					if (session.getAttribute("VisitorInfo") != null) {
						visitor = (Visitor) session.getAttribute("VisitorInfo");
					}
				%>	
				
					<form class = "Rform" method="post" name="f" action="registerVisitor" onsubmit = "return validateForm();">
						<h1>New User</h1>
						<br />
						
						<div class="field"><p>First name:</p>
							<input type="text" name="fname" id = "fname" value="<%= visitor!=null?visitor.getFirstName():""%>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){30}" title="Enter a valid first name (length between 1-30)" placeholder="First name"  required />
							<br />
						</div>
						  
						<div class="field"><p>Last name:</p> 
							<input type="text" name="lname" id = "lname" value="<%= visitor!=null?visitor.getLastName():""%>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){30}" title="Enter a valid last name (length between 1-30)" placeholder="Last name"required />
							<br />
						</div>
						
						<div id="error"><%= session.getAttribute("ErrorUser")!=null?session.getAttribute("ErrorUser").toString():""%></div>
			
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
					  
						<div class = "input">
							<input type="submit" value="Submit"  />
							<input type="button" value="Cancel"  onclick = "javascript:window.location='login';" />
							<br />
						 </div>
					</form>
				
			
			</div>
		</div>
	
</div>
	 
		
		


		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	
	</body>
</html>