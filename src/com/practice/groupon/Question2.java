package com.practice.groupon;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public static int minimumMoves(List<Integer> a, List<Integer> m) {
        if(a.size() != m.size()) {
            throw new IllegalArgumentException("Size of both of the lists must be same");
        }
        final int size = a.size();
        int count = 0;
        for(int index = 0; index < size; index++) {
            char[] aStr = String.valueOf(a.get(index)).toCharArray();
            char[] mStr = String.valueOf(m.get(index)).toCharArray();

            if(aStr.length != mStr.length) {
                throw new IllegalArgumentException("Number of chars must be same in both of the integers.");
            }

            for(int i=0; i<aStr.length; i++) {
                count += Math.abs(Integer.parseInt("" + mStr[i]) - Integer.parseInt("" + aStr[i]));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(123);
        a.add(543);
        List<Integer> m = new ArrayList<>();
        m.add(321);
        m.add(279);

        System.out.println(minimumMoves(a, m));
    }
}
