package com.odaw2a.GJS1003.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.odaw2a.GJS1003.domain.Empleado;
import com.odaw2a.GJS1003.domain.Genero;
import com.odaw2a.GJS1003.exceptions.NotFoundException;
import com.odaw2a.GJS1003.repositories.EmpleadoRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoServiceTest {
    @InjectMocks
    EmpleadoServiceImpl empleadoService;

    @Mock
    EmpleadoRepository empleadoRepository;

    List<Empleado> mockList = new ArrayList<>();

    @BeforeEach
    public void init() {
        mockList.add(new Empleado(1L, "Pepe", "pepe@gmail.com", 1500d, true, Genero.Masculino));
        mockList.add(new Empleado(2L, "Ana", "ana@gmail.com", 1700d, false, Genero.Femenino));
        mockList.add(new Empleado(3L, "Eva", "eva@gmail.com", 1800d, true, Genero.Femenino));
    }

    @Test
    public void añadirTest() {
        Empleado newEmpleado = new Empleado(4L, "Antonio", "ant@gmail.com", 2000d, true, Genero.Masculino);
        when(empleadoRepository.save(newEmpleado)).thenReturn(newEmpleado);
        Empleado nuevo = empleadoService.añadir(newEmpleado);
        assertEquals("Antonio", nuevo.getNombre());
        verify(empleadoRepository, times(1)).save(newEmpleado);
    }

    @Test
    public void obtenerTodosTest() {
        when(empleadoRepository.findAll()).thenReturn(mockList);
        List<Empleado> empList = empleadoService.obtenerTodos();
        assertEquals(2, empList.size());
        assertEquals("Eva", empList.get(1).getNombre());
        verify(empleadoRepository, times(1)).findAll();
    }

    @Test
    public void obtenerPorIdTest_Ok() throws NotFoundException {
        when(empleadoRepository.findById(1L)).thenReturn(Optional.of(mockList.get(0)));
        Empleado empleadoTest = empleadoService.obtenerPorId(1L);
        assertEquals(1500d, empleadoTest.getSalario());
        assertEquals(Genero.Masculino, empleadoTest.getGenero());
        verify(empleadoRepository, times(1)).findById(1L);
    }

    @Test
    public void obtenerPorIdTest_NotFoundException() throws NotFoundException {
        when(empleadoRepository.findById(0L)).thenReturn(Optional.ofNullable(null));
        empleadoService.obtenerPorId(1L);
        verify(empleadoRepository, times(1)).findById(1L);
    }

    // Tiene sentido?
    @Test
    public void obtenerEmpleadosSalarioMayor() {
        List<Empleado> listaResultado = new ArrayList<>();
        // Ponga el empleado que ponga, me va a dar ok
        listaResultado.add(mockList.get(2));
        when(empleadoRepository.findBySalarioGreaterThanEqualOrderBySalario(1700d)).thenReturn(listaResultado);
        empleadoService.obtenerEmpleadosSalarioMayor(1700d);
        verify(empleadoRepository, times(1)).findBySalarioGreaterThanEqualOrderBySalario(1700d);
    }

}
