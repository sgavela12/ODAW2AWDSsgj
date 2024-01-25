let letra = prompt("Introduce una letra")
let letras = ["T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"]
let dnisValidos=[]

for(let i = 0 ; i < 999 ; i++){
    if(darLetra(i)==letra.toUpperCase()){
        dnisValidos.push(i + darLetra(i))
    }
}

dnisValidos.map((dni)=>{document.body.innerHTML+= dni + "<br>"})


function darLetra(numero){
    let resto = numero%23;
    return letras[resto];
}
