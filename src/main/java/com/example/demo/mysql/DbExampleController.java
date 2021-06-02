package com.example.demo.mysql;

import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/db")
@Getter
@Setter
public class DbExampleController {
    @Autowired
    UserRepository session;

    @GetMapping("/createUser")
    public String create(@RequestParam(name = "firstName", required = false) String firstName,
                          @RequestParam(name = "lastName", required = false) String lastName,
                          @RequestParam(name = "username", required = false) String username,
                          @RequestParam(name = "password", required = false) String password,
                          @RequestParam(name = "email", required = false) String email,
                          @RequestParam(name = "role", required = false) String role) {
        User newUser = new User(firstName,
                                lastName,
                                username,
                                password,
                                email,
                                role);
        session.save(newUser); // automatically adds new entry to correct table based on javax.persistence (Hibernate)

        return "db/create";
    }

    @GetMapping("/listAllUsers")
    public String viewAll(Model model) {
        List allData = session.findAll(); // pulls all data elements in the form of a list

        String formattedData = allData.toString();

        model.addAttribute("db_data", formattedData);
        return "db/listAll";
    }
}
