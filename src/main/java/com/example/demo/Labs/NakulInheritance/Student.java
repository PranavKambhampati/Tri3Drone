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
                new Student("Thomas Marsden", 19, "Senior"),
                new Student("Wilma Lynna", 18, "Senior"),
                new Student("Tamsyn Fisher", 16, "Junior"),
                new Student("Esmeralda Lorna", 16, "Sophomore"),
                new Student("Buddy Christie", 17, "Junior"),
                new Student("Sloan Christen", 15, "Freshman"),
                new Student("Briscoe Caren", 19, "Undergraduate"),
                new Student("Kizzie Alfie", 20, "Undergraduate"),
                new Student("Gretchen Norton", 17, "Junior"),
                new Student("Theo Beryl", 18, "Senior"),
                new Student("Hadyn Cyndi", 20, "Undergraduate"),
                new Student("Betony Jordana", 16, "Freshman"),
                new Student("Alex Lee", 22, "Undergraduate")
        };
    }
}
