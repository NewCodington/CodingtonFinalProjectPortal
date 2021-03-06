<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="springcodingtonportal.model.domain.Place"%>
<%@page import="java.util.ArrayList"%>
<%@page import="springcodingtonportal.model.domain.TypePlace"%>
 
<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/BrightSide.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Place Update Page</title>
	</head>


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

		<div id="content-wrap">
		
		
		<img src="image.htm?name=headerphoto" width="100%" height="120" alt="headerphoto" class="header-photo" />
		
			
			<div id="sidebar">							
				
				<h1><%=session.getAttribute("Admin") %></h1>
				<ul class="sidemenu">
					<li><a href="profileAdmin.htm">My Page</a></li>
					<li><a href=<%="registerPlace.htm"%>>Register Place</a></li>
					<li><a href=<%="registerEvent.htm"%>>Register Event</a></li>
					<li><a href="logout.htm">Logout</a></li>

				</ul>		
						
		
			</div>
	
	
			<div id="main">
				<%
					if (request.getAttribute("idPlace") != null) {
						session.setAttribute("idPlace", request.getAttribute("idPlace"));
						Place place = (Place)request.getAttribute("PLACE");
						ArrayList<TypePlace> typePlaceList = (ArrayList<TypePlace>) request.getAttribute("LISTTYPEPLACE");
				%>
				
				<div class = "section">
					<form class = "Rform" method="post" action="updatePlace.htm" enctype="multipart/form-data">
						<h1>Update Place</h1>
						<br />
						
						<div class="field"><p>Place name:</p> 
							<input type="text" id="placeName" name="placeName" value="<%= place.getName() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){45}" title="1 to 45 characters" required />
							<br />
						</div>
						 
						<div class="field"><p>Description:</p> 
							<input type="text" name="description" value="<%= place.getDescription() %>" title="1 to 45 characters" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){45}" required="required" />
							<br />
						</div>
							
						<div class="field"><p>Image:</p> 
							<input type="file" id="image" name="image" value="<%= place.getImage() %>" id="image" required />
							<br /><br />
						</div>
							
						<div class="field"><p>Address:</p> 
							<input type="text" id="address" name="address" value="<%= place.getAddress() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){30}" title="1 to 45 characters" required/>
							<br /><br />
						</div>
							
						<div class="field"><p>Type Place:</p>
							<select id="typePlace" name="typePlace" required>
								<%
									for (TypePlace typePlace : typePlaceList) {
								%>
								<option value="<%= typePlace.getIdTypePlace()%>" <%= place.getTypePlace() == typePlace.getIdTypePlace()?"selected":"" %>> <%=typePlace.getName() %></option>
								<%
									}
								%>
							</select>
							<br />
						</div>
						
						<div class="input">
							<input type="submit" value="Submit" />
							<input type="button" value="Cancel"  onclick = "javascript:window.location='profileAdmin.htm';" />
							<br />
						</div>  
					</form>
					<%
						}
					%>
				</div>
			</div>
		</div>
		
		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	</div>
	</body>
</html>