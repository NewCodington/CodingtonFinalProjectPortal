<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

		<link rel="stylesheet" type="text/css" href="css/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>SiteMap</title>

</head>

<body>


	
<!-- wrap starts here -->
<div id="wrap">
	
	<div id="header">				
			
		<h1 id="logo">New<span class="green">Codington</span></h1>	
		<h2 id="slogan">One of the World's Best Cities 2014</h2> 
		
					
		<!-- Menu Tabs -->
			<ul>
				<li><a href="events.jsp"><span>Event Catalog</span></a></li>
				<li id="current"><a href="siteMap.jsp"><span>Site Map</span></a></li>
				<li><a href="about.jsp"><span>About</span></a></li>
		
			</ul>	
													
	</div>	

	<!-- content-wrap starts here -->
	<div id="content-wrap">		
											
	<img src="image.htm?name=headerphoto" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
		<div id="sidebar" >							
				
			<h1><%= session.getAttribute("Visitor")!=null?session.getAttribute("Visitor").toString():session.getAttribute("Admin").toString() %></h1>
			<ul class="sidemenu">
				<li><a href=<%= session.getAttribute("Visitor")!=null && !session.getAttribute("Visitor").toString().equals("")?"profileVisitor.htm":"profileAdmin.htm" %>>My Page</a></li>
				<%
					if (session.getAttribute("Admin")!=null && !session.getAttribute("Admin").toString().equals("")) 
					{
				%>
				<li><a href=<%="registerPlace.htm"%>>Register Place</a></li>
				<li><a href=<%="registerEvent.htm"%>>Register Event</a></li>
				
				<%
					}else {
				%>
				
				<li><a href="getVisitor.htm">Update Information</a></li>
				<li><a href="updatePasswordVisitor.jsp">Update Password</a></li>
				
				<%
					}
				%>
					
				<li><a href="logout.htm">Logout</a></li>

			</ul>		
						
		
		</div>
			
		<div id="main">	
			
			<div id="content">

					
			<div class="right_nav">
				<div class="title">SITE MAP <hr /></div>
				
				<div class="content">
					<p>Login </a></p>
				  	<blockquote>Register Visitor Page</a></blockquote>
				  	<blockquote>Visitor's Page </a></blockquote>
				  	<blockquote>Admin's Page </a></blockquote>
				  	<blockquote><blockquote>Event's Registration Page </a></blockquote></blockquote>
				  	<blockquote><blockquote>Place's Registration Page </a></blockquote></blockquote>
				  	<blockquote>History Page</a></blockquote>
				  	<blockquote>SiteMap Page</a></blockquote>
				  	<blockquote>About Page</a></blockquote>
			  	</div>
			</div>
			
		</div>
	</div>

		
							
	
			
					
	<!-- content-wrap ends here -->		
	</div>

<!-- footer starts here -->	
<div id="footer">
	
	
	<p>New Codignton Portal - December, 2014</p>
	
	
</div>
<!-- footer ends here -->
	
<!-- wrap ends here -->
</div>
</div>

</body>
</html>
