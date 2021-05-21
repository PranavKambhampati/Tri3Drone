package com.example.demo.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ap-lessons")
public class MethodsFRQ {

    @GetMapping("/MethodsFRQ")
    public String MethodsPrompt() {
        return "lessons/MethodsControlFlow";
    }


    @GetMapping("/MethodsFRQSolutions")
    public String MethodsSolutions() {
        return "lessons/MethodsControlFlowAnswers";
    }
}

