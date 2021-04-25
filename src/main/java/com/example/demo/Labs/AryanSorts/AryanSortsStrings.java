package com.example.demo.Labs.AryanSorts;

import java.time.Duration;
import java.time.Instant;

public class AryanSortsStrings {

    public String [] BubbleSortAnswer;

    public String BubbleSortPrintedAnswer;

    public String [] SelectionSortAnswer;

    public String SelectionSortPrintedAnswer;

    public String [] InsertionSortAnswer;

    public String InsertionSortPrintedAnswer;

    public int timeForBubbleSorts;

    public int timeForSelectionSorts;

    public int timeForInsertionSorts;

    public String fastestSort;

    Duration r;
    Duration f;
    Duration s;

    public AryanSortsStrings(String strTotalArray) {
        String[] totalArray = new String[5];
        if (strTotalArray.trim() == "") {
            strTotalArray = "t,t,t,t,t";
        }
        String [] arrayToSort = strTotalArray.split(",");
        for (int i = 0; i < arrayToSort.length; i++) {
            totalArray[i]= arrayToSort[i].trim();
        }
        Instant startCalc = Instant.now();
        BubbleSortAnswer = BubbleSort(totalArray);
        BubbleSortPrintedAnswer = printArray(BubbleSortAnswer);
        Instant endCalc = Instant.now();
        r = Duration.between(startCalc, endCalc);
        timeForBubbleSorts = r.getNano();

        Instant startCalc1 = Instant.now();
        SelectionSortAnswer = SelectionSort(totalArray);
        SelectionSortPrintedAnswer = printArray(SelectionSortAnswer);
        Instant endCalc1 = Instant.now();
        f = Duration.between(startCalc1, endCalc1);
        timeForSelectionSorts = f.getNano();

        Instant startCalc2 = Instant.now();
        InsertionSortAnswer = InsertionSort(totalArray);
        InsertionSortPrintedAnswer = printArray(InsertionSortAnswer);
        Instant endCalc2 = Instant.now();
        s = Duration.between(startCalc2, endCalc2);
        timeForInsertionSorts = s.getNano();

        fastestSort = getFastestSort(totalArray);

    }

    public String[] BubbleSort(String[] arrayToSort) {
        int length = arrayToSort.length;

        for (int i = 0; i < length-1; i++) {
            for (int k = 0; k < length-i-1; k++) {

                if (arrayToSort[k].compareTo(arrayToSort[k+1]) > 0) {
                    String temporaryIndex = arrayToSort[k];
                    arrayToSort[k] = arrayToSort[k+1];
                    arrayToSort[k+1] = temporaryIndex;
                }
            }
        }
        return arrayToSort;
    }

    public String printArray(String [] arrayToSort) {
        String finalArray = "";
        for (int i = 0; i < arrayToSort.length; i++) {
            if (finalArray.trim() != "") {
                finalArray += ", ";
            }
            finalArray += arrayToSort[i];
        }
        return finalArray;
    }

    public String[] SelectionSort(String [] arrayToSort) {
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            int lowestNumber = i;
            for (int o = i + 1; o < arrayToSort.length; o++) {
                if (arrayToSort[o].compareTo(arrayToSort[lowestNumber]) < 0) {
                    lowestNumber = o;
                }
            }
            String temporaryIndex = arrayToSort[i];
            arrayToSort[i] = arrayToSort[lowestNumber];
            arrayToSort[lowestNumber] = temporaryIndex;
        }
        return arrayToSort;
    }

    public String[] InsertionSort(String [] arrayToSort) {
        int length = arrayToSort.length;
        for (int i = 1; i < length; i++) {
            String lowestNumber = arrayToSort[i];
            int t = i - 1;
            while (t >= 0 && arrayToSort[t].compareTo(lowestNumber) > 0) {
                arrayToSort[t + 1] = arrayToSort [t];
                t = t - 1;
            }
            arrayToSort[t+1] = lowestNumber;
        }
        return arrayToSort;
    }

    public String getFastestSort(String [] arr) {
        if ((timeForBubbleSorts < timeForInsertionSorts) && (timeForBubbleSorts < timeForSelectionSorts)) {
            fastestSort = "bubble sorts";
        }
        if ((timeForSelectionSorts < timeForInsertionSorts) && (timeForSelectionSorts < timeForBubbleSorts)) {
            fastestSort = "selection sorts";
        }
        if ((timeForInsertionSorts < timeForBubbleSorts) && (timeForInsertionSorts < timeForSelectionSorts)) {
            fastestSort = "insertion sorts";
        }
        if ((timeForBubbleSorts == timeForSelectionSorts)) {
            fastestSort = "bubble sorts and selection sorts";
        }
        if ((timeForBubbleSorts == timeForInsertionSorts)) {
            fastestSort = "bubble sorts and insertion sorts";
        }
        if ((timeForSelectionSorts == timeForInsertionSorts)) {
            fastestSort = "selection sorts and insertion sorts";
        }
        return fastestSort;
    }


}
