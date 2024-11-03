package com.example.DrHouse.Service;

import com.example.DrHouse.Model.Personaje;
import com.example.DrHouse.Repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<Personaje> obtenerPersonajes() {
        return personajeRepository.findAll();
    }

    public Personaje obtenerPersonajePorId(Long id) {
        return personajeRepository.findById(id).orElse(null);
    }

    public Personaje crearPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }


}

