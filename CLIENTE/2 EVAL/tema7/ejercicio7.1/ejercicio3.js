import { Cliente } from "./Cliente.js";

let clientes

let comprobarButton = document.getElementById("comprobarButton")
let inputLocalidad = document.getElementById("inputLocalidad")

comprobarButton.addEventListener("click",()=>{Cliente.consultaLocalidad(inputLocalidad.value)})
comprobarLocalidadButton.addEventListener("click",()=>{Cliente.consultaCuota(inputCuota.value)})




document.getElementById("cambiaContenido").addEventListener("click", cambiaContenido);

        function cambiaContenido() {
            var xhr = new XMLHttpRequest();
            xhr.addEventListener("readystatechange", function () {                      
if (this.readyState == 4 && this.status == 200) {
                    clientes= JSON.parse(this.responseText);
                    Cliente.creaTabla(Cliente.convertirClientes(clientes))
                    
                }
            });
            /* .open: especifica la solicitud
             - GET/POST.
             - Archivo: txt, php, xml, json, etc.
             - true/false: asincrono ó sincrono. */
            xhr.open("GET", "clientes.json", true);
            /* .send: envía la solicitud al servidor.
                Si utilizamos POST debemos pasar los datos por parámetro */
            xhr.send();
        }
  
       


