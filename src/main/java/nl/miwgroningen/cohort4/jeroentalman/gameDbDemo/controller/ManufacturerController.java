package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Developer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Manufacturer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Publisher;
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

    @GetMapping("/manufacturer/{manufacturerName}")
    protected String showGameDetails(Model model, @PathVariable("manufacturerName") String manufacturerName){
        Optional<Manufacturer> manufacturer = manufacturerRepository.findByName(manufacturerName);
        if (manufacturer.isEmpty()) {
            return "redirect:/manufacturers";
        }
        model.addAttribute("manufacturer", manufacturer.get());
        return "manufacturerDetails";
    }

    @Modifying
    @PostMapping("/manufacturer/update/{manufacturerId}")
    public String updateManufacturerById(@ModelAttribute("manufacturer") Manufacturer manufacturer,
                                         BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/manufacturers";
        }
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturer/" + manufacturer.getName();
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