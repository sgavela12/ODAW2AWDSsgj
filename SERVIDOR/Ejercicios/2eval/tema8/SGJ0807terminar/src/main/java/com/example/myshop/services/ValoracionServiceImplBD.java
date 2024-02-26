package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Producto;
import com.example.myshop.domain.Usuario;
import com.example.myshop.domain.Valoracion;
import com.example.myshop.repositories.ValoracionRepository;
@Service
public class ValoracionServiceImplBD implements ValoracionService{
    
    @Autowired
    ValoracionRepository valoracionRepository;

    @Override
    public Valoracion añadir(Valoracion valoracion) {
        return valoracionRepository.save(valoracion);
    }


    @Override
    public Valoracion obtenerPorId(Long id) {
        return valoracionRepository.findById(id).orElse(null);
    }

    @Override
    public Valoracion editar(Valoracion valoracion) {
        return valoracionRepository.save(valoracion);
    }

    @Override
    public void borrar(Long id) {
        valoracionRepository.delete(valoracionRepository.findById(id).orElse(null));
    }


    @Override
    public List<Valoracion> obtenerValoracionesPorProducto(Producto producto) {
        return valoracionRepository.findByProducto(producto);
    }


    @Override
    public List<Valoracion> obtenerValoracionesPorUsuario(Usuario usuario) {
        return valoracionRepository.findByUsuario(usuario);
    }
}
