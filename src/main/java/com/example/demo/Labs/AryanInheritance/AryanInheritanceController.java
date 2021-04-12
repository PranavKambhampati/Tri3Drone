package com.example.demo.Labs.AryanInheritance;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Getter
@Controller
public class AryanInheritanceController {
    private CircleQueues circles;
    private int number;
    private boolean languages;
    private Languages.Info languageKey;
    private boolean cities;
    private Cities.Info cityKey;
    private boolean food;
    private Food.Info foodKey;

    public AryanInheritanceController() {
        number = 0;
        circles = new CircleQueues();
    }

    public void addToCircleQueues(Object [] objects) {
        System.out.println("Adding..." + objects.length);
        for (Object obj: objects) {
            circles.add(obj);
            System.out.println("Adding..." + circles.getObject() + circles);
        }
    }

    public void deleteFromCircleQueues() {
        int lengthy = this.number;
        System.out.println("Deleting..." + lengthy);
        for (int i = 0; i < lengthy; i++) {
            System.out.println("Deleting..." + circles.getObject() + circles);
            this.number--;
        }
    }

    public List<String> getCircleQueueList() {
            List<String> stuff = new ArrayList<>();
            Object primero = circles.getFirstObject();
            do {
                stuff.add(circles.getObject().toString());
            } while (circles.setNext() != primero);
            return stuff;
        }

    @GetMapping("/AryanInheritance")
    public String display(Model model) {
        this.number = 0;
        this.circles = new CircleQueues();
        this.cityKey = Cities.Info.title;
        Cities.token = this.cityKey;
        this.foodKey = Food.Info.title;
        Food.token = this.foodKey;
        this.languageKey = Languages.Info.title;
        Languages.token = this.languageKey;
        this.food = true;
        this.languages = true;
        this.cities = true;
        this.addToCircleQueues(Cities.CityInfo());
        this.addToCircleQueues(Food.FoodInfo());
        this.addToCircleQueues(Languages.LanguageInfo());
        model.addAttribute("ctl", this);
        return "labs/AryanInheritanceLab";
    }

    @PostMapping("/AryanInheritance")
    public String showData(
            @RequestParam(value = "languages", required = false) String language,
            @RequestParam(value = "languagesToken") Languages.Info languageKey,
            @RequestParam(value = "cities", required = false) String cities,
            @RequestParam(value = "citiesToken") Cities.Info cityKey,
            @RequestParam(value = "food", required = false) String food,
            @RequestParam(value = "foodToken") Food.Info foodKey,
            Model model)
    {
        number = 0;
        circles = new CircleQueues();
        if (food != null) {
            this.addToCircleQueues(Food.FoodInfo());
            this.food = true;
            this.foodKey = foodKey;
        } else {
            this.food = false;
        }
        if (cities != null) {
            this.addToCircleQueues(Cities.CityInfo());
            this.cities = true;
            this.cityKey = cityKey;
        } else {
            this.food = false;
        }
        if (language != null) {
            this.addToCircleQueues(Languages.LanguageInfo());
            this.languages = true;
            this.languageKey = languageKey;
        } else {
            this.languages = false;
        }
        this.circles.insertionSort();
        model.addAttribute("ctl", this);
        return "labs/AryanInheritanceLab";
    }

    public void printCircleQueues() {
        System.out.println("Size is" + number);
        System.out.println("First Element is:" + circles.getFirstObject());
        System.out.println("Last Element is:" + circles.getLastObject());
        System.out.println("Entire Circle Queue" + circles);
        for(String stuff: this.getCircleQueueList()) {
            System.out.println(stuff);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AryanInheritanceController objectOne = new AryanInheritanceController();
        objectOne.addToCircleQueues(Cities.CityInfo());
        objectOne.addToCircleQueues(Food.FoodInfo());
        objectOne.addToCircleQueues(Languages.LanguageInfo());
        System.out.println("Adding data...");
        objectOne.printCircleQueues();

        Cities.token = Cities.Info.title;
        Food.token = Food.Info.title;
        Languages.token = Languages.Info.title;
        objectOne.circles.insertionSort();
        System.out.println("Order sorted");
        objectOne.printCircleQueues();

        Cities.token = Cities.Info.title;
        Food.token = Food.Info.title;
        Languages.token = Languages.Info.title;
        System.out.println("Get sorted order");
        objectOne.printCircleQueues();
        objectOne.circles.insertionSort();
        System.out.println("Order through data type");
        objectOne.printCircleQueues();

        System.out.println("Delete data");
        objectOne.deleteFromCircleQueues();
    }

}

    




