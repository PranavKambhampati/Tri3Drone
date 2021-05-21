package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ap-lessons")
public class APLessons {

    @GetMapping("/lessons") // actual web address will be /ap-lessons/lessons;
    public String PranavLesson () {
        return "labs/APpresentations";
    }

}
