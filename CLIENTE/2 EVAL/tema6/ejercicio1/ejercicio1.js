const boton = document.getElementById("boton");

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
  mostrarTareas();
}

function mostrarTareas() {
  const listaTareas = document.getElementById('listaTareas');
  listaTareas.innerHTML = '';

  tareas.forEach((tarea, index) => {
    const li = document.createElement('li');
    const checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    checkbox.checked = tarea.completada;
    checkbox.addEventListener('click', () => tachaCompletada(index)); 

    const span = document.createElement('span');
    span.textContent = tarea.texto;
    if (tarea.completada) {
      span.classList.add('completada');
    }

    li.appendChild(checkbox);
    li.appendChild(span);
    listaTareas.appendChild(li);
  });
}

mostrarTareas();
