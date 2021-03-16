package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/labs")
public class LabsController {

    @GetMapping("/test") // actual web address will be /labs/michael
    public String labsMichael () {

        return "labs/test";
    }
}
