package com.example.demo.lessons.inheritance;

public class Principal extends Administrator {
    private String slogan;

    /* Primary constructor */
    public Principal(String name, int age) {
        super(name, age, "Principal");
    }

    /* Secondary constructor */
    public Principal(String name, int age, String slogan) {
        super(name, age, "Principal");
        this.slogan = "One flock, one family.";
    }

    public String getSlogan() {
        return this.slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
