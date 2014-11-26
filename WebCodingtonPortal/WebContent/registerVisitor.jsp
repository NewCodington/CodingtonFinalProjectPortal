<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	  
	<head>
		<link rel="stylesheet" type="text/css" href="css/codington.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--  <script language="javascript" src="Register.js"></script>-->
		<title>Visitor Register Page</title>
		
		<script>
		function validateForm() {
			
			/* Topic : Javascript
			 * Instructions:
			 * 		Ensure that the employee id and name are not empty.
			 *
			 * Hint:
			 * Use the length property of the variable
			 *
			 */ 

			if (!validateEmail())return false;
			
			if (!validateConfirmPass())return false;

			if (!validateDni())return false;
			
			return true;
		}

		function validateEmail(){
			
			var email = document.getElementById("email").value;
			
		    var atpos = email.indexOf("@");

		    var dotpos = email.lastIndexOf(".");

			var wrongchar = ["(",")","[","]","'\'",";",":","<",">"," "];
			
			for (var i = 0; i < wrongchar.length; i++){
				if (email.indexOf(wrongchar[i])>=0){
					alert("Invalid character in the e-mail address");
					return false;
				}
			}

			

		    if (atpos < 1 || dotpos<atpos+2 || dotpos+1>=email.length) {
		        alert("Not a valid e-mail address");
		        return false;
		    }
			return true;
		}

		function validateConfirmPass(){
			var pass = document.getElementById("pass").value;
			var conpass = document.getElementById("cpass").value;
		    if (pass != conpass) {
		        alert("Password and confirm password is not the same");
		        return false;
		    }
			return true;

		}

		function validateDni(){

			var dni = document.getElementById("dni").value;
			var numdni;
			var ldni = 'TRWAGMYFPDXBNJZSQVHLCKE';

		    if (dni.length > 0) {
			
		        if((dotpos = dni.indexOf(".")) == 2 && (dashpos = dni.indexOf("-")) == dni.length-2){
				    var subdni = dni.slice(dotpos + 1,dni.length);

					numdni = dni.substring(0,dotpos);			

					if((dotpos = subdni.indexOf(".")) == 3)
					{
						numdni = numdni.concat("", subdni.substring(0,dotpos));	
						subdni = subdni.slice(dotpos + 1,subdni.length);

				    }
					
					if((dashpos = subdni.indexOf("-")) == 3){
						numdni = numdni.concat("", subdni.substring(0,dashpos));
						var letter = dni[dni.length - 1];
						var letpos = numdni%23;
						if (letter == (ldni.substring(letpos,letpos + 1))){
							return true;
						}
					}
		    
				}
				alert ("Invalid dni (Format XX.XXX.XXX-L) or invalid letter");
				return false;
		    }
			
			return true;

		}
		</script>
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

			<div class = "center_nav">

				<div class="error"><%= session.getAttribute("Error")!=null?session.getAttribute("Error").toString():""%></div>
				
				<form method="post" id="f" name="f" action="registerVisitor" onsubmit = "return validateForm()">
					<div class="title">New User</div>
			        <br />
					
					<div class="field"><p>First name:</p>
						<input type="text" name="fname" id = "fname" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){30}" title="Enter a valid first name (length between 1-30)" placeholder="First name"  required />
						<br />
				    </div>
					  
				    <div class="field"><p>Last name:</p> 
					   	<input type="text" name="lname" id = "lname" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&){30}" title="Enter a valid last name (length between 1-30)" placeholder="Last name"required />
				    	<br />
				    </div>
				    
					<div class="field"><p>Username:</p>
					    <input type="text" name="uname" id = "uname" pattern="\S{6,12}" title="Enter a valid username (length between 6-12)" placeholder="Username" required />
					    <br />
				    </div>
					
					<div class="field"><p>Password:</p> 
					    <input type="password" name="pass" id = "pass" pattern="\S{6,15}" title="Enter a valid password (length between 6-15)" placeholder="Password" required />
					    <br />
				    </div>
				    
					<div class="field"><p>Confirm Password:</p> 
					    <input type="password" name="cpass" id = "cpass" pattern="\S{6,15}" title="Enter a valid password (length between 6-15)" placeholder="Confirm Password" required />
					    <br />
				    </div>
				    
					<div class="field"><p>DNI:</p>
					    <input type="text" name="dni" id = "dni" title="Enter a valid dni(XX.XXX.XXX-L)" placeholder="Dni (XX.XXX.XXX-L)" />
					    <br />
				   	</div>
					
					<div class="field"><p>Phone Number:</p>
					    <input type="tel" name="phone" id = "phone" placeholder="Phone Number" />
					    <br />
				    </div>
					
					<div class="field"><p>Email:</p> 
					    <input type="email" name="email" id = "email" pattern="\S{3,200}" title="Enter a valid email (length between 3-200)" placeholder="Email" required />
				    	<br />
				    </div>
				    
					<div class="field"><p>Address:</p> 
					    <input type="text" name="adress" id = "adress" placeholder="Address" />
					    <br />
				  	</div>
				  
				  	<div class="input">
						<input type="submit" value="Submit"  />
						<input type="button" value="Cancel"  onclick = "javascript:window.location='login';" />
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