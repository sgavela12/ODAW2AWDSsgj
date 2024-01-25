const nombre = document.getElementById('nombre')
const grupo = document.getElementById('grupo')
const anio = document.getElementById('anio')
const tipo = document.getElementById('tipo')
const localizacion = document.getElementById('localizacion')
const enviar = document.getElementById('enviar')
const msgErrorNombre = document.getElementById('msgErrorNombre')
const msgErrorAnio = document.getElementById('msgErrorAnio')



nombre.addEventListener("input",checkErroresNombreGrupo)
grupo.addEventListener("input",checkErroresNombreGrupo)
anio.addEventListener("input",checkAnio)
localizacion.addEventListener("input",checkLocalizacion)

enviar.addEventListener("click", checkInputs);



function checkNombreGrupo(html) {
    if( html.value.length >= 20){
        html.className = "error"
        return false
    } else{
        html.className =""
        return true
    }
}


function checkAnio(){
    if(this.value>999){
        this.className = "error"
        msgErrorAnio.innerHTML = "* El año es demasiado grande"
        return false
    }else{
        this.className =""
        msgErrorAnio.innerHTML = ""
        return true
    }
    
}

function checkLocalizacion(){
   
    if(typeof(this.value)=="undefined" || !isNaN(this.value)){
        this.className = ""
    }else{
        this.className = "error"
    }
}

function checkErroresNombreGrupo(){

    let errorNombre =!checkNombreGrupo(nombre)
    let errorGrupo =  !checkNombreGrupo(grupo)
    if(errorNombre || errorGrupo){
        msgErrorNombre.innerHTML = "Nombre o grupo demasiado largos"
        return false
    }
    else{
        msgErrorNombre.innerHTML="";
        return true
    }
}

function checkInputs(){
    if(checkErroresNombreGrupo() && checkAnio ){
        alert("Enviado")
    }
    


}