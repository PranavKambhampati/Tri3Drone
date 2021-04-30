package com.example.demo.Labs.AryanLinkedLists;
import java.util.*;

import com.example.demo.Labs.AryanInheritance.Cities;
import com.example.demo.Labs.AryanInheritance.LinkedLists;

public class AryanLinkedLists {

    public LinkedList<Object> addToLinkedList(Object[] objects) {
        //int length = objects.length;
        LinkedList<Object> cities = new LinkedList<Object>();
        for (Object t: objects) {
            cities.add(t);
        }
        return cities;
    }

    public LinkedList<Object> addElementToLinkedList(Object object, int index) {
        LinkedList<Object> cities = new LinkedList<Object>();
        cities.add(index,object);
        return cities;
    }



}
