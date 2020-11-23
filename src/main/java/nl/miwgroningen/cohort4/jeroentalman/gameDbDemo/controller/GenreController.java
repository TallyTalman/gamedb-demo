package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Developer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Gamingsystem;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Genre;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * Controller voor het object Genre
 */

@Controller
public class GenreController {

    @Autowired
    GenreRepository genreRepository;

    @GetMapping("/genres")
    protected String showGenres(Model model) {
        model.addAttribute("allGenres", genreRepository.findAll());
        model.addAttribute("genre", new Genre());
        return "genreOverview";
    }

    @PostMapping("/genre/add")
    protected String saveOrUpdateGenre(@ModelAttribute("genre") Genre genre, BindingResult result) {
        if (result.hasErrors()) {
            return "genreOverview";
        }
        genreRepository.save(genre);
        return "redirect:/genres";
    }
}