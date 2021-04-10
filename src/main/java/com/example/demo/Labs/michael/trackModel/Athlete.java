package com.example.demo.Labs.michael.trackModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Athlete extends BasicData{

    private final String name;
    private final int grade;
    private final String gender;
    private final String school;
    private final double seedTime;

    public Athlete(String name, int grade, String gender, String school, double seedTime) {
        this.setType("Athlete");
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.school = school;
        this.seedTime = seedTime;
    }
}
