package com.example.DrHouse.Controller;

import com.example.DrHouse.Model.Temporada;
import com.example.DrHouse.Service.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series/{serieId}/temporadas")
public class TemporadaController {
    @Autowired
    private TemporadaService temporadaService;

    @GetMapping
    public List<Temporada> obtenerTemporadasPorSerieId(@PathVariable Long serieId) {
        return temporadaService.obtenerTemporadasPorSerieId(serieId);
    }

    @GetMapping("/{id}")
    public Temporada obtenerTemporadaPorId(@PathVariable Long id) {
        return temporadaService.obtenerTemporadaPorId(id);
    }

    @PostMapping
    public Temporada crearTemporada(@RequestBody Temporada temporada) {
        return temporadaService.crearTemporada(temporada);
    }
}

