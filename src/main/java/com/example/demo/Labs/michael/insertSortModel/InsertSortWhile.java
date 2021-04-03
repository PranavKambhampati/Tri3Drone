package com.example.demo.Labs.michael.insertSortModel;

import java.util.ArrayList;
import java.util.List;

public class InsertSortWhile extends _InsertionSort {

    private static List<Integer> speedRecords = new ArrayList<>();
    private static int rollingAverageSpeed = 1000;

    public InsertSortWhile(String referenceArrayLiteral) {
        super(referenceArrayLiteral);

        this.speedRecords.add(this.getProcessTimeNano());
        rollingAverageSpeed = (rollingAverageSpeed + this.getProcessTimeNano()) / 2;
    }


    @Override
    protected void init() {
        super.approachName = "While";

        int i;
        int j;
        int temp;
        int length = super.unsortedMutable.length;

        for (i = 1; i < length; i++)
        {
            j = i - 1;
            while (j >= 0 && unsortedMutable[j] > unsortedMutable[i] )
            {
                temp = unsortedMutable[i];
                unsortedMutable[i] = unsortedMutable[j];
                unsortedMutable[j] = temp;
                i = j;
                j--;
            }
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
        _InsertionSort insertionSortWhile = new InsertSortWhile(referenceArrayLiteral);

        insertionSortWhile.printIt();
    }
}
