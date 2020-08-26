package com.practice.array;

public class BinaryToDecimal {
    public static int cal(String binary) {
        int val = 0;
        for (int i = 0; i < binary.length(); i++) {
            int multiplier = Integer.parseInt("" + binary.charAt(binary.length() - (i + 1)));
            int temp = (int) Math.pow(2, i);
            val += temp * multiplier;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(cal("10001110"));
    }
}
