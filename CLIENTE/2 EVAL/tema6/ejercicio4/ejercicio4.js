const crearTexto =  document.getElementById("crearTexto")
const crearPassword =  document.getElementById("crearPassword")
const crearTextarea =  document.getElementById("crearTextarea")
const crearLabel =  document.getElementById("crearLabel")
const crearImagen =  document.getElementById("crearImagen")
const crearCheckbox =  document.getElementById("crearCheckbox")
const crearRadio =  document.getElementById("crearRadio")
const crearSubmit =  document.getElementById("crearSubmit")
const form =  document.getElementById("form")


crearTexto.addEventListener("click",()=>{
    let nombre = prompt("Que nombre quieres que tenga el input?")
    const input  = document.createElement("input")
    input.setAttribute("type","text")
    input.setAttribute("name",nombre)
    input.setAttribute("id",nombre)
    form.appendChild(input)
    form.appendChild(document.createElement("br"))
})


crearPassword.addEventListener("click",()=>{
    let nombre = prompt("Que nombre quieres que tenga el input?")
    const input  = document.createElement("input")
    input.setAttribute("type","password")
    input.setAttribute("name",nombre)
    input.setAttribute("id",nombre)
    form.appendChild(input)
    form.appendChild(document.createElement("br"))
})

crearTextarea.addEventListener("click",()=>{
    let nombre = prompt("Que nombre quieres que tenga el input?")
    const input  = document.createElement("textarea")
    input.setAttribute("cols",40)
    input.setAttribute("rows",5)
    input.setAttribute("name",nombre)
    input.setAttribute("id",nombre)
    form.appendChild(input)
    form.appendChild(document.createElement("br"))
})

crearLabel.addEventListener("click",()=>{
    let nombre = prompt("A que va referido?")
    let texto = prompt("Introduce que quieres que ponga el en el lable")
    const input  = document.createElement("label")
    input.textContent = texto
    input.setAttribute("for",nombre)
    form.appendChild(input)
})


crearImagen.addEventListener("click",()=>{
    let nombre = prompt("Que ruta tiene la imagen?")
    const input  = document.createElement("img")
    input.setAttribute("src",nombre)
    form.appendChild(input)
    form.appendChild(document.createElement("br"))
})

crearCheckbox.addEventListener("click",()=>{
    let nombre = prompt("Que nombre quieres que tenga?")
    let value = prompt("Que valor quieres que tenga?")
    const input  = document.createElement("input")
    input.setAttribute("type","checkbox")
    input.setAttribute("name",nombre)
    input.setAttribute("value",value)
    form.appendChild(input)
    form.appendChild(document.createElement("br"))
})

crearRadio.addEventListener("click",()=>{
    let nombre = prompt("Que nombre quieres que tenga?")
    let value = prompt("Que valor quieres que tenga?")
    const input  = document.createElement("input")
    input.setAttribute("type","radio")
    input.setAttribute("name",nombre)
    input.setAttribute("value",value)
    form.appendChild(input)
    form.appendChild(document.createElement("br"))
})



crearSubmit.addEventListener("click",()=>{
    let nombre = prompt("Que nombre quieres que tenga el input?")
    let value = prompt("Que valor quieres que tenga?")
    const input  = document.createElement("input")
    input.setAttribute("type","submit")
    input.setAttribute("name",nombre)
    input.setAttribute("value",value)
    input.setAttribute("id",nombre)
    form.appendChild(input)
    form.appendChild(document.createElement("br"))
})

