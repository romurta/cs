package com.cs.algorithm.math;

/**
 * Given an array of integers, find the three elements which product will result in the biggest possible value.
 * E.g.:
 * [1, 6, 3, 9, 2] -> 6 * 3 * 9 = 162
 * [1, 7, 5, 8, 2, -1, -2] -> 7 * 5 * 8 = 280
 * [1, 7, 3, 8, 2, -1, -2, -4, -13] -> 8 * -4 * -13 = 416
 */
public class BiggerThreeElementMultiplication {
    public static void main(String[] args) {
        int[] input = {1,7,3,8,2,-1,-2,-4,-13};

        System.out.println(solution(input));
    }

    private static int solution(int[] input) {
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            if(input[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = input[i];
            } else if(input[i] > max2) {
                max3 = max2;
                max2 = input[i];
            } else if(input[i] > max3){
                max3 = input[i];
            }

            if(input[i] < min1){
                min2 = min1;
                min1 = input[i];

            } else if (input[i] < min2){
                min2 = input[i];
            }
        }
        int result1 = max1 * max2 * max3;
        int result2 = max1 * min1 * min2;
        return result1 > result2? result1 : result2;
    }
}
