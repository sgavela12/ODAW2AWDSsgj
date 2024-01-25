
let respuestaCorrecta = "Adolfo Suarez";

let body = document.querySelector("body");
let respuesta = "";



    respuesta = prompt("Nombre y Apellido del primer presidente de la republica")
    



while(respuesta != respuestaCorrecta){
    if(respuesta == "Adolfo"){
        respuesta =  prompt("Te falta el apellido. ¿Cuál fue el primer presidente de la democracia española?")
    }else{
        respuesta =  prompt("ERROR. Inténtelo de nuevo. ¿Cuál fue el primer presidente de la democracia española?")
}
    }
    
alert("Respuesta correcta")
body.innerHTML = "Página desbloqueada"



