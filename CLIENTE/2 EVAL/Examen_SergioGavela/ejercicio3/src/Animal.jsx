function Animal(props){
    let animales = ["Perro","Gato","Loro","Tigre","Tiburón","Gaviota"]
    let animalSeleccionado = animales[props.numero]
    return (
        <>
        <li>Animal: {animalSeleccionado}</li>
        </>
        );
    }
    
        export default Animal;