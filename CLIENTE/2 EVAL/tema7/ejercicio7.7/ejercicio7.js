document.addEventListener("DOMContentLoaded", cargaXmlFetch);

let filtro = document.getElementById("filtro");
let orden = document.getElementById("orden");
let espacioTabla = document.getElementById("espacioTabla");
let inputNacionalidad = document.getElementById("inputNacionalidad");
let tabla = [];
let paginaActual = 1;
const pilotosPorPagina = 3;

filtro.addEventListener("change", () => {
    ordenarTablaPorCriterio();
});

orden.addEventListener("change", ordenarTablaPilotos);

inputNacionalidad.addEventListener("input", filtrarPorNacionalidad);

function cargaXmlFetch(){
    fetch('pilotos.json')
      .then(response => {
        if (!response.ok) {
          throw new Error('Hubo un problema con la solicitud. Código de estado: ' + response.status);
        }
        return response.json();
      })
      .then(data => {
        mostrarPilotos(data);
      })
      .catch(error => {
        console.error('Error en la solicitud:', error);
      });
}

function mostrarPilotos(json){
    tabla = json.pilotos;
    actualizarTabla();
}

function actualizarTabla(){
    const inicio = (paginaActual - 1) * pilotosPorPagina;
    const fin = inicio + pilotosPorPagina;
    const pilotosPagina = tabla.slice(inicio, fin);
    espacioTabla.innerHTML = iteraPilotos(pilotosPagina);

    // Actualizar paginación
    const totalPaginas = Math.ceil(tabla.length / pilotosPorPagina);
    const paginacionHTML = generarPaginacion(totalPaginas);
    document.getElementById("paginacion").innerHTML = paginacionHTML;
}

function iteraPilotos(pilotos){
    let respuesta = "";
    pilotos.forEach((piloto) => {
        respuesta += `<div class="filaPiloto" onclick="destacarPiloto(this)">
            ${piloto.nombre} ${piloto.equipo} ${piloto.nacionalidad} ${piloto.numero}
        </div>`;
    });
    return respuesta;
}

function ordenarTablaPilotos() {
    const order = orden.value;
    if (order === "ascendente") {
        tabla.sort((a, b) => a.nombre.localeCompare(b.nombre));
    } else if (order === "descendente") {
        tabla.sort((a, b) => b.nombre.localeCompare(a.nombre));
    }
    actualizarTabla();
}

function ordenarTablaPorCriterio() {
    const filtroSeleccionado = filtro.value;
    if (filtroSeleccionado === "nombre") {
        tabla.sort((a, b) => a.nombre.localeCompare(b.nombre));
    } else if (filtroSeleccionado === "equipo") {
        tabla.sort((a, b) => a.equipo.localeCompare(b.equipo));
    }
    actualizarTabla();
}

function filtrarPorNacionalidad() {
    const nacionalidad = inputNacionalidad.value.trim().toLowerCase();
    const pilotosFiltrados = tabla.filter(piloto => piloto.nacionalidad.toLowerCase() === nacionalidad);
    actualizarTabla(pilotosFiltrados);
}


function destacarPiloto(elemento){
    elemento.classList.toggle("pilotoDestacado");
}

function generarPaginacion(totalPaginas){
    let paginacionHTML = `<button onclick="cambiarPagina(1)">Primera</button>`;
    for(let i = 1; i <= totalPaginas; i++){
        paginacionHTML += `<button onclick="cambiarPagina(${i})">${i}</button>`;
    }
    paginacionHTML += `<button onclick="cambiarPagina(${totalPaginas})">Última</button>`;
    return paginacionHTML;
}

function cambiarPagina(pagina){
    paginaActual = pagina;
    actualizarTabla();
}
