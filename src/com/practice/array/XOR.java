package com.practice.array;

public class XOR {
    public static int cal(int a, int b) {
        String binA = DecimalToBinary.solve(a);
        System.out.println(a + " -> " + binA);
        String binB = DecimalToBinary.solve(b);
        System.out.println(b + " -> " + binB);

        int lenA = binA.length();
        int lenB = binB.length();

        int lenDif = Math.abs(lenA - lenB);
        StringBuilder zeros = new StringBuilder();
        for (int index = 0; index < lenDif; index++) {
            zeros.append("0");
        }
        if (lenA < lenB) {
            binA = zeros + binA;
        } else {
            binB = zeros + binB;
        }
        String xor = xor(binA, binB);
        System.out.println(binA + " xor  " + binB + " -> " + xor);
        return BinaryToDecimal.cal(xor);
    }

    private static String xor(String binA, String binB) {
        StringBuilder xor = new StringBuilder();

        int lenA = binA.length();
        int lenB = binB.length();

        while (lenA > 0 && lenB > 0) {
            char a = binA.charAt(lenA-1);
            char b = binB.charAt(lenB-1);
            xor.insert(0, xor(a,b));
            lenA--;
            lenB--;
        }

        while (lenA > 0) {
            char a = binA.charAt(lenA-1);
            xor.insert(0, a);
            lenA--;
        }

        while (lenB > 0) {
            char b = binB.charAt(lenB-1);
            xor.insert(0, b);
            lenB--;
        }

        return xor.toString();
    }

    private static String xor(char a, char b) {
        if (a == b) {
            return "0";
        } else {
            return "1";
        }
    }

    public static void main(String[] args) {
        System.out.println(cal(2, 5));
    }
}
