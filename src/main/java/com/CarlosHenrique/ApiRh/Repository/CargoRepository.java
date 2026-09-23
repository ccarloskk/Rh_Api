package com.CarlosHenrique.ApiRh.Repository;

import com.CarlosHenrique.ApiRh.Model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}