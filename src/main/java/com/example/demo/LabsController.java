package com.example.demo;

import com.example.demo.Labs.AryanRecursion;
import com.example.demo.Labs.NakulInheritance.Countries;
import com.example.demo.Labs.NakulInheritance.Gems;
import com.example.demo.Labs.NakulInheritance.Student;
import com.example.demo.Labs.NakulRecursion;
import com.example.demo.Labs.NakulSort.Sort;
import com.example.demo.Labs.PranavRecursion.PranavRecursion;
import com.example.demo.Labs.michael.insertSortModel.InsertSortFor;
import com.example.demo.Labs.michael.insertSortModel.InsertSortRecurse;
import com.example.demo.Labs.michael.insertSortModel.InsertSortWhile;
import com.example.demo.Labs.michael.insertSortModel._InsertionSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.Instant;
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

    @GetMapping("/NakulSort")
    public String NakulSortGet(Model model) {

        //initialize data
        Sort sort = new Sort();
        model.addAttribute("sort", sort);
        return "labs/NakulSort"; //HTML render default condition
    }

    @PostMapping("/NakulSort") // root for Nakul page
    public String NakulSort(Model model) {
        Duration intBubbleSort;
        Duration stringBubbleSort;
        Duration objBubbleSort;
        Duration intInsertionSort;
        Duration stringInsertionSort;
        Duration objInsertionSort;
        Duration intSelectionSort;
        Duration stringSelectionSort;
        Duration objSelectionSort;

        int intBubbleSortTime;
        int stringBubbleSortTime;
        int objBubbleSortTime;
        int intInsertionSortTime;
        int stringInsertionSortTime;
        int objInsertionSortTime;
        int intSelectionSortTime;
        int stringSelectionSortTime;
        int objSelectionSortTime;

        Sort sort = new Sort();
        model.addAttribute("sort", sort);

        Instant start = Instant.now();
        sort.intArray = sort.intArrayBubbleSort(sort.intArray);
        Instant end = Instant.now();
        intBubbleSortTime = Duration.between(start, end).getNano();

        start = Instant.now();
        sort.strArray = sort.stringArrayBubbleSort(sort.strArray);
        end = Instant.now();
        stringBubbleSortTime = Duration.between(start, end).getNano();

        start = Instant.now();
        sort.objArray = sort.objArrayBubbleSort(sort.objArray);
        end = Instant.now();
        objBubbleSortTime = Duration.between(start, end).getNano();

        model.addAttribute("intBubbleSortTime", intBubbleSortTime);
        model.addAttribute("objBubbleSortTime", objBubbleSortTime);
        model.addAttribute("stringBubbleSortTime", stringBubbleSortTime);

        start = Instant.now();
        sort.intArray = sort.intArrayInsertionSort(sort.intArray);
        end = Instant.now();
        intInsertionSortTime = Duration.between(start, end).getNano();

        start = Instant.now();
        sort.strArray = sort.stringArrayInsertionSort(sort.strArray);
        end = Instant.now();
        stringInsertionSortTime = Duration.between(start, end).getNano();

        start = Instant.now();
        sort.objArray = sort.objArrayInsertionSort(sort.objArray);
        end = Instant.now();
        objInsertionSortTime = Duration.between(start, end).getNano();

        model.addAttribute("intInsertionSortTime", intInsertionSortTime);
        model.addAttribute("objInsertionSortTime", objInsertionSortTime);
        model.addAttribute("stringInsertionSortTime", stringInsertionSortTime);

        start = Instant.now();
        sort.intArray = sort.intArraySelectionSort(sort.intArray);
        end = Instant.now();
        intSelectionSortTime = Duration.between(start, end).getNano();

        start = Instant.now();
        sort.strArray = sort.stringArraySelectionSort(sort.strArray);
        end = Instant.now();
        stringSelectionSortTime = Duration.between(start, end).getNano();

        start = Instant.now();
        sort.objArray = sort.objArraySelectionSort(sort.objArray);
        end = Instant.now();
        objSelectionSortTime = Duration.between(start, end).getNano();

        model.addAttribute("intSelectionSortTime", intSelectionSortTime);
        model.addAttribute("objSelectionSortTime", objSelectionSortTime);
        model.addAttribute("stringSelectionSortTime", stringSelectionSortTime);

        return "labs/NakulSort";
    }


}
