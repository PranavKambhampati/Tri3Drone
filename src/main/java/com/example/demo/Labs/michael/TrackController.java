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
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.Instant;

@Getter
@Setter
@Controller
public class TrackController {
    private Entries allAthletes;

    private boolean distance;
    private Distance.KeyType distanceKey;

    private boolean sprints;
    private Sprinter.KeyType sprinterKey;

    private Duration sortTime;

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
    public String userSelections(@RequestParam(value = "distance", required = false) String distance,
                                 @RequestParam(value = "distanceKey") Distance.KeyType distanceKey,
                                 @RequestParam(value = "sprinter", required = false) String sprinter,
                                 @RequestParam(value = "sprinterKey", required = false) Sprinter.KeyType sprinterKey, Model model
                                 ) {

        this.allAthletes = new Entries();

        if (distance != null) {
            this.addAthletes(Distance.distanceAthleteData());
            this.distance = true;
            this.distanceKey = distanceKey;
            Distance.key = this.distanceKey;
        } else {
            this.distance = false;
        }
        if (sprinter != null) {
            this.addAthletes(Sprinter.sprinterAthleteData());
            this.sprints = true;
            this.sprinterKey = sprinterKey;
            Sprinter.key = this.sprinterKey;
        } else {
            this.sprints = false;
        }

        this.allAthletes.insertionSort();

        model.addAttribute("allAthleteData", this);
        return "labs/michaelInheritance";
    }

    public int getSortTimeFormatted() {
        return this.getSortTime().getNano();
    }
}
