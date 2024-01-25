import { Persona } from "./Persona.js"


const enviar = document.getElementById("enviar")
const mensaje = document.getElementById("mensaje")
const condiciones = document.getElementById("registro_condiciones")
const nombre = document.getElementById("registro_nombre")
const apellido = document.getElementById("registro_apellidos")
const email = document.getElementById("registro_email")
const contraseña = document.getElementById("registro_password")

let personas = []


enviar.addEventListener("click",checkErrores)


function checkErrores(){
    if(!checkCondiciones()){

        mensaje.innerHTML= "Debe de aceptar las condiciones del servicio"

    }else{
       if(checkNombre()){
        nombre.className=""
        if(checkApellido()){
            apellido.className=""
           if(checkEmail()){
            email.className=""
            // agrego la persona a el array
            creaPersona(nombre.value,apellido.value,email.value,contraseña.value)
            alert(`Datos de ${nombre.value} ${apellido.value} registrados correctamente`)
    
           }else{
            email.focus()
            email.className="error"
           }
        }else{
            apellido.focus()
            apellido.className="error"
        }
       }else{
        nombre.focus()
        nombre.className="error"
       }
    }
}

function checkCondiciones(){
    return condiciones.checked
}

function checkNombre(){
    if(nombre.value.length == 0){
        mensaje.innerHTML= "El Nombre no puede ser vacío"
        
        
        return false
    }else if(!(nombre.value.length >= 5 && nombre.value.length <=20)){
        mensaje.innerHTML= "El nombre ha de contener entre 5 y 20 caracteres"
        
        return false
    }else{
        return true
    }
}

function checkApellido(){
    if(apellido.value.length == 0){
        mensaje.innerHTML= "El Apellido no puede ser vacío"
        return false
    }else if(!(apellido.value.length >= 2 && apellido.value.length <=20)){
        mensaje.innerHTML= "El Apellido ha de contener entre 2 y 20 caracteres"
        return false
    }else{
        return true
    }
    
}
function checkEmail(){
    if(email.value.length == 0){
        mensaje.innerHTML="El correo no puede ser vacío"
    }else if(!/^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/.test(email.value)
    ){mensaje.innerHTML="El correo no tiene el formato correcto"
    return false
}else{
    mensaje.innerHTML=""
    return true
}
}
function creaPersona(nuevoNombre,nuevoApellidos,nuevoEmail,nuevaContraseña){
    personas.push(new Persona(nuevoNombre,nuevoApellidos,nuevoEmail,nuevaContraseña))
}



