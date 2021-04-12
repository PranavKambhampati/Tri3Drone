package com.example.demo.Labs.michael.trackModel;

import com.example.demo.Labs.michael.trackModel.extras.CsvExtractor;
import lombok.Getter;

import javax.persistence.Basic;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Getter
public class Distance extends Athlete {
    public enum KeyType {name, grade, gender, school, seedTime, split, event}
    public static KeyType key = KeyType.name;

    public static boolean distanceSorted;

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
                break;
            default:
                formattedString = super.getType() + ": " + super.getName() + " " + super.getGrade() + " " + super.getSchool() + " " + this.event + " " + this.split + " " + super.getSeedTime();
                break;
        }

        return formattedString;
    }

    public static BasicData[] distanceAthleteData() {

        /*for (int i = 0; i < 30; i++) {
            data[i] = new Distance(i, "Hayes, Michael", 9, "male", "Del Norte", "2:08.37", "1:02.43", "800 meters");
        }
        return data;*/
        CsvExtractor maleNames = new CsvExtractor("src/main/java/com/example/demo/Labs/michael/trackModel/extras/male_names.csv");
        maleNames.parseData();
        maleNames.print();

        BasicData[] data = new BasicData[24];

        for (int i = 0; i < 24; i++) {
            String school;
            if (i % 2 == 0 ) {
                school = "Del Norte";
            } else {
                school = "Rancho Bernardo";
            }
            if (i < 8) {
                data[i] = new Distance(i, maleNames.getData().get(i), (int) ((Math.random() * (12 - 9)) + 9), "male", school, String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters");
            } else if (i < 16){
                data[i] = new Distance(i, maleNames.getData().get(i), (int) ((Math.random() * (12 - 9)) + 9), "male", school, String.valueOf((Math.random() * (330 - 285)) + 285), String.valueOf((Math.random() * (165 - 145)) + 165), "1600 meters");
            } else {
                data[i] = new Distance(i, maleNames.getData().get(i), (int) ((Math.random() * (12 - 9)) + 9), "male", school, String.valueOf((Math.random() * (750 - 615)) + 615), String.valueOf((Math.random() * (360 - 300) + 300)), "3200 meters");
            }
        }

        return data;
    }
}
