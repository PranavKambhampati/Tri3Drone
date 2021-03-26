package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/labs")
public class LabsController {

    @GetMapping("/test") // actual web address will be /labs/michael
    public String labsMichael () {

        return "labs/test";
    }

    @GetMapping("/AryanRecursion")
    public String AryanRecursion (@RequestParam(name="num", required=false,  defaultValue="10") String num, Model model) {
        int nth = Integer.parseInt(num);

        return "/AryanRecursion";
    }

}
