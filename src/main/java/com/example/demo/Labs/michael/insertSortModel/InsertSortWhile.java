package com.example.demo.Labs.michael.insertSortModel;

public class InsertSortWhile extends _InsertionSort {

    public InsertSortWhile(String referenceArrayLiteral) {
        super(referenceArrayLiteral);
    }


    @Override
    protected void init() {
        super.approachName = "While";

        int i;
        int j;
        int temp;
        int length = super.unsortedMutable.length;

        for (i = 1; i < length; i++)
        {
            j = i - 1;
            while (j >= 0 && unsortedMutable[j] > unsortedMutable[i] )
            {
                temp = unsortedMutable[i];
                unsortedMutable[i] = unsortedMutable[j];
                unsortedMutable[j] = temp;
                i = j;
                j--;
            }
        }
    }

    public static void main(String[] args){
        String referenceArrayLiteral = "7,6,3,1,9,2";
        _InsertionSort insertionSortWhile = new InsertSortWhile(referenceArrayLiteral);

        insertionSortWhile.printIt();
    }
}
