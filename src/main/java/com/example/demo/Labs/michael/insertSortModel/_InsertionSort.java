package com.example.demo.Labs.michael.insertSortModel;

import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Getter
public abstract class _InsertionSort {
    int[] unsorted;
    int[] unsortedMutable;
    String approachName;
    Duration processTime;
    ArrayList<Long> result;

    public _InsertionSort(int referenceArray[]) {
        this.unsorted = referenceArray;
        this.unsortedMutable = this.unsorted.clone();
        this.result = new ArrayList<>();

        Instant processStart = Instant.now();
        this.init();
        Instant processEnd = Instant.now();
        this.processTime = Duration.between(processStart, processEnd);
    }

    //public void assignData(long )

    protected abstract void init();

    public int getProcessTimeNano(){ return this.processTime.getNano(); }

    public int getProcessTimeSec(){ return (int)(this.processTime).getSeconds(); }


    public void printIt() {
        System.out.println("Approach: " + getApproachName());
        System.out.println("Speed: " + getProcessTimeNano() + " nano seconds");
        System.out.println("Reference Array: " + Arrays.toString(getUnsorted()));
        System.out.println("Sorted Array: " + Arrays.toString(getUnsortedMutable()));

    }
}