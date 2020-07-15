package com.cs.algorithm.string;

/**
 * Reverse words in a sentence
 * input: "The sentence should be reversed"
 * output: "reversed be should sentence The"
 */
public class ReverseWords {
    public static void main(String[] args) {
        String input = "The sentence should be reversed";

        System.out.println(solution(input));
    }

    public static String solution(String input){
        String[] inputArr = input.split("\\s");

        int start = 0;
        int end = inputArr.length - 1;

        while(start < end) {
            swap(inputArr, start, end);
            start++;
            end--;
        }


        StringBuilder sb = new StringBuilder();
        for (String s:inputArr) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }

    private static void swap(String[] inputArr, int start, int end) {
        String temp = inputArr[end];
        inputArr[end] = inputArr[start];
        inputArr[start] = temp;
    }
}
