package com.example.demo.Labs.AryanLinkedLists;

import com.example.demo.Labs.AryanInheritance.Cities;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

public class AryanArrayListDelete {
    public ArrayList<Object> totalArray = this.addingArrayList(Cities.CityInfo());

    public ArrayList<Object> randomArrayListOrder;

    public ArrayList<Object> BubbleSortObjectAnswer;

    public String BubbleSortObjectPrintedAnswer;

    public String InitialBubbleSortObjectPrintedAnswer;

    public ArrayList<Object> InsertedArrayListElement;

    public String fastestSort1;

    public int timeForBubbleSorts;

    Duration r;
    Duration t;

    public AryanArrayListDelete (String cityName, String country, int population) {

        Cities newCity = new Cities(cityName,country,population);
        totalArray.remove(newCity);

        Collections.shuffle(totalArray);
        InitialBubbleSortObjectPrintedAnswer = printArray(totalArray);
        Instant startCalc = Instant.now();
        BubbleSortObjectAnswer = BubbleSort(totalArray);
        BubbleSortObjectPrintedAnswer = printArray(BubbleSortObjectAnswer);
        Instant endCalc = Instant.now();
        r = Duration.between(startCalc, endCalc);
        timeForBubbleSorts = r.getNano();

        Instant startCalc2 = Instant.now();

    }


    public ArrayList<Object> addingArrayList (Object[] objects) {
        ArrayList objects1 = new ArrayList<Object>();
        for (Object t: objects) {
            objects1.add(t);
        }
        return objects1;
    }


    public ArrayList<Object> BubbleSort (ArrayList<Object> objects) {
        int length = objects.size();
        for (int i = 0; i < length - 1; i++) {
            for (int k = 0; k < length - i - 1; k++) {

                if (objects.get(k).toString().compareTo(objects.get(k+1).toString()) > 0) {
                    Object temporaryIndex = objects.get(k);
                    objects.set(k, objects.get(k+1));
                    objects.set(k+1, temporaryIndex);
                }
            }
        }
        return objects;
    }




    public ArrayList<Object> deleteFromArrayList(Cities c) {
        ArrayList objects1 = new ArrayList<Object>();
        objects1.remove(c);
        return BubbleSort(objects1);
    }

    public String printArray(ArrayList<Object> arrayToSort) {
        String finalArray = "";
        for (int i = 0; i < arrayToSort.size(); i++) {
            if (finalArray.trim() != "") {
                finalArray += ", ";
            }
            finalArray += arrayToSort.get(i);
        }
        return finalArray;
    }

    /*
    public static void main(String[] args) {
        AryanArrayLists hi = new AryanArrayLists();
        ArrayList<Object> objTest = hi.addingArrayList(Cities.CityInfo());
        objTest = hi.BubbleSort(objTest);
        System.out.println(hi.printArray(objTest));
    }
    // Testing Purposes

     */
}
