package com.example.demo;

import com.example.demo.Security.PrincipalUserService;
import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private UserSQL repository;

    @GetMapping("/index")
    public String index () {
        PrincipalUserService service = new PrincipalUserService(this.repository);

        Long userID = service.getUserID();

        String username = repository.get(userID).getUsername();

        System.out.println("p1-drone CURRENT USER: " + username);

        return "index.html";
    }
}
