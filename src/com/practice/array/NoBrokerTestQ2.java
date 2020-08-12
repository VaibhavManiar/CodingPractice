package com.practice.array;

import java.util.*;

public class NoBrokerTestQ2 {

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        List<Integer> res = new ArrayList<>();
        for (int index = 0; index < a.size(); index++) {
            String strA = a.get(index);
            String strB = b.get(index);
            if(strA.length() != strB.length()) {
                res.add(-1);
                continue;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : strA.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int count = 0;
            for (char ch : strB.toCharArray()) {
                if (map.containsKey(ch)) {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                    if (map.get(ch) <= 0) {
                        map.remove(ch);
                    }
                } else {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        getMinimumDifference(Arrays.asList("tea", "tea", "act"), Arrays.asList("ate", "toe", "acts")).forEach(System.out::println);
    }
}