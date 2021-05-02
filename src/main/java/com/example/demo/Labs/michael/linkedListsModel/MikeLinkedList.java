package com.example.demo.Labs.michael.linkedListsModel;

import com.example.demo.Labs.michael.trackModel.Distance;
import org.w3c.dom.Node;

/**
    LinkedList implementation references
    #1: https://www.youtube.com/watch?v=SMIq13-FZSE
    #2: https://www.youtube.com/watch?v=AeqXFjCUcQM
    #3: https://www.youtube.com/watch?v=tZxPqhkRLiw
 */


public class MikeLinkedList {
    NodePtr head;
    int size;

    /**
     * Insert at tail
     * @param data
     */
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
        size += 1;
    }

    public void insertBeginning(Distance data) {
        /* new candidate node */
        NodePtr node = new NodePtr();
        node.setData(data);
        node.setNext(null);

        node.setNext(this.head); // changes ptr to current head which is connected to the rest of the LinkedList
        this.head = node; // node with the correct ptr to the old head is set as the new head which successfully inserts the node at the start
        size += 1;
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
        size += 1;
    }

    public void insertMiddle(Distance data) {
        int index = (int) 0.5 * this.size;

        insertAt(index, data);
    }

    public void deleteAt(int index) { // access ptr to element before the specified index and change the ptr to the next next node
        if (index == 0) {
            this.head = head.getNext(); // sets head to the next node to erase reference to the original head node
        } else {
            NodePtr nodeIterable = head;
            NodePtr tempAccessNode = null; // node created just to get the "next next" node to skip the ptrs over the specified index
            for (int i = 0; i < index - 1; i++) {
                nodeIterable = nodeIterable.getNext();
            }
            tempAccessNode = nodeIterable.getNext();
            nodeIterable.setNext(tempAccessNode.getNext()); // next of next function works because the tempAccessNode is a reference inside of the iterable LinkedList
            tempAccessNode = null; // deleted from memory on the next access

        }
        size -= 1;
    }

    public void deleteHead() {
        this.head = head.getNext();
    }

    public void deleteMiddle() {
        int index = (int) (0.5 * size);

        this.deleteAt(index);
    }

    public void deleteTail() {
        NodePtr nodeIterable = head;
        NodePtr nodePrevious = new NodePtr();
        while (nodeIterable.getNext() != null) { // traverses through the linked list until a null value is found since the next pointer will reference the next piece of data
            nodePrevious = nodeIterable;
            nodeIterable = nodeIterable.getNext(); // actual "jumping" via accessing next pointers -> n = next piece of data
        }
        nodePrevious.setNext(null);
    }

    public void selectionSort() {
        if (this.head.getNext() != null) {
            NodePtr temp = this.head;

            // Traverse the List
            while (temp.getNext() != null) {
                NodePtr min = temp;
                NodePtr r = temp.getNext();

                // Traverse the unsorted sublist
                while (r.getNext() != null) {
                    if (min.getData().compareTo(r.getData()) < 0) {
                        min = r;
                    }

                    r = r.getNext();
                }

                // Swap Data
                Distance x = temp.getData();
                temp.setData(min.getData()); ;
                min.setData(x);
                temp = temp.getNext();
            }
        }
    }

    public String getPrettyData() {
        String formattedString = "";

        NodePtr node = head;

        while (node.getNext() != null) {
            formattedString += node.getData().getId() + " " + node.getData().getName() + " " + node.getData().getSeedTime() + ", ";
            node = node.getNext();
        }
        formattedString += node.getData().getId() + " " + node.getData().getName() + " " + node.getData().getSeedTime() + ", ";

        return formattedString;
    }

    public void print() {
        NodePtr node = head; // beginning data and ptr

        while (node.getNext() != null) {
            System.out.print(node.getData().getId() + " " + node.getData().getName() + " " + node.getData().getSeedTime());
            node = node.getNext();
            System.out.println();
        }
        System.out.print(node.getData().getId() + " " + node.getData().getName() + " " + node.getData().getSeedTime());
        System.out.println();
    }

    public static void main(String[] args) {
        MikeLinkedList list = new MikeLinkedList();
        list.insert(new Distance(0, "George Gatz", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));
        list.insert(new Distance(0, "Steve Rogers", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));
        list.insert(new Distance(0, "Christopher Bucacan", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));
        list.insert(new Distance(0, "Jacob Gareth", (int) ((Math.random() * (12 - 9)) + 9), "male", "Del Norte", String.valueOf((Math.random() * (150 - 115)) + 115), String.valueOf((Math.random() * (70 - 60)) + 60), "800 meters"));

        list.print();
        list.deleteMiddle();
        System.out.println();
        list.print();
        System.out.println();
        list.deleteTail();
        list.print();
        System.out.println();
        list.deleteHead();
        list.print();
        System.out.println();
        list.deleteAt(0);
        list.print();
        System.out.println();
    }
}
