
let respuestaCorrecta = "Suarez";

let body = document.querySelector("body");
let respuesta = "";


do {
    respuesta = prompt("Apellido del primer presidente de la republica")
    
} while (respuesta != respuestaCorrecta);

alert("Respuesta correcta")
body.innerHTML = "Página desbloqueada"



