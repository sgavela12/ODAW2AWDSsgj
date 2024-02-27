package com.example.demo.services;

import java.time.LocalDateTime;
//Pendiente mostrar movimientos y realizar movimientos
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cuenta;
import com.example.demo.domain.Movimiento;
import com.example.demo.domain.dto.NuevaCuentaDto;
import com.example.demo.domain.dto.NuevoMovimientoDto;
import com.example.demo.exception.CuentaExistenteException;
import com.example.demo.exception.CuentaNoVaciaException;
import com.example.demo.exception.CuentaNotFoundException;
import com.example.demo.exception.EmptyCuentaException;
import com.example.demo.repositories.CuentaRepositorio;
import com.example.demo.repositories.MovimientoRepositorio;

@Service
public class BancoServicioImplBD implements BancoServicio {

    @Autowired
    CuentaRepositorio cuentaRepositorio;
    @Autowired
    MovimientoRepositorio movimientoRepositorio;

    public List<Cuenta> verCuentas() {
        List<Cuenta> listaCuentas = cuentaRepositorio.findAll();
        if (listaCuentas.isEmpty())
            throw new EmptyCuentaException();

        return listaCuentas;
    }

    public List<Movimiento> obtenerMovimientos(String iban) {
        Cuenta cuenta = cuentaRepositorio.findById(iban).orElse(null);
        if (cuenta == null) {
            throw new CuentaNotFoundException(iban);
        }
        return movimientoRepositorio.findByCuenta(cuenta);
    }

    public Cuenta nuevaCuenta(Cuenta cuenta) {
        if (cuentaRepositorio.existsById(cuenta.getIban())) {
            throw new CuentaExistenteException(cuenta.getIban());
        }
        return cuentaRepositorio.save(cuenta);
    }

    public Cuenta obtenerPorIban(String iban) {
        return cuentaRepositorio.findById(iban).get();
    }

    public Cuenta cambiarCuenta(String iban) {

        return cuentaRepositorio.findById(iban).get();
    }

    public void borrarCuenta(String iban) {
       
        Cuenta cuenta = cuentaRepositorio.findById(iban)
                .orElseThrow(() -> new CuentaNotFoundException(iban));
                if(cuenta.getSaldo()!=0) throw new CuentaNoVaciaException();
        cuentaRepositorio.delete(cuenta);
    }

    public List<String> listaIbanes() {
        return cuentaRepositorio.getAllIban();
    }

    public void hacerMovimiento(String iban, Double importe) {
        Cuenta cuenta = cuentaRepositorio.findById(iban)
                .orElseThrow(() -> new CuentaNotFoundException(iban));

        movimientoRepositorio.save(new Movimiento(null, cuenta, LocalDateTime.now(), importe));

        cuenta.setSaldo(cuenta.getSaldo() + importe);
        cuentaRepositorio.save(cuenta);
    }

    public  Cuenta convertDtoToCuenta(NuevaCuentaDto nuevaCuentaDto){
        return new Cuenta(nuevaCuentaDto.getIban(),nuevaCuentaDto.getAlias(),null,null);
    }

    public Movimiento convertDtoToMovimiento(NuevoMovimientoDto nuevoMovimientoDto){
            return new Movimiento(null, cuentaRepositorio.findByIban( nuevoMovimientoDto.getIban()), LocalDateTime.now(),nuevoMovimientoDto.getImporte());
            
        }

    

}
