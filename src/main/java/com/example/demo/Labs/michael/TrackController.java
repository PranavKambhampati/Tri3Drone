package com.example.demo.Labs.michael;

import com.example.demo.Labs.michael.trackModel.BasicData;
import com.example.demo.Labs.michael.trackModel.Distance;
import com.example.demo.Labs.michael.trackModel.Entries;
import com.example.demo.Labs.michael.trackModel.Sprinter;
import lombok.Getter;

import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
@Controller
public class TrackController {
    private Entries allAthletes;

    private boolean distance;
    private Distance.KeyType distanceKey;

    private boolean sprints;
    private Sprinter.KeyType sprinterKey;

    public TrackController() {
        allAthletes = new Entries();
    }

    public void addAthletes(BasicData[] array) {
        for (BasicData data : array) {
            this.allAthletes.addEntry(data);
        }
    }

    @GetMapping("/michaelInheritance")
    public String defaultDisplay (Model model) {
        this.allAthletes = new Entries();

        this.distanceKey = Distance.KeyType.name;
        Distance.key = this.distanceKey;
        this.sprinterKey = Sprinter.KeyType.name;
        Sprinter.key = this.sprinterKey;

        this.distance = true;
        this.sprints = true;

        this.addAthletes(Distance.distanceAthleteData());
        this.addAthletes(Sprinter.sprinterAthleteData());

        model.addAttribute("allAthleteData", this);
        return "labs/michaelInheritance";
    }

    @PostMapping("/michaelInheritance")
    public String userSelections() {
        return "/michaelInheritance";
    }
}
