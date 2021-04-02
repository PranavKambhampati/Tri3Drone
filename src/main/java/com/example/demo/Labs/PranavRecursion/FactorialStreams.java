package com.example.demo.Labs.PranavRecursion;

import java.util.stream.LongStream;

public class FactorialStreams {

    public int factorialcalc(int n){
        return (int) LongStream.rangeClosed(1,n).reduce(1,(a, b) -> a*b);
    }
}
