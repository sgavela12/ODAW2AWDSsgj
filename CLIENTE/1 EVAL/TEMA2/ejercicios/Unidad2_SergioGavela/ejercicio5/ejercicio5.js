hora = 0
minutos = 0


for( ; hora<24 ; minutos +=30){
    
    if(minutos == 60){

        minutos = 0;
        hora = hora+1;
    }
    console.log(hora + ":" + minutos)
}
