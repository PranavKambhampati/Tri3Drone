package com.example.demo.Labs.michael;

import com.example.demo.Labs.michael.linkedListsModel.MikeLinkedList;
import com.example.demo.Labs.michael.trackModel.Distance;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Getter
@Setter
public class LinkedListController {
    List<Distance> arrayListData = new ArrayList<>();
    MikeLinkedList linkedListData = new MikeLinkedList();

    @GetMapping("/michaelLinkedList")
    public String defaultDisplay(Model model) {


        model.addAttribute("listData", this);

        return "labs/michaelLinkedList";
    }

    public void arrayListSelection() {
        for (int i = 0; i < arrayListData.size(); i++) {

            int firstIndex = i;
            for (int j = i + 1; j < arrayListData.size(); j++) {
                if (arrayListData.get(j).compareTo(arrayListData.get(firstIndex)) > 0){
                    firstIndex = j;
                }
            }

            Distance temp = arrayListData.get(firstIndex);
            arrayListData.set(firstIndex, arrayListData.get(i));
            arrayListData.set(i, temp);
        }
    }

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
