package com.example.demo;

import com.example.demo.Labs.AryanLinkedLists.AryanArrayListDelete;
import com.example.demo.Labs.AryanLinkedLists.AryanArrayLists;
import com.example.demo.Labs.AryanLinkedLists.AryanLinkedListRemove;
import com.example.demo.Labs.AryanLinkedLists.AryanLinkedLists;
import com.example.demo.Labs.AryanRecursion;
import com.example.demo.Labs.AryanSorts.AryanSorts;
import com.example.demo.Labs.AryanSorts.AryanSortsObjects;
import com.example.demo.Labs.AryanSorts.AryanSortsStrings;
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

        AryanSorts sortsLab = new AryanSorts(largeArray);;
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

    @GetMapping("/AryanArrayLists")
    public String AryanArrayLists (@RequestParam(name="num", required=false,  defaultValue="Des Moines") String num,
                                    @RequestParam(name="num2", required=false,  defaultValue="USA") String num2,
                                    @RequestParam(name="num3", required=false,  defaultValue="0") String num3,
                                    Model model) {
        int newPopulation = 0;
        if (num3.trim()!="") {
            newPopulation = Integer.parseInt(num3);
        }
        AryanArrayLists arrayLists = new AryanArrayLists(num, num2, newPopulation);
        //model.addAttribute("bubbleSortAnswer", num);
        //model.addAttribute("timeForBubble", num2);
        //model.addAttribute("unsortedArray", num3);
        model.addAttribute("bubbleSortAnswer", arrayLists.BubbleSortObjectPrintedAnswer);
        model.addAttribute("timeForBubble", arrayLists.timeForBubbleSorts);
        model.addAttribute("unsortedArray", arrayLists.InitialBubbleSortObjectPrintedAnswer);

        model.addAttribute("totalArrays", num);
        return "labs/AryanArrayLists";
    }

    @GetMapping("/AryanArrayListsDelete")
    public String AryanArrayListsDelete (@RequestParam(name="num", required=false,  defaultValue="Des Moines") String num,
                                   @RequestParam(name="num2", required=false,  defaultValue="USA") String num2,
                                   @RequestParam(name="num3", required=false,  defaultValue="0") String num3,
                                   Model model) {
        int newPopulation = 0;
        if (num3.trim()!="") {
            newPopulation = Integer.parseInt(num3);
        }
        AryanArrayListDelete arrayLists = new AryanArrayListDelete(num, num2, newPopulation);
        //model.addAttribute("bubbleSortAnswer", num);
        //model.addAttribute("timeForBubble", num2);
        //model.addAttribute("unsortedArray", num3);
        model.addAttribute("bubbleSortAnswer", arrayLists.BubbleSortObjectPrintedAnswer);
        model.addAttribute("timeForBubble", arrayLists.timeForBubbleSorts);
        model.addAttribute("unsortedArray", arrayLists.InitialBubbleSortObjectPrintedAnswer);

        model.addAttribute("totalArrays", num);
        return "labs/AryanArrayListsDelete";
    }

    @GetMapping("/AryanLinkedLists")
    public String AryanLinkedLists (@RequestParam(name="num", required=false,  defaultValue="Des Moines") String num,
                                   @RequestParam(name="num2", required=false,  defaultValue="USA") String num2,
                                   @RequestParam(name="num3", required=false,  defaultValue="0") String num3,
                                   Model model) {
        int newPopulation = 0;
        if (num3.trim()!="") {
            newPopulation = Integer.parseInt(num3);
        }
        AryanLinkedLists LinkedLists = new AryanLinkedLists(num, num2, newPopulation);
        //model.addAttribute("bubbleSortAnswer", num);
        //model.addAttribute("timeForBubble", num2);
        //model.addAttribute("unsortedArray", num3);
        model.addAttribute("bubbleSortAnswer", LinkedLists.BubbleSortObjectPrintedAnswer);
        model.addAttribute("timeForBubble", LinkedLists.timeForBubbleSorts);
        model.addAttribute("unsortedArray", LinkedLists.InitialBubbleSortObjectPrintedAnswer);

        model.addAttribute("totalArrays", num);
        return "labs/AryanLinkedLists";
    }

    @GetMapping("/AryanLinkedListsRemove")
    public String AryanLinkedListsRemove (@RequestParam(name="num", required=false,  defaultValue="Des Moines") String num,
                                          @RequestParam(name="num2", required=false,  defaultValue="USA") String num2,
                                          @RequestParam(name="num3", required=false,  defaultValue="0") String num3,
                                          Model model) {
        int newPopulation = 0;
        if (num3.trim()!="") {
            newPopulation = Integer.parseInt(num3);
        }
        AryanLinkedListRemove LinkedLists = new AryanLinkedListRemove(num, num2, newPopulation);
        //model.addAttribute("bubbleSortAnswer", num);
        //model.addAttribute("timeForBubble", num2);
        //model.addAttribute("unsortedArray", num3);
        model.addAttribute("bubbleSortAnswer", LinkedLists.BubbleSortObjectPrintedAnswer);
        model.addAttribute("timeForBubble", LinkedLists.timeForBubbleSorts);
        model.addAttribute("unsortedArray", LinkedLists.InitialBubbleSortObjectPrintedAnswer);

        model.addAttribute("totalArrays", num);
        return "labs/AryanLinkedListsRemove";
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

    @GetMapping("/AryanSortsObjects")
    public String AryanSortsObjects (@RequestParam(name="array", required=false,  defaultValue="t,t,t,t,t") String num, Model model) {

        AryanSortsObjects ObjectsSortsLab = new AryanSortsObjects(num);
        model.addAttribute("bubbleSortAnswer", ObjectsSortsLab.BubbleSortObjectPrintedAnswer);
        model.addAttribute("selectionSortAnswer", ObjectsSortsLab.SelectionSortPrintedAnswer);
        model.addAttribute("timeForBubble", ObjectsSortsLab.timeForBubbleSorts);
        model.addAttribute("timeForSelection", ObjectsSortsLab.timeForSelectionSorts);
        model.addAttribute("insertionSortAnswer", ObjectsSortsLab.InsertionSortPrintedAnswer);
        model.addAttribute("timeForInsertion", ObjectsSortsLab.timeForInsertionSorts);
        model.addAttribute("fastestSort", ObjectsSortsLab.fastestSort);


        model.addAttribute("totalArrays", num);
        return "labs/AryanSortsObjectsLab";
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
