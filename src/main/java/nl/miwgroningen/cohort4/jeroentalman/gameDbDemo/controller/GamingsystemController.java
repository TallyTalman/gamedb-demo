package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Game;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Gamingsystem;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Manufacturer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.GamingsystemRepository;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.ManufacturerRepository;
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
        model.addAttribute("allManufacturers", manufacturerRepository.findAll());
        return "systemOverview";
    }

    @GetMapping("/system/{systemName}")
    protected String showSystemDetails(Model model, @PathVariable("systemName") String systemName){
        Optional<Gamingsystem> gamingsystem = gamingsystemRepository.findByName(systemName);
        if (gamingsystem.isEmpty()) {
            return "redirect:/systems";
        }
        model.addAttribute("gamingsystem", gamingsystem.get());
        model.addAttribute("allManufacturers", manufacturerRepository.findAll());
        return "systemDetails";
    }

    @Modifying
    @PostMapping("/system/update/{systemId}")
    public String updateSystemById(@ModelAttribute("system") Gamingsystem gamingsystem, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/systems";
        }
        gamingsystemRepository.save(gamingsystem);
        return "redirect:/system/" + gamingsystem.getName();
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
