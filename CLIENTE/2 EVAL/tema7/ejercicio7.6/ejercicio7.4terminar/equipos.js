let select = document.getElementById("selectEquipo")
select.addEventListener("change",()=>{
  mostrarDatosEquipo()
})


fetch('equipos.json')
.then(response => response.json())
.then(equipos => {
  const selectEquipo = document.getElementById('selectEquipo');
  equipos.forEach(equipo => {
    const option = document.createElement('option');
    option.value = equipo.Nombre;
    option.textContent = equipo.Nombre;
    selectEquipo.appendChild(option);
  });
})
.catch(error => console.error('Error:', error));

function mostrarDatosEquipo() {
const selectEquipo = document.getElementById('selectEquipo');
const datosEquipoDiv = document.getElementById('datosEquipo');
const selectedTeam = selectEquipo.value;

fetch('equipos.json')
  .then(response => response.json())
  .then(data => {
    const equipoSeleccionado = data.find(equipo => equipo.Nombre === selectedTeam);

    if (equipoSeleccionado) {
      const html = `
        <h2>${equipoSeleccionado.Nombre}</h2>
        <p>Partidos Jugados: ${equipoSeleccionado.PartidosJugados}</p>
        <p>Partidos Ganados: ${equipoSeleccionado.PartidosGanados}</p>
        <p>Partidos Perdidos: ${equipoSeleccionado.PartidosPerdidos}</p>
        <p>Partidos Empatados: ${equipoSeleccionado.PartidosEmpatados}</p>
      `;
      datosEquipoDiv.innerHTML = html;
    } else {
      datosEquipoDiv.innerHTML = '<p>Equipo no encontrado.</p>';
    }
  })
  .catch(error => console.error('Error:', error));
}