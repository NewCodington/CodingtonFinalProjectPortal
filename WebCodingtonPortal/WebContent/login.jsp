<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	  
<head>

	<link rel="stylesheet" type="text/css" href="css/codington.css" />
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<script language="javascript" src="Register.js"></script>
			<title>New Codington Portal</title>
	<link rel="stylesheet" type="text/css" media="screen" href="images/BrightSide.css" />

</head>

<body>
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
		
			<div class="main2">
				<br />
				<div id="error"><%= session.getAttribute("ErrorPriv")!=null?session.getAttribute("ErrorPriv").toString():""%></div>
				<div id="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
				<div id="error"><%= session.getAttribute("ErrorLogin")!=null?session.getAttribute("ErrorLogin").toString():""%></div>
				<div id="message"><%= session.getAttribute("Success")!=null?session.getAttribute("Success").toString():""%></div>
				
				
				<form class = "loginform" method="post" action="login">
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
						<input type="button" value="Cancel" />
				  
				  </div>
				  <div class = "register"><a href="registerVisitor" > Register New Visitor </a></div>
				</form>
				
			</div>
		</div>


		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>

	</body>

</html>