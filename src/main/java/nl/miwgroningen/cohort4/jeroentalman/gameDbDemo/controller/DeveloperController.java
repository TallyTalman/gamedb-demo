package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Developer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.DeveloperRepository;
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
 * Controller voor het object Developer
 */

@Controller
public class DeveloperController {

    @Autowired
    DeveloperRepository developerRepository;

    @GetMapping("/developers")
    protected String showDevelopers(Model model) {
        model.addAttribute("allDevelopers", developerRepository.findAll());
        return "developerOverview";
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
