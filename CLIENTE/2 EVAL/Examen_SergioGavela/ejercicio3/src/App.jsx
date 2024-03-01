import './App.css'
import Animal from './Animal';
function App() {
  
  function generaRandom(max) {
    return Math.floor(Math.random() * max);
  }

  let listaNumerosAleatorios = [generaRandom(5),generaRandom(5),generaRandom(5)] 


  return (
    <>
    <Animal numero={listaNumerosAleatorios[0]}></Animal>
    <Animal numero={listaNumerosAleatorios[1]}></Animal>
    <Animal numero={listaNumerosAleatorios[2]}></Animal>
    </>
  )
}

export default App
