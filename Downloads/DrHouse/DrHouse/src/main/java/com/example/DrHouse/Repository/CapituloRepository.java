package com.example.DrHouse.Repository;

import com.example.DrHouse.Model.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapituloRepository extends JpaRepository<Capitulo, Long> {
    List<Capitulo> findByTemporadaId(Long temporadaId);
}

