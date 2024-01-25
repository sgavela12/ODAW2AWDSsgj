
let final = new Date("2024-06-20")
let hoy = new Date()
alert(Math.trunc((final.getTime()-hoy.getTime())/(1000 * 3600 * 24)))