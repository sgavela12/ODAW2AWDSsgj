package com.example.ejercicio5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping({"/","","/index"})
    public String showIndex(){
        return "index";
    }
}
