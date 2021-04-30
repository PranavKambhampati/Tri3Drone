package com.example.demo.Labs.PranavLinkedList;
import com.example.demo.Labs.PranavInheritence.*;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class PranavArrayList {

    public ArrayList<Object> bubbleanswer;
    public String answer;
    public int bubblesorttime;
    Duration a;

    public ArrayList<Object> mainarraylist = this.makearraylist(Car.carData());
    public String unsorted = ArrayListPrinter(mainarraylist);

    public PranavArrayList(){ //Need to complete
        Instant startCalc = Instant.now();
        bubbleanswer = BubbleSort(mainarraylist);
        answer = ArrayListPrinter(bubbleanswer);
        Instant endCalc = Instant.now();
        a = Duration.between(startCalc,endCalc);
        bubblesorttime = a.getNano();
    }

    public ArrayList<Object> makearraylist(Object[] arr){
        ArrayList<Object> temp = new ArrayList<Object>();
        for(Object obj: arr){
            temp.add(obj);
        }
        return temp;
    }

    public ArrayList<Object> BubbleSort(ArrayList<Object> passin){
        Object temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < passin.size()-1; i++) {
                if (passin.get(i).toString().compareTo(passin.get(i + 1).toString()) > 0) {
                    temp = passin.get(i);
                    passin.set(i, passin.get(i + 1));
                    passin.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return passin;
    }

    public String ArrayListPrinter(ArrayList<Object> arr){
        String answer = "";
        for(Object j: arr){
            if (answer.trim() != ""){
                answer += " || ";
            }
            answer += j;
        }
        return answer;
    }



}
