package com.example.demo.Labs.michael.insertSortModel;

import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public abstract class _InsertionSort {
    int[] unsorted;
    int[] unsortedMutable;
    String approachName;
    Duration processTime;

    public _InsertionSort(String referenceArrayLiteral) {
        this.unsorted = toIntArray(referenceArrayLiteral);
        this.unsortedMutable = this.unsorted.clone();

        Instant processStart = Instant.now();
        this.init();
        Instant processEnd = Instant.now();
        this.processTime = Duration.between(processStart, processEnd);
    }

    protected abstract void init();

    public int getProcessTimeNano(){ return this.processTime.getNano(); }

    public int getProcessTimeSec(){ return (int)(this.processTime).getSeconds(); }

    /*public int getLastSpeedRecord() {
        if (speedRecords.size() <= 1) {
            return speedRecords.get(speedRecords.size() - 1);
        } else {
            return speedRecords.get(speedRecords.size() - 2);
        }
    }

    public int getRollingAverageSpeed() { return rollingAverageSpeed; }*/

    public String getUnsortedFormatted() { return Arrays.toString(getUnsorted()); }

    public String getSortedFormatted() { return Arrays.toString(getUnsortedMutable()); }


    public int[] toIntArray(String arrayLiteral) {
        /* Input box gives back a string literal, but an int[] is needed */
        String[] array = arrayLiteral.split(","); // automatic split into String[]
        List<String> list = Arrays.asList(array); // conversion to List because of management of a List

        int[] unsortedArray = new int[list.size()];

        for (String element : list) { // takes each element of the list and converts it to an int which is stuffed into an int[]
            unsortedArray[list.indexOf(element)] = Integer.parseInt(element);
        }

        return unsortedArray;
    }

    public void printIt() {
        System.out.println("Approach: " + getApproachName());
        System.out.println("Speed: " + getProcessTimeNano() + " nano seconds");
        System.out.println("Reference Array: " + Arrays.toString(getUnsorted()));
        System.out.println("Sorted Array: " + Arrays.toString(getUnsortedMutable()));

    }
}