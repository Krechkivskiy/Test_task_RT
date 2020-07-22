package com.company.probability.factorial;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        findFactorial(scanner.nextInt());
    }

    private static int findFactorial(int i) {
        int res = 1;
        for (int j = 1; j <= i + 1; j++) {
            res=res*j;
        }
        return res;
    }
}
