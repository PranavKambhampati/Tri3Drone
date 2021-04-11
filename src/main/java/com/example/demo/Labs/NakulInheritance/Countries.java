package com.example.demo.Labs.NakulInheritance;

public class Countries extends MasterClass{
    public enum KeyType {title, name, location}
    public static KeyType key = KeyType.title;
    private final String name;
    private final String location;

    public Countries(String name, String location)
    {
        super.setType("Countries");
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        String output="";
        switch(key) {
            case name:
                output += this.name;
                break;
            case location:
                output += this.location;
                break;
            case title:
            default:
                output += super.getType() + ": " + this.name  + ", " + this.location;
        }
        return output;

    }

    public static MasterClass[] countriesData() {
        return new MasterClass[]{
                new Countries("USA", "North America"),
                new Countries("Canada", "North America"),
                new Countries("Russia", "Asia"),
                new Countries("France", "Europe"),
                new Countries("Italy", "Europe"),
                new Countries("India", "Asia"),
                new Countries("Japan", "Asia"),
                new Countries("Wakanda", "Africa"),
                new Countries("Ethiopia", "Africa"),
                new Countries("Brazil", "South America"),
                new Countries("Suriname", "South America"),
                new Countries("Chile", "South America"),
                new Countries("Australia", "Australia"),

        };
    }
}
