import { Arrays } from "./Arrays.js"

const paises = [
  "Argentina",
  "Brasil",
  "Canadá",
  "Chile",
  "Colombia",
  "España",
  "Estados Unidos",
  "Francia",
  "Italia",
  "Japón",
  "México",
  "Perú",
  "Reino Unido",
  "Rusia",
];

let inputUser = document.getElementById("numberInput")
let checkButton = document.getElementById("check");
let respuesta = document.getElementById("respuesta")
let inputText = document.getElementById("inputText")
let añadirButton = document.getElementById("añadirButton")

checkButton.addEventListener("click", checkNumber)
añadirButton.addEventListener("click", () => Arrays.añadePais(paises, inputText.value))
añadirButton.addEventListener("click", () => {
  añadirButton.style.display = "none";
  inputText.style.display = "none"})


function checkNumber() {
  let numero = parseInt(inputUser.value)
  switch (numero) {
    case 1:
      respuesta.textContent = Arrays.muestraNumeroPaises(paises)
      break;
    case 2:
      respuesta.textContent = Arrays.muestraPaises(paises)
      break;
    case 3:
      añadirButton.style.display = "block"
      inputText.style.display = "block"
      break;
    case 4:
      respuesta.textContent = Arrays.borrarPais(paises)
      break;
    case 5:
      respuesta.textContent = Arrays.consultarPais(paises)
      break;
    default:
      respuesta.textContent = "Error";
      break;
  }

}


