$(document).ready(function () {
    let listaUsuarios;

    $("#mostrarUsuarios").on("click", function () {
        $("#mensajeError").html("");
        if (validaNumero()) {
            muestraUsuarios($("#numeroUsuarios").val());
        } else {
            muestraMensajeError();
        }
    });

    cargaJson();


    
    function cargaJson() {
        $.ajax({
            url: "personas.json",
            dataType: "json",
            success: function (data) {
                listaUsuarios = data.results;
            }
        });
    }

    function validaNumero() {
        return ($("#numeroUsuarios").val() > 0 && $("#numeroUsuarios").val() <= 20);
    }

    function muestraMensajeError() {
        $("#mensajeError").html("No ha introducido un número del 1 al 20.");
    }

    function ordenaListaPorPais() {
        listaUsuarios.sort(function (a, b) {
            if (a.location.country > b.location.country) {
                return 1;
            }
            if (a.location.country < b.location.country) {
                return -1;
            }
            return 0;
        });
    }

    function muestraUsuarios(numero) {
        ordenaListaPorPais();
        for (let x = 0; x < numero; x++) {
            let persona = $("<div class='card'></div>");

            let nombre = $("<p></p>").text(" Nombre: " + listaUsuarios[x].name.first);
            let pais = $("<p></p>").text(" Pais: " + listaUsuarios[x].location.country);
            let usuario = $("<p></p>").text(" Usuario: " + listaUsuarios[x].login.username);
            let contraseña = $("<p></p>").text(" Contraseña: " + listaUsuarios[x].login.password);
            let foto = $("<img>").attr("src", listaUsuarios[x].picture.medium);

            persona.append(nombre, pais, usuario, contraseña, foto);
            $("#lista").append(persona);
        }
    }

   
});

