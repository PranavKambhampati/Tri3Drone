package com.example.demo.lessons.inhertiance;

public class CompScienceInstructor extends Teacher{
    private long binaryCode;

    public CompScienceInstructor(String name, int age, int binaryCode) {
        super(name, age, "Computer Science");
        this.binaryCode = binaryCode;
    }

    public float getBinaryCode() {
        return this.binaryCode;
    }
}
