//Initial Attempt, this file is no longer being used in the controller
//Go to SortList for the updated code

package com.example.demo.Labs.PranavLinkedList;

import com.example.demo.Labs.PranavInheritence.Car;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

public class LinkedListMaster {
    public LinkedList<Object> bubbleanswer;
    public String answer;
    public int bubblesorttime;
    Duration a;

    LinkedList<Object> mainlinkedlist = this.makell(Car.carData());
    public String unsorted = LinkedListPrinter(mainlinkedlist);

    public LinkedListMaster(){
        Instant startCalc = Instant.now();
        bubbleanswer = BubbleSort(mainlinkedlist);
        answer = LinkedListPrinter(bubbleanswer);
        Instant endCalc = Instant.now();
        a = Duration.between(startCalc,endCalc);
        bubblesorttime = a.getNano();
    }

    public LinkedList<Object> makell(Object[] arr){
        LinkedList<Object> temp = new LinkedList<Object>();
        for(Object obj: arr){
            temp.add(obj);
        }
        return temp;
    }

    public LinkedList<Object> BubbleSort(LinkedList<Object> passin){
        Object temp;
        boolean sorted = false;

        while(!sorted){
            sorted = true;
            for (int i =0; i<passin.size()-1;i++){
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

    public String LinkedListPrinter(LinkedList<Object> listy){
        String answer = "";
        for(Object j: listy){
            if (answer.trim() != ""){
                answer += " || ";
            }
            answer += j;
        }
        return answer;
    }



}
