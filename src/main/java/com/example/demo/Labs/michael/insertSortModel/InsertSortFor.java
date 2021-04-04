package com.example.demo.Labs.michael.insertSortModel;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InsertSortFor extends _InsertionSort{
    /* Statics for time analysis */
    private static List<Integer> speedRecords = new ArrayList<>();
    private static int rollingAverageSpeed;
    private static int timeComparedToAverage;

    public InsertSortFor(String referenceArrayLiteral) {
        super(referenceArrayLiteral);

        this.speedRecords.add(this.getProcessTimeNano());

        staticInit();
    }

    @Override
    protected void init() {
        super.approachName = "For";
        int length = super.unsortedMutable.length;

        for (int i = 1; i < length; ++i) {
            int currentPosition = unsortedMutable[i];
            int leftOfPosition = i - 1;

            while (leftOfPosition >= 0 && unsortedMutable[leftOfPosition] > currentPosition) {
                unsortedMutable[leftOfPosition + 1] = unsortedMutable[leftOfPosition];
                leftOfPosition = leftOfPosition - 1;
            }
            unsortedMutable[leftOfPosition + 1] = currentPosition;
        }
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
        _InsertionSort insertionSortFor = new InsertSortFor(referenceArrayLiteral);

        insertionSortFor.printIt();
    }
}
