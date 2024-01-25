import { Edificio } from "./Edificio.js";

let edificios = []

const calleInput = document.getElementById('calle');
const numeroInput = document.getElementById('numero');
const codigoPostalInput = document.getElementById('codigoPostal');
const plantasInput = document.getElementById('plantas');
const puertasInput = document.getElementById('puertas');
const crearButton = document.getElementById('crear');
const selectEdificio = document.getElementById("edificio")
const formulario3 = document.getElementById("miFormulario3")
const validarCalle = /^.{1,100}$/; // Mínimo 1, máximo 100 caracteres.
const validarNumero = /^[0-9]+$/; // Solo números positivos.
const validarCodigoPostal = /^\d{5}$/; // Debe tener 5 dígitos.
const validarPlantasPuertas = /^\d+$/; // Solo números positivos.
let edificioEnUso;
const espacioTabla = document.getElementById("espacioTabla")


crearButton.addEventListener('click', () => {
    if (!validarCalle.test(calleInput.value)) {
        alert('Por favor, introduce una calle válida.');
    } else if (!validarNumero.test(numeroInput.value)) {
        alert('Por favor, introduce un número válido.');
    } else if (!validarCodigoPostal.test(codigoPostalInput.value)) {
        alert('Por favor, introduce un código postal válido.');
    } else if (!validarPlantasPuertas.test(plantasInput.value)) {
        alert('Por favor, introduce un número válido de plantas.');
    } else if (!validarPlantasPuertas.test(puertasInput.value)) {
        alert('Por favor, introduce un número válido de puertas.');
    } else {
        alert('Formulario válido.');

        let nuevoEdificio = new Edificio(calleInput.value, numeroInput.value, codigoPostalInput.value, plantasInput.value, puertasInput.value)
        edificios.push(nuevoEdificio)
        let opcion = document.createElement("option")
        opcion.textContent = nuevoEdificio.getCalle()
        opcion.setAttribute("value", nuevoEdificio.getCalle())
        selectEdificio.appendChild(opcion)

        console.log(edificios)
    }
    if (edificios.length > 0) {
        formulario3.removeAttribute("hidden")
    }
});




selectEdificio.addEventListener('change', function () {
    let edificioCorrecto
    edificios.forEach((edificioIterado) => {
        if (edificioIterado.getCalle() == this.value) edificioCorrecto = edificioIterado
    })
    crearTablaConEdificio(edificioCorrecto)
    edificioEnUso = edificioCorrecto;
});


function crearTablaConEdificio(edificioTabla) {
    espacioTabla.innerHTML = ""
    let tabla = document.createElement("table")
    console.log(edificioTabla.getPlantas())



    //itero las plantas
    edificioTabla.getPlantas().forEach((planta) => {
        tabla.appendChild(document.createElement("tr"))
        let tr = document.createElement("td")
        tr.textContent = `Piso ${planta.getPiso()}`
        tabla.appendChild(tr)
        //itero las puertas
        planta.getPuertas().forEach((puerta) => {
            let columna = document.createElement("td")
            columna.textContent = puerta.getPropietario()
            columna.addEventListener("click", () => { mostrarFormularioEditar(puerta, puerta.getPropietario()) })
            tabla.appendChild(columna)
        })


    })
    espacioTabla.appendChild(tabla)

}

function mostrarFormularioEditar(puertaActual, nombreAntiguo) {

    const formulario = document.createElement("form")
    formulario.setAttribute("id", "formulario4")
    const nombreFormulario = document.createElement("input")
    nombreFormulario.setAttribute("value", nombreAntiguo)
    nombreFormulario.setAttribute("id", "nombreFormulario")
    const botonFormulario = document.createElement("input")
    botonFormulario.setAttribute("type", "button")
    botonFormulario.setAttribute("value", "Actualizar")
    //falta


    formulario.appendChild(nombreFormulario)
    formulario.appendChild(botonFormulario)
    document.body.appendChild(formulario)

    botonFormulario.addEventListener("click", () => {
        modificarPropietario(document.getElementById("nombreFormulario").value, puertaActual.getPlanta(), puertaActual.getNumero())
        // modificarPropietarioSinNombre(puertaActual.getPlanta(), puertaActual.getNumero())
        document.body.removeChild(document.getElementById("formulario4"))
        crearTablaConEdificio(edificioEnUso)
    })

}

function modificarPropietario(nuevoNombre, checkPlanta, checkPuerta) {

    edificioEnUso.getPlantas().forEach((planta) => {
        planta.getPuertas().forEach((puerta) => {
            if (planta.getPiso() == checkPlanta && puerta.getNumero() == checkPuerta)
                puerta.agregaPropietario(nuevoNombre);
        })
    })

}

function modificarPropietarioSinNombre(checkPlanta, checkPuerta) {
    modificarPropietario(document.getElementById("nombreFormulario").value, checkPlanta, checkPuerta)
}


