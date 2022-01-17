let tok = localStorage.getItem("token");
if (!tok){window.location.href="LoginSide.html"}

/* log ud knappen */
function logud() {
    sessionStorage.setItem("username", "");
    window.location.replace("LoginSide.html");
}

function showString(data2){
    let s = ""+data2
    console.log(s)
}
//Funktionen, der indhenter EGK fra database
async function getEkg(){
    const  response = await fetch("dataAccesLayer/SQL")
    console.log(result.status)


    let CPR = document.getElementById("PCR.nr").value;
    let SessionID = document.getElementById("sessionID").value;
    let StartTid = document.getElementById("start").value;
    let Sluttid = document.getElementById("slut").value;
    let meddelelse = document.getElementById("meddelelse").value;

    if (CPR.length == 10 && StartTid != null && Sluttid != null){
        Chart()
        hentPatient()
        Bruger = sessionStorage.getItem("Godkendt_Bruger");

        document.getElementById("PCR.nr"+i).innerHTML = CPR;
        document.getElementById("sessionID"+i).innerHTML = SessionID;
        document.getElementById("start"+i).innerHTML = StartTid;
        document.getElementById("slut"+i).innerHTML = Sluttid;
        document.getElementById("meddelelse"+i).innerHTML = meddelelse;

        i++;
    } else{
        alert("Indtast venligst alle korrekte oplsyninger. ")
    }
}
//Patient data fra database
async function hentPatient() {
    let result = await fetch("dataAccesLayer/SQL");
    console.log(result.status)

    let json = await result.json();
    console.log(json)
}

//EKG plot
let data ={
    datasets:
        [
            { label:"EKG",
                backgroundColor: 'rgb(255, 0, 0)',
                borderColor: 'rgb(255, 0, 0)',
                data: [0.0011440839890657314,
                    0.000840882703069264,
                    0.00042973672095965803,
                    0.00045549980183051594],
            }
        ]
}

//X-akses værdier som skal beregnes
data.labels = Array(data.datasets[0].data.length).fill(0.20)
const config = {
    type: 'line',
    data: data,
    options:{}
}

window.onload = ( function (){
    let canvas = document.getElementById("ekgplot");
    let context = canvas.getContext("2d");
    context.moveTo(0,300);
    for (let i = 0; i < data.length; i++) {
        context.lineTo( i, 300-data[i]*100);
        context.stroke();
    }
    const ekgplot = new Chart(
        document.getElementById('ekgplot'),
        config
    );
})

function fetchSession() {
    document.getElementById("tekstfelt").innerHTML ="";
    let cpr = document.getElementById("cpr").value;
    fetch("/data/ekgSessions?" + new URLSearchParams({
        cpr : cpr
    }),{
        headers: {
            "Authorization": localStorage.getItem("token")
        }
    }).then(resp => resp.json()).then(data => displaydata(data));
}
