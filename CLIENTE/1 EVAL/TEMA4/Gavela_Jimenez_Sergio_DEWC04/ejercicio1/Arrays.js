export class Arrays {

    static muestraNumeroPaises(paises) {
        return paises.length
    }

    static muestraPaises(paises) {
        let cadena = "";
        let respuesta = prompt("Que orden quiere que se muestre [1]Normal [2]Al reves [3]Orden Alfabetico")
        if (respuesta == 1) {

            paises.forEach(pais => cadena += (pais + " "))
            return cadena
        } else if (respuesta == 2) {
            let paisesInvertido = [...paises]
            paisesInvertido.reverse().forEach(pais => cadena += (pais + " "))
            return cadena;
        } else if (respuesta == 3) {
            let paisesAlfabetico = [...paises];
            paisesAlfabetico.sort().forEach(pais => cadena += (pais + " "));
            return cadena;
        }
    }

    static añadePais(paises, pais) {
        paises.push(pais)
    }

    static borrarPais(paises) {
        let respuesta = prompt("Quieres borrar un elemento [1] del principio [2]del final")
        if (respuesta == 1) {
            paises.shift();
        }else{
            paises.pop();
        }
    }

    static consultarPais(paises) {
        let opcion = prompt("Quieres consultar por Posicion[1] o por Nombre[2]")
        let respuesta;
        if(opcion== 1){
            respuesta = prompt("Introduce la posicion que quiere consultar");
            return paises[respuesta]
        }else{
            respuesta = prompt("Introduce el nombre del pais que quiere consultar");
            return paises.indexOf(respuesta);
        }
    }

}

