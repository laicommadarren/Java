const loginForm = document.querySelector("#loginForm");
const registerForm = document.querySelector("#registerForm");

loginForm.style.visibility = "hidden";
registerForm.style.visibility = "hidden";

function showLogin() {
	loginForm.style.visibility = "visible";
	registerForm.style.visibility = "hidden";
}

function showRegister() {
	registerForm.style.visibility = "visible";
	loginForm.style.visibility = "hidden";
}
