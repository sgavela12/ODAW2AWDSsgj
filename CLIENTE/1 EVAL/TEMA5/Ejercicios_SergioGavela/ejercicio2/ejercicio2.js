const comenzarSaludos = document.getElementById('comenzarSaludos')
const pararSaludos = document.getElementById('pararSaludos')

let intervalo
comenzarSaludos.addEventListener('click', añadeIntervalo)
pararSaludos.addEventListener('click', limpiaIntervalo)

function diHola () {
  alert('hola')
}

function limpiaIntervalo () {
  clearInterval(intervalo)
}

function añadeIntervalo () {
  intervalo = setInterval(diHola, 3000)
}
