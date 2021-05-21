package com.example.demo.Labs.PranavSorts;

import java.time.Duration;
import java.time.Instant;

public class PranavStringSorts {

    public String[] bubbleanswer;
    public String bubbleprintanswer;
    public int bubblesorttime;

    public String[] selectanswer;
    public String selectprintanswer;
    public int selectsorttime;

    public String[] insertanswer;
    public String insertprintanswer;
    public int insertsorttime;

    Duration a;
    Duration b;
    Duration c;

    public String fastestsortalgo;



    public PranavStringSorts(String strtotal){
        String[] arrtotal = new String[5];
        if(strtotal.trim() == ""){
            strtotal = "a,a,a,a,a";
        }
        String[] arraysort = strtotal.split(",");
        for (int i = 0; i < arraysort.length; i++) {
            arrtotal[i]=arraysort[i];
        }
        Instant startCalc = Instant.now();
        bubbleanswer = BubbleSortString(arrtotal);
        bubbleprintanswer = SortIntPrinter(bubbleanswer);
        Instant endCalc = Instant.now();
        a = Duration.between(startCalc, endCalc);
        bubblesorttime = a.getNano();

        Instant start = Instant.now();
        selectanswer = SelectionSortString(arrtotal);
        selectprintanswer = SortIntPrinter(selectanswer);
        Instant end = Instant.now();
        b = Duration.between(start,end);
        selectsorttime = b.getNano();


        Instant s = Instant.now();
        insertanswer = InsertionSortString(arrtotal);
        insertprintanswer = SortIntPrinter(insertanswer);
        Instant e= Instant.now();
        c = Duration.between(s,e);
        insertsorttime = c.getNano();

        fastestsortalgo = fastestsort(arrtotal);


    }


    public String[] BubbleSortString(String[] arr) {

        String temp;
        int n =arr.length;

        //Sorting strings using bubble sort
        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                if (arr[j].compareTo(arr[i]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }



    public String[] SelectionSortString( String[] array )
    {
        // Find the string reference that should go in each cell of
        // the array, from cell 0 to the end
        for ( int j=0; j < array.length-1; j++ )
        {
            // Find min: the index of the string reference that should go into cell j.
            // Look through the unsorted strings (those at j or higher) for the one that is first in lexicographic order
            int min = j;
            for ( int k=j+1; k < array.length; k++ )
                if ( array[k].compareTo( array[min] ) < 0 ) min = k;

            // Swap the reference at j with the reference at min
            String temp = array[j];
            array[j] = array[min];
            array[min] = temp;
        }
        return array;
    }



    public static String[] InsertionSortString(String array[]){
        String temp="";
        int f = array.length;
        for(int i=0;i<f;i++){
            for(int j=i+1;j<f;j++){
                if(array[i].compareToIgnoreCase(array[j])>0){
                    temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }


    public String SortIntPrinter(String arr[]){
        String answer = "";
        for(String j: arr){
            if (answer.trim() != ""){
                answer += ",";
            }
            answer += j;
        }
        return answer;
    }

    public String fastestsort(String[] arr){

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
