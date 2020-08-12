package com.practice.dailycodingpractice;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem was asked by Amazon.
 * <p>
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 * <p>
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class Q13 {
    private static int sol(String str, int k) {
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int currMaxCount = 0;
        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() <= k) {
                currMaxCount += 1;
            } else {
                if (currMaxCount > maxCount) {
                    maxCount = currMaxCount;
                    currMaxCount--;
                }
                char startCh = str.charAt(startIndex++);
                int v = map.get(startCh) - 1;
                if (v != 0) {
                    map.put(startCh, v);
                } else {
                    map.remove(startCh);
                }
            }
        }
        if (currMaxCount > maxCount) {
            maxCount = currMaxCount;
        }
        return maxCount+1;
    }

    public static void main(String[] args) {
        System.out.println(sol("abcbabbac", 2));
        System.out.println(sol("abcbabbaca", 2));
    }

}
