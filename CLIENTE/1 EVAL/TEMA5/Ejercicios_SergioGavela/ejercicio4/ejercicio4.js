const numerosHtml = document.getElementById('numerosHtml')
const texto = document.getElementById('texto')
const numeros = [25, 36, 2, 85, 7, 45, 6]

numerosHtml.innerHTML = numeros
numerosHtml.addEventListener('mouseout', mostrarNumerosDesordenados)
numerosHtml.addEventListener('mouseover', mostrarNumerosOrdenados)
texto.addEventListener('mouseout', mostrarTextoDesordenados)
texto.addEventListener('mouseover', mostrarTextoOrdenados)

function mostrarNumerosOrdenados () {
  numerosHtml.innerHTML = [...numeros].sort(function (a, b) {
    return a - b
  })
}

function mostrarNumerosDesordenados () {
  numerosHtml.innerHTML = numeros
}

function mostrarTextoOrdenados () {
  texto.innerHTML = 'Mostrar numeros ordenados'
}
function mostrarTextoDesordenados () {
  texto.innerHTML = 'Mostrar numeros desordenados'
}
