package com.example.demo.Labs.PranavLinkedList;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import com.example.demo.Labs.PranavInheritence.*;


public class SortList {

    public LinkedList<Object> main;
    public String answer;
    public int bubblesorttime;
    Duration a;

    SortList j;

    public SortList(){
        for(Object obj: Car.carData()){
            this.addNode(obj);
        }
        this.display();
        Instant startCalc = Instant.now();
        this.sortList();
        Instant endCalc = Instant.now();
        a = Duration.between(startCalc,endCalc);
        bubblesorttime = a.getNano();
        this.display();
        answer = this.ListPrinter();
    }


    class Node {
        Object data;
        Node next;

        public Node(Object data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(Object data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void sortList(){ //Method to sort LinkedList by using BubbleSort
        Node current = head, index = null;

        Object temp; //might need to be changed;

        if (head == null) {
            return;
        }
        else{
            while(current != null){
                index = current.next;
                while(index != null){
                    if(current.data.toString().compareTo(index.data.toString())>0){ //Might need to change > sign
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

    public void display()
    {
        // Node current will point to head
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            // Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public String ListPrinter(){
        String answer = "";
        Node current = head;
        while(current!=null){
            if (answer.trim() != ""){
                answer += " ||| ";
            }
            answer += current.data;
            current = current.next;
        }
        return answer;
    }

    /*
    public static void main(String[] args) {
        SortList sList = new SortList();
        for(Object obj: Car.carData()){
            sList.addNode(obj);
        }
        sList.display();
        sList.sortList();
        sList.display();
    }

     */
}
