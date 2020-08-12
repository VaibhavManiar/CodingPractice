package com.practice.paytm;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToDecimalNumber {

    private static Map<Integer, String> decimalToRoman = new LinkedHashMap<>();
    private static Map<String, Integer> romanToDecimal = new LinkedHashMap<>();

    static {
        decimalToRoman.put(1, "I");
        decimalToRoman.put(5, "V");
        decimalToRoman.put(10, "X");

        romanToDecimal.put("I", 1);
        romanToDecimal.put("V", 5);
        romanToDecimal.put("X", 10);
        romanToDecimal.put("L", 50);
        romanToDecimal.put("C", 100);
        romanToDecimal.put("D", 500);
        romanToDecimal.put("M", 1000);
    }

    public static int solve(String roman) {
        int len = roman.length();
        int val = 0;
        int prev = 0;
        while (len > 0) {
            String ch = String.valueOf(roman.charAt(len - 1));
            if(romanToDecimal.get(ch) < prev) {
                val -= romanToDecimal.get(ch);
            } else {
                val += romanToDecimal.get(ch);
            }
            prev = romanToDecimal.get(ch);
            len--;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(solve("CDLV"));
    }
}
