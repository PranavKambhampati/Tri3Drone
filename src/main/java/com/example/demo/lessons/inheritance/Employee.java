package com.example.demo.lessons.inheritance;

public class Employee {
    private String name;
    private int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns name and age
     * @return
     */
    public String getInfo() {
        return this.name + this.age;
    }

    public String displayOccupation() {
        return "No occupation has been assigned";
    }

    public String rootMethod() {
        return "Root method is accessible";
    }

    public static void main(String[] args) {
        Teacher t1 = new Teacher("chris", 28, "English");
        t1.rootMethod();

        Employee e1  = new Employee("steve", 30);

        Teacher t2 = new CompScienceInstructor("jake", 42, 01000011);
    }
}
