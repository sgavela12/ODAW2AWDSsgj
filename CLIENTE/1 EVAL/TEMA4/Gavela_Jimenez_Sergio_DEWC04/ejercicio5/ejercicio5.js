import { Jugador } from "./Jugador.js"

let increaseButton = document.getElementById("increase-power")
let showButton = document.getElementById("show-power")

let player = new Jugador()
player.increasePower()

increaseButton.addEventListener("click",()=>{
    player.increasePower()
})
showButton.addEventListener("click",()=>{
    player.showPower()
})