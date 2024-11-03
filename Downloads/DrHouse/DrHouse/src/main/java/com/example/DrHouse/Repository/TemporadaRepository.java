package com.example.DrHouse.Repository;

import com.example.DrHouse.Model.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemporadaRepository extends JpaRepository<Temporada, Long> {
    List<Temporada> findBySerieId(Long serieId);
}
