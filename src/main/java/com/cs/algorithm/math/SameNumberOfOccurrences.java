package com.cs.algorithm.math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * given an array [1,2,2,3,3,3,4,4,4]
 * <p>
 * return if the numbers have ther same count
 */
public class SameNumberOfOccurrences {
    public static void main(String[] args) {
        int input[] = {1, 2, 3};

        System.out.println(solution2(input));
    }

    private static boolean solution(int[] input) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            counts.put(input[i], counts.getOrDefault(input[i], 0) + 1);
        }

        Iterator<Integer> iter = counts.values().iterator();
        int prior = iter.next();
        while (iter.hasNext()) {
            int curr = iter.next();
            if (prior != curr) {
                return false;
            }
            prior = curr;
        }

        return true;
    }

    private static boolean solution2(int[] input) {
        int[] arr = new int[10];

        for (int i = 0; i < input.length; i++) {
            arr[input[i]]++;
        }

        for (int i = 0; i < input.length-1; i++) {
            if (arr[input[i]] != arr[input[i+1]]) {
                return false;
            }
        }

        return true;
    }
}
