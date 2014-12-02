<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ include file="/include.jsp"%>

<% response.setStatus(404); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>Error Page</title>
	</head>

	<body id="body">
	
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
			<div class="right_nav">
				<div class="error">Sorry, the page requested does not exists.</div>
				<%session.invalidate();%>
				<%
					if(session.getAttribute("Visitor") != null) {	
				%>
				
				<br /><br />
				<p class = "return"><a align="center" href="visitor" class="link">Return to Your Profile Page </a></p>
				
				<%
					}else if(session.getAttribute("Admin") != null) {
				%>
				
				<br /><br />
				<p class = "return"><a align="center" href="admin" class="link">Return to Your Profile Page </a></p>
				
				<%
					}else {
				%>
				
				<br /><br />
				<p class = "return"><a align="center" href="login" class="link">Return to Login </a></p>
				
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