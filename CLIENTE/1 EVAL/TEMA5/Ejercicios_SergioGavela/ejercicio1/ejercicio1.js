const salidaX = document.getElementById('salidaX')
const salidaY = document.getElementById('salidaY')

document.addEventListener('mousemove', actualizaPosicion)

function actualizaPosicion () {
  const x = event.clientX
  const y = event.clientY
  salidaX.innerHTML = 'X: ' + x
  salidaY.innerHTML = 'Y: ' + y
}
