package com.example.demo.Labs.michael.trackModel;

public class Sprinter extends Athlete {
    public enum keyType {name, grade, gender, school, seedTime, wind, event}
    public static keyType key = keyType.name;

    private final double wind;
    private final String event;

    public Sprinter(String name, int grade, String gender, String school, double seedTime, double wind, String event){
        super(name, grade, gender, school, seedTime);
        this.wind = wind;
        this.event = event;
    }

    @Override
    public String toString() {
        String formattedString = "";
        switch (key) {
            case name:
                formattedString = super.getName();
                break;
            case grade:
                formattedString += "00" + super.getGrade();
                break;
            case school:
                formattedString = super.getSchool();
                break;
            case seedTime:
                formattedString += super.getSeedTime();
                break;
            case wind:
                formattedString += this.wind;
                break;
            case event:
                formattedString = this.event;
                break;
            default:
                formattedString = super.getType() + ": " + super.getName() + " " + super.getGrade() + " " + super.getSchool() + " " + this.event + " " + super.getSeedTime() + " " + this.wind;
                break;
        }
        return formattedString;
    }
}

