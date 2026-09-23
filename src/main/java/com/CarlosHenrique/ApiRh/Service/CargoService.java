package com.CarlosHenrique.ApiRh.Service;

import com.CarlosHenrique.ApiRh.Model.Cargo;
import com.CarlosHenrique.ApiRh.Repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public Cargo cadastrar(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public List<Cargo> listar() {
        return cargoRepository.findAll();
    }

    public Cargo buscarPorId(Long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo não encontrado"));
    }

    public Cargo atualizar(Long id, Cargo cargo) {
        Cargo cargoExistente = buscarPorId(id);

        cargoExistente.setNome(cargo.getNome());
        cargoExistente.setDescricao(cargo.getDescricao());

        return cargoRepository.save(cargoExistente);
    }

    public void excluir(Long id) {
        Cargo cargo = buscarPorId(id);
        cargoRepository.delete(cargo);
    }
}