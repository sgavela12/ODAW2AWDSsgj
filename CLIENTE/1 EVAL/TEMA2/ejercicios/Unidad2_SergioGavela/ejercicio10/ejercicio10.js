let listaConvocada = ["Luisa", "Maria", "Carlota", "Ana" , "Martina", "Claudia"]

let respuesta = prompt("Introduce el nombre de un jugadora de futbol");



forma1();

//primera forma
function forma1(){
    if(listaConvocada.includes(respuesta)){
        alert("La jugadora esta en la lista de convocadas.")
    }else {
        alert("La jugadora no esta convocada")
    }

}

//segunda forma
function forma2(){
    let estaConvocada = false;
listaConvocada.forEach(jugadora => {
    if(jugadora == respuesta){
        estaConvocada = true;
    }
});

if(estaConvocada){
    alert("La jugadora esta convocada")
}else{
    alert("la jugadora no esta convocada")
}

}

