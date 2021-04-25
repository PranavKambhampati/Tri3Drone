//As of right now, only ints are sorted

package com.example.demo.Labs.PranavSorts;

import java.time.Duration;
import java.time.Instant;

public class PranavSorts {

    public int[] bubbleanswer;
    public String bubbleprintanswer;
    public int bubblesorttime;

    public int[] selectanswer;
    public String selectprintanswer;
    public int selectsorttime;

    public int[] insertanswer;
    public String insertprintanswer;
    public int insertsorttime;

    Duration a;
    Duration b;
    Duration c;



    public PranavSorts(String strtotal){
        int[] arrtotal = new int[5];
        if(strtotal.trim() == ""){
            strtotal = "1,1,1,1,1";
        }
        String[] arraysort = strtotal.split(",");
        for (int i = 0; i < arraysort.length; i++) {
            arrtotal[i]=Integer.parseInt(arraysort[i]);
        }
        Instant startCalc = Instant.now();
        bubbleanswer = BubbleSortInt(arrtotal);
        bubbleprintanswer = SortIntPrinter(bubbleanswer);
        Instant endCalc = Instant.now();
        a = Duration.between(startCalc, endCalc);
        bubblesorttime = a.getNano();

        Instant start = Instant.now();
        selectanswer = SelectionSortInt(arrtotal);
        selectprintanswer = SortIntPrinter(selectanswer);
        Instant end = Instant.now();
        b = Duration.between(start,end);
        selectsorttime = b.getNano();


        Instant s = Instant.now();
        insertanswer = InsertionSortInt(arrtotal);
        insertprintanswer = SortIntPrinter(insertanswer);
        Instant e= Instant.now();
        c = Duration.between(s,e);
        insertsorttime = c.getNano();


    }

    public int[] BubbleSortInt(int[] mixed){
        for(int i=0; i<mixed.length-1; i++){
            for(int j=0; j<mixed.length-i-1;j++){
                if(mixed[j]>mixed[j+1]){
                    int temp = mixed[j];
                    mixed[j]=mixed[j+1];
                    mixed[j+1]=temp;
                }
            }
        }
        return mixed;
    }

    public int[] SelectionSortInt(int[] mixed){
        for (int i = 0; i < mixed.length - 1; i++) {
            int lowestNumber = i;
            for (int j = mixed.length +1; j < mixed.length; j++) {
                if (mixed[j] < mixed[lowestNumber]) {
                    lowestNumber = j;
                }
            }
            int temp=mixed[lowestNumber];
            mixed[lowestNumber]=mixed[i];
            mixed[i]=temp;
        }
        return mixed;
    }

    public int[] InsertionSortInt(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public String SortIntPrinter(int[] arr){
        String answer = "";
        for(int j: arr){
            if (answer.trim() != ""){
                answer += ",";
            }
            answer += j;
        }
        return answer;
    }



}
