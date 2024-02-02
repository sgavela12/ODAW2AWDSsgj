import { Cliente } from "./Cliente.js";

document.addEventListener("DOMContentLoaded", cargaXmlFetch)

let comprobarButton = document.getElementById("comprobarButton")
let inputLocalidad = document.getElementById("inputLocalidad")

comprobarButton.addEventListener("click", () => { Cliente.consultaLocalidad(inputLocalidad.value) })
comprobarLocalidadButton.addEventListener("click", () => { Cliente.consultaCuota(inputCuota.value) })




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

function creaTabla(xml) {
    Cliente.clientesXML = transformaTabla(xml)
    Cliente.creaTabla()
}


function transformaTabla(xml) {
    let clientes = ["Nombre;Localidad;Cuota"]
    xml.forEach(cliente => {
        clientes.push(`${cliente.Nombre};${cliente.Localidad};${cliente.Cuota}`)
    });
    return clientes
}

function cargaXmlFetch(){
fetch('clientes.json')
  .then(response => {
    // La respuesta de la solicitud está disponible aquí
    // Puedes verificar si la solicitud fue exitosa (código de estado 200-299)
    if (!response.ok) {
      throw new Error('Hubo un problema con la solicitud. Código de estado: ' + response.status);
    }

    // Parsear la respuesta como JSON
    return response.json();
  })
  .then(data => {
    // Hacer algo con los datos obtenidos

    Cliente.clientesXML = transformaTabla(data)
    Cliente.creaTabla()
  })
  .catch(error => {
    // Manejar errores de red o del servidor
    console.error('Error en la solicitud:', error);
  });
}