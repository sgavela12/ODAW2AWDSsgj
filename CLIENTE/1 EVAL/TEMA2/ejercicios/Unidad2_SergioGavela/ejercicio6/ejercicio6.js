hora = 9
minutos = 0


for( ; hora<21 ; minutos +=5){
    
    if(minutos == 60){

        minutos = 0;
        hora = hora+1;
    }
    console.log(hora + ":" + minutos)
}
