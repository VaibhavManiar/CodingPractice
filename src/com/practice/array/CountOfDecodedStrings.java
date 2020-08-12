package com.practice.array;

import java.util.*;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * <p>
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * Complexity O(n2)
 */
public class CountOfDecodedStrings {
    private static final Map<Integer, String> dictionary = new HashMap<>();

    static {
        for (int i = 1; i <= 26; i++) {
            dictionary.put(i, Character.toString((char) (96 + i)));
        }
    }

    public static Set<String> distinctDecoding(String encoded) {
        Set<String> set = new HashSet<>();
        List<Integer> intList = new ArrayList<>();
        for (int index = 0; index < encoded.length(); index++) {
            intList.add(Integer.parseInt("" + encoded.charAt(index)));
        }

        StringBuilder str = new StringBuilder();
        for (int val : intList) {
            str.append(dictionary.get(val));
        }
        set.add(str.toString());

        for (int i = 0; i < intList.size(); i++) {
            StringBuilder str1 = new StringBuilder();
            for (int j = 0; j < intList.size(); j++) {
                if((j+1) < intList.size() && ((intList.get(j) * 10) + intList.get(j+1)) < 27 && j>=i) {
                    str1.append(dictionary.get((intList.get(j) * 10) + intList.get(j + 1)));
                    j++;
                } else {
                    str1.append(dictionary.get(intList.get(j)));
                }
            }
            set.add(str1.toString());
        }
        return set;
    }

    public static void main(String[] args) {
        distinctDecoding("111").forEach(System.out::println);
        distinctDecoding("12631").forEach(System.out::println);
        distinctDecoding("12231").forEach(System.out::println);
    }
}