package com.practice.array;

public class BinaryToDecimal {
    public static int cal(String bin) {
        int val = 0;
        for (int i = 0; i < bin.length(); i++) {
            int multiplier = Integer.parseInt("" + bin.charAt(bin.length() - (i + 1)));
            int temp = (int) Math.pow(2, i);
            val += temp * multiplier;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(cal("10001110"));
    }
}
