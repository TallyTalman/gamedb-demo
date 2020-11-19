package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Developer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Manufacturer;
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
 * Controller voor het object Manufacturer
 */

@Controller
public class ManufacturerController {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturers")
    protected String showManufacturers(Model model) {
        model.addAttribute("allManufacturers", manufacturerRepository.findAll());
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturerOverview";
    }

    @PostMapping("/manufacturer/add")
    protected String saveOrUpdateManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer,
                                              BindingResult result) {
        if (result.hasErrors()) {
            return "manufacturerOverview";
        }
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturers";
    }
}