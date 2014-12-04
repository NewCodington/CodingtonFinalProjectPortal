<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" media="screen" href="css/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>History</title>
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
		
		<img src="image.htm?name=headerphoto" width="100%" height="120" alt="headerphoto" class="header-photo" />
	
		<div id="sidebar" >							
				
			<h1><%= session.getAttribute("Visitor")!=null?session.getAttribute("Visitor").toString():session.getAttribute("Admin").toString() %></h1>
			<ul class="sidemenu">
				<li><a href=<%= (session.getAttribute("Visitor")!=null && !session.getAttribute("Visitor").toString().equals(""))?"profileVisitor.htm":"profileAdmin.htm" %>>My Page</a></li>
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

			
		<div class = "section">
			<h1>History of New Codignton </h1><hr />
			
			<div class="content">
					<p>New Codington a new city is formed by the union of two small towns separated by the New Codington River that formerly was called the River Coder. Each of the zones has a tower and various public spaces. In the north are the Museum, the Theater, the Large Business and Stadium. While in the south, are the open spaces as well as the Zoo, the typical Markets, Tourist Attractions and the Park. </p>
	             	<p> It is an annual festival held during the summer to celebrate the founding of the city. During the festival, various events are held in different places. Each year these events will vary. </p>
	        </div>
		</div>
		</div>
		
		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	
	</div>
	</body>
</html>