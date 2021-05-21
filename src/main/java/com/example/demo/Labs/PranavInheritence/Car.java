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
                new Car("Sienna", 25, "Rainbow"),
                new Car("750S",9,"Orange"),
                new Car("Camry",21,"Grey"),
                new Car("Leaf",14,"Black"),
                new Car("i8",39,"Copper"),
                new Car("Artura",1,"Green"),
                new Car("ModelY",14,"Green"),
                new Car("Roadster",0,"Red"),
                new Car("SilverLightning",3,"Silver"),
                new Car("Agera",15,"Orange"),
                new Car("Focus",3,"Magenta"),
                new Car("Explorer",5,"Black"),
                new Car("Cullinan",6,"Blue"),
                new Car("Sonata",3,"Grey"),
                new Car("Phantom",2,"Magnetic Grey"),
                new Car("McQueen",1,"Red"),
                new Car("Altima",2,"White"),
                new Car("Divo",1,"Blue"),
                new Car("Chiron",5,"Blue"),
                new Car("Apple Car",0,"White"),
                new Car("911",2,"Yellow"),
                new Car("Sequoia",3,"Brown"),
                new Car("Aventador",2,"Yellow"),
                new Car("Urus",3,"Red"),
                new Car("RamboLambo",90,"Camo")
        };
    }

    public static void main(String[] args) {
        Generals[] card = carData();
        for(Generals b: card){
            ConsoleMethods.println("" + b);
        }
    }

}
