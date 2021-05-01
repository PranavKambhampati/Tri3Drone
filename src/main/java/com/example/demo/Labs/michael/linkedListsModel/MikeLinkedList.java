package com.example.demo.Labs.michael.linkedListsModel;

import com.example.demo.Labs.michael.trackModel.Distance;

public class MikeLinkedList {
    NodePtr head;

    public void insert(Distance data) {
        /* new candidate node */
        NodePtr node = new NodePtr();
        node.setData(data);
        node.setNext(null); // readability for end of a LinkedList (next node is null because there is no data to point to)

        if (this.head == null) { // if this piece of data is the first in the LinkedList, since NodePtr head has no "new" it is null
            this.head = node;
        } else {
            NodePtr nodeIterable = this.head; // start of LinkedList
            while (nodeIterable.getNext() != null) { // traverses through the linked list until a null value is found since the next pointer will reference the next piece of data
                nodeIterable = nodeIterable.getNext(); // actual "jumping" via accessing next pointers -> n = next piece of data
            }
            nodeIterable.setNext(node); // assigns last node ptr to new piece of data
        }
    }

    public void insertBeginning(Distance data) {
        /* new candidate node */
        NodePtr node = new NodePtr();
        node.setData(data);
        node.setNext(null);

        node.setNext(this.head); // changes ptr to current head which is connected to the rest of the LinkedList
        this.head = node; // node with the correct ptr to the old head is set as the new head which successfully inserts the node at the start
    }

    public void insertAt(int index, Distance data) {
        NodePtr node = new NodePtr();
        node.setData(data);
        node.setNext(null);

        if (index == 0) { // catch for if the node is being added to the beginning of the LinkedList
            this.insertBeginning(data);
        } else {
            NodePtr nodeIterable = head;

            for (int i = 0; i < index - 1; i++) { // cycles through list to piece of data right before the index that is selected for insertion
                nodeIterable = nodeIterable.getNext();
            }
            node.setNext(nodeIterable.getNext()); // sets the new node candidate ptr to the next item in the LinkedList
            nodeIterable.setNext(node); // closes loop of insertion by setting the previous node of the selected insertion index to point to the new node inserted (which is now also pointing to the next node)
        }
    }

    public void print() {
        NodePtr node = head; // beginning data and ptr

        while(node.getNext() != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
        System.out.println(node.getData());
    }

    public static void main(String[] args) {
        MikeLinkedList list = new MikeLinkedList();
        list.insert(new Distance(0, "Steve Rogers", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));
        list.insert(new Distance(0, "Christopher Bucacan", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));

        list.print();
    }
}
