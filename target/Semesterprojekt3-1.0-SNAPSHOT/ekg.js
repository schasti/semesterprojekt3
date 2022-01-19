

let tok = localStorage.getItem("token");
if (!tok) {
    window.location.href = "LoginSide.html"
}

/* log ud knappen */
function logud() {
    sessionStorage.setItem("username", "");
    window.location.replace("LoginSide.html")
}

function showString(data2) {
    let s = "" + data2
    console.log(s)

}


function fetchSession() {
    let cpr = document.getElementById("CPR").value;
    fetch("/Semesterprojekt3_war/data/ekgSessions?" + new URLSearchParams({  //semesterprojektwar er kun for localhost
        cpr: cpr
    }), {
        headers: {
            "Authorization": "Bearer hemmeliglogin"
        }
    }).then(resp => resp.text()).then(data => {
        const parser = new DOMParser();
        const xml = parser.parseFromString(data, "application/xml");
        displaySession(xml)


    })
}


function displaySession(xml) {
    var table = "<tr><th>CPR</th><th>SessionID</th></tr>";
    console.log()
    const Sessions = xml.getElementsByTagName("ekgSession")
    for (let i = 0; i < Sessions.length; i++) {
        table += "<tr><td>" +
            Sessions[i].getElementsByTagName("cpr")[0].innerHTML +
            "</td><td>" +
            Sessions[i].getElementsByTagName("sessionID")[0].innerHTML +
            "</td></tr>";
    }
    document.getElementById("sessions").innerHTML = table;
}


function fetchEkgData() {
    let sessionID = document.getElementById("sessionID").value;
    fetch("/Semesterprojekt3_war/data/ekgSessions/measurements?" + new URLSearchParams({  //semesterprojektwar er kun for localhost
        sessionID: sessionID
    }), {
        headers: {
            "Authorization": "Bearer hemmeliglogin"
        }
    }).then(resp => resp.text()).then(data => {
        const parser = new DOMParser();
        const xml = parser.parseFromString(data, "application/xml");
        plot(xml)
    })

}


let data = {

    datasets: [
        {
            label: "ekg",
            backroundColor: 'rgb(255,99,132)',
            borderColor: 'rgb(255,99,132)',
            data: [],
        }
    ]
}

const config = {
    type: 'line',
    data: data,
    options: {}
}


function plot(xml) {

    const measurements = xml.getElementsByTagName("measurement")
    for (let i = 0; i < measurements.length; i++) {
        data.datasets[0].data[i] = measurements[i].innerHTML
        console.log(i + "    " + data.datasets[0].data[i])
    }
let samplerate = 2000
let xl = []
    for ( let i =0; i<data.datasets[0].data.length; i++){
        xl.push(i/samplerate);
    }
    data.labels = xl

    plotEkg(data.datasets[0].data)
    

}

function plotEkg(data) {

    let canvas = new Chart(
        document.getElementById("ekgplot"),
        config
    );
    let context = canvas.getContext("2d");
    for (i = 0; i < data.length; i++) {
        context.lineTo(i, 300 - data[i] * 100)
        context.stroke()
    }

}