package com.example.demo.Labs.michael.trackModel;

public class Distance extends Athlete {
    public enum keyType {name, grade, school, seedTime, split}
    public static keyType key = keyType.name;

    private final double split;

    public Distance(String name, int grade, String school, double seedTime, double split){
        super(name, grade, school, seedTime);
        this.split = split;
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
            case split:
                formattedString += this.split;
                break;
            default:
                formattedString = super.getType() + ": " + super.getName() + " " + super.getGrade() + " " + super.getSchool() + " " + super.getSeedTime() + " " + this.split;
                break;
        }
        return formattedString;
    }
}
