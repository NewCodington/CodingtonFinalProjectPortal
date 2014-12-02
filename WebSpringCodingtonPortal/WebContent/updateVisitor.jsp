<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="springcodingtonportal.model.domain.Visitor"%>

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Visitor Update Page</title>
	</head>
	

	<body id="body">
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		request.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		request.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("login.htm");
		return;
	}
	else if (session.getAttribute("Admin")!=null) {
		request.setAttribute("ErrorPriv", "You do not have privileges to access this page.");
		request.setAttribute("ViewErrorPriv", "YES");
		
		response.sendRedirect("admin");
		return;
	}else {
		if (request.getAttribute("VISITOR") == null) {
			response.sendRedirect("getVisitor.htm");
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
		</div>
		
		
		<div id="content">

			<div class = "center_nav">

				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
				
				<%
					Visitor visitor=(Visitor)request.getAttribute("VISITOR");
				%>
	
				<form method="post" action="updateVisitor.htm">
					<div class="title">Update User</div>
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


		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
	
	</body>
</html>