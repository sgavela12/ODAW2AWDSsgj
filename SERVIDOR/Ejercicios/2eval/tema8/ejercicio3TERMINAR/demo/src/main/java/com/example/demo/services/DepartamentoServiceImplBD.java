package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Departamento;
import com.example.demo.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImplBD implements DepartamentoService {
    @Autowired
    DepartamentoRepository repositorio;

    public Departamento añadir(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public List<Departamento> obtenerTodos() {
        return repositorio.findAll();
    }

    public Departamento obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Departamento editar(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public void borrar(Departamento departamento) {
        repositorio.delete(departamento); // también es cómodo deleteById(id)
    }

    public Departamento obtenerPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
}
