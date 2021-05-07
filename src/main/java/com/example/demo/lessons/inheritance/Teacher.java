package com.example.demo.lessons.inheritance;

public class Teacher extends Employee {
    private String subject;
    private int tenure;
    private String college;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;

        this.tenure = -1;
        this.college = "Unknown";
    }

    public String getSubject() {
        return this.subject;
    }

    @Override
    public String displayOccupation() {
        return "Teacher";
    }

    /* Overloaded method addExperience:
       Two implementations with the same name, each with
       different parameters
     */
    public void addExperience(int tenure) { // Overload 1
        this.tenure = tenure;
    }

    public void addExperience(int tenure, String college) { // Overload 2
        this.tenure = tenure;
        this.college = college;
    }
}
