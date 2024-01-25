let comprobar = document.getElementById("comprobar");
let mensajeAciertos = document.getElementById("aciertos")
let preguntasSinResponder = document.getElementById("sinResponder")
let respuestas = {capital:"paris",
                 elemento:"oxigeno",
                independencia:"1776",
                rio:"nilo"
                }

let aciertos = 0


comprobar.addEventListener("click", ()=>{
    aciertos = 0
    preguntasSinResponder.innerHTML=""
    verificarSinResponder()
    let elementos = document.getElementsByClassName("acertado")
    let elementosArray = Array.from(elementos)
    elementosArray.forEach((elemento)=>{
        elemento.parentNode.removeChild(elemento)
    })
    for(let clave in respuestas){
        checkAcierto(clave,respuestas[clave])
        actualizaAciertos()
    }
    
})


function actualizaAciertos(){
    mensajeAciertos.innerHTML = `Has acertado ${aciertos}`
}



function checkAcierto(name,respuesta) {
    var radios = document.getElementsByName(name);
    for (var radio of radios) {
        if (radio.checked) {
            if(radio.value == respuesta){
                let check = document.createElement("img")
                check.setAttribute("src","check.ico")
                check.setAttribute("class","acertado")
                check.style.width="30px"
                radio.parentElement.appendChild(check)
                aciertos++
            }
            
            else{
                let check = document.createElement("img")
                check.setAttribute("src","fail.png")
                check.setAttribute("class","acertado")
                check.style.width="30px"
                radio.parentElement.appendChild(check)
                return false
            }
        }
    }
}



function verificarSinResponder() {
    let sinResponder = false;
    let mensajes = [];

    let conjuntos = ["capital", "elemento", "independencia", "rio"];

    conjuntos.forEach((conjunto) => {
        let radios = document.getElementsByName(conjunto);
        let seleccionado = false;

        for (let radio of radios) {
            if (radio.checked) {
                seleccionado = true;
                break;
            }
        }

        if (!seleccionado) {
            sinResponder = true;
            mensajes.push(`Selecciona una respuesta para ${conjunto}`);
        }
    });

    
    if (sinResponder) {
        preguntasSinResponder.innerHTML = mensajes.join("<br>");
    } else {
        preguntasSinResponder.innerHTML = "";
    }

    return sinResponder;
}

