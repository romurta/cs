package com.cs.algorithm.math;

/**
 * == 120
 * 5! = 5*4*3*2*1
 * 4! = 4*3*2*1
 * 3! = 3*2*1
 * 2! = 2*1
 * 1! = 1
 */
public class Factorial {
    public static void main(String[] args) {
        int input = 5;

        int factorial = solution(input);
        System.out.println("Non: " + factorial);

    }

    private static int solution(int input) {
        if (input < 2) {
            return 1;
        }
        return input * solution(input - 1);
    }

}
