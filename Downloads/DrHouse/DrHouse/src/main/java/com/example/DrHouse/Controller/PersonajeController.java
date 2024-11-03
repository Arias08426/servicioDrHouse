package com.example.DrHouse.Controller;

import com.example.DrHouse.Model.Personaje;
import com.example.DrHouse.Service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<Personaje> obtenerPersonajes() {
        return personajeService.obtenerPersonajes();
    }

    @GetMapping("/{id}")
    public Personaje obtenerPersonajePorId(@PathVariable Long id) {
        return personajeService.obtenerPersonajePorId(id);
    }

    @PostMapping
    public Personaje crearPersonaje(@RequestBody Personaje personaje) {
        return personajeService.crearPersonaje(personaje);
    }
}

