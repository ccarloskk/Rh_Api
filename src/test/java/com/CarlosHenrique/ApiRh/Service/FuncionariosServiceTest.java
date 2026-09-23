package com.CarlosHenrique.ApiRh.Service;

import com.CarlosHenrique.ApiRh.Model.Funcionarios;
import com.CarlosHenrique.ApiRh.Repository.FuncionariosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FuncionariosServiceTest {

    @Mock
    private FuncionariosRepository funcionariosRepository;

    @InjectMocks
    private FuncionariosService funcionariosService;

    @Test
    void deveCadastrarFuncionario() {
        Funcionarios funcionario = new Funcionarios();
        funcionario.setNome("teste");
        funcionario.setCpf("12345678900");
        funcionario.setEmail("teste@email.com");
        funcionario.setSalario(new BigDecimal("3000.00"));

        when(funcionariosRepository.save(funcionario)).thenReturn(funcionario);

        Funcionarios resultado = funcionariosService.cadastrar(funcionario);

        assertNotNull(resultado);
        assertEquals("teste", resultado.getNome());
        assertEquals("teste@email.com", resultado.getEmail());
        verify(funcionariosRepository).save(funcionario);
    }
}