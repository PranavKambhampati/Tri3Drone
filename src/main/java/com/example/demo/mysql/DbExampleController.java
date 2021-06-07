package com.example.demo.mysql;

import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserRepository;
import com.example.demo.mysql.models.UserSQL;
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
    private UserSQL session;

    @GetMapping("/createUser")
    public String create(@RequestParam(name = "firstName", required = false, defaultValue = "-1") String firstName,
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
        if (!firstName.equals("-1")) { // catch to avoid null entries of Users
            session.save(newUser); // automatically adds new entry to correct table based on javax.persistence (Hibernate)

        }

        return "db/create";
    }

    @GetMapping("/listAllUsers")
    public String viewAll(Model model) {
        List allData = session.listAll(); // pulls all data elements in the form of a List

        String formattedData = allData.toString();

        model.addAttribute("db_data", formattedData);
        return "db/listAll";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam(name = "id", defaultValue = "-1") Long id) {
        if (session.listAll().size() >= id && id > 0) { // logic to prevent invalid id
            session.delete(id); // searches and finds entry of given id and deletes it? (not working currently)

        }
        return "db/delete";
    }

}
