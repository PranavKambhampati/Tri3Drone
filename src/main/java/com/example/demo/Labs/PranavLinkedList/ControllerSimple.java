package com.example.demo.Labs.PranavLinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/labs")
public class ControllerSimple {

    @GetMapping("/PranavLL") //Actual mapping is /labs/PranavLL
    public String PranavLL(@RequestParam(name="array", required=false,  defaultValue="a,a,a,a,a") String num, Model model){
        PranavArrayList al = new PranavArrayList();
        model.addAttribute("answer",al.answer);
        model.addAttribute("time",al.bubblesorttime);
        model.addAttribute("original",al.unsorted);

        return "labs/PranavLLLab";
    }

    /*
    PranavArrayList al = new PranavArrayList();
        model.addAttribute("answer",al.bubbleprintanswer);
        model.addAttribute("time",al.bubblesorttime);
        model.addAttribute("original",al.main);
     */
}
