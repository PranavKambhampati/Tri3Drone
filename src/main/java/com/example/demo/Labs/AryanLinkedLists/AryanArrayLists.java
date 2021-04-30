package com.example.demo.Labs.AryanLinkedLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AryanArrayLists {

    public ArrayList<Object> addingArrayList (Object[] objects) {
        int length = objects.length;
        ArrayList objects1 = new ArrayList<Object>(length);
        int number = 0;
        for (Object t: objects) {
            objects1.add(number, objects);
            number++;
        }
        return objects1;
    }

    public ArrayList<Object> BubbleSort (Object[] objects) {
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
        List<Object> arrayIntoObjects = Arrays.asList(objects);
        return (ArrayList<Object>) arrayIntoObjects;
    }


}
