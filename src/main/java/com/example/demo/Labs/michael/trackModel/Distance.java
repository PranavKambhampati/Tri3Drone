package com.example.demo.Labs.michael.trackModel;

import javax.persistence.Basic;

public class Distance extends Athlete {
    public enum keyType {name, grade, gender, school, seedTime, split, event}
    public static keyType key = keyType.name;

    private final String split;
    private final String event;

    public Distance(int id, String name, int grade, String gender, String school, String seedTime, String split, String event){
        super(id, name, grade, gender, school, seedTime);
        this.split = split;
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
            case gender:
                formattedString = super.getGender();
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
            case event:
                formattedString += this.event;
            default:
                formattedString = super.getType() + ": " + super.getName() + " " + super.getGrade() + " " + super.getSchool() + " " + this.event + " " + this.split + " " + super.getSeedTime();
                break;
        }
        return formattedString;
    }

    public static BasicData[] distanceAthleteData() {
        BasicData[] data = new BasicData[30];
        for (int i = 0; i < 30; i++) {
            data[i] = new Distance(i, "Hayes, Michael", 9, "male", "Del Norte", "2:08.37", "1:02.43", "800 meters");
        }

        return data;
    }
}
