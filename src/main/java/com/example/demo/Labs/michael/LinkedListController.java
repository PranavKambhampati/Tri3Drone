package com.example.demo.Labs.michael;

import com.example.demo.Labs.michael.linkedListsModel.MikeArrayList;
import com.example.demo.Labs.michael.linkedListsModel.MikeLinkedList;
import com.example.demo.Labs.michael.trackModel.Distance;
import com.example.demo.Labs.michael.trackModel.extras.AthleteNames;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
public class LinkedListController {
    List<Distance> arrayListData = new ArrayList<>();
    List<Distance> arrayListDataSorted = new ArrayList<>();
    MikeLinkedList linkedListData = new MikeLinkedList();
    MikeLinkedList linkedListDataSorted = new MikeLinkedList();

    /* Time analysis */
    Duration sortTimeLL;
    Duration sortTimeAL;

    @GetMapping("/michaelLinkedList")
    public String defaultDisplay(Model model) {

        this.generateData();

        model.addAttribute("listData", this);

        return "labs/michaelLinkedList";
    }

    @PostMapping("/michaelLinkedList")
    public String userInsert(@RequestParam(name = "insertIndex", defaultValue = "-1") int indexInsert, @RequestParam(name = "deleteIndex", defaultValue = "-1") int indexDelete, Model model) {
        if (indexInsert != -1) {
            this.linkedListData.insertAt(indexInsert, new Distance(99, "Scotty McLinkedListInsert", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (330 - 285)) + 285), String.valueOf((Math.random() * (165 - 145)) + 165), "1600 meters"));
            this.arrayListData.set(indexInsert, new Distance(99, "Scotty McListInsert", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (330 - 285)) + 285), String.valueOf((Math.random() * (165 - 145)) + 165), "1600 meters"));

        }
        if (indexDelete != -1) {
            this.linkedListData.deleteAt(indexDelete);
            this.arrayListData.remove(indexDelete);
        }

        Instant alStart = Instant.now();
        this.arrayListSelectionSort();
        Instant alEnd = Instant.now();
        sortTimeAL = Duration.between(alStart, alEnd);

        Instant llStart = Instant.now();
        this.linkedListDataSorted = this.linkedListData;
        this.arrayListSelectionSort();
        Instant llEnd = Instant.now();
        sortTimeLL = Duration.between(llStart, llEnd);

        model.addAttribute("listData", this);
        return "labs/michaelLinkedList";
    }

    public void generateData() {
        AthleteNames males = new AthleteNames();

        for (int i = 0; i < 24; i++) {
            String school;
            if (i % 2 == 0 ) {
                school = "Del Norte";
            } else {
                school = "Rancho Bernardo";
            }
            // maleNames.getData().get(i)
            if (i < 8) {
                int randomGrade = (int) ((Math.random() * (12 - 9)) + 9);
                String randomSeedTime = String.valueOf((Math.random() * (150 - 115)) + 115);
                String randomSplit = String.valueOf((Math.random() * (70 - 60)) + 60);
                arrayListData.add(new Distance(i, males.names.get(i), randomGrade, "male", school, randomSeedTime, randomSplit, "800 meters"));
                linkedListData.insert(new Distance(i, males.names.get(i), randomGrade, "male", school, randomSeedTime, randomSplit, "800 meters"));

            } else if (i < 16){
                int randomGrade = (int) ((Math.random() * (12 - 9)) + 9);
                String randomSeedTime = String.valueOf((Math.random() * (330 - 285)) + 285);
                String randomSplit = String.valueOf((Math.random() * (165 - 145)) + 165);
                arrayListData.add(new Distance(i, males.names.get(i), randomGrade, "male", school, randomSeedTime, randomSplit, "1600 meters"));
                linkedListData.insert(new Distance(i, males.names.get(i), randomGrade, "male", school, randomSeedTime, randomSplit, "1600 meters"));

            } else {
                int randomGrade = (int) ((Math.random() * (12 - 9)) + 9);
                String randomSeedTime = String.valueOf((Math.random() * (750 - 615)) + 615);
                String randomSplit = String.valueOf((Math.random() * (360 - 300) + 300));
                arrayListData.add(new Distance(i, males.names.get(i), randomGrade, "male", school, randomSeedTime, randomSplit, "3200 meters"));
                linkedListData.insert(new Distance(i, males.names.get(i), randomGrade, "male", school, randomSeedTime, randomSplit, "3200 meters"));

            }
        }
    }

    public void arrayListSelectionSort() {
        this.arrayListDataSorted = this.arrayListData;
        for (int i = 0; i < arrayListDataSorted.size(); i++) {

            int firstIndex = i;
            for (int j = i + 1; j < arrayListDataSorted.size(); j++) {
                if (arrayListDataSorted.get(j).compareTo(arrayListDataSorted.get(firstIndex)) > 0){
                    firstIndex = j;
                }
            }

            Distance temp = arrayListDataSorted.get(firstIndex);
            arrayListDataSorted.set(firstIndex, arrayListDataSorted.get(i));
            arrayListDataSorted.set(i, temp);
        }
    }

    public int getSortTimeALFormatted(){ return this.sortTimeAL.getNano(); }

    public int getSortTimeLLFormatted(){ return this.sortTimeLL.getNano(); }


    public static void main(String[] args) {
        List<Distance> list = new ArrayList<>();
        list.add(new Distance(0, "George Gatz", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));
        list.add(new Distance(0, "Steve Rogers", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));
        list.add(new Distance(0, "Christopher Bucacan", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));
        list.add(new Distance(0, "Jacob Gareth", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));

        for (int i = 0; i < list.size(); i++) {

            int firstIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(firstIndex)) > 0){
                    firstIndex = j;
                }
            }

            Distance temp = list.get(firstIndex);
            list.set(firstIndex, list.get(i));
            list.set(i, temp);
        }

        for (Distance o : list) {
            System.out.print(o.getId() + " " + o.getName() + " " + o.getSeedTime());
        }
    }
}
