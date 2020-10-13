package com.cs.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Return longest substring without repeating characters.
 * input: abcdeacd
 * output: abcde
 */
public class LonggestSubStringWithoutRepeatingcharacters {
    public static void main(String[] args) {
        String input = "abcdeacd";

        System.out.println(solution(input));
    }

    private static String solution(String input) {

        String output = "";
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;

        while (end < input.length()) {

            if (map.get(input.charAt(end)) != null) {
                start = Math.max(input.charAt(end) + 1, start);
            }

            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }

            map.put(input.charAt(end), end);
            end++;
        }

        return output;
    }
}
