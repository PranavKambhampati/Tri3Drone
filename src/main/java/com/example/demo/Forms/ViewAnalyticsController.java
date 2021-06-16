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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/analytics")
public class ViewAnalyticsController {
    @Autowired
    private UserSQL userRepository;
    @Autowired
    private FormSQL formRepository;
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

    @GetMapping("/form/{id}/")
    //@GetMapping("/form")
    public String userFormDetailView(@PathVariable("id") int id, Model model) {
    //public String userFormDetailView(@RequestParam(name = "number") String number, Model model) {
        //Form currentForm = allUserForms.get(Integer.parseInt(number));
        Form currentForm = formRepository.get(id);

        List<FormQuestionResponse> allFormResponses = formQuestionResponseRepository.listAll();
        List<FormQuestion> formQuestions = currentForm.getQuestions();

        List<AnalyticCounter> questionCounters = new ArrayList<>();

        boolean newQuestion = true;
        int questionNumber = -1;
        for (FormQuestionResponse response : allFormResponses) {
            for (FormQuestion question : formQuestions) { // cycling through all of the questions in the given form selected
                if (newQuestion){ // creating a counter object for each question
                    questionCounters.add(new AnalyticCounter(question.getQuestion(), question.getOpt_1(), question.getOpt_2(), question.getOpt_3(), question.getOpt_4()));
                    questionNumber++;
                }
                newQuestion = false; // second move boolean switch to avoid creating another counter


                if ((currentForm.getId() == response.getForm().getId()) && (question.getId() == response.getQuestion().getId())) { // checks to see if the given indexed question response is a response to the given form
                    String[] options = {question.getOpt_1(), question.getOpt_2(), question.getOpt_3(), question.getOpt_4()}; // maps out all of the responses in a given question
                    for (int i = 0; i < 4; i++) {
                        if (options[i].equals(response.getResponse())) { // checks to see if the response matches a given from option from the question
                            switch (i) {
                                case 0:
                                    questionCounters.get(questionNumber).incrementOpt1();
                                    break;
                                case 1:
                                    questionCounters.get(questionNumber).incrementOpt2();
                                    break;
                                case 2:
                                    questionCounters.get(questionNumber).incrementOpt3();
                                    break;
                                case 3:
                                    questionCounters.get(questionNumber).incrementOpt4();
                                    break;
                                default:
                                    System.out.println("Fatal error occurred, the database structure has lost its integrity. ");
                            }
                        }
                    }

                    questionCounters.get(questionNumber);
                }
            }
            newQuestion = true;

        }

        model.addAttribute("analyticCounters", questionCounters);
        model.addAttribute("currentForm", currentForm);
        return "forms/analytics/userFormDetail";
    }


}
