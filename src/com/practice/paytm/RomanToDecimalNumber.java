package com.practice.paytm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class RomanToDecimalNumber {

    private static final Map<String, Integer> romanToDecimal = new LinkedHashMap<>();
    private static final String[] M = {"", "M", "MM", "MMM"};
    private static final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    static {
        romanToDecimal.put("I", 1);
        romanToDecimal.put("V", 5);
        romanToDecimal.put("X", 10);
        romanToDecimal.put("L", 50);
        romanToDecimal.put("C", 100);
        romanToDecimal.put("D", 500);
        romanToDecimal.put("M", 1000);
    }

    public static String decimalToRoman(int num) {
        String thousands = M[num/1000];
        String hundreds = C[(num%1000)/100];
        String tens = X[(num%100)/10];
        String ones = I[num%10];
        return thousands + hundreds + tens + ones;
    }

    public static int romanToDecimal(String roman) {
        int len = roman.length();
        int finalValue = 0;
        int prev = -1;
        while (len > 0) {
            String ch = String.valueOf(roman.charAt(len - 1));
            int currVal = romanToDecimal.get(ch);
            if(currVal < prev) {
                finalValue -= currVal;
            } else {
                finalValue += currVal;
            }
            prev = currVal;
            len--;
        }
        return finalValue;
    }

    public static void main(String[] args) {
        System.out.println(romanToDecimal("CDLV"));
        System.out.println(decimalToRoman(3699));
    }
}
