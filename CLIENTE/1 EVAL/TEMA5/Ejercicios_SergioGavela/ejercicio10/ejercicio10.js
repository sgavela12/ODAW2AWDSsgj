import { Cliente } from "./Cliente.js"

let listaClientes = [new Cliente("dni", "02553235M", "18/05/1998")]

let tipo
let dni = document.getElementById("dni")
let pasaporte = document.getElementById("pasaporte")
let entrar = document.getElementById("entrar")
let numero = document.getElementById("numero")
let dia = document.getElementById("dia")
let mes = document.getElementById("mes")
let anio = document.getElementById("anio")
let recordar = document.getElementById("recordar")
let fecha

entrar.addEventListener("click", () => {

    checkTipoDocumento();

    let cliente = new Cliente(tipo, numero.value, getFecha);
    if (recordar.checked) {
        localStorage.setItem("cliente", cliente);
    }
    fecha = `${dia.value}/${mes.value}/${anio.value}`;


    if (recogeDatos()) {
        validar();
        //Poner nueva pagina
        window.location = "./password.html"
    }
});





function checkDatos(cliente) {
    if (listaClientes.some(existingCliente =>
        existingCliente.tipo === cliente.tipo &&
        existingCliente.numero === cliente.numero &&
        existingCliente.fecha === cliente.fecha
    )) {
        return true;
    }

    alert("No existe el usuario");
    return false;
}




function checkTipoDocumento() {
    if (tipo == undefined) {
        let elemento = document.getElementsByName("documento")
        let elementosArray = Array.from(elemento)
        elementosArray.forEach((elemento) => {
            if (elemento.checked) {
                tipo = elemento.value
            }
        })
    }

}

function getFecha() {
    return `${dia.value}/${mes.value}/${anio.value}`
}








if (localStorage.getItem("numero") != null) {
    numero.value = localStorage.getItem("numero");
    let fecha = localStorage.getItem("fecha").split("/")
    dia.value = fecha[0]
    mes.value = fecha[1]
    anio.value = fecha[2]
    recordar.checked = true
    let prueba = localStorage.getItem("tipo")
    if (prueba == "dni") {
        dni.checked = true
    } else if (prueba == "pasaporte") {
        pasaporte.checked = true
    }

}



function validar() {
    if (recordar.checked) {
        localStorage.setItem("numero", numero.value)
        localStorage.setItem("fecha", `${dia.value}/${mes.value}/${anio.value}`)
        localStorage.setItem("tipo", tipo)


    } else {
        localStorage.clear()
    }

}


function recogeDatos() {
    return checkDatos(new Cliente(tipo, numero.value, fecha))
}