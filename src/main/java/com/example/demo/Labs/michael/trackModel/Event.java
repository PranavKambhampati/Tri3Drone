package com.example.demo.Labs.michael.trackModel;

import java.util.ArrayList;
import java.util.List;
/*
    BACKLOGGED, original intention was to use class to display each event separately in its own table. This class would have been a display wrapper
 */
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
