package com.example.demo;

import com.example.demo.Labs.AryanRecursion;
import com.example.demo.Labs.AryanSorts.AryanSorts;
import com.example.demo.Labs.AryanSorts.AryanSortsStrings;
import com.example.demo.Labs.NakulRecursion;
import com.example.demo.Labs.PranavRecursion.PranavRecursion;
import com.example.demo.Labs.michael.insertSortModel.InsertSortFor;
import com.example.demo.Labs.michael.insertSortModel.InsertSortRecurse;
import com.example.demo.Labs.michael.insertSortModel.InsertSortWhile;
import com.example.demo.Labs.michael.insertSortModel._InsertionSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/AryanRecursion") // web address will be /labs/AryanRecursion
    public String AryanRecursion (@RequestParam(name="num", required=false,  defaultValue="1") String num, Model model) {
        int nth = Integer.parseInt(num);
        AryanRecursion recursionLab = new AryanRecursion(nth); // creates object of class AryanRecursion

        // adding the components of the control into the model, to be used in the view later
        model.addAttribute("recursionAnswer", recursionLab.answerRecursionFactorial);
        model.addAttribute("ForLoopAnswer", recursionLab.answerForLoop);
        model.addAttribute("StreamsAnswer", recursionLab.answerForStream);
        model.addAttribute("timeForRecursion", recursionLab.timeRecursionFactorial);
        model.addAttribute("timeForLoops", recursionLab.timeForLoop);
        model.addAttribute("timeForStreams", recursionLab.timeForStream);

        model.addAttribute("totalNumber", nth);
        return "labs/AryanRecursionLab";
    }

    @GetMapping("/404")
    public String AryanRecursion404 () {
        return "labs/AryanRecursionLab404";
    }

    @GetMapping("/PranavRecursion")
    public String PranavRecursion(@RequestParam(name="number", required = false, defaultValue="1") String number, Model model){
        int numbertocalc = Integer.parseInt(number);
        PranavRecursion pranav = new PranavRecursion(numbertocalc);

        model.addAttribute("recursionanswer", pranav.recanswer);
        model.addAttribute("forloopanswer", pranav.foranswer);
        model.addAttribute("streamsanswer", pranav.streamanswer);
        model.addAttribute("recursiontime", pranav.rectime);
        model.addAttribute("forlooptime", pranav.fortime);
        model.addAttribute("streamtime", pranav.streamtime);

        model.addAttribute("total",number);

        System.out.println(number);

        return "labs/PranavRecursionLab";
    }

    @GetMapping("/MichaelRecursion") // actual web address will be /labs/michael
    public String MichaelRecursion (@RequestParam(name = "unsortedArray", required = false, defaultValue = "3,2,3,4") String unsortedArrayLiteral, Model model) {

        List<_InsertionSort> insertSortApproachList = new ArrayList<_InsertionSort>();

        insertSortApproachList.add(new InsertSortFor(unsortedArrayLiteral));
        insertSortApproachList.add(new InsertSortWhile(unsortedArrayLiteral));
        insertSortApproachList.add(new InsertSortRecurse(unsortedArrayLiteral));

        model.addAttribute("insertSortList", insertSortApproachList);

        return "labs/michaelRecursion";
    }

    @GetMapping("/AryanSortsIntegers")
    public String AryanSorts (@RequestParam(name="array", required=false,  defaultValue="1,1,1,1,1") String num, Model model) {
        /*
        int[] largeArray = new int[5];
        if (num.trim() == "") {
            num = "1,1,1,1,1";
        }
        String [] arrayToSort = num.split(",");
        for (int i = 0; i < arrayToSort.length; i++) {
            largeArray[i]=Integer.parseInt(arrayToSort[i]);
        }

        AryanSorts sortsLab = new AryanSorts(largeArray);
         */
        AryanSorts sortsLab = new AryanSorts(num);
        model.addAttribute("bubbleSortAnswer", sortsLab.BubbleSortPrintedAnswer);
        model.addAttribute("selectionSortAnswer", sortsLab.SelectionSortPrintedAnswer);
        model.addAttribute("timeForBubble", sortsLab.timeForBubbleSorts);
        model.addAttribute("timeForSelection", sortsLab.timeForSelectionSorts);
        model.addAttribute("insertionSortAnswer", sortsLab.InsertionSortPrintedAnswer);
        model.addAttribute("timeForInsertion", sortsLab.timeForInsertionSorts);
        model.addAttribute("fastestSort", sortsLab.fastestSort);


        model.addAttribute("totalArrays", num);
        return "labs/AryanSortsLab";
    }

    @GetMapping("/AryanSortsStrings")
    public String AryanSortsStrings (@RequestParam(name="array", required=false,  defaultValue="t,t,t,t,t") String num, Model model) {

        AryanSortsStrings StringsSortsLab = new AryanSortsStrings(num);
        model.addAttribute("bubbleSortAnswer", StringsSortsLab.BubbleSortPrintedAnswer);
        model.addAttribute("selectionSortAnswer", StringsSortsLab.SelectionSortPrintedAnswer);
        model.addAttribute("timeForBubble", StringsSortsLab.timeForBubbleSorts);
        model.addAttribute("timeForSelection", StringsSortsLab.timeForSelectionSorts);
        model.addAttribute("insertionSortAnswer", StringsSortsLab.InsertionSortPrintedAnswer);
        model.addAttribute("timeForInsertion", StringsSortsLab.timeForInsertionSorts);
        model.addAttribute("fastestSort", StringsSortsLab.fastestSort);


        model.addAttribute("totalArrays", num);
        return "labs/AryanSortsLabStrings";
    }


}
