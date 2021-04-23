package com.example.demo.Labs.NakulInheritance;

public class Student extends MasterClass{
    public enum KeyType {title, name, age, year}
    public static KeyType key = KeyType.title;
    private final String name;
    private final int age;
    private final String year;

    public Student(String name, int age, String year)
    {
        super.setType("Student");
        this.name = name;
        this.age = age;
        this.year = year;
    }

    @Override
    public String toString() {
        String output="";
        switch(key) {
            case name:
                output += this.name;
                break;
            case age:
                output += "00" + this.age;
                output = output.substring(output.length()-2);
                break;
            case year:
                output += this.year;
                break;
            case title:
            default:
                output += super.getType() + ": " + this.name  + ", " + this.age + ", " + this.year;
        }
        return output;

    }

    public static MasterClass[] studentData() {
        return new MasterClass[]{
                new Student("Nakul Nandhakumar", 18, "Senior"),
                new Student("Michael Hayes", 16, "Junior"),
                new Student("Aryan Amberkar", 16, "Sophomore"),
                new Student("Pranav Khambhampati", 17, "Junior"),
                new Student("John Smith", 15, "Freshman"),
                new Student("Karen Greene", 22, "Undergraduate"),
                new Student("Marian Brady", 20, "Undergraduate"),
                new Student("Thomas Marsden", 19, "Senior")
        };
    }
}
