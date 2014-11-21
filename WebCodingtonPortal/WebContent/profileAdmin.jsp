<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Administrator</title>
	</head>

	<body>
	
		<div class="header">
			<p class="cabecera">
			<table width="100%" border="0">
		      <tr>
		        <td width="284" rowspan="2"><img src="logo.gif" width=130 height=130 border=2 vspace=30 hspace=75 align=middle /></td>
		        <td><p class="cabecera">New Codington Portal</p></td>	
		        <td width="151">&nbsp;</td>
		        <td width="6"></p>
		      </tr>
		      <tr>
		        <td><p class="cabecera2"><strong><em>One of the World's Best Cities 2014</em></strong></p>
		      </td>
		        <td>&nbsp;</td>
		      </tr>
		    </table>
			
			<div class="menuHorizontal"> 
				<a href="home.html" class="link">Home </a> | <a href="History.html" class="link" > History </a> | <a href="SiteMap.html" class="link">Site Map </a> | <a class="link" href="Events.html"> Events </a> | <a href="myprofile.html" class="link">My Profile </a> | <a href="logout" class="link">Logout </a> 
			</div>
		</div>
		
		<div class = "section">
		</div>
		
		<div class = "region">
			
			<br><b><a style="color:blue"><%= session.getAttribute("Success")!=null?session.getAttribute("Success").toString():""%></a></b>
			
		  <table width="100%" border="1">
		    <tr>
		      <td width="576"><span class="Estilo5">EVENTS</span></td>
		      <td width="158"><div class="Estilo2"> 
		        <div align="right"><a href="registerEvent" class="link"> Register Event</a>  </div>
		      </div></td>
		    </tr>
		    <tr>
		      <td height="163">Aqui van los eventos </td>
		      <td><div align="right">
		        <input name="submit" type="submit" value="Delete" />
		        <input name="submit" type="submit" value="Update" />
		      </div></td>
		    </tr>
		  </table>
		</div>
		 
		  <div class = "region">
			<p margin-bottom=10px></p>
		  </div>
		  
		  <table width="100%" border="1">
		    <tr>
		      <td width="576"><span class="Estilo5">PLACE</span></td>
		      <td width="158"><div class="Estilo2"> 
		        <div align="right"><a href="registerPlace" class="link"> Register Place</a> </div>
		      </div></td>
		    </tr>
		    <tr>
		      <td height="163">Aqui van los eventos </td>
		      <td><div align="right">
		        <input name="submit2" type="submit" value="Delete" />
		        <input name="submit2" type="submit" value="Update" />
		        </div></td>
		    </tr>
		  </table>
		  
		</div>
		
		<div class="footer">
		  <p>New Codignton Portal - December, 2014  </p>
		</div>
	</body>
</html>