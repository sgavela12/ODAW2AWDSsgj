function crearParrafo() {
  var texto = document.getElementById("texto").value.trim();

  var color = document.getElementById("colores").value;

  var resultado = document.getElementById("resultado");

  if (texto === "") {
    resultado.innerHTML =
      "<p style='color: red;'>Error: El texto no puede estar vacío.</p>";
  } else {
    var nuevoParrafo = document.createElement("p");
    nuevoParrafo.textContent = texto;
    nuevoParrafo.style.backgroundColor = color;

    resultado.appendChild(nuevoParrafo);

    document.getElementById("texto").value = "";
  }
}
