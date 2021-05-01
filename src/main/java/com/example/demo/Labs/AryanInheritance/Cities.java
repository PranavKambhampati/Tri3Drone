package com.example.demo.Labs.AryanInheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cities extends AryanInheritance {

    public enum Info {title, city, state, population}
    public static Cities.Info token = Cities.Info.title;
    private final String city;
    private final String state;
    private final int population;

    public Cities (String city1, String state1, int population1) {
        super.setName("Cities");
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
                display += "00" + population;
                display = display.substring(display.length()-2);
                break;
            case title:
            default:
                display += super.getName() + ": " + city  + ", " + state + ", " + population;
        }
        return display;
    }

    public static AryanInheritance[] CityInfo() {
        return new AryanInheritance[] {
                new Cities("San Francisco", "USA", 874961),
                new Cities("San Diego", "USA", 1410000),
                new Cities("Mumbai", "India",20000000),
                new Cities("London","United Kingdom", 9304000),
                new Cities("Paris", "France",11017000),
                new Cities("Barcelona", "Spain",5586000),
                new Cities("Toronto", "Canada",6197000)
        };
    }

    public static void main(String[] args) {
        AryanInheritance[] cityInfo = CityInfo();
            for (AryanInheritance c: cityInfo) {
            System.out.println(" " + c);
        }
    }
}
