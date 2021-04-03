package com.example.demo.Labs.michael.insertSortModel;

import java.util.ArrayList;
import java.util.List;

public class InsertSortFor extends _InsertionSort{

    private static List<Integer> speedRecords = new ArrayList<>();
    private static int rollingAverageSpeed = 1000;

    public InsertSortFor(String referenceArrayLiteral) {
        super(referenceArrayLiteral);

        this.speedRecords.add(this.getProcessTimeNano());
        rollingAverageSpeed = (rollingAverageSpeed + this.getProcessTimeNano()) / 2;
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
        if (speedRecords.size() <= 1) {
            return speedRecords.get(speedRecords.size() - 1);
        } else {
            return speedRecords.get(speedRecords.size() - 2);
        }
    }

    public int getRollingAverageSpeed() { return rollingAverageSpeed; }

    public static void main(String[] args){
        String referenceArrayLiteral = "7,6,3,1,9,2";
        _InsertionSort insertionSortFor = new InsertSortFor(referenceArrayLiteral);

        insertionSortFor.printIt();
    }
}
