package com.practice;

public class CheckIsCoPrime {

    public static boolean isCoPrime(int a, int b) {
        if(Math.abs(a-b) == 1)
            return true;
        while ((a != 0 && b != 0) && a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a == b;
    }

    // This fails when a and b are too big numbers Ex : a = Integer.MAX_VALUE and b = Integer.MAX_VALUE -1;
    public static boolean isCoPrimeUsingRecursion(int a, int b) {
        if(a ==0 || b == 0) {
            return false;
        }

        if(a == b) {
            return true;
        }

        if(a > b) {
            return isCoPrimeUsingRecursion(a-b, a);
        }
        return isCoPrimeUsingRecursion(a, b-a);
    }



    public static void main(String[] args) {
        System.out.println(isCoPrime(12, 4) ? "YES" : "NO");
        System.out.println(isCoPrimeUsingRecursion(5, 9) ? "YES" : "NO");
    }
}
