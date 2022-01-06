let tok = localStorage.getItem("token");
if (!tok){window.location.href="LoginSide.html"}

document.getElementById("brugernavn").innerText = sessionStorage.getItem("user");

function logud() {
    sessionStorage.setItem("username", "");
    window.location.replace("LoginSide.html");
}

function SeEKg() {
    window.location.replace("ekgSide.html");
}