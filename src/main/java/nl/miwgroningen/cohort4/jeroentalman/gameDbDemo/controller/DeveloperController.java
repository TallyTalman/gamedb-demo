package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Developer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Game;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
 * Controller voor het object Developer
 */

@Controller
public class DeveloperController {

    @Autowired
    DeveloperRepository developerRepository;

    @GetMapping("/developers")
    protected String showDevelopers(Model model) {
        model.addAttribute("allDevelopers", developerRepository.findAll());
        model.addAttribute("developer", new Developer());
        return "developerOverview";
    }

    @GetMapping("/developer/{developerName}")
    protected String showGameDetails(Model model, @PathVariable("developerName") String developerName){
        Optional<Developer> developer = developerRepository.findByName(developerName);
        if (developer.isEmpty()) {
            return "redirect:/developers";
        }
        model.addAttribute("developer", developer.get());
        return "developerDetails";
    }

    @Modifying
    @PostMapping("/developer/update/{developerId}")
    public String updateDeveloperById(@ModelAttribute("developer") Developer developer, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/developers";
        }
        developerRepository.save(developer);
        return "redirect:/developer/" + developer.getName();
    }

    @PostMapping("/developer/add")
    protected String saveOrUpdateDeveloper(@ModelAttribute("developer") Developer developer, BindingResult result) {
        if (result.hasErrors()) {
            return "developerOverview";
        }
        developerRepository.save(developer);
        return "redirect:/developers";
    }
}
