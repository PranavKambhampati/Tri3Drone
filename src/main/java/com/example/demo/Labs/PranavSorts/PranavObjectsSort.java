package com.example.demo.Labs.PranavSorts;

import com.example.demo.Labs.PranavInheritence.Car;
import java.time.*;
import java.util.Arrays;

public class PranavObjectsSort {

    public Object[] bubbleanswer;
    public String bubbleprintanswer;
    public int bubblesorttime;
    Duration a;

    public Object[] selectanswer;
    public String selectprintanswer;
    public int selectsorttime;
    Duration b;

    public Object[] insertanswer;
    public String insertprintanswer;
    public int insertsorttime;
    Duration c;

    public String fastestsortalgo;

    public Object[] mainarray = this.makearray(Car.carData());

    public PranavObjectsSort(String strtotal){
        Instant startCalc = Instant.now();
        bubbleanswer = BubbleSortObject(mainarray);
        bubbleprintanswer = SortObjectPrinter(bubbleanswer);
        Instant endCalc = Instant.now();
        a = Duration.between(startCalc, endCalc);
        bubblesorttime = a.getNano();

        Instant start = Instant.now();
        selectanswer = SelectionSortObject(mainarray);
        selectprintanswer = SortObjectPrinter(selectanswer);
        Instant end = Instant.now();
        b = Duration.between(start,end);
        selectsorttime = b.getNano();

        Instant s = Instant.now();
        insertanswer = InsertionSortObject(mainarray);
        insertprintanswer = SortObjectPrinter(insertanswer);
        Instant e= Instant.now();
        c = Duration.between(s,e);
        insertsorttime = c.getNano();

        fastestsortalgo = fastestsort(mainarray);
    }

    public Object[] makearray(Object[] arr){
        Object[] array = new Object[arr.length];
        int index = 0;
        for(Object obj: arr){
            array[index] = obj;
            index++;
        }
        return array;
    }

    public Object[] BubbleSortObject(Object[] mixed){
        for(int i=0; i<mixed.length-1; i++){
            for(int j=0; j<mixed.length-i-1;j++){
                if(mixed[j].toString().compareTo(mixed[j+1].toString())>0){
                    Object temp = mixed[j];
                    mixed[j]=mixed[j+1];
                    mixed[j+1]=temp;
                }
            }
        }
        return mixed;
    }

    public Object[] SelectionSortObject(Object[] mixed){
        for (int i = 0; i < mixed.length - 1; i++) {
            int lowestNumber = i;
            for (int j = mixed.length +1; j < mixed.length; j++) {
                if (mixed[j].toString().compareTo(mixed[j+1].toString())<0) {
                    lowestNumber = j;
                }
            }
            Object temp=mixed[lowestNumber];
            mixed[lowestNumber]=mixed[i];
            mixed[i]=temp;
        }
        return mixed;
    }

    public Object[] InsertionSortObject(Object arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Object key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j].toString().compareTo(key.toString()) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public String SortObjectPrinter(Object[] arr){
        String answer = "";
        for(Object j: arr){
            if (answer.trim() != ""){
                answer += ",";
            }
            answer += j;
        }
        return answer;
    }

    public String fastestsort(Object[] arr){

        if ((bubblesorttime < insertsorttime) && (bubblesorttime < selectsorttime)) {
            fastestsortalgo = "bubble sort";
        }
        if ((selectsorttime < insertsorttime) && (selectsorttime < bubblesorttime)) {
            fastestsortalgo = "selection sort";
        }
        if ((insertsorttime < bubblesorttime) && (insertsorttime < selectsorttime)) {
            fastestsortalgo = "insertion sort";
        }
        if ((bubblesorttime == selectsorttime)) {
            fastestsortalgo = "bubble sort and selection sort";
        }
        if ((bubblesorttime == insertsorttime)) {
            fastestsortalgo = "bubble sort and insertion sort";
        }
        if ((selectsorttime == insertsorttime)) {
            fastestsortalgo = "selection sort and insertion sort";
        }
        return fastestsortalgo;

    }
}
