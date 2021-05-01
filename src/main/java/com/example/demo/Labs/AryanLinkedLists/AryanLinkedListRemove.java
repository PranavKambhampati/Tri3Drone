package com.example.demo.Labs.AryanLinkedLists;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import com.example.demo.Labs.AryanInheritance.Cities;
import com.example.demo.Labs.AryanInheritance.LinkedLists;

public class AryanLinkedListRemove {

    public LinkedList<Object> totalArray = this.addToLinkedList(Cities.CityInfo());

    public LinkedList<Object> BubbleSortObjectAnswer;

    public String BubbleSortObjectPrintedAnswer;

    public String InitialBubbleSortObjectPrintedAnswer;

    public int timeForBubbleSorts;

    Duration r;

    public AryanLinkedListRemove(String cityName, String country, int population) {
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

    }

    public LinkedList<Object> addToLinkedList(Object[] objects) {
        LinkedList<Object> cities = new LinkedList<Object>();
        for (Object t: objects) {
            cities.add(t);
        }
        return cities;
    }
/*
    public LinkedList<Object> addElementToLinkedList(Object object, int index) {
        LinkedList<Object> cities = new LinkedList<Object>();
        cities.add(index,object);
        return cities;
    }

 */

    // Override previous method if user just wants to add objects without specifying indices
    public LinkedList<Object> addElementToLinkedList(Object object) {
        LinkedList<Object> cities = new LinkedList<Object>();
        cities.add(object);
        return cities;
    }

    public LinkedList<Object> deleteElementToLinkedList(Object object) {
        LinkedList<Object> cities = new LinkedList<Object>();
        cities.remove(object);
        return cities;
    }

    public LinkedList<Object> BubbleSort (LinkedList<Object> objects) {
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

    public String printArray(LinkedList<Object> arrayToSort) {
        String finalArray = "";
        for (int i = 0; i < arrayToSort.size(); i++) {
            if (finalArray.trim() != "") {
                finalArray += ", ";
            }
            finalArray += arrayToSort.get(i);
        }
        return finalArray;
    }







}
