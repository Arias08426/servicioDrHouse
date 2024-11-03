package com.example.DrHouse.Controller;

import com.example.DrHouse.Model.Capitulo;
import com.example.DrHouse.Model.Serie;
import com.example.DrHouse.Model.Personaje;
import com.example.DrHouse.Model.Temporada;
import com.example.DrHouse.Service.CapituloService;
import com.example.DrHouse.Service.SerieService;
import com.example.DrHouse.Service.PersonajeService;
import com.example.DrHouse.Service.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class PaginaController {

    @Autowired
    private SerieService serieService;

    @Autowired
    private PersonajeService personajeService;
    @Autowired
    private TemporadaService temporadaService;
    @Autowired
    private CapituloService capituloService;

    @GetMapping("/temporada/{temporadaId}/capitulos")
    public String mostrarCapitulosPorTemporada(@PathVariable Long temporadaId, Model model) {
        List<Capitulo> capitulos = capituloService.obtenerCapitulosPorTemporadaId(temporadaId);
        model.addAttribute("capitulos", capitulos);
        model.addAttribute("temporada", temporadaId); // Pasamos la temporada actual a la vista
        return "capitulo"; // nombre del archivo HTML que muestra los capítulos
    }


    @GetMapping("/pagina")
    public String mostrarPaginaPrincipal(Model model) {
        List<Serie> series = serieService.obtenerSeries();
        model.addAttribute("series", series); // Atributo para la lista de series en la página principal
        return "index"; // Carga el archivo index.html desde templates/
    }

    @GetMapping("/seriedetalles/{id}")
    public String mostrarDetallesSerie(@PathVariable("id") Long id, Model model) {
        Optional<Serie> serie = Optional.ofNullable(serieService.obtenerSeriePorId(id)); // Método en SerieService para obtener una serie por su ID

        if (serie.isPresent()) {
            model.addAttribute("serie", serie.get());
            return "seriedetalles"; // Carga el archivo seriedetalles.html desde templates/
        } else {
            return "redirect:/pagina"; // Redirige a la página principal si no se encuentra la serie
        }
    }

    @GetMapping("/temporada/{id}")
    public String mostrarTemporada(@PathVariable("id") Long id, Model model) {
        Optional<Temporada> temporada = Optional.ofNullable(temporadaService.obtenerTemporadaPorId(id)); // Método en TemporadaService para obtener una temporada por su ID

        if (temporada.isPresent()) {
            model.addAttribute("temporada", temporada.get());
            model.addAttribute("capitulos", temporada.get().getCapitulos()); // Atributo para la lista de capítulos de la temporada
            return "temporada"; // Carga el archivo temporada.html desde templates/
        } else {
            return "redirect:/pagina"; // Redirige a la página principal si no se encuentra la temporada
        }
    }

    @GetMapping("/personajes")
    public String mostrarPersonajes(Model model) {
        List<Personaje> personajes = personajeService.obtenerPersonajes(); // Método en PersonajeService para obtener todos los personajes
        model.addAttribute("personajes", personajes); // Atributo para la lista de personajes
        return "personaje"; // Carga el archivo personaje.html desde templates/
    }
}

