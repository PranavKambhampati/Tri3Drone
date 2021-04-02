package com.example.demo.Labs.michael.insertSortModel;

public class InsertSortRecurse extends _InsertionSort {

    public InsertSortRecurse(String referenceArrayLiteral) {
        super(referenceArrayLiteral);
    }

    @Override
    protected void init() {
        super.approachName = "Recursion";
        int length = super.unsortedMutable.length;

        super.unsortedMutable = recurseIt(unsortedMutable, length);
    }

    private int[] recurseIt(int[] unsortedArray, int length) {
            // Base case
            if (length <= 1) {
                return unsortedArray;
            }

            // Sort first n-1 elements
            recurseIt(unsortedArray, length - 1);

            // Insert last element at its correct position
            // in sorted array.
            int last = unsortedArray[length - 1];
            int shift = length - 2;

        /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
            while (shift >= 0 && unsortedArray[shift] > last)
            {
                unsortedArray[shift + 1] = unsortedArray[shift];
                shift--;
            }
            unsortedArray[shift + 1] = last;

            return unsortedArray;
        }

    public static void main(String[] args){
        String referenceArrayLiteral = "7,6,3,1,9,2";
        _InsertionSort insertionSortRecurse = new InsertSortRecurse(referenceArrayLiteral);

        insertionSortRecurse.printIt();
    }
}
