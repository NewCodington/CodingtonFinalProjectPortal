<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="springcodingtonportal.model.domain.Visitor"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/BrightSide.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Visitor Update Page</title>
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
				
				<h1><%=session.getAttribute("Visitor") %></h1>
				<ul class="sidemenu">
					<li><a href="profileVisitor.htm">My Page</a></li>
					<li><a href="getVisitor.htm">Update Information</a></li>
					<li><a href="updatePasswordVisitor.jsp">Update Password</a></li>
					<li><a href="logout.htm">Logout</a></li>

				</ul>		
						
		
			</div>
	
	
		<div id="main">				
				<%
					Visitor visitor=(Visitor)session.getAttribute("VISITOR");
				%>
	
			<div class = "section">
			
				<form class = "Rform" method="post" action="updateVisitor.htm">
					<h1>Update User</h1>
			        <br />
					
					<div class="field"><p>First name:</p>
						<input type="text" value="<%= visitor.getFirstName() %>" name="fname" id = "fname" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){30}" title="Enter a valid first name (length between 1-30)" placeholder="First name"  required />
						<br />
				    </div>
					  
				    <div class="field"><p>Last name:</p> 
					   	<input type="text" value="<%= visitor.getLastName() %>" name="lname" id = "lname" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){30}" title="Enter a valid last name (length between 1-30)" placeholder="Last name"required />
				    	<br />
				    </div>
				    
					<div class="field"><p>DNI:</p>
					    <input type="text" name="dni"  value="<%= visitor.getDni() %>"id = "dni" title="Enter a valid dni(XX.XXX.XXX-L)" placeholder="Dni (XX.XXX.XXX-L)" />
					    <br />
				   	</div>
					
					<div class="field"><p>Phone Number:</p>
					    <input type="tel" name="phone" value="<%= visitor.getPhoneNumber() %>"id = "phone" placeholder="Phone Number" />
					    <br />
				    </div>
					
					<div class="field"><p>Email:</p> 
					    <input type="email" name="email" value="<%= visitor.getEmail() %>"id = "email" pattern="\S{3,200}" title="Enter a valid email (length between 3-200)" placeholder="Email" required />
				    	<br />
				    </div>
				    
					<div class="field"><p>Address:</p> 
					    <input type="text" name="adress" value="<%= visitor.getAddress() %>"id = "adress" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&|.|,|;|:|'|´){30}" placeholder="Address" />
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
	</div>

		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	
	</div>
	</body>
</html>