const zonaDibujo = document.getElementById("zonadibujo");
let colorSeleccionado = null;
let pincelActivado = false;

crearTablero(30, 30);

function crearTablero(columnas, filas) {
    let tabla = document.createElement("table");
    for (let x = 0; x < columnas; x++) {
        let columnaActual = document.createElement("tr");
        for (let y = 0; y < filas; y++) {
            let celda = document.createElement("td");
            celda.className = "tablerodibujo";
            columnaActual.appendChild(celda);
            celda.addEventListener("click", cambiaColor);
            celda.addEventListener("mouseover", pintaHover);
        }
        tabla.appendChild(columnaActual);
        tabla.className = "tablerodibujo";
    }
    zonaDibujo.appendChild(tabla);
}

function cambiaColor() {
    if (pincelActivado) {
        this.classList.add(colorSeleccionado);
    }
}

function pintaHover() {
    if (pincelActivado) {
        this.classList.add(colorSeleccionado);
    }


// Obtener todas las filas de la tabla
let filas = zonaDibujo.getElementsByTagName('tr');

// Iterar sobre cada fila
for (let i = 0; i < filas.length; i++) {
    // Obtener todas las celdas de la fila actual
    let celdas = filas[i].getElementsByTagName('td');

    // Iterar sobre cada celda de la fila actual
    for (let j = 0; j < celdas.length; j++) {
        // Acceder al contenido de la celda y hacer algo con él
        let contenidoCelda = celdas[j];

        contenidoCelda.addEventListener("click", function () {
            pincelActivado = !pincelActivado;
            document.getElementById("pincel").textContent = pincelActivado ? "PINCEL ACTIVADO" : "PINCEL DESACTIVADO";
            
        });

        // Aquí puedes realizar las operaciones que necesites con el contenido de cada celda
        
    }
}

// Función para manejar la selección de colores
document.getElementById("paleta").addEventListener("click", function (event) {
    const target = event.target;
    if (target.classList.contains("color1") || target.classList.contains("color2") ||
        target.classList.contains("color3") || target.classList.contains("color4") ||
        target.classList.contains("color5") || target.classList.contains("color6")) {
        colorSeleccionado = target.style.backgroundColor;
        resetearSeleccion();
        target.classList.add("seleccionado");
    }
});

function resetearSeleccion() {
    const colores = document.querySelectorAll(".color.seleccionado");
    colores.forEach(function (color) {
        color.classList.remove("seleccionado");
    });
}

}