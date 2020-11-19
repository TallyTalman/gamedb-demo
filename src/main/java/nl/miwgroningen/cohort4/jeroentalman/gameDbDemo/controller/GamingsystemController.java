package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Gamingsystem;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.GamingsystemRepository;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.ManufacturerRepository;
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
 * Controller voor het object Gamingsystem
 */

@Controller
public class GamingsystemController {

    @Autowired
    GamingsystemRepository gamingsystemRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @GetMapping("/systems")
    protected String showSystems(Model model) {
        model.addAttribute("allSystems", gamingsystemRepository.findAll());
        model.addAttribute("system", new Gamingsystem());
        return "systemOverview";
    }

    @GetMapping("/system/add")
    protected String showSystemForm(Model model) {
        model.addAttribute("system", new Gamingsystem());
        model.addAttribute("allManufacturers", manufacturerRepository.findAll());
        return "systemForm";
    }

    @PostMapping("/system/add")
    protected String saveOrUpdateSystem(@ModelAttribute("system") Gamingsystem system, BindingResult result) {
        if (result.hasErrors()) {
            return "systemOverview";
        }
        gamingsystemRepository.save(system);
        return "redirect:/systems";
    }
}
