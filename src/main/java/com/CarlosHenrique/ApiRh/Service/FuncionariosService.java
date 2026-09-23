package com.CarlosHenrique.ApiRh.Service;

import com.CarlosHenrique.ApiRh.Model.Funcionarios;
import com.CarlosHenrique.ApiRh.Repository.FuncionariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService {

    private final FuncionariosRepository funcionariosRepository;

    public FuncionariosService(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;
    }

    public Funcionarios cadastrar(Funcionarios funcionario) {
        return funcionariosRepository.save(funcionario);
    }

    public List<Funcionarios> listar() {
        return funcionariosRepository.findAll();
    }

    public Funcionarios buscarPorId(Long id) {
        return funcionariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public Funcionarios atualizar(Long id, Funcionarios funcionario) {
        Funcionarios funcionarioExistente = buscarPorId(id);

        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setCpf(funcionario.getCpf());
        funcionarioExistente.setEmail(funcionario.getEmail());
        funcionarioExistente.setDataAdmissao(funcionario.getDataAdmissao());
        funcionarioExistente.setSalario(funcionario.getSalario());

        return funcionariosRepository.save(funcionarioExistente);
    }

    public void excluir(Long id) {
        Funcionarios funcionario = buscarPorId(id);
        funcionariosRepository.delete(funcionario);
    }
}