let numero = document.getElementById("numero");
let tipo = document.getElementById("tipo");
let letras = ["T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"]

function comprobar(){
    if(tipo.value== "nif"){
        if(numero.value.length !=  8){
            alert("El nif tiene que tener 8 digitos")
        }else{
            document.write("Tu nif " + numero.value+ " le corresponde la letra "+darLetra(numero.value))
        }
    }else{
        if(numero.value.length!=7){
            alert("El nie tiene que tener 7 digitos")
        }else{
            document.write("Tu nie " + numero.value+ " le corresponde la letra "+darLetra(numero.value))
        }
    }
}

function darLetra(numero){
    let resto = numero%23;
    return letras[resto];
}