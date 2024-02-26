package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Empleado;
import com.example.demo.exception.EmpleadoNotFoundException;
import com.example.demo.exception.EmptyEmpleadosException;
import com.example.demo.repository.EmpleadoRepository;

@Service
@Primary
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public List<Empleado> obtenerTodos() {
        List<Empleado> lista = repositorio.findAll();
        if (lista.isEmpty()) throw new EmptyEmpleadosException();
        return lista; }

    public Empleado obtenerPorId (long id) {
        return repositorio.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
        }

    public Empleado editar(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    public List<Empleado> obtenerEmpleadosSalarioMayor(double salario) {
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }

    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.obtenerEmpleadoSalarioMayorMedia();
    }

}