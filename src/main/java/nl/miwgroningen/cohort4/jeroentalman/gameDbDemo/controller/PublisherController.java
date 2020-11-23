package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Developer;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Publisher;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.PublisherRepository;
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

    @GetMapping("/publisher/{publisherName}")
    protected String showPublisherDetails(Model model, @PathVariable("publisherName") String publisherName){
        Optional<Publisher> publisher = publisherRepository.findByName(publisherName);
        if (publisher.isEmpty()) {
            return "redirect:/publishers";
        }
        model.addAttribute("publisher", publisher.get());
        return "publisherDetails";
    }

    @Modifying
    @PostMapping("/publisher/update/{publisherId}")
    public String updatePublisherById(@ModelAttribute("publisher") Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/publishers";
        }
        publisherRepository.save(publisher);
        return "redirect:/publisher/" + publisher.getName();
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
