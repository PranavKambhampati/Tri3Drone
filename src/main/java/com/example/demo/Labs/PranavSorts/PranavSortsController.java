package com.example.demo.Labs.PranavSorts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/labs")
public class PranavSortsController {

    @GetMapping("/PranavSorts")
    public String PranavSorts (@RequestParam(name="array", required=false,  defaultValue="1,1,1,1,1") String num, Model model) {

        PranavSorts sorts = new PranavSorts(num);
        model.addAttribute("bubbleSortAnswer", sorts.bubbleprintanswer);
        model.addAttribute("selectionSortAnswer", sorts.selectprintanswer);
        model.addAttribute("insertionSortAnswer",sorts.insertprintanswer);
        model.addAttribute("timeForBubble", sorts.bubblesorttime);
        model.addAttribute("timeForSelection", sorts.selectsorttime);
        model.addAttribute("timeForInsertion", sorts.insertsorttime);
        model.addAttribute("totalArrays", num);
        return "labs/PranavSortsLab";
    }


}
