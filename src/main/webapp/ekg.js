let tok = localStorage.getItem("token");
if (!tok){window.location.href="LoginSide.html"}

/* log ud knappen */
function logud() {
    sessionStorage.setItem("username", "");
    window.location.replace("LoginSide.html");
}

/* EKG plot */
let data ={
    datasets:
        [
            { label:"EKG",
                backgroundColor: 'rgb(255, 0, 0)',
                borderColor: 'rgb(255, 0, 0)',
                data: [20, 20, 20, 20, 15, 35, 15, 20, 20, 20, 20, 15, 35, 15, 20, 20, 20, 20, 15, 35, 15, 20, 20, 20, 20, 15, 35, 15, 20, 20, 20,],
            }
        ]
}

data.labels = Array(data.datasets[0].data.length).fill("")
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
