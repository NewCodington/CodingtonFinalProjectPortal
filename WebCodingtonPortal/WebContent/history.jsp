<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>History</title>
	</head>

	
	<body id="body">
	<%
	if((session.getAttribute("Admin")== null) && (session.getAttribute("Visitor")==null)) {
		response.sendRedirect("login");
	}
	else if (session.getAttribute("Visitor")!=null) {
		//session.setAttribute("Error", "You do not have administrator privileges. You will be redirected to your profile page");
		response.sendRedirect("visitor");
	}
	else {
		response.sendRedirect("admin");
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
				<div class = "title"><%= session.getAttribute("Visitor")!=null && !session.getAttribute("Visitor").toString().equals("")?session.getAttribute("Visitor").toString():session.getAttribute("Admin").toString() %>'s Menu</div>
				<hr size=10 />
				
				<div class = content>	
					<p><a class="link" href=<%= session.getAttribute("Visitor")!=null && !session.getAttribute("Visitor").toString().equals("")?"visitor":"admin" %>>My Page </a></p>
					<hr />
					<p><a href="logout" class="link">Logout </a></p>
				</div>
			</div>

			
			<div class="right_nav">
				<div class="title">History of New Codignton <hr /></div>
				
				<div class="content">
					<p>New Codington a new city is formed by the union of two small towns separated by the New Codington River that formerly was called the River Coder. Each of the zones has a tower and various public spaces. In the north are the Museum, the Theater, the Large Business and Stadium. While in the south, are the open spaces as well as the Zoo, the typical Markets, Tourist Attractions and the Park. </p>
	              	<p> It is an annual festival held during the summer to celebrate the founding of the city. During the festival, various events are held in different places. Each year these events will vary. </p>
	            </div>
			</div>
		</div>


		<div id ="footer">
			<p>New Codignton Portal - December, 2014</p>
		</div>
		
	</body>
</html>
