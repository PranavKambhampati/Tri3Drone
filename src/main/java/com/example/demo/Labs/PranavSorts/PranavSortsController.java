package com.example.demo.Labs.PranavSorts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/labs")
public class PranavSortsController {

    @GetMapping("/PranavIntSorts")
    public String PranavSorts (@RequestParam(name="array", required=false,  defaultValue="1,1,1,1,1") String num, Model model) {

        PranavSorts sorts = new PranavSorts(num);
        model.addAttribute("bubbleSortAnswer", sorts.bubbleprintanswer);
        model.addAttribute("selectionSortAnswer", sorts.selectprintanswer);
        model.addAttribute("insertionSortAnswer",sorts.insertprintanswer);
        model.addAttribute("timeForBubble", sorts.bubblesorttime);
        model.addAttribute("timeForSelection", sorts.selectsorttime);
        model.addAttribute("timeForInsertion", sorts.insertsorttime);
        model.addAttribute("fastestsort",sorts.fastestsortalgo);
        model.addAttribute("totalArrays", num);
        return "labs/PranavSortsLab";
    }

    @GetMapping("/PranavStringSorts")
    public String PranavStringSorts (@RequestParam(name="array", required=false,  defaultValue="a,a,a,a,a") String num, Model model){
        PranavStringSorts stringsort = new PranavStringSorts(num);
        model.addAttribute("bubbleSortAnswer", stringsort.bubbleprintanswer);
        model.addAttribute("selectionSortAnswer", stringsort.selectprintanswer);
        model.addAttribute("insertionSortAnswer",stringsort.insertprintanswer);
        model.addAttribute("timeForBubble", stringsort.bubblesorttime);
        model.addAttribute("timeForSelection", stringsort.selectsorttime);
        model.addAttribute("timeForInsertion", stringsort.insertsorttime);
        model.addAttribute("fastestsort",stringsort.fastestsortalgo);
        model.addAttribute("totalArrays", num);
        return "labs/PranavStringSorts";
    }

    @GetMapping("/PranavObjectSorts")
    public String PranavObjectSorts (@RequestParam(name="array", required=false,  defaultValue="a,a,a,a,a") String num, Model model){
        PranavObjectsSort objsort = new PranavObjectsSort(num);
        model.addAttribute("bubbleSortAnswer", objsort.bubbleprintanswer);
        model.addAttribute("selectionSortAnswer", objsort.selectprintanswer);
        model.addAttribute("insertionSortAnswer",objsort.insertprintanswer);
        model.addAttribute("timeForBubble", objsort.bubblesorttime);
        model.addAttribute("timeForSelection", objsort.selectsorttime);
        model.addAttribute("timeForInsertion", objsort.insertsorttime);
        model.addAttribute("fastestsort",objsort.fastestsortalgo);
        model.addAttribute("originalarray",objsort.main);
        model.addAttribute("totalArrays", num);

        return "labs/PranavObjectSorts";
    }


}
