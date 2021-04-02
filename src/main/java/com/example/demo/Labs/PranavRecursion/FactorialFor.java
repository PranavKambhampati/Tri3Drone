package com.example.demo.Labs.PranavRecursion;

public class FactorialFor {

    public int factorialcalc(int num){

        int answer = 1;

        for(int i = 1; i <= num; i++){
            answer*=i;
        }
        return answer;
    }


}
