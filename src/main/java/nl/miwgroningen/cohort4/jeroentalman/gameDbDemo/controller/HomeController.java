package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Game;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * Controller for the object Game
 */

@Controller
public class HomeController {

    @Autowired
    GameRespository gameRespository;

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    GamingsystemRepository gamingsystemRepository;

    @Autowired
    GenreRepository genreRepository;

    @GetMapping({"/", "/home"})
    protected String showHome(Model model) {
        model.addAttribute("allGames", gameRespository.findAll());
        model.addAttribute("game", new Game());
        model.addAttribute("allDevelopers", developerRepository.findAll());
        model.addAttribute("allPublishers", publisherRepository.findAll());
        model.addAttribute("allGenres", genreRepository.findAll());
        model.addAttribute("allSystems", gamingsystemRepository.findAll());
        return "homepage";
    }
}
