package com.example.demo.Labs.NakulLinkedList;

import com.example.demo.Labs.NakulInheritance.Student;
import com.example.demo.Labs.NakulSort.Sort;
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
public class LinkedListLabController {

    @GetMapping("/NakulLinkedList")
    public String GetNakulLL(Model model){
        LinkedListLab linkedListLab = new LinkedListLab();
        model.addAttribute("object", linkedListLab);
        return "labs/NakulLinkedList";
    }

    @PostMapping("/NakulLinkedList")
    public String PostNakulLL(Model model){
        LinkedListLab linkedListLab = new LinkedListLab();
        model.addAttribute("object", linkedListLab);

        Duration sort;
        Instant start;
        Instant end;

        linkedListLab.arrayListData.add(new Student("Sabrina Carmack", 18, "Senior"));
        linkedListLab.linkedListData.add(new Student("Sabrina Carmack", 18, "Senior"));
        linkedListLab.addNode(new Student("Sabrina Carmack", 18, "Senior"));

        linkedListLab.arrayListData.remove(3);
        linkedListLab.linkedListData.remove(3);
        linkedListLab.deleteNode(3);

        start = Instant.now();
        linkedListLab.arrayListData = linkedListLab.bubbleSortArrayList(linkedListLab.arrayListData);
        end = Instant.now();
        sort = Duration.between(start, end);
        linkedListLab.arrayListSortTime = sort.getNano();

        model.addAttribute("arrayListSortTime", linkedListLab.arrayListSortTime);

        start = Instant.now();
        linkedListLab.bubbleSortLinkedList();
        end = Instant.now();
        sort = Duration.between(start, end);
        linkedListLab.linkedListSortTime = sort.getNano();
        linkedListLab.linkedListData = linkedListLab.returnList();

        model.addAttribute("linkedListSortTime", linkedListLab.linkedListSortTime);

        return "labs/NakulLinkedList";
    }
}
