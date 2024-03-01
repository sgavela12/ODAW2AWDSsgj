let mostrarUsuarios = document.getElementById("mostrarUsuarios")
let numeroUsuarios = document.getElementById("numeroUsuarios")
let mensajeError = document.getElementById("mensajeError")
let lista = document.getElementById("lista")


let listaUsuarios;

document.addEventListener("DOMContentLoaded", ()=>{
    cargaJson();
    
})

mostrarUsuarios.addEventListener("click", () => {
    mensajeError.innerHTML=""
    if(validaNumero()){
        muestraUsuarios(numeroUsuarios.value);
    }else{
        muestraMensajeError();
    }
    
})

function cargaJson() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //Al hacer parse nos devuelve un objeto
            let objeto = JSON.parse(this.responseText);

            listaUsuarios = objeto.results;
            
        }
    }
    xhr.open("GET", "personas.json", true);
    xhr.send();
}

function validaNumero() {
    return(numeroUsuarios.value >0 && numeroUsuarios.value<=20)
}


function muestraMensajeError(){
    mensajeError.innerHTML = "No ha introducido un numero del 1 al 20."
}

function ordenaListaPorPais(){
    listaUsuarios.sort(function (a, b) {
        if (a.location.country > b.location.country) {
          return 1;
        }
        if (a.location.country < b.location.country) {
          return -1;
        }
     
        return 0;
    });
}


function muestraUsuarios(numero) {
    ordenaListaPorPais();
    for (let x = 0; x < numero; x++) {
        let persona = document.createElement("p")
        persona.className = "card"

        let nombre = document.createElement("p")
        nombre.textContent += ` Nombre: ${listaUsuarios[x].name.first}  `

        let pais = document.createElement("p")
        pais.textContent += ` Pais:${listaUsuarios[x].location.country} `

        let usuario = document.createElement("p")
        usuario.textContent += ` Usuario: ${listaUsuarios[x].login.username} `

        let contraseña = document.createElement("p")
        contraseña.textContent += ` Contraseña: ${listaUsuarios[x].login.password} `

        let foto = document.createElement("img")
        foto.setAttribute("src",`${listaUsuarios[x].picture.medium} `)

        persona.appendChild(nombre)
        persona.appendChild(pais)
        
        persona.appendChild(usuario)
        persona.appendChild(contraseña)
        persona.appendChild(foto)
        
        lista.appendChild(persona)
    }
}