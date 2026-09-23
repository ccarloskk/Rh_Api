package com.CarlosHenrique.ApiRh.Repository;

import com.CarlosHenrique.ApiRh.Model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {
}