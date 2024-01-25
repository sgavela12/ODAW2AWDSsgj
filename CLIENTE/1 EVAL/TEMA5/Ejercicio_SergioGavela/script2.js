

document.addEventListener("DOMContentLoaded", function () {
  let intentosEnvio = 0;

  function actualizarIntentosEnvio() {
      intentosEnvio++;
      document.getElementById("intentos").innerHTML =
          "Intento de Envíos del formulario: " + intentosEnvio;
      Cookies.set("intentosEnvio", intentosEnvio);
  }

  function convertirAMayusculas(evento) {
      evento.target.value = evento.target.value.toUpperCase();
  }

  function validarNombreYApellidos() {
      const nombre = document.getElementById("nombre").value;
      const apellidos = document.getElementById("apellidos").value;

      if (nombre.trim() === "" || apellidos.trim() === "") {
          document.getElementById("errores").innerHTML =
              "Nombre y apellidos son campos obligatorios.";
          document.getElementById("nombre").classList.add("error");
          document.getElementById("apellidos").classList.add("error");
          document.getElementById("nombre").focus();
          return false;
      }

      return true;
  }

  function validarEdad() {
      const edad = document.getElementById("edad").value;

      if (!/^\d+$/.test(edad) || parseInt(edad) < 0 || parseInt(edad) > 105) {
          document.getElementById("errores").innerHTML =
              "La edad debe ser un número entre 0 y 105.";
          document.getElementById("edad").classList.add("error");
          document.getElementById("edad").focus();
          return false;
      }

      return true;
  }

  function validarNIF() {
      const nif = document.getElementById("nif").value;
      const nifRegex = /^\d{8}-[a-zA-Z]$/;

      if (!nifRegex.test(nif)) {
          document.getElementById("errores").innerHTML =
              "Formato de NIF incorrecto.";
          document.getElementById("nif").classList.add("error");
          document.getElementById("nif").focus();
          return false;
      }

      return true;
  }

  function validarEmail() {
      const email = document.getElementById("email").value;
      const emailRegex =
          /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

      if (!emailRegex.test(email)) {
          document.getElementById("errores").innerHTML =
              "Formato de correo electrónico incorrecto.";
          document.getElementById("email").classList.add("error");
          document.getElementById("email").focus();
          return false;
      }

      return true;
  }

  function validarProvincia() {
      const provincia = document.getElementById("provincia").value;

      if (provincia === "0") {
          document.getElementById("errores").innerHTML =
              "Debe seleccionar una provincia.";
          document.getElementById("provincia").classList.add("error");
          document.getElementById("provincia").focus();
          return false;
      }

      return true;
  }

  function validarFecha() {
      const fecha = document.getElementById("fecha").value;
      const fechaRegex = /^(0[1-9]|[12][0-9]|3[01])[-/](0[1-9]|1[0-2])[-/]\d{4}$/;

      if (!fechaRegex.test(fecha)) {
          document.getElementById("errores").innerHTML =
              "Formato de fecha incorrecto.";
          document.getElementById("fecha").classList.add("error");
          document.getElementById("fecha").focus();
          return false;
      }

      return true;
  }

  function validarTelefono() {
      const telefono = document.getElementById("telefono").value;
      const telefonoRegex = /^\d{9}$/;

      if (!telefonoRegex.test(telefono)) {
          document.getElementById("errores").innerHTML =
              "Formato de teléfono incorrecto.";
          document.getElementById("telefono").classList.add("error");
          document.getElementById("telefono").focus();
          return false;
      }

      return true;
  }

  function validarHora() {
      const hora = document.getElementById("hora").value;
      const horaRegex = /^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/;

      if (!horaRegex.test(hora)) {
          document.getElementById("errores").innerHTML =
              "Formato de hora incorrecto.";
          document.getElementById("hora").classList.add("error");
          document.getElementById("hora").focus();
          return false;
      }

      return true;
  }

  document.getElementById("nombre").addEventListener("blur", convertirAMayusculas);
  document.getElementById("apellidos").addEventListener("blur", convertirAMayusculas);

  document.getElementById("formulario").addEventListener("submit", function (evento) {
      actualizarIntentosEnvio(); // Incrementar intentos de envío incluso si el formulario no es válido

      if (
          validarNombreYApellidos() &&
          validarEdad() &&
          validarNIF() &&
          validarEmail() &&
          validarProvincia() &&
          validarFecha() &&
          validarTelefono() &&
          validarHora()
      ) {
          if (!confirm("¿Desea enviar el formulario?")) {
              evento.preventDefault();
          }
      } else {
          evento.preventDefault();
      }
  });

  intentosEnvio = Cookies.get("intentosEnvio") || 0;
  document.getElementById("intentos").innerHTML =
      "Intento de Envíos del formulario: " + intentosEnvio;
});
