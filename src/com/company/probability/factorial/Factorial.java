package com.company.probability.factorial;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int result = 0;
        BigInteger factorial = findFactorial(100);
        char[] chars = factorial.toString().toCharArray();
        for (char aChar : chars) {
            result = result + Character.getNumericValue(aChar);
        }
        System.out.println(result);
    }

    private static BigInteger findFactorial(long n) {
        //  BigInteger needs to avoid problems with size of result number (more than 32 bit)
        BigInteger result = BigInteger.ONE;
        for (long i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
