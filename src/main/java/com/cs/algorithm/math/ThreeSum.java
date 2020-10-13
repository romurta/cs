package com.cs.algorithm.math;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static void main(String[] args) {
        int []nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> response = solution(nums);

        System.out.println(response);
    }

    private static List<List<Integer>> solution(int[] nums) {
        int target = 0;
        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i <nums.length ; i++) {
            int j = i+1;
            int k = nums.length - 1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == target){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(sum > target){
                    k--;
                } else if(sum < target){
                    j++;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
