<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="codingtonportal.model.domain.Visitor"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" media="screen" href="images/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Visitor Update Password Page</title>
	</head>

	<%
		Visitor visitor=new Visitor();
		visitor=(Visitor)session.getAttribute("VISITOR");
	%>

<body>
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login");
		return;
	}
	else if (session.getAttribute("Admin")!=null) {
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
											
		<img src="images/ciudad2.jpg" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
			<div id="sidebar">							
				
				<h1><%=session.getAttribute("Visitor") %></h1>
				<ul class="sidemenu">
					<li><a href="visitor">My Page</a></li>
					<li><a href="updateVisitor">Update Information</a></li>
					<li><a href="updatePasswordVisitor">Update Password</a></li>
					<li><a href="logout">Logout</a></li>

				</ul>		
						
		
			</div>
			
			<div class = "main2">

				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
				
				<form class = "loginform" method="post" action="updatePasswordVisitor">
					<h1>Update Password</h1>
			        <br />
					
					<div class="field"> <p>Password:</p>
					    <input type="password" name="pass" id = "pass" pattern="\S{6,15}" title="Enter a valid password (length between 6-15)" placeholder="Password" required />
					    <br />
				    </div>
				    
					<div class="field">  <p>Confirm Password:</p>
					    <input type="password" name="cpass" id = "cpass" pattern="\S{6,15}" title="Enter a valid password (length between 6-15)" placeholder="Confirm Password" required />
					    <br />
				    </div>
				  
				  	<div class="input">
						<input type="submit" value="Submit" />
						<input type="button" value="Cancel"  onclick = "javascript:window.location='visitor';" />
						<br />
					</div>  
				</form>
			</div>
		
		</div>

		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	</div>
</body>
</html>