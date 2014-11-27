<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="codingtonportal.model.domain.Place"%>
<%@page import="java.util.ArrayList"%>
<%@page import="codingtonportal.model.domain.TypePlace"%>
	 
<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Place Update Page</title>
	</head>


	<body id="body">
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
		if(session.getAttribute("idPlace") == null) {
			session.setAttribute("ErrorPriv", "You have not got selected a Place to update.");
			session.setAttribute("ViewErrorPriv", "YES");
			
			response.sendRedirect("admin");
			return;	
		}
	}
	%> 
		<div id="header">
			<table>
		    	<tr>
		      		<td class="colum1" rowspan="2">
		        		<img src="logo.gif" width="130" height="130" vspace="30" hspace="75" align="middle" />
		        	</td>
		        	<td class="colum2">
		        		<div class="title">New Codington Portal</div>
		        	</td>	
		        	<td class="colum3">&nbsp;</td>
		      		</tr>
		      	<tr>
		        	<td>
		        		<div class="subtitle">One of the World's Best Cities 2014</div>
		        	</td>
		        	<td>&nbsp;</td>
		      	</tr>
		    </table>
		    <div class="menuHorizontal"> <a href="history.jsp" class="link" > History </a> | <a href="siteMap.jsp" class="link">Site Map </a> | <a href="about.jsp" class="link">About </a> </div>
		</div>

		<div id="content">
			
			<div class = "left_nav">
				<div class = "title"><p><%=session.getAttribute("Admin") %>'s Menu</p></div>
				<hr size=10 />
				
				<div class = content>	
					<p><a href="admin" class="link">My Page </a></p>
					<hr />
					<p ><a class="link"  href=<%="registerPlace"%>>Register Place </a></p>
					<p ><a class="link" href=<%="registerEvent"%>>Register Event </a></p>
					<hr />
					<p><a href="logout" class="link">Logout </a></p>
				</div>
			</div>
	
	
			<div class="center_nav">
				
				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>

				<%
					if (session.getAttribute("idPlace") != null) {
						Place place = (Place)session.getAttribute("PLACE");
						ArrayList<TypePlace> typePlaceList = (ArrayList<TypePlace>) session.getAttribute("LISTTYPEPLACE");
				%>
				<form method="post" action="updatePlace">
					<div class="title">Update Place</div>
					<br />
					
					<div class="field"><p>Place name:</p> 
					  	<input type="text" id="placeName" name="placeName" value="<%= place.getName() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){45}" title="1 to 45 characters" required />
					  	<br />
					</div>
					 
					<div class="field"><p>Description:</p> 
					  	<input type="text" name="description" value="<%= place.getDescription() %>" title="1 to 45 characters" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){45}" required="required" />
					  	<br />
					</div>
					    
					<div class="field"><p>Image:</p> 
						<input type="file" id="image" name="image" value="<%= place.getImage() %>" id="image" required />
						<br /><br />
				  	</div>
				  		
				  	<div class="field"><p>Address:</p> 
					    <input type="text" id="address" name="address" value="<%= place.getAddress() %>" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){30}" title="1 to 45 characters" required/>
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
						<input type="button" value="Cancel"  onclick = "javascript:window.location='admin';" />
						<br />
					</div>  
				</form>
				<%
					}
				%>
			</div>
		</div>
		
		
		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	
	</body>
</html>