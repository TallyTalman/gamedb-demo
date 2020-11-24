package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.controller;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.DatabaseUser;
import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.DatabaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 */

@Controller
public class DatabaseUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    DatabaseUserRepository databaseUserRepository;

    @GetMapping("/user/new")
    @Secured("ROLE_ADMIN")
    protected String showNewUserForm(Model model) {
        model.addAttribute("user", new DatabaseUser());
        return "userForm";
    }

    @PostMapping("/user/new")
    @Secured("ROLE_ADMIN")
    protected String saveOrUpdateUser(@ModelAttribute("user") DatabaseUser user, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            databaseUserRepository.save(user);
            return "redirect:/";
        }
    }
}