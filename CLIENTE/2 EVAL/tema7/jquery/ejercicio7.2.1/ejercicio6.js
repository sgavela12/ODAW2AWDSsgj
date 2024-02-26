let botones = [];
let boton1 = [$("#button1"), "", false, false];
let boton2 = [$("#button2"), "", false, false];
let boton3 = [$("#button3"), "", false, false];
let boton4 = [$("#button4"), "", false, false];
let boton5 = [$("#button5"), "", false, false];
let boton6 = [$("#button6"), "", false, false];
let boton7 = [$("#button7"), "", false, false];
let boton8 = [$("#button8"), "", false, false];
let boton9 = [$("#button9"), "", false, false];
let boton10 = [$("#button10"), "", false, false];
let boton11 = [$("#button11"), "", false, false];
let boton12 = [$("#button12"), "", false, false];

let imagenesVolteadas = 0;
let puntos = 0;
let errores = 0;
let primerBoton;

$("#aceptarNombre").click(() => {
    document.cookie = `nombre=${$("#nombre").val()};`;
    document.cookie = `contador=0`;
});

if (!(document.cookie == "")) {
    setCookie("contador", parseInt(getCookie("contador")) + 1);
    $("#vecesJugadas").html("Has jugado " + getCookie("contador") + " veces.");
    $("#restart").css("display", "block");
    $("#formularioNombre").css("display", "none");
    $("#juego").css("display", "block");
    $("#mensajeNombre").html("Bienvenido " + getCookie("nombre") + "!");
}

$("#restart").click(() => {
    location.reload();
});

botones.push(
    boton1,
    boton2,
    boton3,
    boton4,
    boton5,
    boton6,
    boton7,
    boton8,
    boton9,
    boton10,
    boton11,
    boton12
);

botones.forEach((boton) => {
    boton[0].click(() => {
        if (boton[2] == false && (imagenesVolteadas == 0 || imagenesVolteadas == 1)) {
            cambiaImagen(boton[0], boton[1]);
            boton[2] = true;
            imagenesVolteadas++;
        }
    });
});

$(document).click(() => {
    checkImagenesVolteadas();
    actualizaErrores();
    checkAciertos();
});

function setCookie(nombre, valor) {
    document.cookie = nombre + "=" + valor + ";";
}

function getCookie(nombre) {
    let nom = nombre + "=";
    let array = document.cookie.split(";");
    for (let i = 0; i < array.length; i++) {
        let c = array[i];
        while (c.charAt(0) == " ") {
            c = c.substring(1);
        }
        if (c.indexOf(nombre) == 0) {
            return c.substring(nom.length, c.length);
        }
    }
    return "";
}

function esconderImagenes() {
    botones.forEach((boton) => {
        if (boton[2] == true && boton[3] == false) {
            boton[2] = false;
            cambiaImagen(boton[0], "img/carta.jpg");
        }
    });
}

function actualizaAciertos() {
    $("#numeroAciertos").html(`Numero de Aciertos: ${puntos}`);
}

function actualizaErrores() {
    $("#numeroErrores").html(`Numero de Errores: ${errores}`);
}

function cambiaImagen(elemento, imagen) {
    elemento.children().eq(0).attr("src", imagen);
}

function checkAciertos() {
    if (puntos == 6) {
        $("#mensajeGanado").html("HAS GANADO!");
    } else {
        actualizaAciertos();
    }
}

function checkImagenesVolteadas() {
    let acierto = false;
    if (imagenesVolteadas == 1) {
        botones.forEach((boton) => {
            if (boton[2] == true && boton[3] == false) {
                primerBoton = boton;
            }
        });
    }
    if (imagenesVolteadas >= 2) {
        let coincidencias = 0;
        botones.forEach((boton) => {
            if (boton[2] == true) {
                if (primerBoton[1] == boton[1]) {
                    coincidencias++;
                    if (coincidencias == 2) {
                        puntos++;
                        acierto = true;
                        primerBoton[3] = true;
                        boton[3] = true;
                        imagenesVolteadas = 0;
                    }
                }
            }
        });
        if (!acierto) {
            errores++;
            setTimeout(() => {
                esconderImagenes();
                imagenesVolteadas = 0;
            }, 1250);
        }
        acierto = false;
    }
}

let xhttp = new XMLHttpRequest();

let url = "https://randomuser.me/api/?results=6&format=xml";
xhttp.open("GET", url, true);

xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        let responseXML = this.responseXML;

        let pictures = responseXML.getElementsByTagName("picture");

        for (let i = 0; i < pictures.length; i++) {
            let mediumElement = pictures[i].getElementsByTagName("large")[0];
            botones[i][1] = mediumElement.textContent;
            botones[i + 6][1] = mediumElement.textContent;
        }
    }
};

xhttp.send();
