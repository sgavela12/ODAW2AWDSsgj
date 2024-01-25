export class Disco{

    constructor(nombre,grupo,anio,tipo,caratula){
        this.nombre = nombre;
        this.grupo = grupo;
        this.anio = anio ;
        this.tipo = tipo ;
        this.caratula = caratula;
        this.localizacion = 0;
        this.prestado = false;
    }

    cambiarEstanteria(nuevaLocalizacion){
        this.localizacion = nuevaLocalizacion;
    }

    cambiarPretado(){
        prestado = !prestado;
    }

    infoDisco(){

    }





}