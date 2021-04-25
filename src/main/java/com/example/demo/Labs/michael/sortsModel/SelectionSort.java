package com.example.demo.Labs.michael.sortsModel;

public class SelectionSort extends _Sorts {

    public SelectionSort(String stringLiteral) {
        super(stringLiteral);

        super.sortName = "Selection Sort";
        super.sortDescription = "The selection sort repeatedly keeps checking the first element compared to all of the other elements. If one of the other elements has a smaller value that the first index, then that element becomes the new first index and the first element is swapped into the index of the other element. O(n²)";
    }

    @Override
    public void sort() {
        switch (data) {
            case Int:
                for (int i = 0; i < unsortedDataI.length; i++) {

                    int firstIndex = i;
                    for (int j = i + 1; j < unsortedDataI.length; j++) {
                        if (unsortedDataI[j] < unsortedDataI[firstIndex]){
                            firstIndex = j;
                        }
                    }

                    int temp = unsortedDataI[firstIndex];
                    unsortedDataI[firstIndex] = unsortedDataI[i];
                    unsortedDataI[i] = temp;
                }
                break;
            case String:
                for (int i = 0; i < unsortedDataS.length; i++) {

                    int firstIndex = i;
                    for (int j = i + 1; j < unsortedDataS.length; j++) {
                        if (unsortedDataS[j].compareTo(unsortedDataS[firstIndex]) < 0){
                            firstIndex = j;
                        }
                    }

                    String temp = unsortedDataS[firstIndex];
                    unsortedDataS[firstIndex] = unsortedDataS[i];
                    unsortedDataS[i] = temp;
                }
                break;
            default:
                System.out.println("No enum assigned");
        }
    }

    public static void main(String[] args) {
        _Sorts arrayS = new SelectionSort("i,g,f,h");
        System.out.print("String ");
        for (String s : arrayS.unsortedDataS) {
            System.out.print(s + ", ");
        }

        _Sorts arrayI = new SelectionSort("5,3,2,1");
        System.out.print("Integers ");
        for (Integer s : arrayI.unsortedDataI) {
            System.out.print(s + ", ");
        }
    }
}
