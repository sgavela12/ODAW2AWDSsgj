const respuesta = document.getElementById('respuesta')
const digitos = document.getElementById('digitos')

digitos.addEventListener('input', calculaLetras)

function calculaLetras () {
  respuesta.value = darLetra(digitos.value)
}

function darLetra (numero) {
  const letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E']
  const resto = numero % 23
  return letras[resto]
}
