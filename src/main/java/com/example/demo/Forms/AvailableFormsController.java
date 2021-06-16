package com.example.demo.Forms;

import com.example.demo.Security.PrincipalUserService;
import com.example.demo.mysql.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/takeAForm")
public class AvailableFormsController {
    @Autowired
    private UserSQL userRepository;
    @Autowired
    private FormSQL formRepository;
    @Autowired
    private FormQuestionSQL formQuestionRepository;

    private User currentUser;
    private PrincipalUserService service;

    private List<Form> everyForm;

    private void innit() {
        this.service = new PrincipalUserService(this.userRepository);
        this.currentUser = userRepository.get(service.getUserID());
        everyForm = formRepository.listAll();
    }

    @GetMapping("/allForms")
    public String allAvailableForms(Model model) {
        innit();

        model.addAttribute("allCreatedFormsList", everyForm);
        return "forms/interaction/userAvailableFormsDashboard";
    }

    @GetMapping("/survey/{id}")
    public String takeASurvey(@PathVariable("id") int id, Model model) {
        Form formAccessed = formRepository.get(id);

        

        return "forms/interaction/takeASurvey";
    }
}
