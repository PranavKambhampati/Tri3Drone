package com.example.demo.Labs.NakulLinkedList;

import com.example.demo.Labs.NakulInheritance.Student;
import com.example.demo.Labs.PranavInheritence.Car;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListLab {
    public ArrayList<Object> linkedListData = new ArrayList<Object>();
    public ArrayList<Object> arrayListData = new ArrayList<Object>();

    Duration sort;
    Instant start;
    Instant end;

    public int arrayListSortTime;
    public int linkedListSortTime;

    public LinkedListLab(){
        arrayListData = this.addToArrayList(Student.studentData());
        for(Object obj: Student.studentData()){
            this.addNode(obj);
            linkedListData.add(obj);
        }
    }

    public ArrayList<Object> addToArrayList(Object[] objects) {
        return new ArrayList<>(Arrays.asList(objects));
    }

    public ArrayList<Object> bubbleSortArrayList(ArrayList<Object> arrayList) {
        boolean sorted = false;
        Object temp;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (arrayList.get(i).toString().compareTo(arrayList.get(i+1).toString()) > 0) {
                    temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i+1));
                    arrayList.set(i+1, temp);
                    sorted = false;
                }
            }
        }
        return arrayList;
    }

    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteNode(int position) {

        if (head == null) {
            return;
        }
        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        for (int i=0; temp!=null && i<position-1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            return;
        }

        Node next = temp.next.next;

        temp.next = next;
    }

    public void bubbleSortLinkedList() {

        Node current = head;
        Node index = null;
        Object temp;

        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.data.toString().compareTo(index.data.toString()) > 0) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public ArrayList<Object> returnList() {
        Node current = head;
        ArrayList<Object> temp = new ArrayList<Object>();
        if (head == null) {
            return temp;
        }
        while (current != null) {
            // Prints each node by incrementing pointer
            temp.add(current.data);
            current = current.next;
        }
        return temp;
    }


}
