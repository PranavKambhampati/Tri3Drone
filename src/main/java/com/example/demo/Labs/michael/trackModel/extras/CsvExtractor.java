package com.example.demo.Labs.michael.trackModel.extras;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Getter
public class CsvExtractor {
    private String path;
    public List<String> data;

    public CsvExtractor(String path) {
        this.path = path;
    }
    public void parseData() {
        Scanner scan;
        this.data = new ArrayList<>();
        try {
            scan = new Scanner(new File(path));
            scan.useDelimiter(",");
            while (scan.hasNext()) {
                data.add(scan.next());
            }
        } catch (Exception e) {
            System.out.println("Not a valid file path");
        }
    }

    public void print() {
        for (String name : this.data){
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        CsvExtractor maleNames = new CsvExtractor("src/main/java/com/example/demo/Labs/michael/trackModel/extras/male_names.csv");
        maleNames.parseData();
        maleNames.print();

        System.out.println((Math.random() * (150 - 115)) + 115);
    }
}
