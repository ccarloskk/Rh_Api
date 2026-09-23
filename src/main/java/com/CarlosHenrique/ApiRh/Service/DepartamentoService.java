package com.CarlosHenrique.ApiRh.Service;

import com.CarlosHenrique.ApiRh.Model.Departamento;
import com.CarlosHenrique.ApiRh.Repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public Departamento cadastrar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    public Departamento buscarPorId(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }

    public Departamento atualizar(Long id, Departamento departamento) {
        Departamento departamentoExistente = buscarPorId(id);

        departamentoExistente.setNome(departamento.getNome());
        departamentoExistente.setDescricao(departamento.getDescricao());

        return departamentoRepository.save(departamentoExistente);
    }

    public void excluir(Long id) {
        Departamento departamento = buscarPorId(id);
        departamentoRepository.delete(departamento);
    }
}