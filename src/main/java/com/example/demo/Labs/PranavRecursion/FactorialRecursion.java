package com.example.demo.Labs.PranavRecursion;

public class FactorialRecursion {

    public int factorialcalc(int num){
        if (num >= 1){
            return num*factorialcalc(num-1);
        } else {
            return 1;
        }
    }
}
