package com.example.DrHouse.Service;

import com.example.DrHouse.Model.Capitulo;
import com.example.DrHouse.Repository.CapituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class CapituloService {
    @Autowired
    private CapituloRepository capituloRepository;


    public List<Capitulo> obtenerCapitulosPorTemporadaId(Long temporadaId) {
        return capituloRepository.findByTemporadaId(temporadaId);
    }

    public Capitulo obtenerCapituloPorId(Long id) {
        return capituloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Capítulo no encontrado"
                ));
    }

    public Capitulo crearCapitulo(Capitulo capitulo) {
        return capituloRepository.save(capitulo);
    }
}

