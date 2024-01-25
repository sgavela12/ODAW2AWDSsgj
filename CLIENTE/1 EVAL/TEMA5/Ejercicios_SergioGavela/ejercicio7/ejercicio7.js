
const expFecha = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/;
const expNombre = /^[A-Z]{2}[^A-Za-z0-9]\d{4}$/;
const expDestinatario = /^[A-Z]{2,3}_[A-Za-z]+:\d{4}$/;
const expPeso = /^([1-9][0-9]{2,3}|5000)$/;
const expCuenta = /^[A-Z]{2}\d{2}[A-Za-z0-9]{4}\d{7}([A-Za-z0-9]{1,23})?$/;

let fechaCreacion = document.getElementById("fechaCreacion");
let nombre = document.getElementById("nombre");
let destinatario = document.getElementById("destinatario");
let peso = document.getElementById("peso");
let cuenta = document.getElementById("cuenta");
let info = document.getElementById("info");
let enviar = document.getElementById("enviar");

enviar.addEventListener("click", checkValues);

function checkValues() {

  const fechaValor = fechaCreacion.value;
  const nombreValor = nombre.value;
  const destinatarioValor = destinatario.value;
  const pesoValor = peso.value;
  const cuentaValor = cuenta.value;

  const fechaValida = expFecha.test(fechaValor);
  const nombreValido = expNombre.test(nombreValor);
  const destinatarioValido = expDestinatario.test(destinatarioValor);
  const pesoValido = expPeso.test(pesoValor);
  const cuentaValida = expCuenta.test(cuentaValor);


  info.innerHTML = "";
  if (!fechaValida) info.innerHTML += "Fecha no válida. ";
  if (!nombreValido) info.innerHTML += "Nombre no válido. ";
  if (!destinatarioValido) info.innerHTML += "Destinatario no válido. ";
  if (!pesoValido) info.innerHTML += "Peso no válido. ";
  if (!cuentaValida) info.innerHTML += "Cuenta no válida. ";


  if (fechaValida && nombreValido && destinatarioValido && pesoValido && cuentaValida) {
    info.innerHTML = "¡Todos los campos son válidos!";
  }
}
