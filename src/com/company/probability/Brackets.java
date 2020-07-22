package com.company.probability;

import java.util.ArrayList;
import java.util.Scanner;

public class Brackets {

    public static void main(String[] args) {
        System.out.println("Please input count of pairs to find all possible probabilities");
        Scanner scanner = new Scanner(System.in);
        showAllPossibleCases(scanner.nextInt());
    }

    private static void showAllPossibleCases(int coupleCount) {
        ArrayList<String> result = new ArrayList<>();
        char leftBracket = '(';
        // right combination need starts with '(' and finish with ')'
        StringBuilder startCombination = new StringBuilder("(");
        int reservedLeftBracketsCount = coupleCount - 1;
        int reservedRightBracketsCount = coupleCount;
        generateCombinations(startCombination, reservedLeftBracketsCount, reservedRightBracketsCount, result);
        result.forEach(System.out::println);
    }

    private static void generateCombinations(StringBuilder currentCombination,
                                             int reservedLeftBracketsCount,
                                             int reservedRightBracketsCount,
                                             ArrayList<String> result) {
        //stop program if he haven't more non reserved symbols
        if (reservedLeftBracketsCount == 0 && reservedRightBracketsCount == 0) {
            result.add(currentCombination.toString());
        }
        //we have no conditions except count of allowable '(' symbols
        if (reservedLeftBracketsCount != 0) {
            StringBuilder cur = new StringBuilder(currentCombination.toString());
            cur.append("(");
            generateCombinations(cur, reservedLeftBracketsCount - 1, reservedRightBracketsCount, result);
        }
        // Check for two conditions:
        // First: if count of '(' will not be less than right and we will print ')' we will get result like this '())('
        // by task conditions it's incorrect
        // Second: There are one case when count of '(' can be less than '(' -- last symbol in string
        if (reservedLeftBracketsCount < reservedRightBracketsCount ||
                (reservedLeftBracketsCount == 0 && reservedRightBracketsCount != 0)) {
            StringBuilder cur = new StringBuilder(currentCombination.toString());
            cur.append(")");
            generateCombinations(cur, reservedLeftBracketsCount, reservedRightBracketsCount - 1, result);
        }
    }
}
