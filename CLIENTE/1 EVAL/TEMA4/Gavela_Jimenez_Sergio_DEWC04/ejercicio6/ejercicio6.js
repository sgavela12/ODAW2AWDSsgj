const convocatorias = ["Luis,Pepe,Manuel,Lolo,Marcos,Sergio,Juan", "Sergio,Marcos,Luis,Pepe,David,Antonio,Pedro,Juan,Lolo", "Sergio,Juan,Carlos,Lolo", "Sergio,Juan,Lolo"]


checkConvocados(convocatorias)

function checkConvocados(convocatorias) {
    let convocatoriaAnterior
    convocatorias.forEach(convocatoria => {
        if (convocatoriaAnterior == null) {
            convocatoriaAnterior = convocatoria.split(",")
        } else {
            let menor, mayor
            convocatoria = convocatoria.split(",")
            if (convocatoria.length < convocatoriaAnterior.length) {
                menor = convocatoria
                mayor = convocatoriaAnterior
            } else {
                menor = convocatoriaAnterior
                mayor = convocatoria
            }

            let repetidos = []
            for (let i = 0; i < mayor.length; i++) {

                mayor.forEach(campo => {
                    if (campo == menor[i]) {
                        repetidos.push(campo)

                    }
                })
            }
            convocatoriaAnterior = repetidos

        }


    });
    document.body.innerHTML = "Jugadores que han sido siempre convocados: "+ convocatoriaAnterior
    
    


}