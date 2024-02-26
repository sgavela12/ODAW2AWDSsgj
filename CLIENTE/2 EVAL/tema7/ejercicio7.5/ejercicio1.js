const boton = document.getElementById("boton");
document.addEventListener("DOMContentLoaded",cargaXml)

const tareas = [];

boton.addEventListener("click", agregarTarea);

function agregarTarea() {
  const nuevaTareaTexto = document.getElementById('nuevaTarea').value;
  if (nuevaTareaTexto.trim() !== '') {
    const nuevaTarea = { texto: nuevaTareaTexto, completada: false };
    tareas.push(nuevaTarea);
    mostrarTareas();
    document.getElementById('nuevaTarea').value = '';
  }
}

function tachaCompletada(index) {
  tareas[index].completada = !tareas[index].completada;
  
}

function mostrarTareas() {
  const listaTareas = document.getElementById('listaTareas');
  listaTareas.innerHTML = '';

  tareas.forEach((tarea, index) => {
    const li = document.createElement('li');
    const checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    if(tarea.estado == "completada"){
      checkbox.checked = true;
    }else{
      checkbox.checked = false
    }
  
    checkbox.addEventListener('click', () => tachaCompletada(index)); 

    const span = document.createElement('span');
    span.textContent = tarea.descripcion;
    if (tarea.estado=="completada") {
      checkbox.checked=true
    }else{
      checkbox.checked = tarea.completada;
    }

    li.appendChild(checkbox);
    li.appendChild(span);
    listaTareas.appendChild(li);
  });
}

mostrarTareas();





function cargaXml() {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
          //Al hacer parse nos devuelve un objeto
          let objeto = JSON.parse(this.responseText);

        cargaTareas(objeto)
          let cadena = JSON.stringify(objeto);

      }
  }
  xhr.open("GET", "tareas.json", true);
  xhr.send();
}


function cargaTareas(json){
  json.forEach((tarea)=>{
    tareas.push(tarea)
  })
  mostrarTareas()
}