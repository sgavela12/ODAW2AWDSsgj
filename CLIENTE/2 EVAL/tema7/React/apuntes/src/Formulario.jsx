import { useState } from 'react';

const Formulario = () => {
 const [nombre, setNombre] = useState('');
 const [correo, setCorreo] = useState('');

 const handleNombreChange = (event) => {
 setNombre(event.target.value);
 };

 const handleCorreoChange = (event) => {
 setCorreo(event.target.value);
 };

 const handleSubmit = (event) => {
 event.preventDefault();
 alert('nombre: ')

 // Objeto con los datos del formulario
 const formData = {
 nombre: nombre,
 correo: correo,
 };

 // Enviar datos al servidor
 fetch('URL_DEL_SERVIDOR', {
 method: 'POST',
 headers: {
 'Content-Type': 'application/json',
 },
 body: JSON.stringify(formData),
 })
 .then(response => response.json())
 .then(data => {
 // Manejar la respuesta del servidor si es necesario
 console.log('Respuesta del servidor:', data);
})
.catch(error => {
console.error('Error al enviar los datos:', error);
});
};

return (
<form onSubmit={handleSubmit}>
<label>
Nombre:
<input type="text" value={nombre} onChange={handleNombreChange} />
</label>
<br />
<label>
Correo Electrónico:
<input type="email" value={correo} onChange={handleCorreoChange} />
</label>
<br />
<button type="submit">Enviar</button>
</form>
);
};

export default Formulario;
