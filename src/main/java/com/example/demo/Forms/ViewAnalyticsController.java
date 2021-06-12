package com.example.demo.Forms;

import com.example.demo.Security.PrincipalUserService;
import com.example.demo.lessons.inheritance.Principal;
import com.example.demo.mysql.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/analytics")
public class ViewAnalyticsController {
    @Autowired
    private UserSQL userRepository;
    @Autowired
    private FormQuestionResponseSQL formQuestionResponseRepository;
    @Autowired
    private FormQuestionSQL formQuestionRepository;

    private PrincipalUserService service;
    private User currentUser;
    private List<Form> allUserForms;

    public void innit() {
        this.service = new PrincipalUserService(this.userRepository);
        this.currentUser = userRepository.get(service.getUserID());
        this.allUserForms = currentUser.getForms();
    }

    @GetMapping("/myForms")
    public String userFormsDashboard() {
        innit();

        return "userFormDashboard.html";
    }
}
