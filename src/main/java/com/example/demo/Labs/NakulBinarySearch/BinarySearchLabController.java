package com.example.demo.Labs.NakulBinarySearch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.Instant;


@Controller
@RequestMapping("/labs")
public class BinarySearchLabController {

    @GetMapping("/NakulBinarySearch")
    public String GetNakulBS(Model model){
        BinarySearchLab binarySearchLab = new BinarySearchLab();
        model.addAttribute("binary", binarySearchLab);
        return "labs/NakulBinarySearch";
    }

    @PostMapping("/NakulBinarySearch")
    public String PostNakulBS(@RequestParam(name = "name", required = false, defaultValue = "Alex Lee") String name, Model model){

        BinarySearchLab binarySearchLab = new BinarySearchLab();
        Object value;

        model.addAttribute("binary", binarySearchLab);

        Duration search;
        Instant start;
        Instant end;

        binarySearchLab.arrayListData = binarySearchLab.bubbleSortArrayList(binarySearchLab.arrayListData);
        start = Instant.now();
        value = binarySearchLab.binarySearchArray(binarySearchLab.arrayListData, name);
        end = Instant.now();
        search = Duration.between(start, end);
        binarySearchLab.arrayListSearchTime = search.getNano();
        if (value == null){
            model.addAttribute("resultArray", "Not Present");
        }
        else {
            model.addAttribute("resultArray", "Present");
        }
        model.addAttribute("arrayListSearchTime", binarySearchLab.arrayListSearchTime);

        binarySearchLab.bubbleSortLinkedList();
        binarySearchLab.linkedListData = binarySearchLab.returnList();
        start = Instant.now();
        value = binarySearchLab.binarySearchLinked(binarySearchLab.head, name);
        end = Instant.now();
        search = Duration.between(start, end);
        binarySearchLab.linkedListSearchTime = search.getNano();
        if (value == null){
            model.addAttribute("resultLinked", "Not Present");
        }
        else {
            model.addAttribute("resultLinked", "Present");
        }
        model.addAttribute("linkedListSearchTime", binarySearchLab.linkedListSearchTime);

        return "labs/NakulBinarySearch";
    }
}
