package com.example.demo.Labs.PranavInheritence;

import com.example.demo.Labs.PranavInheritence.ConsoleMethods.ConsoleMethods;

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
    private Planets.KeyType planetkey;

    public DataController(){
        count = 0;
        queue = new CircleQueue();
    }

    public void addCQueue(Object[] objects){
        ConsoleMethods.println("Add " + objects.length);
        for(Object o: objects){
            queue.addobj(o);
            ConsoleMethods.println("Add: " + queue.getObject() + " " + queue);

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
        this.planetkey = Planets.KeyType.title;
        Planets.key = this.planetkey;

        this.planet = true;

        this.addCQueue(Planets.PlanetsData());

        model.addAttribute("ctl", this);
        return "labs/PranavInheritence";
    }

    @PostMapping("/pi")
    public String dataFilter(
            @RequestParam(value = "planet", required = false) String planet,
            @RequestParam(value = "planetkey") Planets.KeyType planetkey, Model model){

        count = 0;
        queue = new CircleQueue();

        if (planet != null){
            this.addCQueue(Planets.PlanetsData());
            this.planet = true;
            this.planetkey = planetkey;
            Planets.key = this.planetkey;
        } else {
            this.planet = false;
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

        trial.addCQueue(Planets.PlanetsData());
        ConsoleMethods.println("Add order (all data)");
        trial.printCQueue();

        Planets.key = Planets.KeyType.name;
        trial.queue.InsertionSort();
        ConsoleMethods.println("Sorted order (key only)");
        trial.printCQueue();

        Planets.key = Planets.KeyType.title;
        ConsoleMethods.println("Retain sorted order (all data)");
        trial.printCQueue();
        trial.queue.InsertionSort();
        ConsoleMethods.println("Order by data type (all data)");
        trial.printCQueue();

        ConsoleMethods.println("Delete from front (all data)");
        trial.deleteCQueue();
    }


}
