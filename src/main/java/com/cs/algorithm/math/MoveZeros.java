package com.cs.algorithm.math;

public class MoveZeros {
    public static void main(String[] args) {

        int [] nums = {0,1,0,2,0};
        solution(nums);
        for (int i : nums){
            System.out.print(i);
        }
    }

    private static void solution(int[] nums) {
        int z = -1;
        for (int i=0; i< nums.length; i++) {
            int temp = nums[i];
            if (temp != 0) {
                z++;
                nums[i]=nums[z];
                nums[z]=temp;

            }
        }
    }

}
