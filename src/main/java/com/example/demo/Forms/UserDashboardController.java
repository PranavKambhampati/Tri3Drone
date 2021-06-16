package com.example.demo.Forms;

import com.example.demo.Security.PrincipalUserService;
import com.example.demo.mysql.models.FormQuestionSQL;
import com.example.demo.mysql.models.FormSQL;
import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class UserDashboardController {
    @Autowired
    private UserSQL userRepository;
    @Autowired
    private FormSQL formRepository;
    @Autowired
    private FormQuestionSQL formQuestionRepository;

    private User currentUser;
    private PrincipalUserService service;

    private void innit() {
        this.service = new PrincipalUserService(this.userRepository);
        this.currentUser = userRepository.get(service.getUserID());
    }
    @GetMapping("/home")
    public String home(Model model) {
        innit();

        model.addAttribute("currentUser", currentUser.getFirstName());
        return "forms/interaction/userHome";
    }

}
