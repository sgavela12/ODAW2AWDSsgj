import {Tarea} from "./Tarea";

import { useEffect, useState } from 'react';


export function ListaTareas() {
  const [datos, setDatos] = useState([]);
    useEffect(() => {
      // Este código se ejecuta después del renderizado inicial
      // Puedes realizar operaciones asíncronas aquí, como llamadas a una API
     // Ejemplo de solicitud a una API y actualización del estado
     fetch('tareas.json')
     .then(response => response.json())
     .then(data =>{ setDatos(data)
    
 }
     );
     

   // Función de limpieza
   return () => {
     // Código de limpieza aquí, se ejecuta antes de que el componente se desmonte
   };
 }, []);
 
  
  return (
    <div>
      <h1>Lista de Tareas</h1>
      <input type="text" id="nuevaTarea" placeholder="Nueva tarea" />
      <button id="boton">Agregar</button>
      <ul id="listaTareas">
        {datos.map((dato)=><Tarea tarea={dato}></Tarea>}

      </ul>

      
    </div>
  );


}

