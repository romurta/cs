package com.cs.algorithm.math;

public class Fibonacci {
    public static void main(String[] args) {
        int input = 10;

        int fib = solutionDp(input);
        System.out.println(fib);

        fib = solutionRec(input);
        System.out.println(fib);
    }

    private static int solutionDp(int x) {
        int[] dp = new int[x + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < x + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[x];
    }

    private static int solutionRec(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        } else {
            int f = solutionRec(x - 1) + solutionRec(x - 2);
            return f;
        }
    }
}
