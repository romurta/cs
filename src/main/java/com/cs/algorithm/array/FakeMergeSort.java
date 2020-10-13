package com.cs.algorithm.array;

public class FakeMergeSort {

    public static void sort(int[] array) {
        if (array.length < 2) {
            return;
        } else {
            int mid = array.length / 2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[array.length - mid];

            for (int i = 0; i < array.length; i++) {
                if (i < leftArray.length) {
                    leftArray[i] = array[i];
                } else {
                    rightArray[i - mid] = array[i];
                }
            }

            sort(leftArray);
            sort(rightArray);
            merge(leftArray, rightArray, array);
        }

    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] < rightArray[j]) {
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
            }
            k++;
        }

        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 2, 0, 10, 9, 4, 8, 6, 7, 0};
        sort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}