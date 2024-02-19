package com.odaw2a.glc1003.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odaw2a.glc1003.domain.Empleado;
import com.odaw2a.glc1003.exceptions.NotFoundException;
import com.odaw2a.glc1003.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public List<Empleado> obtenerTodos() {
        List<Empleado> repo = repositorio.findAll();
        List<Empleado> empleadosActivos = new ArrayList<>();
        for (Empleado empleado : repo) {
            if (empleado.getEnActivo()) {
                empleadosActivos.add(empleado);
            }
        }
        return empleadosActivos;
    }

    public Empleado obtenerPorId(long id) throws NotFoundException {
        return repositorio.findById(id).orElse(null);
    }

    public Empleado editar(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Empleado> obtenerEmpleadosSalarioMayor(Double salario) {
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }

    @Override
    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.obtenerEmpleadoSalarioMayorMedia();
    }

}
