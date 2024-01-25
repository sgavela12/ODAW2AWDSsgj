const boton1 = document.getElementById("boton1")
const boton2 = document.getElementById("boton2")
const boton3 = document.getElementById("boton3")
const victorias = document.getElementById("winCount")
const ganancias = document.getElementById("ganancias")
const botonGanancias = document.getElementById("calcula")





let imagenes = ["img/cereza.webp","img/piña.webp","img/platano.webp"]

botones = [[boton1,"img/dolar.webp"],[boton2,"img/dolar.webp"],[boton3,"img/dolar.webp"]]
calcula.addEventListener("click",actualizaGanancias)

if (localStorage.getItem("victorias")==null){
    localStorage.setItem("victorias",0)
}

if (localStorage.getItem("ganancias")==null){
    localStorage.setItem("ganancias",0)
}

botones.forEach(boton => {
   
    boton[0].addEventListener("click", ()=>{
        tirarRuleta(boton)
        cambiaImagenes()
        if(checkPremio()){
            localStorage.setItem("victorias", parseInt(localStorage.getItem("victorias"))+1)

            localStorage.setItem("ganancias", parseInt(localStorage.getItem("victorias"))+checkTipoPremio())
        }
    })
});

function tirarRuleta(arrayBoton){
    arrayBoton[1] = imagenes[random(0,2)]
}


function random(min, max) {
    return Math.floor((Math.random() * (max - min + 1)) + min);
}

function cambiaImagenes(){
    botones.forEach((boton)=>{
        boton[0].childNodes[0].setAttribute("src", boton[1]);
    })
}

function checkPremio(){
    let imagenComparar ="img/dolar.webp"
    let premio = false
    let cartaAnterior=""
    let aciertos = 0
    botones.forEach((boton)=>{
        
        if(boton[1]=="img/dolar.webp"){
            premio = false
        }else{
            if(cartaAnterior==""){
                cartaAnterior = boton[1]
                aciertos++
            }else if(cartaAnterior == boton[1]){
                aciertos++
            }
            
        }
    })
    if(aciertos == 3){
        premio = true
    }
    return premio;
}

function checkTipoPremio(){
    if(botones[0][1]== "img/cereza.webp")return 5
    if(botones[0][1]== "img/piña.webp")return 20
    if(botones[0][1]== "img/platano.webp")return 10
}


function actualizaGanancias(){
    victorias.innerHTML = localStorage.getItem("victorias")
    ganancias.innerHTML = localStorage.getItem("ganancias")
}