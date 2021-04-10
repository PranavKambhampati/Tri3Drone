package com.example.demo.Labs.michael.trackModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Athlete extends BasicData{
    public enum KeyType {title, name, grade, seedTime}
    public static KeyType key = KeyType.title;

    private final String name;
    private final int grade;
    private final String school;
    private final double seedTime;

    public Athlete(String name, int grade, String school, double seedTime) {
        this.setType("Athlete");
        this.name = name;
        this.grade = grade;
        this.school = school;
        this.seedTime = seedTime;
    }
}
