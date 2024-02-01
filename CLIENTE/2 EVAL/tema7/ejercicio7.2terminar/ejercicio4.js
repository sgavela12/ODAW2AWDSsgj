import { Disco } from "./Disco.js";

let discos = []
let numeroDiscos = document.getElementById("numeroDiscos")
let ordenNormalButton = document.getElementById("ordenNormal")
let ordenInversoButton = document.getElementById("ordenInverso")
let ordenAlfabeticoButton = document.getElementById("ordenAlfabetico")
let crearDisco = document.getElementById("crearDisco")
let tablaHtml = document.getElementById("espacioTabla")
let borrarDisco = document.getElementById("borrarDisco")
let consultarDisco = document.getElementById("consultarDisco")


consultarDisco.addEventListener("click",()=>{
   let respuesta = prompt("Quieres hacer la consulta por posicion[1] o por nombre[2]")

   if(respuesta ==1){
    let posicion = prompt("Que posicion quieres consultar?")-1
    tablaHtml.appendChild(mostrarTabla([discos[posicion]]))
   }
})



crearDisco.addEventListener("click",()=>{
    let nombreNuevo = prompt("Introduce el nombre del disco")
    let grupoNuevo = prompt("Introduce el grupo del disco")
    let anioNuevo = prompt("Introduce el año del disco")
    let tipoNuevo = prompt("Introduce el tipo del disco")
    let caratulaNuevo = prompt("Introduce la caratula del disco")

    discos.push(new Disco(nombreNuevo,grupoNuevo,anioNuevo,tipoNuevo,caratulaNuevo))

    actualizaTabla()
    actulizaNumeroDiscos()
    
})

borrarDisco.addEventListener("click",()=>{
   let opcion = prompt("Borrar al principio [1] o al final[2]")
   if(opcion == 1){
    discos.shift()
    

   }else{
    discos.pop()
    
   }
   actualizaTabla()
   actulizaNumeroDiscos()
})

ordenNormalButton.addEventListener("click",()=>{
   actualizaTabla()})
     
ordenInversoButton.addEventListener("click",()=>{
    tablaHtml.innerHTML=""
    tablaHtml.appendChild( mostrarTabla([...discos].reverse()))})
    
ordenAlfabeticoButton.addEventListener("click",()=>{
    tablaHtml.innerHTML=""
    tablaHtml.appendChild( mostrarTabla([...discos].sort((a, b) => {
        return a.nombre.localeCompare(b.nombre);
    })))})


actulizaNumeroDiscos()


function mostrarTabla(arryaDiscos){
    let table= document.createElement("table")
    arryaDiscos.forEach((disco) => {

        
        let columna =  table.insertRow()
        for(let campo in disco){
            let nuevoCampo =  columna.insertCell()
            nuevoCampo.innerHTML = disco[campo]
            
        }   
        
    })
    return table
}


function actualizaTabla(){
    tablaHtml.innerHTML=""
     tablaHtml.appendChild(mostrarTabla(discos))
}

function actulizaNumeroDiscos(){
    numeroDiscos.innerHTML = "Numero de discos: " + discos.length;
}


// Crear una instancia de XMLHttpRequest
var xmlhttp = new XMLHttpRequest();

// Especificar el método HTTP y la URL de la API
var url = "https://randomuser.me/api/?results=6&format=XML";
xmlhttp.open("GET", url, true);

// Configurar el tipo de respuesta esperada (en este caso, XML)
xmlhttp.setRequestHeader("Accept", "application/xml");

// Definir la función de devolución de llamada cuando la solicitud esté completa
xmlhttp.onreadystatechange = function () {
  // Verificar si la solicitud se ha completado satisfactoriamente
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    // Parsear la respuesta XML
    var xmlDoc = xmlhttp.responseXML;

    // Aquí puedes trabajar con el objeto xmlDoc que contiene la respuesta XML
    console.log(xmlDoc);
  }
};

// Enviar la solicitud
xmlhttp.send();

  