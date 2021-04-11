package com.example.demo.Labs.michael.trackModel;

public class Sprinter extends Athlete {
    public enum KeyType {name, grade, gender, school, seedTime, wind, event}
    public static KeyType key = KeyType.name;

    private final String wind;
    private final String event;

    public Sprinter(int id, String name, int grade, String gender, String school, String seedTime, String wind, String event){
        super(id, name, grade, gender, school, seedTime);
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
            case gender:
                formattedString = super.getGender();
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

    public static BasicData[] sprinterAthleteData() {
        BasicData[] data = new BasicData[30];
        for (int i = 0; i < 30; i++) {
            data[i] = new Sprinter(i, "Hayes, Michael", 9, "male", "Del Norte", "0:58.22", "-0.7", "400 meters");
        }

        return data;
    }
}

