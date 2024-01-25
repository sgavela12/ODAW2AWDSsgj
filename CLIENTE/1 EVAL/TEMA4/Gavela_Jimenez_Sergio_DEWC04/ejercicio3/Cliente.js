export  class Cliente {
    static clientes = [
        "Nombre;Localidad;Cuota",
        "Laura;Santander;50",
        "Álvaro;Castro;50",
        "Igor;Castro;60",
        "Ivan;Santander;40",
        "Mónica;Zamora;30",
        "Javi;Bilbao;30",
        "David;Bilbao;50",
    ];


    static tabla = document.getElementById("tabla");
    static clientesSerparados=[]

    static creaTabla() {
        Cliente.clientes.forEach((cliente) => {
            let nuevoTr = document.createElement("tr");
            let datos = cliente.split(";");

            datos.forEach((campo) => {
                let nuevoTd = document.createElement("td");
                nuevoTd.innerHTML = campo;
                nuevoTr.appendChild(nuevoTd);
            });
            tabla.appendChild(nuevoTr);
        });
    }

    static separaArray(){
        Cliente.clientes.forEach((cliente) => {
            let datos = cliente.split(";");
            Cliente.clientesSerparados.push(datos)
       })
       return Cliente.clientesSerparados
    }

    static consultaLocalidad(localidad){
        let clientesAptos = []
        let respuesta = document.getElementById("respuesta")

        Cliente.separaArray().forEach((elemento)=>{
            if(localidad == elemento[1]){
                elemento.splice(1,1)
                clientesAptos.push(elemento)
            }
        })
        if (clientesAptos.length == 0){
            respuesta.innerHTML = "No se ha encontrado ningun cliente"
        }else{
            let mensaje = ""
            clientesAptos.forEach((cliente)=>{
                mensaje += "El cliente "+cliente[0] + " con la couta de "+ cliente[1] +"<br>"
            })
            respuesta.innerHTML = mensaje
        }
    }

    static consultaCuota(cuota){
        let clientesAptos =[]

        Cliente.separaArray().forEach((elemento)=>{
            if(cuota < elemento[2] &&  !(elemento[2]=="Cuota")){
                clientesAptos.push(elemento)
            }
        })
        if (clientesAptos.length == 0){
            respuesta.innerHTML = "No se ha encontrado ningun cliente"
        }else{
            let mensaje = ""
            clientesAptos.forEach((cliente)=>{
                mensaje += "El cliente "+cliente[0] + " de la localidad de  "+ cliente[1] + " con la cuota de "+cliente[2]+"<br>"
            })
            respuesta.innerHTML = mensaje
    }
}


}

