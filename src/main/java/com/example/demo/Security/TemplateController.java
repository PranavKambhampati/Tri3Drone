package com.example.demo.Security;

import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserSQL;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TemplateController {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserSQL repository;

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @GetMapping("/login")
    public String getLoginView() {
        /* admin user always created if the DB is reset */
        if (repository.listAll().size() == 0) {
            User admin = new User( // clearer way to define objects with lots of data
                    "admin",
                    "user",
                    "nighthawk",
                    "dnhs20-21",
                    "dnhs.cs.a@gmail.com",
                    "USER"
            );

            repository.save(admin);
        }
        return "security/login";
    }

    @GetMapping("/logout")
    public String getLogoutView() {
        return "security/logout";
    }

    @PostMapping("/logout")
    public String getLogoutView(Model model) { return "index"; }

    @GetMapping("/createUser")
    public String createUser(Model model)
    {
        model.addAttribute("newUser", new NewUser());
        model.addAttribute("error", "");
        return "security/createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid NewUser user, BindingResult bindingResult, Model model) throws JsonProcessingException {

        boolean usernameExists = false;

        for (User u : repository.listAll()) {
            if (u.getUsername().equals(user.getUsername())) {
                usernameExists = true;
            }
        }
        if (usernameExists) {
            model.addAttribute("error", "The given username already exists");
            return "security/createUser";
        }

        if (bindingResult.hasErrors()) {
            return "security/createUser";
        }
        /* Setup of new database user */
        User newDBUser = new User();
        newDBUser.setFirstName(user.getFirstName());
        newDBUser.setLastName(user.getLastName());
        newDBUser.setEmail(user.getEmail());
        newDBUser.setUsername(user.getUsername());
        newDBUser.setPassword(user.getPassword());
        newDBUser.setRole("STUDENT");

        repository.save(newDBUser);

        /* Setup of new spring security user */
        UserDetails newSpringUser = org.springframework.security.core.userdetails.User.withUsername(newDBUser.getUsername()).password(encoder.encode(newDBUser.getPassword()))
                .roles(user.getRole()).build();

        inMemoryUserDetailsManager.createUser(newSpringUser);
        return "security/successful";
    }
}
