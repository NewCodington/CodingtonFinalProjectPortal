<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	  
<head>

			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<script language="javascript" src="Register.js"></script>
			<title>New Codington Portal</title>
			<link rel="stylesheet" type="text/css" media="screen" href="css/BrightSide.css" />

</head>

<body>
	<div id="wrap">
	 
		<div id="header">				
			
			<h1 id="logo">New<span class="green">Codington</span></h1>	
			<h2 id="slogan">One of the World's Best Cities 2014</h2> 						
		</div>
	
		
	<!-- content-wrap starts here -->
	<div id="content-wrap">		
											
	<img src="image.htm?name=headerphoto" width="100%" height="120" alt="headerphoto" class="header-photo"/>
		
			<div class="main">
				<br />
				<div id="error">${VisitorLoginMessage}</div><div id="error">${ErrorPriv}</div>
				<div id="message">${RegisterVisitorMessage}</div>
				<% session.removeAttribute("ErrorPriv"); %>
				
				<form class = "loginform" method="post" action="login.htm">
					<h1>Sign In</h1>
					<br />
					
					<div class="field">
					  	<input type="text" id = "uname" name="username" placeholder="Username" required />
					  	<br />
					</div>
					
					<div class="field">
				    	<input type="password" id = "pass" name="password" placeholder="Password" required />
				      	<br />
				  	</div>
				  <div class = "input">
						<input type="submit" value="Submit" />
				  
				  </div>
				  <div class = "register"><a href="registerVisitor.jsp" > Register New Visitor </a></div>
				</form>
				
			</div>
		</div>


		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	</div>
	</body>

</html>