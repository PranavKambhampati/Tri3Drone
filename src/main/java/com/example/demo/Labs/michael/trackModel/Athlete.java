package com.example.demo.Labs.michael.trackModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Athlete extends BasicData{

    private int id;
    private final String name;
    private final int grade;
    private final String gender;
    private final String school;
    private final String seedTime;

    public Athlete(int id, String name, int grade, String gender, String school, String seedTime) {
        this.setType("Athlete");
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.school = school;
        this.seedTime = seedTime;
    }
}
