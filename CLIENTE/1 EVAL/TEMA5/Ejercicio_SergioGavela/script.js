let nombre = document.getElementById("nombre")
let enviar = document.getElementById("enviar")

enviar.addEventListener("click",()=>{
    sumaIntento()
})

if(Cookies.get("intentos")== null ){
    Cookies.set("intentos",0)
}




function sumaIntento(){
    Cookies.set("intentos",Cookies.get("intento"))
}