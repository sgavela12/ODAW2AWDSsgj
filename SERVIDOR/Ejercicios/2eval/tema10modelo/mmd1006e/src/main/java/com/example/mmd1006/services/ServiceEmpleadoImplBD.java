package com.example.mmd1006.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.mmd1006.domain.Empleado;
import com.example.mmd1006.repository.EmpleadoRepository;

@Service
@Primary
public class ServiceEmpleadoImplBD implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;

    public Empleado añadir (Empleado empleado) {
        return repositorio.save(empleado);
    }

    public List<Empleado> obtenerTodos() {
        return repositorio.findAll();
    }

    public Empleado obtenerPorId(long Id) {
        return repositorio.findById(Id).orElse(null);
    }

    public Empleado editar (Empleado empleado) {
        return repositorio.save(empleado);
    }

    public void borrar (Long Id) {
        repositorio.deleteById(Id);
    }

    public List<Empleado> obtenerEmpleadosSalarioMayor (double salario){
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }
    
    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.obtenerEmpleadoSalarioMayorMedia();
    }
}