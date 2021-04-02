package com.example.demo.Labs.PranavRecursion;

import java.math.BigInteger;

public class FactorialBigInt {

    public BigInteger factorialcalc(int num){
        BigInteger result = BigInteger.ONE;
        for(int i=1; i<=num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }


}
