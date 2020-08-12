package com.practice.array;

public class DecimalToBinary {
    public static String solve(int decimal) {
        StringBuilder str = new StringBuilder();
        while (decimal > 0) {
            int rem = decimal % 2;
            decimal = decimal/2;
            str.insert(0, rem);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve(142));
    }
}
