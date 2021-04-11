package com.example.demo.Labs.michael;

import com.example.demo.Labs.michael.trackModel.BasicData;
import com.example.demo.Labs.michael.trackModel.Distance;
import com.example.demo.Labs.michael.trackModel.Entries;
import com.example.demo.Labs.michael.trackModel.Sprinter;
import lombok.Getter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Controller
public class TrackController {
    private Entries allAthletes;

    private boolean distance;
    private Distance.keyType distanceKey;

    private boolean sprints;
    private Sprinter.keyType sprinterKey;

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

        this.distanceKey = Distance.keyType.name;
        Distance.key = this.distanceKey;
        this.sprinterKey = Sprinter.keyType.name;
        Sprinter.key = this.sprinterKey;

        this.distance = true;
        this.sprints = true;

        this.addAthletes(Distance.distanceAthleteData());
        this.addAthletes(Sprinter.sprinterAthleteData());

        model.addAttribute("allAthleteData", this.allAthletes);
        return "labs/michaelRecursion";
    }
}
