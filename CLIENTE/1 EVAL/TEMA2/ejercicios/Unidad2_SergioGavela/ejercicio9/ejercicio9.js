let respuesta  = parseInt( prompt("Introduce tu edad"))


switch (true) {
    case (respuesta>=0 && respuesta <=12):
        alert("Eres un niño")
        
        break;

    case ( respuesta >12 && respuesta <= 26):
        alert("Eres un joven")
            
        break;

    case ( respuesta >26 && respuesta <= 60):
        alert("Eres un adulto")
            
        break;

    case ( respuesta >60 ):
        alert("Eres un jubilado")
                
        break;
    
    default:
        alert("Edad no valida")
  
}