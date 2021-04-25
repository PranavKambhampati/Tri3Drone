package com.example.demo.Labs.michael;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Controller
public class SortsController {

    @GetMapping("/michaelSorts")
    public String defaultDisplay() {
        return "labs/michaelSorts";
    }
}
