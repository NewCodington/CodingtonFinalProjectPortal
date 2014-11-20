<!DOCTYPE html>
<html>
	  
	<head>
	<link rel="stylesheet" type="text/css" href="css/codington.css">
	</head>

<body>

<div class="header">
	<p class="cabecera">
	<table width="100%" border="0">
      <tr>
        <td width="284" rowspan="2"><img src="logo.gif" width=130 height=130 border=2 vspace=30 hspace=75 align=middle /></td>
        <td width="499"><div align="center">New Codington Portal</div></td>	
        <td width="151">&nbsp;</td>
        <td width="6"></p>
      </tr>
      <tr>
        <td><p class="cabecera2">One of the World's Best Cities 2014</p></td>
        <td>&nbsp;</td>
      </tr>
    </table>
</div>

<div class = "nav_log">
	
	
	<br><b><a style="color:blue"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
		
	<form method="post" action="RegistPlaceServlet"><p class = "title">
        New Place	    </p>
		
		  Place name: 
		  <br>
		  <input type="text" id="placeName" name="placeName" pattern="\S{1,45}" title="1 to 45 characters" required >
	      </p>
		 
		    <p>Description: 
		  <br>
		  <textarea id="description" name="description" title="1 to 45 characters" pattern="\S{1,45}" required="required"></textarea>
		    </p>
		 
		    <p>Region:
		  <br>
		  <input type="text" id="region" name="region" pattern="\S{1,45}" title="1 to 45 characters" required/>
		    </p>
		    <p>Image: 
		      <br>
		      <input type="file" id="image" name="image" id="image" required />
		      <br>
		  
		   
	  
		  Address: <br>
		    <input type="text" id="address" name="address"  pattern="\S{1,45}" title="1 to 45 characters" required/>
	  </p>
		    <p>Type Place  : <br>
	          <input type="text" id="typePlace" name="typePlace" required title="Field required"/>
   
		      </p>
		        </p>
		    <p class = "input">
			<INPUT type="SUBMIT" value="Submit">
			<INPUT type="SUBMIT" value="Cancel">
		</p>  
	</form>
</div>




<div class ="footer">
New Codignton Portal - December, 2014
</div>

</body>
</html>

</html>