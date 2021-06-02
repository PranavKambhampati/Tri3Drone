package com.example.demo.mysql;

import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/db")
@Getter
@Setter
public class DbExampleController {
    UserRepository session;

    public String create (@RequestParam(name = "firstName") String firstName,
                          @RequestParam(name = "lastName") String lastName,
                          @RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password,
                          @RequestParam(name = "email") String email,
                          @RequestParam(name = "role") String role) {
        User newUser = new User(firstName,
                                lastName,
                                username,
                                password,
                                email,
                                role);
        session.save(newUser);

        return "db/create";
    }
}
