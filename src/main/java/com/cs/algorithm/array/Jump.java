package com.cs.algorithm.array;

public class Jump {
    public static boolean hasSingleCycle(int[] array) {
        int index = 0;
        int count = 0;
        while(count < array.length) {
            if(count > 0 && index == 0) return false;
            count++;
            index = getIndex(index, array);
        }

        return index == 0;
    }

    private static int getIndex(int index, int[] array) {
        int jump = array[index];
        int nextIndex = (index + jump) % array.length;
        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
    }

    public static void main(String[] args) {
        int array[] = {2,3,1,-4,-4,2};
        System.out.println(hasSingleCycle(array));
        System.out.println();
    }
}
