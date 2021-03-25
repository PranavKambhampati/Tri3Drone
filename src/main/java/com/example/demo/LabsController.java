package com.example.demo;

import Labs.NakulRecursion;
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

    @GetMapping("/NakulRecursion") // root for Nakul page
    public String NakulRecursion(@RequestParam(name = "nValue", required = false, defaultValue = "4") String nString, Model model) {
        int nInteger = Integer.parseInt(nString);
        NakulRecursion recursion = new NakulRecursion(nInteger);

        model.addAttribute("recursionResult", recursion.recursionFactorialResult);
        model.addAttribute("loopResult", recursion.loopFactorialResult);
        model.addAttribute("streamResult", recursion.streamFactorialResult);

        model.addAttribute("recursionTime", recursion.recursionProcessingTime);
        model.addAttribute("loopTime", recursion.loopProcessingTime);
        model.addAttribute("streamTime", recursion.streamProcessingTime);

        model.addAttribute("n", nInteger);

        return "labs/NakulRecursion";
    }
}
