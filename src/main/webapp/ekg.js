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
                    0.0010356545984921855,
                    0.0008638921255015488,
                    0.000870975020195274,
                    0.0008485945276582323,
                    0.0007939222198664315,
                    0.0007254872693949947,
                    0.0007951344730568994,
                    0.0005690727383250099,
                    0.0007790199856753748,
                    0.0005053332268098342,
                    0.0006689931721082538,
                    0.0005249577079459323,
                    0.0005508277737289583,
                    0.0005022748038461657,
                    0.0005324867739430977,
                    0.00040646701965248156,
                    0.0005525316309558815,
                    0.0003501867613933682,
                    0.0004848665573124212,
                    0.00039905388065117884,
                    0.0003643721118982607,
                    0.00044931576661608413,
                    0.0003179089198732599,
                    0.00038020882383350466,
                    0.00038881972084640236,
                    0.0002654029760217801,
                    0.00043757978930354934,
                    0.00022790638309326387,
                    0.00037210201133721553,
                    0.00029711203563618767,
                    0.00024237106484012655,
                    0.0003514409197812385,
                    0.0001704223771646687,
                    0.00034903144387122246,
                    0.00010819086725619159,
                    0.0003496649633284904,
                    -2.5389716322045934e-06,
                    0.0003640611077277547,
                    -0.00010779481059969757,
                    0.0003097867105606565,
                    -0.0001751846289821622,
                    0.000180314893147995,
                    -0.00023796836731868837,
                    3.874984250039111e-05,
                    -0.00031734549018443955,
                    -0.00011177902325986402,
                    -0.0003552980558472362,
                    -0.0002427355865313201,
                    -0.00037027485228275584,
                    -0.00026673108898495014,
                    -0.00034853868983630555,
                    -0.00011454731354926118,
                    -0.00023170680106893152,
                    0.00020918804303786674,
                    3.1915925929826934e-05,
                    0.0006934943090946437,
                    0.0005166375693462792,
                    0.0012841855664444217,
                    0.0012221224077215867,
                    0.0019136510955789004,
                    0.002073802259507836,
                    0.0025421884382065196,
                    0.002891286928944901,
                    0.003164990819081592,
                    0.0034492333702011843,
                    0.00371801355483492,
                    0.003679391470123511,
                    0.003992541685046595,
                    0.0036275242634015905,
                    0.0038588822719051756,
                    0.003343391423314004,
                    0.0033847752813139973,
                    0.002796161787853098,
                    0.002737594910246606,
                    0.0020914816279924827,
                    0.001980686403935482,
                    0.0014126643010859991,
                    0.0012372910154430164,
                    0.000841472167523535,
                    0.0006743446615180765,
                    0.00035068047970723197,
                    0.0003496099846859084,
                    -5.8196173053249326e-06,
                    0.00017205283322643502,
                    -0.0001482779645136014,
                    6.0501811702866856e-05,
                    -0.00016800346489740688,
                    3.787029427354349e-05,
                    -0.00018163114773213487,
                    0.00011734894720513444,
                    -0.00020920139702785347,
                    0.0002005976855759301,
                    -0.00016299726869269004,
                    0.00020841005712722902,
                    -8.046017099295475e-05,
                    0.00022890222753890358,
                    -3.889147930036722e-05,
                    0.0003148126534489379,
                    -5.494829849135697e-05,
                    0.00040103865645839724,
                    -2.630383253458734e-05,
                    0.00041441739377476614,
                    7.106779650433348e-05,
                    0.00040417332058264113,
                    0.0001632554508464939,
                    0.0004116127172439508,
                    0.00023981134430624214,
                    0.00045300447407015484,
                    0.00030182225253447904,
                    0.0004937337400789173,
                    0.00037928379186481787,
                    0.0005154587702758198,
                    0.00045902555670294167,
                    0.0005384891997342261,
                    0.00047195517961913416,
                    0.0005838675088422833,
                    0.00045818214760205884,
                    0.0006059847106460235,
                    0.00042341661615589847,
                    0.0005929090236222156,
                    0.0003930900121168822,
                    0.000550549026482074,
                    0.00036623632959131565,
                    0.0005226496981483071,
                    0.0003110166368335972,
                    0.0005139349038585795,
                    0.00025979859626915975,
                    0.0005296218419323128,
                    0.00022533567373816832,
                    0.0005383265977248276,
                    0.00021568101294639253,
                    0.0005512104071189278,
                    0.00020810780626993799,
                    0.000588184213132401,
                    0.00019600209931924117,
                    0.0006045270459134758,
                    0.00023809714840816723,
                    0.000550765388171943,
                    0.0003441547993108188,
                    0.0004877821888982138,
                    0.0004281017571924544,
                    0.0004949405820029939,
                    0.00043395095426886527,
                    0.0005986253047595601,
                    0.0004236718310666767,
                    0.000680519174336949,
                    0.00048305583034595766,
                    0.0007008999643296047,
                    0.0006009888827532805,
                    0.0007089084172978218,
                    0.0007086357002032946,
                    0.0007453854844146757,
                    0.0007451400995223184,
                    0.0008288515043278562,
                    0.0007706931442963011,
                    0.0008889644791546596,
                    0.0008406743568777995,
                    0.0008938195635540101,
                    0.0009381229146748563,
                    0.0009139787112519296,
                    0.0010360586878059438,
                    0.00095640532382561,
                    0.0011223419489477511,
                    0.0010519910049420268,
                    0.001196781463460545,
                    0.0011634898524975328,
                    0.0012974075525070132,
                    0.0012619013405412642,
                    0.0014334705770966023,
                    0.0013467305060313641,
                    0.0015535443944946208,
                    0.0014799000006892585,
                    0.0016177246400319472,
                    0.0016310359281882384,
                    0.0016795961301865343,
                    0.0017259911228593092,
                    0.001765081449943661,
                    0.001797455983914662,
                    0.0018281988578785742,
                    0.0018441863708092375,
                    0.0018667981009750367,
                    0.0018499608370782998,
                    0.0019266551669115883,
                    0.001787033703185442,
                    0.001942199593214225,
                    0.0017672862544220972,
                    0.0018420268083529454,
                    0.0017559427490084,
                    0.0017366916854010617,
                    0.001645484865402534,
                    0.0016690765975994337,
                    0.0015125444115276516,
                    0.0015351211884266538,
                    0.0014153601045170956,
                    0.001354346057911373,
                    0.0013382609866722007,
                    0.0011705262424892345,
                    0.0012547559676607855,
                    0.001010125455143632,
                    0.0011546026716925087,
                    0.0009117327361254003,
                    0.0009772726784131784,
                    0.000915331285555583,
                    0.000756409889924887,
                    0.0009141324407100889,
                    0.0006164348335822657,
                    0.000803794558722714,
                    0.0005712393771077301,
                    0.0006682373640222432,
                    0.0005066646547006103,
                    0.0005850748131885452,
                    0.0004063875061988551,
                    0.0005631429453956704,
                    0.0002893009086547153,
                    0.0005475947826672363,
                    0.00023533021147281377,
                    0.0004996627942659521,
                    0.00023380228908638224,
                    0.0004608224923352025,
                    0.00022443214495569702,
                    0.00047609984098476567,
                    0.00016678003720306523,
                    0.0005383671420723139,
                    0.00010867412217898165,
                    0.0005534038389083851,
                    0.00015372511482779295,
                    0.00046285911978709597,
                    0.0002782394076622862,
                    0.0003803818150258436,
                    0.00034489567250979824,
                    0.0003906313230372139,
                    0.00035841706934896964,
                    0.0004665752506672155,
                    0.00033886557615701136,
                    0.0005548303957802967,
                    0.00035081978499292216,
                    0.0006149510564304546,
                    0.0003979835784004527,
                    0.000643546247015511,
                    0.0004713250591550783,
                    0.0006522566402540001,
                    0.0005688389597403994,
                    0.0006378635146421652,
                    0.0006908962135775112,
                    0.0006039030707348275,
                    0.0007960259745380627,
                    0.0006393518264413377,
                    0.0008037766610187226,
                    0.0007501674003137383,
                    0.0007699643247408472,
                    0.0008354832642453755,
                    0.0008032972732646107,
                    0.0008170914323826965,
                    0.0008818533663853391,
                    0.0008165016387000974,
                    0.0008704934467853163,
                    0.0008995020134413611,
                    0.0007782557142811605,
                    0.0010135336264348118,
                    0.0006900438310825515,
                    0.0010791798153093161,
                    0.0006897399844687903,
                    0.0010479439926326995,
                    0.0008045086750533288,
                    0.0009041730758867575,
                    0.0010104247458909204,
                    0.0007763349048863985,
                    0.0011539743269661268,
                    0.0007688506097077686,
                    0.001128222236949601,
                    0.0009185658816698466,
                    0.0010214900217271857,
                    0.001076216437120697,
                    0.0009391207135709147,
                    0.0011583825805239058,
                    0.0009128942354500408,
                    0.0011877179484937037,
                    0.0009117923490445167,
                    0.0011924204385022252,
                    0.0009123125761131778,
                    0.0011691970079968851,
                    0.0009187332064548655,
                    0.0011414257017794767,
                    0.0009316288857617117,
                    0.0010799053221080776,
                    0.0009651650388625822,
                    0.0009945094608930958,
                    0.0010206293966122406,
                    0.0009101430201561625,
                    0.0010298618842871047,
                    0.0009234169384223312,
                    0.0009359508570561544,
                    0.0010250658007948331,
                    0.000795003982872452,
                    0.001113275788711221,
                    0.0007248929549430916,
                    0.0011011048885853404,
                    0.0007455881456114015,
                    0.0010328854305863804,
                    0.0007768028472605814,
                    0.0009902394251356439,
                    0.0007830199610515594,
                    0.0009737803540596593,
                    0.0008293644155108703,
                    0.0009019286879533874,
                    0.0009466409569484466,
                    0.0008110009463347201,
                    0.0010179841400709435,
                    0.0008373868195240754,
                    0.0009499676271327314,
                    0.0009640151651522739,
                    0.000832735599559112,
                    0.0010265687126030769,
                    0.0008125052645438799,
                    0.0009673800778647244,
                    0.0008489337437374321,
                    0.0008982232712960915,
                    0.0008648001691796787,
                    0.000849238010314754,
                    0.0008537018690358712,
                    0.0008067781950583749,
                    0.000874064956169419,
                    0.0007554963921861725,
                    0.0008858080119182265,
                    0.0007369519055195631,
                    0.0008611543204352127,
                    0.0007619341825425443,
                    0.0008367099626268651,
                    0.0007343465884809995,
                    0.0008803674794484694,
                    0.0006773698815141192,
                    0.0009182698299139345,
                    0.0006650088334181193,
                    0.0008713348975477829,
                    0.0007567698570988333,
                    0.0007466481473308254,
                    0.0008702951199401801,
                    0.0006838224159774943,
                    0.0008826236380110199,
                    0.0007567659538231722,
                    0.0007789248405991132,
                    0.0009132863100271242,
                    0.0006749896071235416,
                    0.0010071895332545715,
                    0.000694872480335601,
                    0.0009603632595341911,
                    0.0008285591839346702,
                    0.0008670818724457511,
                    0.0008788159937934153,
                    0.0009109359046560422,
                    0.0007795315243583942,
                    0.0010585286408906183,
                    0.0006176164296901481,
                    0.0011744345917180674,
                    0.0005598982566967981,
                    0.001163306083213948,
                    0.0006187708306297964,
                    0.0011212371427477307,
                    0.0006941081694350754,
                    0.0010854309438554437,
                    0.0007711472528162653,
                    0.001086660869230787,
                    0.0008394977163949746,
                    0.001091399062192013,
                    0.0009156588433323635,
                    0.001094672522670375,
                    0.000965473688873538,
                    0.0011518549687169006,
                    0.0009642389437958664,
                    0.0012356821039469204,
                    0.0009761028954384578,
                    0.0012945023426807448,
                    0.001038998295520439,
                    0.0013285753439777068,
                    0.001116138704403264,
                    0.0013793709670813468,
                    0.0011735743376895,
                    0.0014267910765889214,
                    0.0012330565549114308,
                    0.001427611983076232,
                    0.0012823707223249094,
                    0.0014166951507950274,
                    0.0012544815456044915,
                    0.0014227140719705333,
                    0.0011711748904774555,
                    0.0013772004477819305,
                    0.0011161697795047138,
                    0.0012668391073141923,
                    0.0010754735541804027,
                    0.0011502685740738012,
                    0.0010133960810686285,
                    0.001045281706531918,
                    0.0009673416065364541,
                    0.0009269377865774884,
                    0.0009579500441530132,
                    0.0008311340137822001,
                    0.0008754235112563331,
                    0.0008686647655332676,
                    0.0007009858829537397,
                    0.0009463181375486043,
                    0.0005918393956037812,
                    0.0009057617456685884,
                    0.0006133122046494498,
                    0.0007945339409787058,
                    0.0006552732821096851,
                    0.0007379255288548091,
                    0.0006172500755320144,
                    0.0007443703248095122,
                    0.0005847158242745019,
                    0.0007353270936823308,
                    0.0005927979259948483,
                    0.0006862802875214015,
                    0.0006262750085334701,
                    0.0006490750448629878,
                    0.0006140170934556503,
                    0.000661784573781788,
                    0.0005304855103625474,
                    0.0006733540535578521,
                    0.00046734534792213325,
                    0.0005807591108681327,
                    0.000471933792277417,
                    0.00041093175201289224,
                    0.00045306286731284015,
                    0.00028268357218049097,
                    0.00036656132947362574,
                    0.00020359037145514818,
                    0.0002487726639950489,
                    0.00014655952786088526,
                    0.0001386939470742175,
                    8.714220102441661e-05,
                    5.2962696243638154e-05,
                    4.1921709829818006e-05,
                    -3.67060129972356e-05,
                    2.0156258287380905e-05,
                    -0.00012280515999324416,
                    3.375259729737582e-05,
                    -0.00016929604417948162,
                    5.535768179842013e-05,
                    -0.00010839156555872085,
                    7.892023096186333e-05,
                    9.539729623164178e-05,
                    0.0002014674588112412,
                    0.00041048414766641764,
                    0.00047782132829006643,
                    0.0008426811808415868,
                    0.0009199976046383297,
                    0.0014285008998067305,
                    0.0015311596650866744,
                    0.002070417102322596,
                    0.0023084340669957968,
                    0.002685415187559521,
                    0.0031271373476809425,
                    0.0032496607505553645,
                    0.003758111565863081,
                    0.0037247530073444193,
                    0.00409703016604869,
                    0.003931059689576626,
                    0.004105165610376789,
                    0.003820058240229327,
                    0.0037511280914298336,
                    0.0034025977989015988,
                    0.0031467919147436995,
                    0.0027080979276987173,
                    0.0024813716197121267,
                    0.0018317878931969514,
                    0.0017903638861350019,
                    0.0010921096632544396,
                    0.0010636472558218555,
                    0.000648785047914837,
                    0.0003971482604269065,
                    0.0004174226258475418,
                    -3.548786168205844e-05,
                    0.0002277390651748439,
                    -0.00014255518249671473,
                    3.2878873029844576e-05,
                    -8.377554419946392e-05,
                    -5.849987545479549e-05,
                    -5.389611799543229e-05,
                    6.123729100044731e-06,
                    -8.00163578559028e-05,
                    0.00013307593459383464,
                    -4.8058059477015604e-05,
                    0.00016823732616573817,
                    0.00011898941399675537,
                    0.00013387009900670053,
                    0.00029421846943664885,
                    0.00018967862694453417,
                    0.0003752643477863721,
                    0.000316295166852415,
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
