package com.example.demo.Labs.AryanInheritance;

public class Food extends AryanInheritance {

    public enum Info {title, food, cusine}

    public static Food.Info token = Food.Info.title;
    private final String food;
    private final String cusine;

    public Food(String food, String cusine) {
        super.setName("Food");
        this.food = food;
        this.cusine = cusine;
    }

    @Override
    public String toString() {
        String display = "";
        switch (token) {
            // case statement to display the different outputs
            case food:
                display += food;
                break;
            case cusine:
                display += cusine;
                break;
            case title:
            default:
                display += super.getName() + food;
        }
        return display;
    }

    public static AryanInheritance[] FoodInfo() {
        return new AryanInheritance[]{
                new Food("Pasta", "Italian"),
                new Food ("Pizza", "Italian"),
                new Food ("Tacos", "Mexican"),
                new Food("Sushi", "Japanese")
        };
    }
}