package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.GameRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * Controller for the object Game
 */

@Controller
public class GameController {

    @Autowired
    GameRespository gameRespository;

    @GetMapping("/games")
    protected String showGames(Model model) {
        model.addAttribute("allGames", gameRespository.findAll());
        return "gamesOverview";
    }
}
