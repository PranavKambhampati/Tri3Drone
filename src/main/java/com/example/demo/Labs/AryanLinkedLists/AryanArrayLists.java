package com.example.demo.Labs.AryanLinkedLists;

import java.util.ArrayList;

public class AryanArrayLists {

    public ArrayList addingArrayList (Object[] objects) {
        int length = objects.length;
        ArrayList objects1 = new ArrayList<Object>(length);
        int number = 0;
        for (Object t: objects) {
            objects1.add(number, objects);
            number++;
        }
        return objects1;
    }


}
