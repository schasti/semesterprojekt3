
if (!localStorage.getItem("token")){window.location.href="LoginSide.html"}

/*viser dropdown menu*/
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

/* Lukker dropdown menuen */
window.onclick = function (event) {
    if (!event.target.matches('.dropdownbtn')) {
        let dropdowns = document.getElementsByClassName("dropdown-content");
        let i;
        for (i = 0; i < dropdowns.length; i++) {
            let openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

/* Fetch kald som skal resultere i at xml bliver hentet*/
function fetchfunction(grp) {
    document.getElementById("tekstfelt").innerHTML ="";
    let cpr = document.getElementById("cpr").value;
    fetch("/data/import?" + new URLSearchParams({
        grp : grp,
        CPR : cpr
    }),{
        headers: {
            "Authorization": localStorage.getItem("token")
        }
    }).then(resp => resp.json()).then(data => displaydata(data));
}

function displaydata(data) {
    if(1 < data.aftaleListe.aftale.length) {
        createList(data);
    }else{
        createSingle(data);
    }
}

function createSingle(data){
    let container = "";
    let cpr = "CPR: " + data.aftaleListe.aftale.CPR;
    let klinikid = "KlinikID: " + data.aftaleListe.aftale.klinikID;
    let id = "AftaleID: " + data.aftaleListe.aftale.ID;
    let time = data.aftaleListe.aftale.timeStart + " ----- " + data.aftaleListe.aftale.timeEnd;
    let note = data.aftaleListe.aftale.notat;

    let tider = '<span class="tider">' + time + '</span><br>'
    let navne = '<span class="name">' + cpr + " --- " + klinikid + " --- " + id + '</span><br>';
    let notat = '<span class="note">' + note + '</span><br>';

    container += navne + tider + notat;
    console.log(container);
    document.getElementById("tekstfelt").innerHTML = container;
}

function createList(data){
    let container = "";
    for (let i = 0; i < data.aftaleListe.aftale.length; i++) {
        let cpr = "CPR: " + data.aftaleListe.aftale[i].CPR;
        let klinikid = "KlinikID: " + data.aftaleListe.aftale[i].klinikID;
        let id = "AftaleID: " + data.aftaleListe.aftale[i].ID;
        let time = data.aftaleListe.aftale[i].timeStart + " ----- " + data.aftaleListe.aftale[i].timeEnd;
        let note = data.aftaleListe.aftale[i].notat;

        let tider = '<span class="tider">' + time + '</span><br>'
        let navne = '<span class="name">' + cpr + " --- " + klinikid + " --- " + id + '</span><br>';
        let notat = '<span class="note">' + note + '</span><hr>';

        container += navne + tider + notat;
        console.log(container);
        }
    document.getElementById("tekstfelt").innerHTML = container;
}