package com.example.demo.Security;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class TemplateController {
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/login")
    public String getLoginView() {
        return "security/login";
    }

    @GetMapping("/logout")
    public String getLogoutView() {
        return "security/logout";
    }

    @GetMapping("/createUser")
    public String createUser(Model model)
    {
        model.addAttribute("newUser", new NewUser());
        return "security/createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid NewUser user, BindingResult bindingResult) throws JsonProcessingException {

        if (bindingResult.hasErrors()) {
            return "security/createUser";
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return "security/successful";
    }
}
