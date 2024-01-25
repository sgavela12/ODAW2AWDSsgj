package com.example.ejercicio5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.ui.Model;



@Controller
@RequestMapping("/calculos")
public class MainController {

    @GetMapping({"","/"})
    public String showMe() {
        return "index";
    }

    @GetMapping("/primo/{numero}")
        public String calculoPrimo(@PathVariable String numero, Model model ){
            String respuesta = (MathController.esPrimo(Integer.parseInt(numero))) ? "El numero es primo": "El numero no es primo";
            model.addAttribute("respuesta", respuesta);


            return"index";
        }


        @GetMapping("/primo/")
        public String showError(){
            return "error";

        }



        @GetMapping("/hipotenusa/{x}/{y}")
        public String calculaHipotenusa(@PathVariable String x, @PathVariable String y, Model model){
            String respuesta = String.valueOf(Math.hypot(Double.parseDouble(x),Double.parseDouble(y)));
            model.addAttribute("respuesta", "La hipotenusa de "+y+" y "+ x +" es " + respuesta);
            if(Integer.parseInt(x) < 0 || Integer.parseInt(y) < 0) {
                return "error";
            }else{
                return "index";
            }
            

        }


        @GetMapping("/sinRepetidos/{x}")
        public String numeroAleatorio(@PathVariable Integer x,Model model){

            

            if(x>=1 && x <= 100){
                model.addAttribute("numeros",MathController.generaAleatorios(x));
                System.out.println(MathController.generaAleatorios(x));
                return "index";
            }else{
                return "error";
            }

        }
    
    @GetMapping("/divisores/{x}")
        public String divisores(@PathVariable Integer x,Model model){
            model.addAttribute("divisores", MathController.generaDivisores(x) );
            return "index";

            
}

 @GetMapping("/divisores")
        public String divisoresQuery(@RequestParam Integer num,Model model){
            model.addAttribute("divisores", MathController.generaDivisores(num) );
            return "index";

            
}}


