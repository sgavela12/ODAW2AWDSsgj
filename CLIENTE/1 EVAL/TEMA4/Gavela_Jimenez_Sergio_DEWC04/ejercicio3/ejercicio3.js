import { Cliente } from "./Cliente.js";


let comprobarButton = document.getElementById("comprobarButton")
let inputLocalidad = document.getElementById("inputLocalidad")

comprobarButton.addEventListener("click",()=>{Cliente.consultaLocalidad(inputLocalidad.value)})
comprobarLocalidadButton.addEventListener("click",()=>{Cliente.consultaCuota(inputCuota.value)})



Cliente.creaTabla()
