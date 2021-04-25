package com.example.demo.Labs.michael;

import com.example.demo.Labs.michael.sortsModel.BubbleSort;
import com.example.demo.Labs.michael.sortsModel.InsertionSort;
import com.example.demo.Labs.michael.sortsModel.SelectionSort;
import com.example.demo.Labs.michael.sortsModel._Sorts;
import com.example.demo.Labs.michael.trackModel.Athlete;
import com.example.demo.Labs.michael.trackModel.BasicData;
import com.example.demo.Labs.michael.trackModel.Distance;
import com.example.demo.Labs.michael.trackModel.Entries;
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
    Entries pojoData;

    private Distance.KeyType distanceKey;


    public void init(){
        /* Integer and String data */
        sortsList = new ArrayList<>();

        sortsList.add(new BubbleSort("10,2,6,1,7,5"));
        sortsList.add(new InsertionSort("10,2,6,1,7,5"));
        sortsList.add(new SelectionSort("10,2,6,1,7,5"));

        sortsList.add(new BubbleSort("g,y,e,w,v,b,a"));
        sortsList.add(new InsertionSort("g,y,e,w,v,b,a"));
        sortsList.add(new SelectionSort("g,y,e,w,v,b,a"));

        /* Java POJO Athlete */
        this.distanceKey = Distance.KeyType.school;
        Distance.key = distanceKey;
        sortsList.add(new BubbleSort(Distance.distanceAthleteData(), _Sorts.DataType.Object));
        sortsList.add(new InsertionSort(Distance.distanceAthleteData(), _Sorts.DataType.Object));
        sortsList.add(new SelectionSort(Distance.distanceAthleteData(), _Sorts.DataType.Object));
    }

    @GetMapping("/michaelSorts")
    public String defaultDisplay(Model model) {

        init();

        model.addAttribute("sorts", this);
        return "labs/michaelSorts";
    }

    public void addPOJO(BasicData[] array) {
        for (BasicData data : array) {
            this.pojoData.addEntry(data);
        }
    }
}
