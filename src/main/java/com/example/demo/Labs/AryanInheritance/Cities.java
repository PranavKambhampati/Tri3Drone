package com.example.demo.Labs.AryanInheritance;

public class Cities extends AryanInheritance {

    public enum Info {title, city, state, population}
    public static Cities.Info token = Cities.Info.title;
    private final String city;
    private final String state;
    private final int population;

    public Cities (String city1, String state1, int population1) {
        city = city1;
        state = state1;
        population = population1;
    }

    @Override
    public String toString() {
        String display = "";
        switch(token) {
            // case statement to display the different outputs
            case city:
                display += city;
                break;
            case state:
                display += state;
                break;
            case population:
                display += population;
                break;
            case title:
            default:
                display += "";
        }
        return display;
    }

    public static AryanInheritance[] CityInfo() {
        return new AryanInheritance[] {
                new Cities("San Francisco", "California", 874961),
                new Cities("San Diego", "California", 1410000),
                new Cities("New York City", "New York",8491000),
                new Cities("Chicago","Illinois", 2710000)
        };
    }

    public static void main(String[] args) {
        AryanInheritance[] cityInfo = CityInfo();
        for (AryanInheritance c: cityInfo) {
            System.out.println("" + c);
        }
    }
}
