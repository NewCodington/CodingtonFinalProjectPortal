<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.TypePlace"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" media="screen" href="images/BrightSide.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Event Register Page</title>
	</head>

	
<body>
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login");
		return;
	}
	else if (session.getAttribute("Visitor")!=null) {
		session.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		session.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("visitor");
		return;
	}
	else
	{
		if(session.getAttribute("LISTTYPEPLACE") == null)
			response.sendRedirect("registerPlace");
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

		
		<div id="content-wrap">
		

		<img src="images/ciudad2.jpg" width="100%" height="120" alt="headerphoto" class="header-photo" />
			
			<div id="sidebar">							
				
				<h1><%=session.getAttribute("Admin") %></h1>
				<ul class="sidemenu">
					<li><a href="index.html">My Page</a></li>
					<li><a href=<%="registerPlace"%>>Register Place</a></li>
					<li><a href=<%="registerEvent"%>>Register Event</a></li>
					<li><a href="logout">Logout</a></li>

				</ul>		
						
		
			</div>
			<div id="main">
				
				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error"):""%></div>
				
					<div class = "section">
		
					<form class = "Rform" method="post" action="registerPlace" enctype="multipart/form-data">
							<h1>New Place</h1>
							<br />
					
							<div class="field"><p>Place name:</p> 
								<input type="text" id="placeName" name="placeName" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){45}" title="1 to 45 characters" required />
								<br />
							</div>
							 
							<div class="field"><p>Description:</p> 
								<input type="text" name="description" title="1 to 45 characters" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){45}" required="required" />
								<br />
							</div>
								
							<div class="field"><p>Image:</p> 
								<input type="file" id="image" name="image" id="image" required />
								<br /><br />
							</div>
								
							<div class="field"><p>Address:</p> 
								<input type="text" id="address" name="address"  pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){30}" title="1 to 30 characters" required/>
								<br /><br />
							</div>
							
							<div class="field"><p>Type Place:</p>
								<%
									if (session.getAttribute("LISTTYPEPLACE") != null) {
										ArrayList<TypePlace> typePlaceList = (ArrayList<TypePlace>) session.getAttribute("LISTTYPEPLACE");
								%>
								<select id="typePlace" name="typePlace" required>
									<%
										for (TypePlace typePlace : typePlaceList) {
									%>
									<option value="<%= typePlace.getIdTypePlace()%>"><%=typePlace.getName() %></option>
									<%
										}
									%>
								</select>
								<%
									}
								%>
								<br />
							</div>
							
							<div class="input">
								<input type="submit" value="Submit" />
								<input type="button" value="Cancel"  onclick = "javascript:window.location='admin';" />
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
