package com.example.demo.lessons.inheritance;

public class Administrator extends Employee {
    private String scope;

    public Administrator(String name, int age, String scope) {
        super(name, age);
        this.scope = scope;
    }

    public String getScope() {
        return this.scope;
    }

    @Override
    public String displayOccupation() {
        return "Administrator";
    }
}
