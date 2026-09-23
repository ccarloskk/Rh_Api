package com.CarlosHenrique.ApiRh.Service;

import com.CarlosHenrique.ApiRh.Model.Departamento;
import com.CarlosHenrique.ApiRh.Repository.DepartamentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {

    @Mock
    private DepartamentoRepository departamentoRepository;

    @InjectMocks
    private DepartamentoService departamentoService;

    @Test
    void deveCadastrarDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNome("Tecnologia");
        departamento.setDescricao("Departamento de tecnologia");

        when(departamentoRepository.save(departamento)).thenReturn(departamento);

        Departamento resultado = departamentoService.cadastrar(departamento);

        assertNotNull(resultado);
        assertEquals("Tecnologia", resultado.getNome());
        verify(departamentoRepository).save(departamento);
    }

    @Test
    void deveListarDepartamentos() {
        when(departamentoRepository.findAll()).thenReturn(java.util.List.of(
                new Departamento(),
                new Departamento()
        ));

        var resultado = departamentoService.listar();

        assertEquals(2, resultado.size());
        verify(departamentoRepository).findAll();
    }
}