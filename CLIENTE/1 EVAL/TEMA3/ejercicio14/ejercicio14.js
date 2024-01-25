
let nombre = document.getElementById("ordenador");
let body = document.querySelector("body");
let volver = document.getElementById("volver")
let parrafo = document.getElementById("parrafo")


function comprobar(){
    let numeros =  nombre.value.substring(3,6)
    let letra = nombre.value.substring(6,7)
    parrafo.innerHTML = "Tu ip es: "
    if (letra == "A"){
         parrafo.innerHTML  += "10.42.68."+ numeros
    }else if(letra =="B"){
        parrafo.innerHTML+= "10.42.69."+ numeros
    }else{
        parrafo.innerHTML+= "10.52.178."+ numeros
    }
    volver.hidden = false
    
}

function recargar(){
    window.location.reload()
}