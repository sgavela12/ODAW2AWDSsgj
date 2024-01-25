package com.example.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Empleado;
import com.example.demo.services.EmpleadoServiceImpl;

@Controller
public class EmpleadoController {
@Autowired
public EmpleadoServiceImpl empleadoService;

@GetMapping({ "/", "/list" })
public String showList(Model model) {
model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
return "listView";
}

@GetMapping("/nuevo")
public String showNew(Model model) {
//el commandobject del formulario es una instancia de empleado vacia
model.addAttribute("empleadoForm", new Empleado());
return "newFormView";
}

@PostMapping("/nuevo/submit")
public String showNewSubmit(@Valid Empleado empleadoForm,BindingResult bindingResult) {
if (bindingResult.hasErrors()) return "redirect:/nuevo";
empleadoService.añadir(empleadoForm);
return "redirect:/list";
}

@GetMapping("/editar/{id}")
public String showEditForm (@PathVariable long id, Model model) {
Empleado empleado = empleadoService.obtenerPorId(id);
//el commandobject del formulario es el empleado con el id solicitado
if (empleado != null) {
model.addAttribute("empleadoForm", empleado);
return "editFormView";
}
//si no lo encuentra vuelve a la página de inicio.
return "redirect:/";
}

@PostMapping("/editar/submit")
public String showEditSubmit(@Valid Empleado empleadoForm,BindingResult bindingResult) {
if (!bindingResult.hasErrors())
empleadoService.editar(empleadoForm);
return "redirect:/list";
}

@GetMapping("/borrar/{id}")
public String showDelete(@PathVariable long id) {
empleadoService.borrar(id);
return "redirect:/list";
}
}


