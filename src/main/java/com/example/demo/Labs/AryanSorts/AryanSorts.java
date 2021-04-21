package com.example.demo.Labs.AryanSorts;

import java.time.Duration;
import java.time.Instant;


public class AryanSorts {

    public int [] BubbleSortAnswer;

    public String BubbleSortPrintedAnswer;

    public int [] SelectionSortAnswer;

    public String SelectionSortPrintedAnswer;

    public int timeForBubbleSorts;

    public int timeForSelectionSorts;

    Duration r;
    Duration f;
    Duration s;

    public AryanSorts(int [] totalArray) {
        Instant startCalc = Instant.now();
        BubbleSortAnswer = BubbleSort(totalArray);
        BubbleSortPrintedAnswer = printBubbleSort(BubbleSortAnswer);
        Instant endCalc = Instant.now();
        r = Duration.between(startCalc, endCalc);
        timeForBubbleSorts = r.getNano();

        Instant startCalc1 = Instant.now();
        SelectionSortAnswer = SelectionSort(totalArray);
        SelectionSortPrintedAnswer = printBubbleSort(SelectionSortAnswer);

        Instant endCalc1 = Instant.now();
        f = Duration.between(startCalc1, endCalc1);
        timeForSelectionSorts = f.getNano();

    }

    public AryanSorts(String strTotalArray) {
        int[] totalArray = new int[5];
        if (strTotalArray.trim() == "") {
            strTotalArray = "1,1,1,1,1";
        }
        String [] arrayToSort = strTotalArray.split(",");
        for (int i = 0; i < arrayToSort.length; i++) {
            totalArray[i]=Integer.parseInt(arrayToSort[i]);
        }
        Instant startCalc = Instant.now();
        BubbleSortAnswer = BubbleSort(totalArray);
        BubbleSortPrintedAnswer = printBubbleSort(BubbleSortAnswer);
        Instant endCalc = Instant.now();
        r = Duration.between(startCalc, endCalc);
        timeForBubbleSorts = r.getNano();

        Instant startCalc1 = Instant.now();
        SelectionSortAnswer = SelectionSort(totalArray);
        SelectionSortPrintedAnswer = printBubbleSort(SelectionSortAnswer);

        Instant endCalc1 = Instant.now();
        f = Duration.between(startCalc1, endCalc1);
        timeForSelectionSorts = f.getNano();

    }



    public int[] BubbleSort(int[] arrayToSort) {
        int length = arrayToSort.length;

        for (int i = 0; i < length-1; i++) {
            for (int k = 0; k < length-i-1; k++) {

                if (arrayToSort[k] > arrayToSort[k+1]) {
                    int temporaryIndex = arrayToSort[k];
                    arrayToSort[k] = arrayToSort[k+1];
                    arrayToSort[k+1] = temporaryIndex;
                }
            }
        }
        return arrayToSort;
    }

    public String printBubbleSort(int [] arrayToSort) {
        String finalArray = "";
        for (int i = 0; i < arrayToSort.length; i++) {
            if (finalArray.trim() != "") {
                finalArray += ", ";
            }
            finalArray += arrayToSort[i];
        }
        return finalArray;
    }

    public int[] SelectionSort(int [] arrayToSort) {
        int length = arrayToSort.length;
        for (int i = 0; i < length - 1; i++) {
            int lowestNumber = i;
            for (int o = length +1; o < length; o++) {
                if (arrayToSort[o] < arrayToSort[lowestNumber]) {
                    lowestNumber = o;
                }
            }
            int temporaryIndex = arrayToSort[lowestNumber];
            arrayToSort[lowestNumber] = arrayToSort[i];
            arrayToSort[i] = temporaryIndex;
            }
        return arrayToSort;
        }
    public int [] printSelectionSort(int [] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i] + " ");
        }
        return arrayToSort;
    }

}
