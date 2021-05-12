package com.example.demo.Labs.NakulBinarySearch;

import com.example.demo.Labs.NakulInheritance.Student;
import com.example.demo.Labs.NakulLinkedList.LinkedListLab;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchLab {
    public ArrayList<Object> linkedListData = new ArrayList<Object>();
    public ArrayList<Object> arrayListData = new ArrayList<Object>();

    public int arrayListSearchTime;
    public int linkedListSearchTime;

    public BinarySearchLab(){
        arrayListData = this.addToArrayList(Student.studentData());
        for(Object obj: Student.studentData()){
            this.addNode(obj);
            linkedListData.add(obj);
        }
    }

    public ArrayList<Object> addToArrayList(Object[] objects) {
        return new ArrayList<>(Arrays.asList(objects));
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

    public Node middleNode(Node start, Node last)
    {
        if (start == null)
            return null;

        Node slow = start;
        Node fast = start.next;

        while (fast != last)
        {
            fast = fast.next;
            if (fast != last)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    // function to insert a node at the beginning
    // of the Singly Linked List
    public Node binarySearchLinked(Node head, String value) {
        Node start = head;
        Node last = null;

        do {
            Node mid = middleNode(start, last);

            if (mid == null) {
                return null;
            }

            if (mid.data.toString().compareTo(value) == 0 ) {
                return mid;
            }

            else if (mid.data.toString().compareTo(value) < 0) {
                start = mid.next;
            }

            else {
                last = mid;
            }

        } while (last == null || last != start);

        // value not present
        return null;
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

    public Object binarySearchArray(ArrayList<Object> arr, String x)
    {
        int left = 0, right = arr.size() - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr.get(mid).toString().compareTo(x) == 0)
                return mid;

            // If x greater, ignore left half
            if (arr.get(mid).toString().compareTo(x) < 0)
                left = mid + 1;

                // If x is smaller, ignore right half
            else
                right = mid - 1;
        }

        // if we reach here, then element was
        // not present
        return null;
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
