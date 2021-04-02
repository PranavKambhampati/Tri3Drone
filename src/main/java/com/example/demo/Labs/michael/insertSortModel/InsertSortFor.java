package com.example.demo.Labs.michael.insertSortModel;

public class InsertSortFor extends _InsertionSort{

    public InsertSortFor(String referenceArrayLiteral) {
        super(referenceArrayLiteral);
    }

    @Override
    protected void init() {
        super.approachName = "For";
        int n = super.unsortedMutable.length;
        for (int i = 1; i < n; ++i) {
            int currentPosition = unsortedMutable[i];
            int leftOfPosition = i - 1;

            while (leftOfPosition >= 0 && unsortedMutable[leftOfPosition] > currentPosition) {
                unsortedMutable[leftOfPosition + 1] = unsortedMutable[leftOfPosition];
                leftOfPosition = leftOfPosition - 1;
            }
            unsortedMutable[leftOfPosition + 1] = currentPosition;
        }
    }

    public static void main(String[] args){
        String referenceArrayLiteral = "7,6,3,1,9,2";
        _InsertionSort insertionSort = new InsertSortFor(referenceArrayLiteral);

        insertionSort.printIt();
    }
}
