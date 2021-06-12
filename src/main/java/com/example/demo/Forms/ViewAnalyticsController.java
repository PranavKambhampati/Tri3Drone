package com.example.demo.Forms;

import com.example.demo.Security.PrincipalUserService;
import com.example.demo.lessons.inheritance.Principal;
import com.example.demo.mysql.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    /* Stay the same between all of the roots in this controller */
    private PrincipalUserService service;
    private User currentUser;
    private List<Form> allUserForms;

    public void innit() {
        this.service = new PrincipalUserService(this.userRepository);
        this.currentUser = userRepository.get(service.getUserID());
        this.allUserForms = currentUser.getForms();
    }

    @GetMapping("/myForms")
    public String userFormsDashboard(Model model) {
        innit();

        model.addAttribute("userFormList", allUserForms);
        return "forms/analytics/userFormDashboard";
    }

    //@GetMapping("/form/{id}")
    @GetMapping("/form")
    //public String userFormDetailView(@PathVariable("id") int id, Model model) {
    public String userFormDetailView(@RequestParam(name = "number") String number, Model model) {
        Form currentForm = allUserForms.get(Integer.parseInt(number));

        model.addAttribute("currentForm", currentForm);
        return "forms/analytics/userFormDetail";
    }


}
