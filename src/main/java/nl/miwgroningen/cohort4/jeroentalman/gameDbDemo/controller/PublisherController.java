package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Developer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Publisher;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.PublisherRepository;
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
 * Controller voor het object Publisher
 */

@Controller
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    @GetMapping("/publishers")
    protected String showPublishers(Model model) {
        model.addAttribute("allPublishers", publisherRepository.findAll());
        model.addAttribute("publisher", new Publisher());
        return "publisherOverview";
    }

    @PostMapping("/publisher/add")
    protected String saveOrUpdatePublisher(@ModelAttribute("publisher") Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "publisherOverview";
        }
        publisherRepository.save(publisher);
        return "redirect:/publishers";
    }
}
