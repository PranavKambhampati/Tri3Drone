package com.example.demo.Labs.michael.trackModel;

import com.example.demo.Labs.michael.trackModel.extras.CsvExtractor;
import lombok.Getter;

@Getter
public class Sprinter extends Athlete {
    public enum KeyType {name, grade, gender, school, seedTime, wind, event}
    public static KeyType key = KeyType.name;

    private final String wind;
    private final String event;

    public Sprinter(int id, String name, int grade, String gender, String school, String seedTime, String wind, String event){
        super(id, name, grade, gender, school, seedTime);
        this.setType("Sprinter");

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
                formattedString = formattedString.substring(formattedString.length()-2);
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
    /**
     * Sprinter data generated via
     * 1. name parsed from CSV file (trackModel.extras.males_names.csv)
     * 2. school with simple randomization
     * 3. grade, seedTime, and wind from Math.random() generation
     * 4. Event via 8 athletes per event
     * @return
     */
    public static BasicData[] sprinterAthleteData() {

        CsvExtractor maleNames = new CsvExtractor("src/main/java/com/example/demo/Labs/michael/trackModel/extras/male_names.csv");
        maleNames.parseData();
        maleNames.print();

        BasicData[] data = new BasicData[24];

        for (int i = 24; i < 48; i++) {
            String school;
            if (i % 2 == 0 ) {
                school = "Del Norte";
            } else {
                school = "Rancho Bernardo";
            }
            if (i < 32) {
                data[i - 24] = new Sprinter(i, maleNames.getData().get(i), (int) ((Math.random() * (12 - 9)) + 9), "male", school, String.valueOf((Math.random() * (14 - 10.5)) + 10.5), String.valueOf((Math.random() * (2 - 0)) + 0), "100 meters");
            } else if (i < 40){
                data[i - 24] = new Sprinter(i, maleNames.getData().get(i), (int) ((Math.random() * (12 - 9)) + 9), "male", school, String.valueOf((Math.random() * (30 - 24)) + 24), String.valueOf((Math.random() * (2 - 0)) + 0), "200 meters");
            } else {
                data[i - 24] = new Sprinter(i, maleNames.getData().get(i), (int) ((Math.random() * (12 - 9)) + 9), "male", school, String.valueOf((Math.random() * (61 - 52)) + 52), String.valueOf((Math.random() * (2 - 0) + 0)), "400 meters");
            }
        }

        return data;
    }
}

