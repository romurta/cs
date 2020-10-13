package com.cs.algorithm.string;


import java.util.Stack;

/**
 * Remove adjacent duplicates
 * input: pqqprq
 * output: rq
 */
public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String input = "pqqprq";
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (stack.isEmpty() || stack.peek() != input.charAt(i)) {
                stack.push(input.charAt(i));
            } else if (stack.peek() == input.charAt(i)) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
