package com.example.demo.Labs.michael;

import com.example.demo.Labs.michael.trackModel.BasicData;
import com.example.demo.Labs.michael.trackModel.Distance;
import com.example.demo.Labs.michael.trackModel.Entries;
import com.example.demo.Labs.michael.trackModel.Sprinter;
import lombok.Getter;
import org.springframework.stereotype.Controller;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

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
}
