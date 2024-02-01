import { Cliente } from "./Cliente.js";

document.addEventListener("DOMContentLoaded",cargaXml)

let comprobarButton = document.getElementById("comprobarButton")
let inputLocalidad = document.getElementById("inputLocalidad")

comprobarButton.addEventListener("click", () => { Cliente.consultaLocalidad(inputLocalidad.value) })
comprobarLocalidadButton.addEventListener("click", () => { Cliente.consultaCuota(inputCuota.value) })



let personas




function cargaXml() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //Al hacer parse nos devuelve un objeto
            let objeto = JSON.parse(this.responseText);
            
            //Mostramos los datos

            //Si queremos convertir un objeto Javascript en una cadena
            let cadena = JSON.stringify(objeto);
            console.log(cadena)
            creaTabla(objeto)
            
        }
    }
    xhr.open("GET", "clientes.json", true);
    xhr.send();
}

function creaTabla(xml){
    Cliente.clientesXML=transformaTabla(xml)
    Cliente.creaTabla()
}


function transformaTabla(xml){
    let clientes = ["Nombre;Localidad;Cuota"]
    xml.forEach(cliente => {
        clientes.push( `${cliente.Nombre};${cliente.Localidad};${cliente.Cuota}`)
    });
    return clientes
}