package com.example.demo.Labs.PranavInheritence;


public class Planet extends Generals {

    public enum KeyType {title, name, distance, color}
    public static KeyType key = KeyType.title;
    //private static final int size = 26;
    private final String name;
    private final int distance;
    private final String color;

    public Planet(String nam, int num, String color){
        this.setType("Planet");
        this.name = nam;
        this.distance = num;
        this.color = color;
    }

    @Override
    public String toString(){

        String output = "";
        switch (key){
            case distance:
                output += this.distance;
                break;
            case name:
                output+= this.name;
                break;
            case color:
                output += this.color;
                break;
            case title:
            default:
                output += super.getType() + ": " + this.name  + ", " + this.color + ", " + this.distance;
        }
        return output;
    }

    public static Generals[] planetData(){
        return new Generals[]{
                new Planet("Mercury", 1,"Light Grey"),
                new Planet("Venus",2,"White"),
                new Planet("Earth", 3, "Green"),
                new Planet("Mars",4, "Red"),
                new Planet("Jupiter", 5, "Brown"),
                new Planet("Saturn", 6, "Yellow"),
                new Planet("Uranus", 7, "Bluish Green"),
                new Planet("Neptune",8, "Blue")
        };
    }


}
