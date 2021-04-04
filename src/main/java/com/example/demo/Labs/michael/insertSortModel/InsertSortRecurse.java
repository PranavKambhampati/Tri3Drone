package com.example.demo.Labs.michael.insertSortModel;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InsertSortRecurse extends _InsertionSort {
    /* Statics for time analysis */
    private static List<Integer> speedRecords = new ArrayList<>();
    private static int rollingAverageSpeed;
    private static int timeComparedToAverage;


    public InsertSortRecurse(String referenceArrayLiteral) {
        super(referenceArrayLiteral);

        this.speedRecords.add(this.getProcessTimeNano());

        staticInit();
    }

    @Override
    protected void init() {
        super.approachName = "Recursion";
        int length = super.unsortedMutable.length;

        super.unsortedMutable = recurseIt(unsortedMutable, length);
    }

    private int[] recurseIt(int[] unsortedArray, int length) {

            if (length <= 1) {
                return unsortedArray; // "base case" exit, begins unfurling of recursive stack
            }

            recurseIt(unsortedArray, length - 1);

            int last = unsortedArray[length - 1];
            int shift = length - 2;

            while (shift >= 0 && unsortedArray[shift] > last)
            {
                unsortedArray[shift + 1] = unsortedArray[shift];
                shift--;
            }
            unsortedArray[shift + 1] = last;

            return unsortedArray;
    }

    public int getLastSpeedRecord() {
        /* Index out of bounds exception avoidance via simple logic */
        if (speedRecords.size() <= 1) {
            return speedRecords.get(speedRecords.size() - 1);
        } else {
            return speedRecords.get(speedRecords.size() - 2);
        }
    }

    /* Static getters applicable to purpose of statics (used in th HTML) */
    public int getRollingAverageSpeed() { return rollingAverageSpeed; }

    public int getTimeComparedToAverage() { return timeComparedToAverage;}


    /**
     * Uses speed records created for each activation and creates a rolling average
     * and comparison to rolling average
     */
    public void staticInit() {
        if (speedRecords.size() <= 1){
            rollingAverageSpeed = this.getProcessTimeNano();
        } else {
            rollingAverageSpeed = (rollingAverageSpeed + this.getProcessTimeNano()) / 2;
        }

        timeComparedToAverage = rollingAverageSpeed - this.getProcessTimeNano();
    }

    public static void main(String[] args){
        String referenceArrayLiteral = "7,6,3,1,9,2";
        _InsertionSort insertionSortRecurse = new InsertSortRecurse(referenceArrayLiteral);

        insertionSortRecurse.printIt();
    }
}
