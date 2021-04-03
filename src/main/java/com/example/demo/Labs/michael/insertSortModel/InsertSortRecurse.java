package com.example.demo.Labs.michael.insertSortModel;

import java.util.ArrayList;
import java.util.List;

public class InsertSortRecurse extends _InsertionSort {

    private static List<Integer> speedRecords = new ArrayList<>();
    private static int rollingAverageSpeed = 1000;

    public InsertSortRecurse(String referenceArrayLiteral) {
        super(referenceArrayLiteral);

        this.speedRecords.add(this.getProcessTimeNano());
        rollingAverageSpeed = (rollingAverageSpeed + this.getProcessTimeNano()) / 2;
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
        if (speedRecords.size() <= 1) {
            return speedRecords.get(speedRecords.size() - 1);
        } else {
            return speedRecords.get(speedRecords.size() - 2);
        }
    }

    public int getRollingAverageSpeed() { return rollingAverageSpeed; }

    public static void main(String[] args){
        String referenceArrayLiteral = "7,6,3,1,9,2";
        _InsertionSort insertionSortRecurse = new InsertSortRecurse(referenceArrayLiteral);

        insertionSortRecurse.printIt();
    }
}
