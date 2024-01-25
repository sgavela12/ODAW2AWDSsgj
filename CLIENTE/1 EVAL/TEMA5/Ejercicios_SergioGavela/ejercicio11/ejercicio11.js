


const trollButton = document.getElementById("trollButton");
let ancho = window.innerWidth;
let alto = window.innerHeight;

trollButton.addEventListener("mouseover", cambiaPosicionBoton);

function cambiaPosicionBoton() {
    trollButton.style.position = "absolute";
    trollButton.style.right = Math.floor(Math.random() * ancho) + "px";
    trollButton.style.top = Math.floor(Math.random() * alto) + "px";
}
