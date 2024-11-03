package com.example.DrHouse.Controller;

import com.example.DrHouse.Model.Serie;
import com.example.DrHouse.Service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {
    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<Serie> obtenerSeries() {
        return serieService.obtenerSeries();
    }

    @GetMapping("/{id}")
    public Serie obtenerSeriePorId(@PathVariable Long id) {
        return serieService.obtenerSeriePorId(id);
    }

    @PostMapping
    public Serie crearSerie(@RequestBody Serie serie) {
        return serieService.crearSerie(serie);
    }

    @PutMapping("/{id}")
    public Serie actualizarSerie(@PathVariable Long id, @RequestBody Serie serie) {
        return serieService.actualizarSerie(id, serie);
    }

    @DeleteMapping("/{id}")
    public void eliminarSerie(@PathVariable Long id) {
        serieService.eliminarSerie(id);
    }
}
