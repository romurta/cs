package com.cs.algorithm.math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * given an array [1,2,2,3,3,3,4,4,4]
 *
 * return if the numbers have ther same count
 */
public class SameNumberOfOccurrences {
    public static void main(String[] args) {
        int input[] = {1,2,3};

        System.out.println(solution(input));
    }

    private static boolean solution(int[] input) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int j : input) {
            counts.put(j, counts.getOrDefault(j, 0) + 1);
        }

        Iterator<Integer> iter = counts.values().iterator();
        int prior = iter.next();
        while(iter.hasNext()){
            int curr = iter.next();
            if(prior != curr){
                return false;
            }
            prior = curr;
        }

        return true;
    }
}
