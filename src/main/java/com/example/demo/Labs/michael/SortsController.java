package com.example.demo.Labs.michael;

import com.example.demo.Labs.michael.sortsModel.BubbleSort;
import com.example.demo.Labs.michael.sortsModel.InsertionSort;
import com.example.demo.Labs.michael.sortsModel.SelectionSort;
import com.example.demo.Labs.michael.sortsModel._Sorts;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Controller
public class SortsController {
    List<_Sorts> sortsList;

    public void init(){
        sortsList = new ArrayList<>();

        sortsList.add(new BubbleSort("10,2,6,1,7,5"));
        sortsList.add(new InsertionSort("10,2,6,1,7,5"));
        sortsList.add(new SelectionSort("10,2,6,1,7,5"));
    }

    @GetMapping("/michaelSorts")
    public String defaultDisplay(Model model) {

        init();

        model.addAttribute("sorts", this);
        return "labs/michaelSorts";
    }
}
