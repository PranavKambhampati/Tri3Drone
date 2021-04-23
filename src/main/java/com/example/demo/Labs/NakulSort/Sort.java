package com.example.demo.Labs.NakulSort;

import com.example.demo.Labs.NakulInheritance.Student;

import java.time.Duration;
import java.util.Arrays;
import java.time.Instant;

public class Sort {
    public String[] strArray = {"Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Sophia", "William"};
    public int[] intArray = {1, 6, 5, 3, 8, 7, 4, 2};
    public Object[] objArray = this.addToArray(Student.studentData());

    public Sort(){

    }

    public Object[] addToArray(Object[] objects)
    {
        int arrayLength = objects.length;
        Object[] array = new Object[arrayLength];
        int count = 0;
        for (Object o : objects)
        {
            array[count] = o;
            count++;
        }
        return array;
    }

    public int[] intArrayBubbleSort(int[] array){
        int n = array.length;

        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
        return array;
    }

    public String[] stringArrayBubbleSort(String[] array){
        int n = array.length;
        String temp;

        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
        return array;
    }

    public Object[] objArrayBubbleSort(Object[] array){
        int n = array.length;
        Object temp;

        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].toString().compareTo(array[j+1].toString()) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
        return array;
    }

    public int[] intArrayInsertionSort(int[] array)
    {
        int n = array.length;
        for (int j = 1; j < n; ++j) {  // ++j increments and then assigns value of j
            int key = array[j];
            int k = j - 1;

            while (k >= 0 && array[k] > key) {
                array[k + 1] = array[k];
                k = k - 1;
            }
            array[k + 1] = key;
        }
        return array;
    }

    public String[] stringArrayInsertionSort(String[] array)
    {
        int n = array.length;
        for (int j = 1; j < n; ++j) {  // ++j increments and then assigns value of j
            String key = array[j];
            int k = j - 1;

            while (k >= 0 && array[k].compareTo(key) > 0) {
                array[k + 1] = array[k];
                k = k - 1;
            }
            array[k + 1] = key;
        }
        return array;
    }

    public Object[] objArrayInsertionSort(Object[] array)
    {
        int n = array.length;
        for (int j = 1; j < n; ++j) {  // ++j increments and then assigns value of j
            Object key = array[j];
            int k = j - 1;

            while (k >= 0 && array[k].toString().compareTo(key.toString()) > 0) {
                array[k + 1] = array[k];
                k = k - 1;
            }
            array[k + 1] = key;
        }
        return array;
    }

    public int[] intArraySelectionSort(int[] array)
    {
        int n = array.length;

        for (int i = 0; i < n-1; i++)
        {
            int minimumIndex = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[minimumIndex])
                    minimumIndex = j;


            int temp = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public String[] stringArraySelectionSort(String[] array)
    {
        int n = array.length;

        for (int i = 0; i < n-1; i++)
        {
            int minimumIndex = i;
            for (int j = i+1; j < n; j++)
                if (array[j].compareTo(array[minimumIndex]) < 0)
                    minimumIndex = j;


            String temp = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public Object[] objArraySelectionSort(Object[] array)
    {
        int n = array.length;

        for (int i = 0; i < n-1; i++)
        {
            int minimumIndex = i;
            for (int j = i+1; j < n; j++)
                if (array[j].toString().compareTo(array[minimumIndex].toString()) < 0)
                    minimumIndex = j;


            Object temp = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();

        // TEST CODE FOR SORT ALGOS

        String[] strTest = {"Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Sophia", "William"};
        strTest = sort.stringArraySelectionSort(strTest);
        System.out.println(Arrays.toString(strTest));

        int[] intTest = {1, 6, 5, 3, 8, 7, 4, 2};
        intTest = sort.intArraySelectionSort(intTest);
        System.out.println(Arrays.toString(intTest));

        Object[] objTest = sort.addToArray(Student.studentData());
        objTest = sort.objArraySelectionSort(objTest);
        System.out.println(Arrays.toString(objTest));

    }


}
