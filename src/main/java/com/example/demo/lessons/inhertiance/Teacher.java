package com.example.demo.lessons.inhertiance;

public class Teacher extends Employee {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public String displayOccupation() {
        return "Teacher";
    }
}
