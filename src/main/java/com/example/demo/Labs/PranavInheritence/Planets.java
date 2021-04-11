package com.example.demo.Labs.PranavInheritence;
import com.example.demo.Labs.PranavInheritence.ConsoleMethods.ConsoleMethods;


public class Planets extends Generals {

    public enum KeyType {title, name, distance}
    public static KeyType key = KeyType.title;
    //private static final int size = 26;
    private final int distance;
    private final String name;

    public Planets(String nam, int num){
        this.setType("Planet");
        this.name = nam;
        this.distance = num;
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
            case title:
            default:
                output += super.getType()+": " + this.distance;
        }
        return output;
    }

    public static Generals[] PlanetsData(){
        return new Generals[]{
                new Planets("Mercury", 1),
                new Planets("Venus",2),
                new Planets("Earth", 3),
                new Planets("Mars",4),
                new Planets("Jupiter", 5),
                new Planets("Saturn", 6),
                new Planets("Uranus", 7),
                new Planets("Neptune",8)
        };
    }

    public static void main(String[] args) {
        Generals[] planData = PlanetsData();
        for(Generals a: PlanetsData()){
            ConsoleMethods.println(""+a);
        }
    }

}
