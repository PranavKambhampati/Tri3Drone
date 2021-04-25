package com.example.demo.Labs.michael.sortsModel;

import com.example.demo.Labs.michael.trackModel.BasicData;

public class BubbleSort extends _Sorts {

    public BubbleSort(String stringLiteral) {
        super(stringLiteral);

        initB();
    }

    public BubbleSort(BasicData[] data, DataType knownType) {
        super(data, knownType);

        initB();
    }
    public void initB() {
        super.sortName = "Bubble Sort";
        super.sortDescription = "The bubble sort loops through all of the elements in comparing it to single element. Once all of the elements have been compared to to that single element, the process repeats with the next element to the right. Once the last element is compared to the other elements, the list will be sorted.";
        super.complexity = "Complexity: O(n) - O(n²)";
        super.use = "Fastest sort if the list is already ordered";
    }
    /**
     *  After attempts to use opaque class Object to write a single sort algos, enum that identifies data type
     *  for sort and uses the correct bubble algo
     */
    @Override
    public void sort() {
        switch (this.data) {
            case Int:
                for (int i = 0; i < unsortedDataI.length; i++) {
                    for (int j = 0; j < unsortedDataI.length - i - 1; j++) {
                        if (unsortedDataI[j].intValue() > unsortedDataI[j + 1].intValue()) {
                            int temp = unsortedDataI[j];
                            unsortedDataI[j] = unsortedDataI[j + 1];
                            unsortedDataI[j + 1] = temp;
                        }
                    }
                }
                break;
            case String:
                for (int i = 0; i < unsortedDataS.length; i++) {
                    for (int j = 0; j < unsortedDataS.length - i - 1; j++) {
                        if (unsortedDataS[j].compareTo(unsortedDataS[j + 1]) > 0) {
                            String temp = unsortedDataS[j];
                            unsortedDataS[j] = unsortedDataS[j + 1];
                            unsortedDataS[j + 1] = temp;
                        }
                    }
                }
                break;
            case Object:
                for (int i = 0; i < unsortedDataO.length; i++) {
                    for (int j = 0; j < unsortedDataO.length - i - 1; j++) {
                        if (unsortedDataO[j].toString().compareTo(unsortedDataO[j + 1].toString()) > 0) {
                            BasicData temp = unsortedDataO[j];
                            unsortedDataO[j] = unsortedDataO[j + 1];
                            unsortedDataO[j + 1] = temp;
                        }
                    }
                }
                break;
            default:
                System.out.println("No enum assigned");
                break;
        }
    }

    public static void main(String[] args) {
        _Sorts arrayS = new BubbleSort("i,g,f,h");
        System.out.print("String ");
        for (String s : arrayS.unsortedDataS) {
            System.out.print(s + ", ");
        }

        _Sorts arrayI = new BubbleSort("5,3,2,1");
        System.out.print("Integers ");
        for (Integer s : arrayI.unsortedDataI) {
            System.out.print(s + ", ");
        }
    }
}
