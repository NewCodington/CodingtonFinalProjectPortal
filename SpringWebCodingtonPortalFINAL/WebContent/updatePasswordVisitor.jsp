<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="springcodingtonportal.model.domain.Visitor"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" media="screen" href="css/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Visitor Update Password Page</title>
	</head>

	<%
		Visitor visitor=new Visitor();
		visitor=(Visitor)session.getAttribute("VISITOR");
	%>

<body>

	
	<div id="wrap">
	 
		<div id="header">				
			
			<h1 id="logo">New<span class="green">Codington</span></h1>	
			<h2 id="slogan">One of the World's Best Cities 2014</h2> 
		
			
			<!-- Menu Tabs -->
			<ul>
				<li><a href="events.jsp"><span>Event Catalog</span></a></li>
				<li><a href="siteMap.jsp"><span>Site Map</span></a></li>
				<li><a href="about.jsp"><span>About</span></a></li>
		
			</ul>													
		</div>
		
		<!-- content-wrap starts here -->
		<div id="content-wrap">		
											
		<img src="image.htm?name=headerphoto" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
			<div id="sidebar">							
				
				<h1><%=session.getAttribute("Visitor") %></h1>
				<ul class="sidemenu">
					<li><a href="profileVisitor.htm">My Page</a></li>
					<li><a href="getVisitor.htm">Update Information</a></li>
					<li><a href="updatePasswordVisitor.jsp">Update Password</a></li>
					<li><a href="logout.htm">Logout</a></li>

				</ul>		
						
		
			</div>
			
			<div id = "main">


				<form class = "Rform" method="post" action="updatePasswordVisitor.htm" onsubmit = "return validateConfirmPass();">
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
						<input type="button" value="Cancel"  onclick = "javascript:window.location='profileVisitor.htm';" />
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