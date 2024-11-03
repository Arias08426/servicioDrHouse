package com.example.DrHouse.Controller;

import com.example.DrHouse.Model.Capitulo;
import com.example.DrHouse.Service.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temporadas/{temporadaId}/capitulos")
public class CapituloController {
    @Autowired
    private CapituloService capituloService;

    @GetMapping
    public List<Capitulo> obtenerCapitulosPorTemporadaId(@PathVariable Long temporadaId) {
        return capituloService.obtenerCapitulosPorTemporadaId(temporadaId);
    }

    @GetMapping("/{id}")
    public Capitulo obtenerCapituloPorId(@PathVariable Long id) {
        return capituloService.obtenerCapituloPorId(id);
    }

    @PostMapping
    public Capitulo crearCapitulo(@RequestBody Capitulo capitulo) {
        return capituloService.crearCapitulo(capitulo);
    }
}
