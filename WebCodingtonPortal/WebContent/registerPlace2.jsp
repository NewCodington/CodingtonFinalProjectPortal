<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css">
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
		
			<div class = "left_nav">
				<div class="title"> Register</div>
				<hr />
				<div class = "content">
					<p><a  href=<%="registerPlace"%>>Register Place </a></p>
					<p><a href=<%="registerEvent"%>>Register Event </a></p>
				</div>
			</div>
	
	
			<div class="center_nav">		
				<br />
				<div class="message"><%= session.getAttribute("Error")!=null?session.getAttribute("Error"):""%></div>
					
				<form method="post" action="RegistPlaceServlet">
					<div class="title">New Place</div>
					<br />
					<div class="field"><p>Place name:</p> 
					  	<input type="text" id="placeName" name="placeName" pattern="\S{1,45}" title="1 to 45 characters" required >
					  	<br /><br />
					</div>
					 
					<div class="field"><p>Description:</p> 
					  	<textarea id="description" name="description" title="1 to 45 characters" pattern="\S{1,45}" required="required"></textarea>
					  	<br /><br />
					</div>
					 
					<div class="field"><p>Region:</p>
					  	<select id="region" name="region" required>
							<option value="1">Norte</option>
							<option value="2">Sur</option>
						</select>
						<br /><br />
					</div>
					    
					<div class="field"><p>Image:</p> 
						<input type="file" id="image" name="image" id="image" required />
						<br /><br />
				  	</div>
				  		
				  	<div class="field"><p>Address:</p> 
					    <input type="text" id="address" name="address"  pattern="\S{1,45}" title="1 to 45 characters" required/>
					    <br /><br />
				  	</div>
				  		
					<div class="field"><p>Type Place:</p>
						<input type="text" id="typePlace" name="typePlace" required title="Field required"/>
						<br />
					</div>
					
					<div class="input">
						<input type="submit" value="Submit">
						<input type="button" value="Cancel"  onclick = "javascript:window.location='admin';">
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