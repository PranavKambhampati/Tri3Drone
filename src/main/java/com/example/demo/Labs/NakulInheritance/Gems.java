package com.example.demo.Labs.NakulInheritance;

public class Gems extends MasterClass{
    public enum KeyType {title, name, color, value}
    public static KeyType key = KeyType.title;
    private final String name;
    private final String color;
    private final int value;

    public Gems(String name, int value, String color)
    {
        super.setType("Gems");
        this.name = name;
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        String output="";
        switch(key) {
            case name:
                output += this.name;
                break;
            case value:
                output += this.value;
                break;
            case color:
                output += this.color;
                break;
            case title:
            default:
                output += super.getType() + ": " + this.name  + ", " + this.value + ", " + this.color;
        }
        return output;

    }

    public static MasterClass[] gemsData() {
        return new MasterClass[]{
                new Gems("Diamond", 5100, "Colorless"),
                new Gems("Emerald", 8600, "Green"),
                new Gems("Sapphire", 1600, "Blue"),
                new Gems("Ruby", 1200, "Red"),
                new Gems("Topaz", 3500, "Orange"),
                new Gems("Alexandrite", 5000, "Blueish Green"),
                new Gems("Opal", 6000, "White"),

        };
    }
}
