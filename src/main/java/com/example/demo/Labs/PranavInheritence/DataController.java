package com.example.demo.Labs.PranavInheritence;

import com.example.demo.Labs.PranavInheritence.ConsoleMethods.ConsoleMethods;
import com.example.demo.Labs.PranavInheritence.Planet;
import com.example.demo.Labs.PranavInheritence.Car;


import com.example.demo.Labs.PranavInheritence.Technicals.CircleQueue;
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
public class DataController {

    private CircleQueue queue;
    private int count;
    private boolean planet;
    private Planet.KeyType planetKey;

    private Car.KeyType carKey;
    private boolean car;

    public DataController(){
        count = 0;
        queue = new CircleQueue();
    }

    public void addCQueue(Object[] objects){
        ConsoleMethods.println("Add " + objects.length);
        for(Object o: objects){
            queue.addobj(o);
            ConsoleMethods.println("Add: " + queue.getObject() + " " + queue);
            this.count++;
        }
    }

    public void deleteCQueue(){
        int length = this.count;
        ConsoleMethods.println("Delete "+ length);

        for (int i = 0; i<length; i++){
            ConsoleMethods.println("Delete: " + queue.deleteobj() + " " + queue);
            this.count--;
        }
    }

    public List<String> getCQList(){
        List<String> log = new ArrayList<>();
        Object first = queue.getFirst();
        do{
            log.add(queue.getObject().toString());
        } while (queue.setnext() != first);
        return log;
    }

    @GetMapping("/pi")
    public String data(Model model){
        this.count = 0;
        this.queue = new CircleQueue();
        this.planetKey = Planet.KeyType.title;
        Planet.key = this.planetKey;

        this.carKey = Car.KeyType.title;
        Car.key = this.carKey;

        this.planet = true;
        this.car = true;

        this.addCQueue(Planet.planetData());
        this.addCQueue(Car.carData());

        model.addAttribute("ctl", this);
        return "labs/PranavInheritence";
    }

    @PostMapping("/pi")
    public String dataFilter(
            @RequestParam(value = "planet", required = false) String planet,
            @RequestParam(value = "planetKey", required = false) Planet.KeyType planetKey,
            @RequestParam(value = "car", required = false) String car,
            @RequestParam(value = "carKey",required = false) Car.KeyType carKey,
            Model model){

        count = 0;
        queue = new CircleQueue();

        if (planet != null){
            this.addCQueue(Planet.planetData());
            this.planet = true;
            this.planetKey = planetKey;
            Planet.key = this.planetKey;
        } else {
            this.planet = false;
        }
        if(car != null){
            this.addCQueue(Car.carData());
            this.car = true;
            this.carKey = carKey;
            Car.key = this.carKey;
        } else{
            this.car = false;
        }
        this.queue.InsertionSort();
        model.addAttribute("ctl", this);
        return "labs/PranavInheritence";
    }

    public void printCQueue(){
        ConsoleMethods.println("Size: " + count);
        ConsoleMethods.println("First Element: " + queue.getFirst());
        ConsoleMethods.println("Last Element: " + queue.getLast());
        ConsoleMethods.println("Full cqueue: " + queue);
        for (String line : this.getCQList()) {
            ConsoleMethods.println(line);
        }
        ConsoleMethods.println();

    }

    public static void main(String[] args) {
        DataController trial = new DataController();

        trial.addCQueue(Planet.planetData());
        trial.addCQueue(Car.carData());
        ConsoleMethods.println("Add order (all data)");
        trial.printCQueue();

        Planet.key = Planet.KeyType.name;
        Car.key = Car.KeyType.name;
        trial.queue.InsertionSort();
        ConsoleMethods.println("Sorted order (key only)");
        trial.printCQueue();

        Planet.key = Planet.KeyType.title;
        Car.key = Car.KeyType.title;
        ConsoleMethods.println("Retain sorted order (all data)");
        trial.printCQueue();
        trial.queue.InsertionSort();
        ConsoleMethods.println("Order by data type (all data)");
        trial.printCQueue();

        ConsoleMethods.println("Delete from front (all data)");
        trial.deleteCQueue();
    }


}
