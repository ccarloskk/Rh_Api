package com.CarlosHenrique.ApiRh.Repository;

import com.CarlosHenrique.ApiRh.Model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}