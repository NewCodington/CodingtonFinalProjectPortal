function validateForm(f) {
	
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
	
	for (i = 0; i < wrongchar.length; i++){
		if (email.indexOf(wrongchar[i])>=0){
			alert("Invalid character in the e-mail address");
			return false;
		}
	}

	

    if (atpos < 1 || dotpos<atpos+2 || dotpos+1>=email.length) {
        alert("Not a valid e-mail address");
        return false;
    }
	return true
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
		alert ("Invalid dni (Format XX.XXX.XXX-L)");
		return false;
    }
	
	return true;

}

