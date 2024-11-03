package com.example.DrHouse.Service;

import com.example.DrHouse.Model.Serie;
import com.example.DrHouse.Repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> obtenerSeries() {
        return serieRepository.findAll();
    }

    public Serie obtenerSeriePorId(Long id) {
        return serieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Serie no encontrada"
                ));
    }

    public Serie crearSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public Serie actualizarSerie(Long id, Serie serieActualizada) {
        Serie serie = obtenerSeriePorId(id);
        serie.setNombre(serieActualizada.getNombre());
        serie.setDescripcion(serieActualizada.getDescripcion());
        serie.setCreador(serieActualizada.getCreador());
        serie.setClasificacion(serieActualizada.getClasificacion());
        serie.setPoster(serieActualizada.getPoster());
        return serieRepository.save(serie);
    }

    public void eliminarSerie(Long id) {
        Serie serie = obtenerSeriePorId(id);
        serieRepository.delete(serie);
    }
}

