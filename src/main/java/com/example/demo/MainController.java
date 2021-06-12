package com.example.demo;

import com.example.demo.Security.PrincipalUserService;
import com.example.demo.mysql.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserSQL userRepository;

    @Autowired
    private FormSQL formRepository;

    @Autowired
    private FormQuestionSQL formQuestionRepository;

    @GetMapping("/index")
    public String index () {
        PrincipalUserService service = new PrincipalUserService(this.userRepository);

        Long userID = service.getUserID();

        User currentUser = userRepository.get(userID);
        String username = currentUser.getUsername();

        System.out.println("p1-drone CURRENT USER: " + username);

        System.out.println("p1-drone FORM TABLE: " + formRepository.listAll());

        /* Form newForm = new Form();
        FormQuestion question_1 = new FormQuestion();
        question_1.setQuestion("First question?");
        question_1.setOpt_1("A Jan");
        question_1.setOpt_2("B Feb");
        question_1.setOpt_3("C Mar");
        question_1.setOpt_4("D Apr");
        question_1.setForm(newForm);

        FormQuestion question_2 = new FormQuestion();
        question_2.setQuestion("Second question?");
        question_2.setOpt_1("E May");
        question_2.setOpt_2("F June");
        question_2.setOpt_3("G July");
        question_2.setOpt_4("H Aug");
        question_2.setForm(newForm);

        List<FormQuestion> questionList = new ArrayList<>();
        questionList.add(question_1);
        questionList.add(question_2);

        newForm.setQuestions(questionList);
        newForm.setCreator(currentUser);

        formRepository.save(newForm); */

        return "index.html";
    }
}
