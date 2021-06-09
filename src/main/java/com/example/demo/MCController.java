package com.example.demo;

import com.example.demo.Forms.CreateMC;
import com.example.demo.mysql.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/labs")
public class MCController {
    @Autowired
    private UserSQL UserRepository;
    @Autowired
    private FormQuestionSQL formQuestionSQL;
    @Autowired
    private FormSQL formSQl;


    @GetMapping("/CreateMC")
    public String CreateMC(@RequestParam(name = "num", required = false, defaultValue = " ") String num,
                           @RequestParam(name = "num2", required = false, defaultValue = " ") String num2,
                           @RequestParam(name = "num3", required = false, defaultValue = " ") String num3,
                           @RequestParam(name = "num4", required = false, defaultValue = " ") String num4,
                           @RequestParam(name = "num5", required = false, defaultValue = " ") String num5,
                           @RequestParam(name = "num6", required = false, defaultValue = " ") String num6,
                           @RequestParam(name = "num7", required = false, defaultValue = " ") String num7,
                           @RequestParam(name = "num8", required = false, defaultValue = " ") String num8,
                           @RequestParam(name = "num9", required = false, defaultValue = " ") String num9,
                           @RequestParam(name = "num10", required = false, defaultValue = " ") String num10,
                           @RequestParam(name = "num11", required = false, defaultValue = " ") String num11,
                           @RequestParam(name = "num12", required = false, defaultValue = " ") String num12,
                           @RequestParam(name = "num13", required = false, defaultValue = " ") String num13,
                           @RequestParam(name = "num14", required = false, defaultValue = " ") String num14,
                           @RequestParam(name = "num15", required = false, defaultValue = " ") String num15,
                           @RequestParam(name = "num16", required = false, defaultValue = " ") String num16,
                           @RequestParam(name = "num17", required = false, defaultValue = " ") String num17,
                           @RequestParam(name = "num18", required = false, defaultValue = " ") String num18,
                           @RequestParam(name = "num19", required = false, defaultValue = " ") String num19,
                           @RequestParam(name = "num20", required = false, defaultValue = " ") String num20,
                           @RequestParam(name = "num21", required = false, defaultValue = " ") String num21,
                           @RequestParam(name = "num22", required = false, defaultValue = " ") String num22,
                           @RequestParam(name = "num23", required = false, defaultValue = " ") String num23,
                           @RequestParam(name = "num24", required = false, defaultValue = " ") String num24,
                           @RequestParam(name = "num25", required = false, defaultValue = " ") String num25,
                           @RequestParam(name = "num26", required = false, defaultValue = " ") String num26,
                           @RequestParam(name = "num27", required = false, defaultValue = " ") String num27,
                           @RequestParam(name = "num28", required = false, defaultValue = " ") String num28,
                           @RequestParam(name = "num29", required = false, defaultValue = " ") String num29,
                           @RequestParam(name = "num30", required = false, defaultValue = " ") String num30,
                           @RequestParam(name = "num31", required = false, defaultValue = " ") String num31,
                           @RequestParam(name = "num32", required = false, defaultValue = " ") String num32,
                           @RequestParam(name = "num33", required = false, defaultValue = " ") String num33,
                           @RequestParam(name = "num34", required = false, defaultValue = " ") String num34,
                           @RequestParam(name = "num35", required = false, defaultValue = " ") String num35,
                           @RequestParam(name = "num36", required = false, defaultValue = " ") String num36,
                           @RequestParam(name = "num37", required = false, defaultValue = " ") String num37,
                           @RequestParam(name = "num38", required = false, defaultValue = " ") String num38,
                           @RequestParam(name = "num39", required = false, defaultValue = " ") String num39,
                           @RequestParam(name = "num40", required = false, defaultValue = " ") String num40,
                           @RequestParam(name = "num41", required = false, defaultValue = " ") String num41,
                           @RequestParam(name = "num42", required = false, defaultValue = " ") String num42,
                           @RequestParam(name = "num43", required = false, defaultValue = " ") String num43,
                           @RequestParam(name = "num44", required = false, defaultValue = " ") String num44,
                           @RequestParam(name = "num45", required = false, defaultValue = " ") String num45,
                           @RequestParam(name = "num46", required = false, defaultValue = " ") String num46,
                           @RequestParam(name = "num47", required = false, defaultValue = " ") String num47,
                           @RequestParam(name = "num48", required = false, defaultValue = " ") String num48,
                           @RequestParam(name = "num49", required = false, defaultValue = " ") String num49,
                           @RequestParam(name = "num50", required = false, defaultValue = " ") String num50,
                           Model model) {
        List<FormQuestion> listOfQuestions = new ArrayList<FormQuestion>();
        Form formObject = new Form();


        CreateMC form = new CreateMC(num, num2, num3, num4, num5,num6,num7,num8,num9,num10,num11,num12,num13,num14
                ,num15,num16,num17,num18,num19,num20,num21,num22,num23,num24,num25,num26,num27,num28,num29,num30,
                num31,num32,num33,num34,num35,num36,num37,num38,num39,num40,num41,num42,num43,num44,num45,num46,num47,
                num48,num49,num50);
        FormQuestion formQuestion1 = new FormQuestion();
        formQuestion1.setForm(formObject);
        formQuestion1.setQuestion(form.question);
        formQuestion1.setOpt_1(form.answerOne);
        formQuestion1.setOpt_2(form.answerTwo);
        formQuestion1.setOpt_3(form.answerThree);
        formQuestion1.setOpt_4(form.answerFour);

        FormQuestion formQuestion2 = new FormQuestion();
        formQuestion2.setForm(formObject);
        formQuestion2.setQuestion(form.question2);
        formQuestion2.setOpt_1(form.answer21);
        formQuestion2.setOpt_2(form.answer22);
        formQuestion2.setOpt_3(form.answer23);
        formQuestion2.setOpt_4(form.answer24);

        FormQuestion formQuestion3 = new FormQuestion();
        formQuestion3.setForm(formObject);
        formQuestion3.setQuestion(form.question3);
        formQuestion3.setOpt_1(form.answer31);
        formQuestion3.setOpt_2(form.answer32);
        formQuestion3.setOpt_3(form.answer33);
        formQuestion3.setOpt_4(form.answer34);

        FormQuestion formQuestion4 = new FormQuestion();
        formQuestion4.setForm(formObject);
        formQuestion4.setQuestion(form.question4);
        formQuestion4.setOpt_1(form.answer41);
        formQuestion4.setOpt_2(form.answer42);
        formQuestion4.setOpt_3(form.answer43);
        formQuestion4.setOpt_4(form.answer44);

        FormQuestion formQuestion5 = new FormQuestion();
        formQuestion5.setForm(formObject);
        formQuestion5.setQuestion(form.question5);
        formQuestion5.setOpt_1(form.answer51);
        formQuestion5.setOpt_2(form.answer52);
        formQuestion5.setOpt_3(form.answer53);
        formQuestion5.setOpt_4(form.answer54);

        FormQuestion formQuestion6 = new FormQuestion();
        formQuestion6.setForm(formObject);
        formQuestion6.setQuestion(form.question6);
        formQuestion6.setOpt_1(form.answer61);
        formQuestion6.setOpt_2(form.answer62);
        formQuestion6.setOpt_3(form.answer63);
        formQuestion6.setOpt_4(form.answer64);


        FormQuestion formQuestion7 = new FormQuestion();
        formQuestion7.setForm(formObject);
        formQuestion7.setQuestion(form.question7);
        formQuestion7.setOpt_1(form.answer71);
        formQuestion7.setOpt_2(form.answer72);
        formQuestion7.setOpt_3(form.answer73);
        formQuestion7.setOpt_4(form.answer74);


        FormQuestion formQuestion8 = new FormQuestion();
        formQuestion8.setForm(formObject);
        formQuestion8.setQuestion(form.question8);
        formQuestion8.setOpt_1(form.answer81);
        formQuestion8.setOpt_2(form.answer82);
        formQuestion8.setOpt_3(form.answer83);
        formQuestion8.setOpt_4(form.answer84);

        FormQuestion formQuestion9 = new FormQuestion();
        formQuestion9.setForm(formObject);
        formQuestion9.setQuestion(form.question9);
        formQuestion9.setOpt_1(form.answer91);
        formQuestion9.setOpt_2(form.answer92);
        formQuestion9.setOpt_3(form.answer93);
        formQuestion9.setOpt_4(form.answer94);

        FormQuestion formQuestion10 = new FormQuestion();
        formQuestion10.setForm(formObject);
        formQuestion10.setQuestion(form.question10);
        formQuestion10.setOpt_1(form.answer101);
        formQuestion10.setOpt_2(form.answer102);
        formQuestion10.setOpt_3(form.answer103);
        formQuestion10.setOpt_4(form.answer104);

        model.addAttribute("question", form.question);
        model.addAttribute("answerChoice1", form.answerOne);
        model.addAttribute("answerChoice2", form.answerTwo);
        model.addAttribute("answerChoice3", form.answerThree);
        model.addAttribute("answerChoice4", form.answerFour);


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

    @GetMapping("/ShowMC")
    public String ShowMC(@RequestParam(name = "num", required = false, defaultValue = " ") String num,
                         @RequestParam(name = "num2", required = false, defaultValue = " ") String num2,
                         @RequestParam(name = "num3", required = false, defaultValue = " ") String num3,
                         @RequestParam(name = "num4", required = false, defaultValue = " ") String num4,
                         @RequestParam(name = "num5", required = false, defaultValue = " ") String num5,
                         @RequestParam(name = "num6", required = false, defaultValue = " ") String num6,
                         @RequestParam(name = "num7", required = false, defaultValue = " ") String num7,
                         @RequestParam(name = "num8", required = false, defaultValue = " ") String num8,
                         @RequestParam(name = "num9", required = false, defaultValue = " ") String num9,
                         @RequestParam(name = "num10", required = false, defaultValue = " ") String num10,
                         @RequestParam(name = "num11", required = false, defaultValue = " ") String num11,
                         @RequestParam(name = "num12", required = false, defaultValue = " ") String num12,
                         @RequestParam(name = "num13", required = false, defaultValue = " ") String num13,
                         @RequestParam(name = "num14", required = false, defaultValue = " ") String num14,
                         @RequestParam(name = "num15", required = false, defaultValue = " ") String num15,
                         @RequestParam(name = "num16", required = false, defaultValue = " ") String num16,
                         @RequestParam(name = "num17", required = false, defaultValue = " ") String num17,
                         @RequestParam(name = "num18", required = false, defaultValue = " ") String num18,
                         @RequestParam(name = "num19", required = false, defaultValue = " ") String num19,
                         @RequestParam(name = "num20", required = false, defaultValue = " ") String num20,
                         @RequestParam(name = "num21", required = false, defaultValue = " ") String num21,
                         @RequestParam(name = "num22", required = false, defaultValue = " ") String num22,
                         @RequestParam(name = "num23", required = false, defaultValue = " ") String num23,
                         @RequestParam(name = "num24", required = false, defaultValue = " ") String num24,
                         @RequestParam(name = "num25", required = false, defaultValue = " ") String num25,
                         @RequestParam(name = "num26", required = false, defaultValue = " ") String num26,
                         @RequestParam(name = "num27", required = false, defaultValue = " ") String num27,
                         @RequestParam(name = "num28", required = false, defaultValue = " ") String num28,
                         @RequestParam(name = "num29", required = false, defaultValue = " ") String num29,
                         @RequestParam(name = "num30", required = false, defaultValue = " ") String num30,
                         @RequestParam(name = "num31", required = false, defaultValue = " ") String num31,
                         @RequestParam(name = "num32", required = false, defaultValue = " ") String num32,
                         @RequestParam(name = "num33", required = false, defaultValue = " ") String num33,
                         @RequestParam(name = "num34", required = false, defaultValue = " ") String num34,
                         @RequestParam(name = "num35", required = false, defaultValue = " ") String num35,
                         @RequestParam(name = "num36", required = false, defaultValue = " ") String num36,
                         @RequestParam(name = "num37", required = false, defaultValue = " ") String num37,
                         @RequestParam(name = "num38", required = false, defaultValue = " ") String num38,
                         @RequestParam(name = "num39", required = false, defaultValue = " ") String num39,
                         @RequestParam(name = "num40", required = false, defaultValue = " ") String num40,
                         @RequestParam(name = "num41", required = false, defaultValue = " ") String num41,
                         @RequestParam(name = "num42", required = false, defaultValue = " ") String num42,
                         @RequestParam(name = "num43", required = false, defaultValue = " ") String num43,
                         @RequestParam(name = "num44", required = false, defaultValue = " ") String num44,
                         @RequestParam(name = "num45", required = false, defaultValue = " ") String num45,
                         @RequestParam(name = "num46", required = false, defaultValue = " ") String num46,
                         @RequestParam(name = "num47", required = false, defaultValue = " ") String num47,
                         @RequestParam(name = "num48", required = false, defaultValue = " ") String num48,
                         @RequestParam(name = "num49", required = false, defaultValue = " ") String num49,
                         @RequestParam(name = "num50", required = false, defaultValue = " ") String num50,
                         Model model) {
        CreateMC form = new CreateMC(num, num2, num3, num4, num5,num6,num7,num8,num9,num10,num11,num12,num13,num14
                ,num15,num16,num17,num18,num19,num20,num21,num22,num23,num24,num25,num26,num27,num28,num29,num30,
                num31,num32,num33,num34,num35,num36,num37,num38,num39,num40,num41,num42,num43,num44,num45,num46,num47,
                num48,num49,num50);

        model.addAttribute("question", form.question);
        model.addAttribute("answerChoice1", form.answerOne);
        model.addAttribute("answerChoice2", form.answerTwo);
        model.addAttribute("answerChoice3", form.answerThree);
        model.addAttribute("answerChoice4", form.answerFour);

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



        model.addAttribute("totalNumber", num);
        return "labs/ShowMCPage";
    }
}



