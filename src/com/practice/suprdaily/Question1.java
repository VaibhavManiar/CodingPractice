package com.practice.suprdaily;

import java.util.*;

/**
 * Sort array by number and it's repetition count
 */
public class Question1 {

    private static void sort(List<Integer> list) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> keySortList = new ArrayList<>(map.entrySet());
        keySortList.sort(Comparator.comparingInt(Map.Entry::getValue));
        keySortList.forEach(e -> System.out.println(e.getKey()));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(4);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(1);
        sort(list);
    }

}
