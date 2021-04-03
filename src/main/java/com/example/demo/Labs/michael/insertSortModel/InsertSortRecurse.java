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

            if (length <= 1) {
                return unsortedArray; // "base case" exit, begins unfurling of recursive stack
            }

            recurseIt(unsortedArray, length - 1);

            int last = unsortedArray[length - 1];
            int shift = length - 2;

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
