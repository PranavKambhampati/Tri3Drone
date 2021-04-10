package com.example.demo.Labs.michael.trackModel;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private Entries participants;

    public Event(String name) {
        this.name = name;
    }

    public void addEntry(BasicData athlete) {
        this.participants.addEntry(athlete);
    }
}
