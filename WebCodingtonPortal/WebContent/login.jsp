<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script language="javascript" src="Register.js"></script>
		<title>New Codington Portal</title>
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
		
			<div class="center_nav">
				<br />
				<div class="error"><%= session.getAttribute("ErrorLogin")!=null?session.getAttribute("ErrorLogin").toString():""%></div>
				
				<form method="post" action="login">
					<div class="title">Sign In</div>
					<br />
					
					<div class="field">
					  	<input type="text" id = "uname" name="username" placeholder="Username" required />
					  	<br />
					</div>
					
					<div class="field">
				    	<input type="password" id = "pass" name="password" placeholder="Password" required />
				      	<br />
				  	</div>
				  <div class = "input">
						<input type="submit" value="Submit" />
						<input type="button" value="Cancel" />
				  </div>
				</form>
				<div><a href="registerVisitor" > Register New Visitor </a></div>
			</div>
		</div>


		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>

	</body>

</html>