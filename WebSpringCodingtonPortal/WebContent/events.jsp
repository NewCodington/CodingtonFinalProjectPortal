<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="springcodingtonportal.model.domain.Event"%>
<%@page import="springcodingtonportal.model.domain.Visitor"%>

<html>
<head>

	<title>New Codington</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<link rel="stylesheet" type="text/css" media="screen" href="css/BrightSide.css" />

</head>

	<body>
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login.jsp");
		return;
	}
	else if (session.getAttribute("Admin")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("profileAdmin.htm");
		return;
	}
	else
	%> 
	
		<!-- wrap starts here -->
		<div id="wrap">
			
			<div id="header">				
					
				<h1 id="logo">New<span class="green">Codington</span></h1>	
				<h2 id="slogan">One of the World's Best Cities 2014</h2> 
				
							
				<!-- Menu Tabs -->
				<ul>
					<li><a href="history.jsp"><span>History</span></a></li>
					<li><a href="siteMap.jsp"><span>Site Map</span></a></li>
					<li><a href="about.jsp"><span>About</span></a></li>
			
				</ul>	
															
			</div>	
		
			<!-- content-wrap starts here -->
			<div id="content-wrap">		
													
			<img src="images/ciudad2.jpg" width="100%" height="120" alt="headerphoto" class="header-photo" />
				
				<div id="sidebar" >							
						
					<h1><%=session.getAttribute("Visitor") %></h1>
					<ul class="sidemenu">
						<li><a href="profileVisitor.htm">My Page</a></li>
						<li><a href="events.jsp">Town Events</a></li>
						<li><a href="getVisitor.htm">Update Information</a></li>
						<li><a href="updatePasswordVisitor.jsp">Update Password</a></li>
						<li><a href="logout.htm">Logout</a></li>
					</ul>		
								
				
				</div>
					
				<div id="main">	
					
							<div class="search">		
								<form class="searchform" method="post" action="visitor">	
									<input class = "textbox" type = "text" name="search" id="search" placeholder="Search" />
									<input type= "submit" value="Search" />
								</form>
							</div>
	
						
						<div class = "section2">
							<h1>North Town</h1>
							<div class = "subsection1">
								<h1>Business</h1>
								<a href ="business.jsp"><img src="images/business.jpg"  style = "width: 250px; height:180px"/></a>
							</div>
							<div class = "subsection1">
								<h1>Museum</h1>
								<a href = "museum.jsp"><img src="images/museum.jpg" style = "width: 250px; height:180px"/></a>
							</div>
						</div>
						
						<div class = "section2">
							
							<div class = "subsection1">
								<h1>Theater</h1>
								<a href = "theater.jsp"><img src="images/theater.jpg" style = "width: 250px; height:180px"/></a>
							</div>
							<div class = "subsection1">
								<h1>Stadium</h1>
								<a href ="stadium.jsp"><img src="images/stadium.jpg" style = "width: 250px; height:180px"/></a>
							</div>
							
						</div>
								
						
						
						<div class = "section2">	
						<h1>South Town</h1>				
											
							<div class = "subsection1">
								<h1>Parks</h1>
								<a href ="park.jsp"><img src="images/park.jpg" style = "width: 250px; height:180px"/></a>
							</div>
							
							<div class = "subsection1">
								<h1>Tourism</h1>
								<a href ="tourism.jsp"><img src="images/tourism.jpg" style = "width: 250px; height:180px"/></a>
							</div>
							
						</div>
						
						<div class = "section2">
							<div class = "subsection1">
								<h1>Zoos</h1>
								<a href ="zoo.jsp"><img src="images/zoo.jpg" style = "width: 250px; height:180px"/></a>
							</div>
							
							<div class = "subsection1">
								<h1>Markets</h1>
								<a href ="market.jsp"><img src="images/market.jpg" style = "width: 250px; height:180px"/></a>
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
	</body>
</html>
