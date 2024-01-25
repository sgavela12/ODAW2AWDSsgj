
let numero =   document.querySelector("#numero").value;

function checkEdad(){
    numero = parseInt(numero);
    alert(numero)
    if(numero<12){
        alert(typeof(numero))
        alert("Eres un niño")
    }else if(numero<36){
        alert("Eres un joven")
    }else if(numero<60){
        alert("Eres un adulto")
    }else if(numero>60){
        alert("Eres un jubilado")
    }

    
}