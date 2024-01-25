

let contraseña = Math.floor(Math.random() * 900) + 100;
let numerosAcertados = 0;
let numeroIntento = "";
console.log(contraseña)

generarBotonesAleatorios();
añadeEventos()


  
  function generarBotonesAleatorios() {
  
    let numeros = Array.from({ length: 10 }, (_, index) => index);
  
 
    for (let i = numeros.length - 1; i > 0; i--) {
      let j = Math.floor(Math.random() * (i + 1));
      let temp = numeros[i];
      numeros[i] = numeros[j];
      numeros[j] = temp;
    }
  

    let contenedor = document.getElementById("contenedor")
  
    let contador = 0
    numeros.forEach(function(numero) { 
      let boton = document.createElement('button');
      boton.textContent = numero;
      boton.id = contador++;
      if (contador==6){
        contenedor.innerHTML += "<br>"
      }
      contenedor.appendChild(boton);
    });
  }

  function comprueba(numero){
   
      numerosAcertados++
      document.getElementById(`${numerosAcertados}input`).value = numero
      numeroIntento +=`${numero}`
    
    if(contraseña ==  numeroIntento  ){
      document.body.innerHTML="Log in Correcto"
    }else if(numeroIntento.length ==3){
      document.getElementById("mensaje").innerHTML = "Error en la contraseña"
      limpiaCasillas()
      numeroIntento=""
      numerosAcertados=0
    }
   
    
  }
  

function añadeEventos(){
  for(let i = 0 ; i<10; i++ ){
    
    let valor = document.getElementById(`${i}`).textContent;
    document.getElementById(`${i}`).addEventListener("click",()=>{comprueba(valor)})
  }
}

function limpiaCasillas(){
  document.getElementById("1input").value = ""
  document.getElementById("2input").value = ""
  document.getElementById("3input").value = ""
}

