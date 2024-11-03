package com.example.DrHouse.Service;

import com.example.DrHouse.Model.Temporada;
import com.example.DrHouse.Repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class TemporadaService {
    @Autowired
    private TemporadaRepository temporadaRepository;

    public List<Temporada> obtenerTemporadasPorSerieId(Long serieId) {
        return temporadaRepository.findBySerieId(serieId);
    }

    public Temporada obtenerTemporadaPorId(Long id) {
        return temporadaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Temporada no encontrada"
                ));
    }

    public Temporada crearTemporada(Temporada temporada) {
        return temporadaRepository.save(temporada);
    }
}
