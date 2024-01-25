
document.addEventListener("DOMContentLoaded", () => {
    function createFormElement(type, id, placeholder) {
        const input = document.createElement("input");
        input.type = type;
        input.id = id;
        input.placeholder = placeholder;
        return input;
    }

    function createSelectOption(value, text) {
        const option = document.createElement("option");
        option.value = value;
        option.textContent = text;
        return option;
    }


    const form = document.createElement("form");

    const titulo = document.createElement("h2");
    titulo.textContent = "Nuevo Disco";
    form.appendChild(titulo);

    const nombre = createFormElement("text", "nombre", "Nombre del Disco");
    nombre.setAttribute("id", "nombre");
    form.appendChild(nombre);
    form.appendChild(document.createElement("br"));

    const grupo = createFormElement("text", "grupo", "Grupo");
    grupo.setAttribute("id", "grupo");
    form.appendChild(grupo);
    form.appendChild(document.createElement("br"));

    const msgErrorNombre = document.createElement("div");
    msgErrorNombre.style.color = "red";
    msgErrorNombre.id = "msgErrorNombre";
    form.appendChild(msgErrorNombre);
    form.appendChild(document.createElement("br"));

    const anio = createFormElement("number", "anio", "Año de publicación");
    anio.setAttribute("id", "anio");
    form.appendChild(anio);
    form.appendChild(document.createElement("br"));

    const msgErrorAnio = document.createElement("div");
    msgErrorAnio.style.color = "red";
    msgErrorAnio.id = "msgErrorAnio";
    form.appendChild(msgErrorAnio);
    form.appendChild(document.createElement("br"));

    const select = document.createElement("select");
    select.name = "tipo";
    select.id = "tipo";

    const generos = ["Rock", "Pop", "Punk", "Indie"];
    generos.forEach(function (genero) {
        select.appendChild(createSelectOption(genero.toLowerCase(), genero));
    });

    form.appendChild(select);
    form.appendChild(document.createElement("br"));

    form.appendChild(createFormElement("text", "localizacion", "Localización"));

    document.body.appendChild(form);

    const button = document.createElement("button");
    button.id = "enviar";
    button.textContent = "Enviar";
    document.body.appendChild(button);


    function checkNombreGrupo(html) {
        if (html.value.length >= 20) {
            html.className = "error";
            return false;
        } else {
            html.className = "";
            return true;
        }
    }

    function checkAnio() {
        if (this.value > 999) {
            this.className = "error";
            msgErrorAnio.innerHTML = "* El año es demasiado grande";
            return false;
        } else {
            this.className = "";
            msgErrorAnio.innerHTML = "";
            return true;
        }
    }

    function checkLocalizacion() {
        if (typeof (this.value) == "undefined" || !isNaN(this.value)) {
            this.className = "";
        } else {
            this.className = "error";
        }
    }

    function checkErroresNombreGrupo() {
        let errorNombre = !checkNombreGrupo(nombre);
        let errorGrupo = !checkNombreGrupo(grupo);
        if (errorNombre || errorGrupo) {
            msgErrorNombre.innerHTML = "Nombre o grupo demasiado largos";
            return false;
        } else {
            msgErrorNombre.innerHTML = "";
            return true;
        }
    }

    function checkInputs() {
        if (checkErroresNombreGrupo() && checkAnio()) {
            alert("Enviado");
        }
    }

    nombre.addEventListener("input", checkErroresNombreGrupo);
    grupo.addEventListener("input", checkErroresNombreGrupo);
    anio.addEventListener("input", checkAnio);
    localizacion.addEventListener("input", checkLocalizacion);

    button.addEventListener("click", checkInputs);

});
