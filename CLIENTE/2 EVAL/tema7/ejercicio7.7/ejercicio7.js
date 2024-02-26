document.addEventListener("DOMContentLoaded",cargaXmlFetch)
let filtro = document.getElementById("filtro")
let orden = document.getElementById("orden")
let espacioTabla = document.getElementById("espacioTabla");

let tabla = []

filtro.addEventListener("change", () => {
    ordenarTablaPorCriterio();
    
});

orden.addEventListener("change",ordenarTablaPilotos)

function cargaXmlFetch(){
    fetch('pilotos.json')
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
        mostrarPilotos(data)
        // Hacer algo con los datos obtenidos
    
        
      })
      .catch(error => {
        // Manejar errores de red o del servidor
        console.error('Error en la solicitud:', error);
      });
    }


    function mostrarPilotos(json){
        

       
            json.pilotos.forEach((piloto)=>{
                tabla.push(piloto)
            })

         
    }


    function creaTablaPiloto(){
        espacioTabla.innerHTML = iteraPilotos()

    }

    function iteraPilotos(){
        let respuesta=""
        tabla.forEach((piloto)=>{
            respuesta += `${piloto.nombre} ${piloto.equipo} ${piloto.nacionalidad}${piloto.numero} <br>`
        })
        return respuesta
    }


    function ordenarTablaPilotos() {
        const order = orden.value; // Obtener el valor seleccionado en el elemento <select> con id "orden"
        
        if (order === "ascendente") {
            tabla.sort((a, b) => a.nombre.localeCompare(b.nombre)); // Ordenar el array tabla de forma ascendente según el nombre del piloto
        } else if (order === "descendente") {
            tabla.sort((a, b) => b.nombre.localeCompare(a.nombre)); // Ordenar el array tabla de forma descendente según el nombre del piloto
        }
        
        espacioTabla.innerHTML = iteraPilotos();
    }


    function ordenarTablaPorCriterio() {
        const filtroSeleccionado = filtro.value; // Obtener el valor seleccionado en el elemento <select> con id "filtro"
    
        if (filtroSeleccionado === "nombre") {
            tabla.sort((a, b) => a.nombre.localeCompare(b.nombre)); // Ordenar el array tabla alfabéticamente por el nombre del piloto
        } else if (filtroSeleccionado === "nacionalidad") {
            tabla.sort((a, b) => a.nacionalidad.localeCompare(b.nacionalidad)); // Ordenar el array tabla alfabéticamente por la nacionalidad del piloto
        }
        
        // Renderizar la tabla con el nuevo orden según el criterio seleccionado
        espacioTabla.innerHTML = iteraPilotos();
    }
    
    
    