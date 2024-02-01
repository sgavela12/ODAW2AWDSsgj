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


document.addEventListener("DOMContentLoaded", cargarDiscos())

function cargarDiscos() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            cargarXML(this);
        }
    };
    xhr.open("GET", "discos.xml", true);
    xhr.send();
        }

        function cargarXML(xml) {
            let docXML = xml.responseXML;
            let discosXML = docXML.getElementsByTagName("disco");
            for (let i = 0; i < discosXML.length; i++) {
                discos.push(new Disco(discosXML[i].getElementsByTagName("id")[0].textContent,discosXML[i].getElementsByTagName("grupo")[0].textContent,discosXML[i].getElementsByTagName("anno")[0].textContent,discosXML[i].getElementsByTagName("genero")[0].textContent,discosXML[i].getElementsByTagName("caratula")[0].textContent))
                console.log(discosXML[i].getElementsByTagName("id")[0].textContent);
                console.log(discosXML[i].getElementsByTagName("grupo")[0].textContent);
                console.log(discosXML[i].getElementsByTagName("anno")[0].textContent);
                console.log(discosXML[i].getElementsByTagName("genero")[0].textContent);
                console.log(discosXML[i].getElementsByTagName("caratula")[0].textContent);



            }
            
        }
