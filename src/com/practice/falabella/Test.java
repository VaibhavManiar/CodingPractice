package com.practice.falabella;

import java.util.*;

public class Test {
    public static void main(String[] args) {
       /* List<Integer> l = new ArrayList<>();
        l.add(3,1 );
        System.out.println(l);*/

        /*Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        Collections.unmodifiableMap(map);
        map.put("b", 2);
        System.out.println(map);*/

        String s = new String("123");
        String s1 = new String(s);
        int v = s == s1 ? 1 : 2;
        System.out.println(v);
    }
}
