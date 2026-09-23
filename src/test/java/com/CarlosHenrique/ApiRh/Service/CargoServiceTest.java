package com.CarlosHenrique.ApiRh.Service;

import com.CarlosHenrique.ApiRh.Model.Cargo;
import com.CarlosHenrique.ApiRh.Repository.CargoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CargoServiceTest {

    @Mock
    private CargoRepository cargoRepository;

    @InjectMocks
    private CargoService cargoService;

    @Test
    void deveCadastrarCargo() {
        Cargo cargo = new Cargo();
        cargo.setNome("Desenvolvedor");
        cargo.setDescricao("Auxiliar ");

        when(cargoRepository.save(cargo)).thenReturn(cargo);

        Cargo resultado = cargoService.cadastrar(cargo);

        assertNotNull(resultado);
        assertEquals("Desenvolvedor", resultado.getNome());
        verify(cargoRepository).save(cargo);
    }

    @Test
    void deveBuscarCargoPorId() {
        Cargo cargo = new Cargo();
        cargo.setNome("Desenvolvedor");

        when(cargoRepository.findById(1L)).thenReturn(Optional.of(cargo));

        Cargo resultado = cargoService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals("Desenvolvedor", resultado.getNome());
        verify(cargoRepository).findById(1L);
    }
}