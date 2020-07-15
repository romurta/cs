package com.cs.algorithm.dynamic;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 */
public class CoinChange {
    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;


        System.out.println(solution(coins, amount));
    }

    private static int solution(int[] coins, int amount) {

        int[] ans = new int[amount + 1];
        Arrays.fill(ans, amount+1); // 0 1 2
        ans[0] = 0;

        for (int i = 0; i < ans.length; i++) {
            for (int c = 0; c < coins.length; c++) {
                if(coins[c] <= i){
                    ans[i] = Math.min(ans[i], ans[i - coins[c]] + 1);
                }
            }
        }


        return ans[amount];
    }
}
