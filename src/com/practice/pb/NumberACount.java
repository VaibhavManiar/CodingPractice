package com.practice.pb;

import java.util.Arrays;

public class NumberACount {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long stringLength = s.length();
        long count = ((n/stringLength) * numberOfA(s, s.length())) + (numberOfA(s, (n%stringLength)));
        return count;
    }

    private static long numberOfA(String s, long size) {
        int count = 0;
        for(char ch : s.substring(0, (int)size).toCharArray()) {
            if(ch == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
    }
}
