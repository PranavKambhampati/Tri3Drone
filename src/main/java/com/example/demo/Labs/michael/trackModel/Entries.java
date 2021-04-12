package com.example.demo.Labs.michael.trackModel;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Entries {
    private List<BasicData> list = new ArrayList<>();

    public void insertionSort(){
        for (int j = 1; j < list.size(); j++) {
            BasicData current = list.get(j);
            int i = j - 1;

            while ((i > -1) && (list.get(i).toString().compareTo(current.toString()) == 1)) {
                list.set(i + 1, list.get(i));
                i--;
            }
            list.set(i + 1, current);
        }
    }

    public void fillAthleteList(Object[] athletes) {
        for (Object athlete : athletes) {
            this.list.add((BasicData) athlete);
        }
    }

    public void addEntry(BasicData entry) { this.list.add(entry); }
}
