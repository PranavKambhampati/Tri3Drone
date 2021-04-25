package com.example.demo.Labs.michael.sortsModel;

public class InsertionSort extends _Sorts{

    public InsertionSort(String stringLiteral) {
        super(stringLiteral);

        super.sortName = "Insertion Sort";
        super.sortDescription = "The insertion sort cycles through all of the elements in a list. The currently selected element is compared to all of the elements in previous indexes. If the currently selected element is larger than smaller indexes, that element is moved to the correct place so that it is trending towards the correct order. Complexity: O(n²)";
    }

    @Override
    public void sort() {
        switch (data) {
            case Int:
                int jI;
                int tempI;

                for (int i = 1; i < unsortedDataI.length; i++)
                {
                    jI = i - 1;
                    while (jI >= 0 && unsortedDataI[jI] > unsortedDataI[i] )
                    {
                        tempI = unsortedDataI[i];
                        unsortedDataI[i] = unsortedDataI[jI];
                        unsortedDataI[jI] = tempI;
                        i = jI;
                        jI--;
                    }
                }
                break;
            case String:
                int jS;
                String tempS;

                for (int i = 1; i < unsortedDataS.length; i++)
                {
                    jS = i - 1;
                    while (jS >= 0 && unsortedDataS[jS].compareTo(unsortedDataS[i]) > 0 )
                    {
                        tempS = unsortedDataS[i];
                        unsortedDataS[i] = unsortedDataS[jS];
                        unsortedDataS[jS] = tempS;
                        i = jS;
                        jS--;
                    }
                }
                break;
            default:
                System.out.println("No enum assigned");
        }
    }

    public static void main(String[] args) {
        _Sorts arrayS = new InsertionSort("i,g,f,h");
        System.out.print("String ");
        for (String s : arrayS.unsortedDataS) {
            System.out.print(s + ", ");
        }

        _Sorts arrayI = new InsertionSort("5,3,2,1");
        System.out.print("Integers ");
        for (Integer s : arrayI.unsortedDataI) {
            System.out.print(s + ", ");
        }
    }
}
