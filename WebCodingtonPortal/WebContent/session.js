function sessionVisitor() {
	
	alert("You do not have administrator privileges. You will be redirected to your profile page");
	
	return true;
}

function sessionAdmin(){
	
	alert("You do not have visitor privileges. You will be redirected to your profile page");
	
	return true;
}

function sessionGuest(){
	
	alert("You do not have privileges. You will be redirected to login page");
	
	return true;
}

