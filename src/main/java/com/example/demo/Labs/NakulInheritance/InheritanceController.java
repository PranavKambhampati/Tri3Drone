package com.example.demo.Labs.NakulInheritance;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Getter
@Controller
@RequestMapping("/labs")
public class InheritanceController {
    private ArrayList<Object> list;
    private int count;
    private boolean student;
    private Student.KeyType studentKey;
    private boolean gems;
    private Gems.KeyType gemsKey;
    private boolean countries;
    private Countries.KeyType countriesKey;

    public InheritanceController(){
        list = new ArrayList<Object>();
        count = 0;
    }

    public void addToList(Object[] objects)
    {
        for (Object o : objects)
        {
            list.add(o);
            this.count++;
        }
    }

    public void insertionSortArrayList() {
        for (int j = 1; j < list.size(); j++) {
            Object current = list.get(j);
            int i = j-1;
            while ((i > -1) && ((list.get(i).toString().compareTo(current.toString())) > 0)) {
                list.set(i+1, list.get(i));
                i--;
            }
            list.set(i+1, current);
        }
    }

    @GetMapping("/NakulInheritance")
    public String data(Model model) {

        //initialize data
        this.count = 0;
        this.list = new ArrayList<Object>();
        //application specific inits
        //title defaults
        this.studentKey = Student.KeyType.title;
        Student.key = this.studentKey;
        this.gemsKey = Gems.KeyType.title;
        Gems.key = this.gemsKey;
        this.countriesKey = Countries.KeyType.title;
        Countries.key = this.countriesKey;

        //control options
        this.student = true;
        this.gems = true;
        //load data
        this.addToList(Student.studentData());
        this.addToList(Gems.gemsData());
        this.addToList(Countries.countriesData());

        //data is not sorted, queue order (FIFO) is default
        model.addAttribute("ctl", this);
        return "labs/NakulInheritance"; //HTML render default condition
    }


    @PostMapping("/NakulInheritance")
    public String dataFilter(
            @RequestParam(value = "student", required = false) String student,
            @RequestParam(value = "studentKey") Student.KeyType studentKey,
            @RequestParam(value = "gems", required = false) String gems,
            @RequestParam(value = "gemsKey") Gems.KeyType gemsKey,
            @RequestParam(value = "countries", required = false) String countries,
            @RequestParam(value = "countriesKey") Countries.KeyType countriesKey,
            Model model)
    {
        //re-init data according to check boxes selected
        count = 0;
        list = new ArrayList<Object>();
        //for each category rebuild data, set presentation and data defaults
        if (student != null) {
            this.addToList(Student.studentData());  //adding Student data to list
            this.student = true;             //persistent selection from check box selection
            this.studentKey = studentKey;     //persistent enum update from radio button selection
            Student.key = this.studentKey;    //toString configure for sort order
        } else {
            this.student = false;
        }
        if (gems != null) {
            this.addToList(Gems.gemsData());  //adding Student data to list
            this.gems = true;             //persistent selection from check box selection
            this.gemsKey = gemsKey;     //persistent enum update from radio button selection
            Gems.key = this.gemsKey;    //toString configure for sort order
        } else {
            this.gems = false;
        }
        if (countries != null) {
            this.addToList(Countries.countriesData());  //adding Student data to list
            this.countries = true;             //persistent selection from check box selection
            this.countriesKey = countriesKey;     //persistent enum update from radio button selection
            Countries.key = this.countriesKey;    //toString configure for sort order
        } else {
            this.countries = false;
        }
        //sort data according to selected options
        insertionSortArrayList();
        //render with options
        model.addAttribute("ctl", this);
        return "labs/NakulInheritance";
    }

    public static void main(String[] args) {
        InheritanceController ctl = new InheritanceController();
        ctl.addToList(Student.studentData());
        System.out.println(ctl.list.get(ctl.count-1));
    }

}
