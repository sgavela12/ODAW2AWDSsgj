let nombre = document.getElementById("nombre")
let numero = document.getElementById("numero")
let contrasenia = document.getElementById("contrasenia")
let confirmContrasenia = document.getElementById("confirmContrasenia")
let continuar = document.getElementById("continuar")


continuar.addEventListener("click",validar)


if(localStorage.getItem("nombre")!=null){
    nombre.value = localStorage.getItem("nombre");
    numero.value = localStorage.getItem("numero")
}



function validar(){
   localStorage.setItem("nombre",nombre.value)
   localStorage.setItem("numero",numero.value)


    
}