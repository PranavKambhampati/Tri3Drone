package com.example.demo.Forms;

import com.example.demo.Forms.CreateMC;
import com.example.demo.Security.PrincipalUserService;
import com.example.demo.mysql.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/create")
public class MCController {
    @Autowired
    private UserSQL UserRepository;
    @Autowired
    private FormQuestionSQL formQuestionSQL;
    @Autowired
    private FormSQL formSQl;

    private PrincipalUserService service;
    private User currentUser;

    private Form currentForm;

    private void innit() {
        this.service = new PrincipalUserService(this.UserRepository);
        this.currentUser = UserRepository.get(service.getUserID());
    }


    @GetMapping("/survey")
    public String CreateMC(@RequestParam(name = "num", required = false, defaultValue = "-0") String num,
                           @RequestParam(name = "num2", required = false, defaultValue = "-0") String num2,
                           @RequestParam(name = "num3", required = false, defaultValue = "-0") String num3,
                           @RequestParam(name = "num4", required = false, defaultValue = "-0") String num4,
                           @RequestParam(name = "num5", required = false, defaultValue = "-0") String num5,
                           @RequestParam(name = "num6", required = false, defaultValue = "-0") String num6,
                           @RequestParam(name = "num7", required = false, defaultValue = "-0") String num7,
                           @RequestParam(name = "num8", required = false, defaultValue = "-0") String num8,
                           @RequestParam(name = "num9", required = false, defaultValue = "-0") String num9,
                           @RequestParam(name = "num10", required = false, defaultValue = "-0") String num10,
                           @RequestParam(name = "num11", required = false, defaultValue = "-0") String num11,
                           @RequestParam(name = "num12", required = false, defaultValue = "-0") String num12,
                           @RequestParam(name = "num13", required = false, defaultValue = "-0") String num13,
                           @RequestParam(name = "num14", required = false, defaultValue = "-0") String num14,
                           @RequestParam(name = "num15", required = false, defaultValue = "-0") String num15,
                           @RequestParam(name = "num16", required = false, defaultValue = "-0") String num16,
                           @RequestParam(name = "num17", required = false, defaultValue = "-0") String num17,
                           @RequestParam(name = "num18", required = false, defaultValue = "-0") String num18,
                           @RequestParam(name = "num19", required = false, defaultValue = "-0") String num19,
                           @RequestParam(name = "num20", required = false, defaultValue = "-0") String num20,
                           @RequestParam(name = "num21", required = false, defaultValue = "-0") String num21,
                           @RequestParam(name = "num22", required = false, defaultValue = "-0") String num22,
                           @RequestParam(name = "num23", required = false, defaultValue = "-0") String num23,
                           @RequestParam(name = "num24", required = false, defaultValue = "-0") String num24,
                           @RequestParam(name = "num25", required = false, defaultValue = "-0") String num25,
                           @RequestParam(name = "num26", required = false, defaultValue = "-0") String num26,
                           @RequestParam(name = "num27", required = false, defaultValue = "-0") String num27,
                           @RequestParam(name = "num28", required = false, defaultValue = "-0") String num28,
                           @RequestParam(name = "num29", required = false, defaultValue = "-0") String num29,
                           @RequestParam(name = "num30", required = false, defaultValue = "-0") String num30,
                           @RequestParam(name = "num31", required = false, defaultValue = "-0") String num31,
                           @RequestParam(name = "num32", required = false, defaultValue = "-0") String num32,
                           @RequestParam(name = "num33", required = false, defaultValue = "-0") String num33,
                           @RequestParam(name = "num34", required = false, defaultValue = "-0") String num34,
                           @RequestParam(name = "num35", required = false, defaultValue = "-0") String num35,
                           @RequestParam(name = "num36", required = false, defaultValue = "-0") String num36,
                           @RequestParam(name = "num37", required = false, defaultValue = "-0") String num37,
                           @RequestParam(name = "num38", required = false, defaultValue = "-0") String num38,
                           @RequestParam(name = "num39", required = false, defaultValue = "-0") String num39,
                           @RequestParam(name = "num40", required = false, defaultValue = "-0") String num40,
                           @RequestParam(name = "num41", required = false, defaultValue = "-0") String num41,
                           @RequestParam(name = "num42", required = false, defaultValue = "-0") String num42,
                           @RequestParam(name = "num43", required = false, defaultValue = "-0") String num43,
                           @RequestParam(name = "num44", required = false, defaultValue = "-0") String num44,
                           @RequestParam(name = "num45", required = false, defaultValue = "-0") String num45,
                           @RequestParam(name = "num46", required = false, defaultValue = "-0") String num46,
                           @RequestParam(name = "num47", required = false, defaultValue = "-0") String num47,
                           @RequestParam(name = "num48", required = false, defaultValue = "-0") String num48,
                           @RequestParam(name = "num49", required = false, defaultValue = "-0") String num49,
                           @RequestParam(name = "num50", required = false, defaultValue = "-0") String num50,
                           Model model) {
        innit();
        List<FormQuestion> listOfQuestions = new ArrayList<>();

        Form formObject = new Form(); // new form entry
        /*FormQuestion formQuestion1 = new FormQuestion();
        FormQuestion formQuestion2 = new FormQuestion();
        FormQuestion formQuestion3 = new FormQuestion();
        FormQuestion formQuestion4 = new FormQuestion();
        FormQuestion formQuestion5 = new FormQuestion();
        FormQuestion formQuestion6 = new FormQuestion();
        FormQuestion formQuestion7 = new FormQuestion();
        FormQuestion formQuestion8 = new FormQuestion();
        FormQuestion formQuestion9 = new FormQuestion();
        FormQuestion formQuestion10 = new FormQuestion();*/


        CreateMC form = new CreateMC(num, num2, num3, num4, num5,num6,num7,num8,num9,num10,num11,num12,num13,num14
                ,num15,num16,num17,num18,num19,num20,num21,num22,num23,num24,num25,num26,num27,num28,num29,num30,
                num31,num32,num33,num34,num35,num36,num37,num38,num39,num40,num41,num42,num43,num44,num45,num46,num47,
                num48,num49,num50);
        if (!(form.question.equals("-0"))) { // validation to determine if the user entered a question
            FormQuestion formQuestion1 = new FormQuestion();
            formQuestion1.setForm(formObject);
            formQuestion1.setQuestion(form.question);
            formQuestion1.setOpt_1(form.answerOne);
            formQuestion1.setOpt_2(form.answerTwo);
            formQuestion1.setOpt_3(form.answerThree);
            formQuestion1.setOpt_4(form.answerFour);
            listOfQuestions.add(formQuestion1);
        }

        if (!(form.question2.equals("-0"))) { // validation to determine if the user entered a question
            FormQuestion formQuestion2 = new FormQuestion();
            formQuestion2.setForm(formObject);
            formQuestion2.setQuestion(form.question2);
            formQuestion2.setOpt_1(form.answer21);
            formQuestion2.setOpt_2(form.answer22);
            formQuestion2.setOpt_3(form.answer23);
            formQuestion2.setOpt_4(form.answer24);
            listOfQuestions.add(formQuestion2);
        }

        if (!(form.question3.equals("-0"))) { // validation to determine if the user entered a question
            FormQuestion formQuestion3 = new FormQuestion();
            formQuestion3.setForm(formObject);
            formQuestion3.setQuestion(form.question3);
            formQuestion3.setOpt_1(form.answer31);
            formQuestion3.setOpt_2(form.answer32);
            formQuestion3.setOpt_3(form.answer33);
            formQuestion3.setOpt_4(form.answer34);
            listOfQuestions.add(formQuestion3);
        }

        if (!(form.question4.equals("-0"))){ // validation to determine if the user entered a question
            FormQuestion formQuestion4 = new FormQuestion();
            formQuestion4.setForm(formObject);
            formQuestion4.setQuestion(form.question4);
            formQuestion4.setOpt_1(form.answer41);
            formQuestion4.setOpt_2(form.answer42);
            formQuestion4.setOpt_3(form.answer43);
            formQuestion4.setOpt_4(form.answer44);
            listOfQuestions.add(formQuestion4);
        }

        if (!(form.question5.equals("-0"))) { // validation to determine if the user entered a question
            FormQuestion formQuestion5 = new FormQuestion();
            formQuestion5.setForm(formObject);
            formQuestion5.setQuestion(form.question5);
            formQuestion5.setOpt_1(form.answer51);
            formQuestion5.setOpt_2(form.answer52);
            formQuestion5.setOpt_3(form.answer53);
            formQuestion5.setOpt_4(form.answer54);
            listOfQuestions.add(formQuestion5);
        }

        if (!(form.question6.equals("-0"))) { // validation to determine if the user entered a question
            FormQuestion formQuestion6 = new FormQuestion();
            formQuestion6.setForm(formObject);
            formQuestion6.setQuestion(form.question6);
            formQuestion6.setOpt_1(form.answer61);
            formQuestion6.setOpt_2(form.answer62);
            formQuestion6.setOpt_3(form.answer63);
            formQuestion6.setOpt_4(form.answer64);
            listOfQuestions.add(formQuestion6);
        }

        if (!(form.question7.equals("-0"))) { // validation to determine if the user entered a question
            FormQuestion formQuestion7 = new FormQuestion();
            formQuestion7.setForm(formObject);
            formQuestion7.setQuestion(form.question7);
            formQuestion7.setOpt_1(form.answer71);
            formQuestion7.setOpt_2(form.answer72);
            formQuestion7.setOpt_3(form.answer73);
            formQuestion7.setOpt_4(form.answer74);
            listOfQuestions.add(formQuestion7);
        }

        if (!(form.question8).equals("-0")) { // validation to determine if the user entered a question
            FormQuestion formQuestion8 = new FormQuestion();
            formQuestion8.setForm(formObject);
            formQuestion8.setQuestion(form.question8);
            formQuestion8.setOpt_1(form.answer81);
            formQuestion8.setOpt_2(form.answer82);
            formQuestion8.setOpt_3(form.answer83);
            formQuestion8.setOpt_4(form.answer84);
            listOfQuestions.add(formQuestion8);
        }

        if (!(form.question9.equals("-0"))) { // validation to determine if the user entered a question
            FormQuestion formQuestion9 = new FormQuestion();
            formQuestion9.setForm(formObject);
            formQuestion9.setQuestion(form.question9);
            formQuestion9.setOpt_1(form.answer91);
            formQuestion9.setOpt_2(form.answer92);
            formQuestion9.setOpt_3(form.answer93);
            formQuestion9.setOpt_4(form.answer94);
            listOfQuestions.add(formQuestion9);
        }

        if (!(form.question10.equals("-0"))) { // validation to determine if the user entered a question
            FormQuestion formQuestion10 = new FormQuestion();
            formQuestion10.setForm(formObject);
            formQuestion10.setQuestion(form.question10);
            formQuestion10.setOpt_1(form.answer101);
            formQuestion10.setOpt_2(form.answer102);
            formQuestion10.setOpt_3(form.answer103);
            formQuestion10.setOpt_4(form.answer104);
            listOfQuestions.add(formQuestion10);
        }

        formObject.setCreator(currentUser); // relationship back to user that is currently logged in
        formObject.setQuestions(listOfQuestions);
        formSQl.save(formObject);

        for (FormQuestion question : listOfQuestions) {
            formQuestionSQL.save(question);
        }



            model.addAttribute("questionDiv1", form.questionDiv1);
            model.addAttribute("question", form.question);
            model.addAttribute("answerChoice1", form.answerOne);
            model.addAttribute("answerChoice2", form.answerTwo);
            model.addAttribute("answerChoice3", form.answerThree);
            model.addAttribute("answerChoice4", form.answerFour);



            model.addAttribute("questionDiv2", form.questionDiv2);
            model.addAttribute("question2", form.question2);
            model.addAttribute("answerChoice21", form.answer21);
            model.addAttribute("answerChoice22", form.answer22);
            model.addAttribute("answerChoice23", form.answer23);
            model.addAttribute("answerChoice24", form.answer24);

        model.addAttribute("question3", form.question3);
        model.addAttribute("answerChoice31", form.answer31);
        model.addAttribute("answerChoice32", form.answer32);
        model.addAttribute("answerChoice33", form.answer33);
        model.addAttribute("answerChoice34", form.answer34);



        model.addAttribute("question4", form.question4);
        model.addAttribute("answerChoice41", form.answer41);
        model.addAttribute("answerChoice42", form.answer42);
        model.addAttribute("answerChoice43", form.answer43);
        model.addAttribute("answerChoice44", form.answer44);



        model.addAttribute("question5", form.question5);
        model.addAttribute("answerChoice51", form.answer51);
        model.addAttribute("answerChoice52", form.answer52);
        model.addAttribute("answerChoice53", form.answer53);
        model.addAttribute("answerChoice54", form.answer54);

        model.addAttribute("question6", form.question6);
        model.addAttribute("answerChoice61", form.answer61);
        model.addAttribute("answerChoice62", form.answer62);
        model.addAttribute("answerChoice63", form.answer63);
        model.addAttribute("answerChoice64", form.answer64);

        model.addAttribute("question7", form.question7);
        model.addAttribute("answerChoice71", form.answer71);
        model.addAttribute("answerChoice72", form.answer72);
        model.addAttribute("answerChoice73", form.answer73);
        model.addAttribute("answerChoice74", form.answer74);

        model.addAttribute("question8", form.question8);
        model.addAttribute("answerChoice81", form.answer81);
        model.addAttribute("answerChoice82", form.answer82);
        model.addAttribute("answerChoice83", form.answer83);
        model.addAttribute("answerChoice84", form.answer84);

        model.addAttribute("question9", form.question9);
        model.addAttribute("answerChoice91", form.answer91);
        model.addAttribute("answerChoice92", form.answer92);
        model.addAttribute("answerChoice93", form.answer93);
        model.addAttribute("answerChoice94", form.answer94);

        model.addAttribute("question10", form.question10);
        model.addAttribute("answerChoice101", form.answer101);
        model.addAttribute("answerChoice102", form.answer102);
        model.addAttribute("answerChoice103", form.answer103);
        model.addAttribute("answerChoice104", form.answer104);


        model.addAttribute("totalNumber", num);
        return "labs/CreateMCPage";

    }

    @GetMapping("/ShowMC/{id}/")
    public String ShowMC(@PathVariable("id") int id, Model model) {
        innit();

        this.currentForm = formSQl.get(id);
        List<FormQuestion> listOfQuestions = currentForm.getQuestions();

        int sizeOfForm = currentForm.getQuestions().size();

        if (sizeOfForm >= 1) {
            model.addAttribute("questionDiv1", "1");
            model.addAttribute("question", listOfQuestions.get(0).getQuestion());
            model.addAttribute("answerChoice1", listOfQuestions.get(0).getOpt_1());
            model.addAttribute("answerChoice2", listOfQuestions.get(0).getOpt_2());
            model.addAttribute("answerChoice3", listOfQuestions.get(0).getOpt_3());
            model.addAttribute("answerChoice4", listOfQuestions.get(0).getOpt_4());
        }

        if (sizeOfForm >= 2) {
            model.addAttribute("questionDiv2", "1");
            model.addAttribute("question2", listOfQuestions.get(1).getQuestion());
            model.addAttribute("answerChoice21", listOfQuestions.get(1).getOpt_1());
            model.addAttribute("answerChoice22", listOfQuestions.get(1).getOpt_2());
            model.addAttribute("answerChoice23", listOfQuestions.get(1).getOpt_3());
            model.addAttribute("answerChoice24", listOfQuestions.get(1).getOpt_4());
        }

        if (sizeOfForm >= 3) {
            model.addAttribute("questionDiv3", "1");
            model.addAttribute("question3", listOfQuestions.get(2).getQuestion());
            model.addAttribute("answerChoice31", listOfQuestions.get(2).getOpt_1());
            model.addAttribute("answerChoice32", listOfQuestions.get(2).getOpt_2());
            model.addAttribute("answerChoice33", listOfQuestions.get(2).getOpt_3());
            model.addAttribute("answerChoice34", listOfQuestions.get(2).getOpt_4());
        }

        if (sizeOfForm >= 4) {
            model.addAttribute("questionDiv4", "1");
            model.addAttribute("question4", listOfQuestions.get(3).getQuestion());
            model.addAttribute("answerChoice41", listOfQuestions.get(3).getOpt_1());
            model.addAttribute("answerChoice42", listOfQuestions.get(3).getOpt_2());
            model.addAttribute("answerChoice43", listOfQuestions.get(3).getOpt_3());
            model.addAttribute("answerChoice44", listOfQuestions.get(3).getOpt_4());
        }

        if (sizeOfForm >= 5) {
            model.addAttribute("questionDiv5", "1");
            model.addAttribute("question5", listOfQuestions.get(4).getQuestion());
            model.addAttribute("answerChoice51", listOfQuestions.get(4).getOpt_1());
            model.addAttribute("answerChoice52", listOfQuestions.get(4).getOpt_2());
            model.addAttribute("answerChoice53", listOfQuestions.get(4).getOpt_3());
            model.addAttribute("answerChoice54", listOfQuestions.get(4).getOpt_4());
        }

        if (sizeOfForm >= 6) {
            model.addAttribute("questionDiv6", "1");
            model.addAttribute("question6", listOfQuestions.get(5).getQuestion());
            model.addAttribute("answerChoice61", listOfQuestions.get(5).getOpt_1());
            model.addAttribute("answerChoice62", listOfQuestions.get(5).getOpt_2());
            model.addAttribute("answerChoice63", listOfQuestions.get(5).getOpt_3());
            model.addAttribute("answerChoice64", listOfQuestions.get(5).getOpt_4());
        }

        if (sizeOfForm >= 7) {
            model.addAttribute("questionDiv7", "1");
            model.addAttribute("question7", listOfQuestions.get(6).getQuestion());
            model.addAttribute("answerChoice71", listOfQuestions.get(6).getOpt_1());
            model.addAttribute("answerChoice72", listOfQuestions.get(6).getOpt_2());
            model.addAttribute("answerChoice73", listOfQuestions.get(6).getOpt_3());
            model.addAttribute("answerChoice74", listOfQuestions.get(6).getOpt_4());
        }

        if (sizeOfForm >= 8) {
            model.addAttribute("questionDiv8", "1");
            model.addAttribute("question8", listOfQuestions.get(7).getQuestion());
            model.addAttribute("answerChoice81", listOfQuestions.get(7).getOpt_1());
            model.addAttribute("answerChoice82", listOfQuestions.get(7).getOpt_2());
            model.addAttribute("answerChoice83", listOfQuestions.get(7).getOpt_3());
            model.addAttribute("answerChoice84", listOfQuestions.get(7).getOpt_4());
        }

        if (sizeOfForm >= 9) {
            model.addAttribute("questionDiv9", "1");
            model.addAttribute("question9", listOfQuestions.get(8).getQuestion());
            model.addAttribute("answerChoice91", listOfQuestions.get(8).getOpt_1());
            model.addAttribute("answerChoice92", listOfQuestions.get(8).getOpt_2());
            model.addAttribute("answerChoice93", listOfQuestions.get(8).getOpt_3());
            model.addAttribute("answerChoice94", listOfQuestions.get(8).getOpt_4());
        }

        if (sizeOfForm >= 10) {
            model.addAttribute("questionDiv10", "1");
            model.addAttribute("question10", listOfQuestions.get(9).getQuestion());
            model.addAttribute("answerChoice101", listOfQuestions.get(9).getOpt_1());
            model.addAttribute("answerChoice102", listOfQuestions.get(9).getOpt_2());
            model.addAttribute("answerChoice103", listOfQuestions.get(9).getOpt_3());
            model.addAttribute("answerChoice104", listOfQuestions.get(9).getOpt_4());
        }

        model.addAttribute("form", currentForm);
        return "labs/ShowMCPage";
    }

    @PostMapping("/ShowMC")
    public String ShowMC(@RequestParam(name = "question1", required = false, defaultValue = "-0") String answer1,
                         @RequestParam(name = "question2", required = false, defaultValue = "-0") String answer2,
                         @RequestParam(name = "question3", required = false, defaultValue = "-0") String answer3,
                         @RequestParam(name = "question4", required = false, defaultValue = "-0") String answer4,
                         @RequestParam(name = "question5", required = false, defaultValue = "-0") String answer5,
                         @RequestParam(name = "question6", required = false, defaultValue = "-0") String answer6,
                         @RequestParam(name = "question7", required = false, defaultValue = "-0") String answer7,
                         @RequestParam(name = "question8", required = false, defaultValue = "-0") String answer8,
                         @RequestParam(name = "question9", required = false, defaultValue = "-0") String answer9,
                         @RequestParam(name = "question10", required = false, defaultValue = "-0") String answer10,
                         @RequestParam(name = "question11", required = false, defaultValue = "-0") String answer11,
                         @RequestParam(name = "question12", required = false, defaultValue = "-0") String answer12,
                         @RequestParam(name = "question13", required = false, defaultValue = "-0") String answer13,
                         @RequestParam(name = "question14", required = false, defaultValue = "-0") String answer14,
                         @RequestParam(name = "question15", required = false, defaultValue = "-0") String answer15,
                         @RequestParam(name = "question16", required = false, defaultValue = "-0") String answer16,
                         @RequestParam(name = "question17", required = false, defaultValue = "-0") String answer17,
                         @RequestParam(name = "question18", required = false, defaultValue = "-0") String answer18,
                         @RequestParam(name = "question19", required = false, defaultValue = "-0") String answer19,
                         @RequestParam(name = "question20", required = false, defaultValue = "-0") String answer20,
                         @RequestParam(name = "question21", required = false, defaultValue = "-0") String answer21,
                         @RequestParam(name = "question22", required = false, defaultValue = "-0") String answer22,
                         @RequestParam(name = "question23", required = false, defaultValue = "-0") String answer23,
                         @RequestParam(name = "question24", required = false, defaultValue = "-0") String answer24,
                         @RequestParam(name = "question25", required = false, defaultValue = "-0") String answer25,
                         @RequestParam(name = "question26", required = false, defaultValue = "-0") String answer26,
                         @RequestParam(name = "question27", required = false, defaultValue = "-0") String answer27,
                         @RequestParam(name = "question28", required = false, defaultValue = "-0") String answer28,
                         @RequestParam(name = "question29", required = false, defaultValue = "-0") String answer29,
                         @RequestParam(name = "question30", required = false, defaultValue = "-0") String answer30,
                         @RequestParam(name = "question31", required = false, defaultValue = "-0") String answer31,
                         @RequestParam(name = "question32", required = false, defaultValue = "-0") String answer32,
                         @RequestParam(name = "question33", required = false, defaultValue = "-0") String answer33,
                         @RequestParam(name = "question34", required = false, defaultValue = "-0") String answer34,
                         @RequestParam(name = "question35", required = false, defaultValue = "-0") String answer35,
                         @RequestParam(name = "question36", required = false, defaultValue = "-0") String answer36,
                         @RequestParam(name = "question37", required = false, defaultValue = "-0") String answer37,
                         @RequestParam(name = "question38", required = false, defaultValue = "-0") String answer38,
                         @RequestParam(name = "question39", required = false, defaultValue = "-0") String answer39,
                         @RequestParam(name = "question40", required = false, defaultValue = "-0") String answer40,
                         Model model) {
        innit();

        List<String> responses = new ArrayList<>();
        responses.add(answer1);
        responses.add(answer2);
        responses.add(answer3);
        responses.add(answer4);
        responses.add(answer5);
        responses.add(answer6);
        responses.add(answer7);
        responses.add(answer8);
        responses.add(answer9);
        responses.add(answer10);
        responses.add(answer12);
        responses.add(answer13);
        responses.add(answer14);
        responses.add(answer15);
        responses.add(answer16);
        responses.add(answer17);
        responses.add(answer18);
        responses.add(answer19);
        responses.add(answer20);
        responses.add(answer21);
        responses.add(answer22);
        responses.add(answer23);
        responses.add(answer24);
        responses.add(answer25);
        responses.add(answer26);
        responses.add(answer27);
        responses.add(answer28);
        responses.add(answer29);
        responses.add(answer30);
        responses.add(answer31);
        responses.add(answer32);
        responses.add(answer33);
        responses.add(answer34);
        responses.add(answer35);
        responses.add(answer36);
        responses.add(answer37);
        responses.add(answer38);
        responses.add(answer39);
        responses.add(answer40);

        List<String> realResponses = new ArrayList<>();

        for (String s : responses) {
            if (s != "-0") {
                realResponses.add(s);
            }
        }

        List<FormQuestion> listOfQuestions = currentForm.getQuestions();

        int counter = 0;
        for (FormQuestion question : listOfQuestions) {
            FormQuestionResponse response = new FormQuestionResponse();
            response.setForm(currentForm);
            response.setQuestion(question);
            response.setUser(currentUser);
            response.setResponse(realResponses.get(counter));
            counter++;
        }

        return "labs/ShowMCPage";
    }
    @GetMapping("/Final")
    public String Final() {
        return "labs/Final";
    }



}



