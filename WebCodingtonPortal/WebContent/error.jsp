<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
 
<% response.setStatus(404); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="codingtonportal.model.domain.Event"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.Place"%>
<%@ page import = "codingtonportal.utils.ImageConversion" %>

<html>
	  
<head>
		<link rel="stylesheet" type="text/css" media="screen" href="images/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Error Page</title>
</head>

	<body>
	
<!-- wrap starts here -->
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
	<img src="<%=nev.showImage_Page("headerphoto")%>" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
		<div id="sidebar" >							
				
			<h1><%= session.getAttribute("Visitor")!=null?session.getAttribute("Visitor").toString():session.getAttribute("Admin").toString() %>></h1>
			<ul class="sidemenu">
				<li><a href=<%= session.getAttribute("Visitor")!=null && !session.getAttribute("Visitor").toString().equals("")?"visitor":"admin" %>>My Page</a></li>
				<li><a href="events.jsp">Town Events</a></li>
				<%
					if (session.getAttribute("Admin")!=null && !session.getAttribute("Admin").toString().equals("")) 
					{
				%>
				<li><a href=<%="registerPlace"%>>Register Place</a></li>
				<li><a href=<%="registerEvent"%>>Register Event</a></li>
				
				<%
					}else {
				%>
				
				<li><a href="updateVisitor">Update Information</a></li>
				<li><a href="updatePasswordVisitor">Update Password</a></li>
				
				<%
					}
				%>
					
				<li><a href="logout">Logout</a></li>

			</ul>		
						
		
		</div>
			
		<div id="main">	
			


		<div id="content">
			
				<div class="error"><p>There has been a problem on the server. Please try again later.</p>
					<p>Sorry for the inconvenience.</p>
				</div>
				<%session.invalidate();%>
				<br /><br />
				<p class = "return"><a align="center" href="login" class="link">Return to Login </a></p>
			
		</div>
		</div>
		
		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	</div>
	</div>
	</body>
</html>