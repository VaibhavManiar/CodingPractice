package com.practice.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllTripletsOfZeroSum {
    // arr[] = {1, -2, 2, -3, 1}
    public static void find(List<Integer> list) {
        Set<Integer> s= new HashSet<>();
        for (int i=0; i<list.size(); i++) {
            for(int j = 1; j < list.size(); j++) {
                int val = -1 * (list.get(i)+list.get(j));
                if(s.contains(val)) {
                    System.out.println(list.get(i) + " " + list.get(j) + " " + val);
                } else {
                    s.add(list.get(j));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-2);
        list.add(2);
        list.add(-3);
        list.add(1);
        find(list);
    }
}
