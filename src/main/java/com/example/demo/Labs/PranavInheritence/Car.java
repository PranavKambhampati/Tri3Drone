package com.example.demo.Labs.PranavInheritence;
import com.example.demo.Labs.PranavInheritence.ConsoleMethods.ConsoleMethods;


public class Car extends Generals {

    public enum KeyType {title, name, age, color}
    public static KeyType key = KeyType.title;
    private final String name;
    private final int age;
    private final String color;

    public Car(String name, int age, String color){
        super.setType("Car");
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString(){
        String output="";
        switch(key) {
            case name:
                output += this.name;
                break;
            case age:
                output += "00" + this.age;
                output = output.substring(output.length()-2);
                break;
            case color:
                output += this.color;
                break;
            case title:
            default:
                output += super.getType() + ": " + this.name  + ", " + this.color + ", " + this.age;
        }
        return output;
    }

    public static Generals[] carData(){
        return new Generals[]{
                new Car("Prius", 24, "Silver"),
                new Car("Civic", 3, "Blue"),
                new Car("Wrangler", 4, "Red"),
                new Car("ModelX", 1, "Black"),
                new Car("Pista", 5, "Green"),
                new Car("Cayman", 2, "Purple"),
                new Car("Sienna", 25, "Rainbow")
        };
    }

    public static void main(String[] args) {
        Generals[] card = carData();
        for(Generals b: card){
            ConsoleMethods.println("" + b);
        }
    }

}
