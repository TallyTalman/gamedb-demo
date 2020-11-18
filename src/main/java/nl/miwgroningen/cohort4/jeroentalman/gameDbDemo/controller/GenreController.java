package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Genre;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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