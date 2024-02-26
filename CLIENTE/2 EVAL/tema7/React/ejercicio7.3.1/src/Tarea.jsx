export function Tarea({tarea}){

return (
    <>
    <li>
    <input  type="checkbox" checked={tarea.estado}/>
    {tarea.descripcion}
    </li>
    </>
    );
}

    