package com.example.demo.Labs.AryanSorts;

import com.example.demo.Labs.AryanInheritance.Languages;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class AryanSortsObjects {

    public Object[] totalArray = this.addingArray(Languages.LanguageInfo());

    public Object[] BubbleSortObjectAnswer;

    public String BubbleSortObjectPrintedAnswer;

    public Object [] SelectionSortAnswer;

    public String SelectionSortPrintedAnswer;

    public Object [] InsertionSortAnswer;

    public String InsertionSortPrintedAnswer;

    public int timeForBubbleSorts;

    public int timeForSelectionSorts;

    public int timeForInsertionSorts;

    public String fastestSort;

    Duration r;
    Duration f;
    Duration s;

    public AryanSortsObjects(String strTotalArray) {
        Instant startCalc = Instant.now();
        BubbleSortObjectAnswer = BubbleSort(totalArray);
        BubbleSortObjectPrintedAnswer = printArray(BubbleSortObjectAnswer);
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
    public Object [] addingArray (Object[] objects) {
        int length = objects.length;
        Object [] arrays = new Object[length];
        int number = 0;
        for (Object t: objects) {
            arrays[number] = t;
            number++;
        }
        return arrays;
    }

    public Object[] BubbleSort (Object[] objects) {
            int length = objects.length;


            for (int i = 0; i < length - 1; i++) {
                for (int k = 0; k < length - i - 1; k++) {

                    if (objects[k].toString().compareTo(objects[k+1].toString()) > 0) {
                        Object temporaryIndex = objects[k];
                        objects[k] = objects[k+1];
                        objects[k+1] = temporaryIndex;
                    }
                }
            }
            return objects;
        }

    public Object[] SelectionSort(Object [] arrayToSort) {
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            int lowestNumber = i;
            for (int o = i + 1; o < arrayToSort.length; o++) {
                if (arrayToSort[o].toString().compareTo(arrayToSort[lowestNumber].toString()) < 0) {
                    lowestNumber = o;
                }
            }
            Object temporaryIndex = arrayToSort[i];
            arrayToSort[i] = arrayToSort[lowestNumber];
            arrayToSort[lowestNumber] = temporaryIndex;
        }
        return arrayToSort;
    }

    public Object[] InsertionSort(Object [] arrayToSort) {
        int length = arrayToSort.length;
        for (int i = 1; i < length; i++) {
            Object lowestNumber = arrayToSort[i];
            int t = i - 1;
            while (t >= 0 && arrayToSort[t].toString().compareTo(lowestNumber.toString()) > 0) {
                arrayToSort[t + 1] = arrayToSort [t];
                t = t - 1;
            }
            arrayToSort[t+1] = lowestNumber;
        }
        return arrayToSort;
    }

    public String printArray(Object [] arrayToSort) {
        String finalArray = "";
        for (int i = 0; i < arrayToSort.length; i++) {
            if (finalArray.trim() != "") {
                finalArray += ", ";
            }
            finalArray += arrayToSort[i];
        }
        return finalArray;
    }

    public String getFastestSort(Object [] arr) {
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

