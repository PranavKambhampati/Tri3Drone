package com.example.demo.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ap-lessons")
public class InterfaceFRQ {

    @GetMapping("/interface-abstraction-FRQ")
    public String InterfaceLesson() {
        return "lessons/michaelInterface";
    }


    @GetMapping("/interface-abstraction-FRQ/answers")
    public String interfaceFRQAnswers() {
        return "lessons/michaelInterface-answers";
    }
}
