function validateForm() {
	var ename = document.getElementById("uname").value;
	var epass = document.getElementById("pass").value;
	
	/* Topic : Javascript
	 * Instructions:
	 * 		Ensure that the employee id and name are not empty.
	 *
	 * Hint:
	 * Use the length property of the variable
	 *
	 */ 
	if (ename.length == 0) {
		alert("Enter employee id");
	} else if (ename.length == 0) {
		alert("Enter your name")
	} else {
		alert("Registering " + ename + " ...")
	}
		
	return true;
}

