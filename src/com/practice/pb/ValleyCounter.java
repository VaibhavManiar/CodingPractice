package com.practice.pb;

public class ValleyCounter {
    private static int countingValleys(int n, String s) {
        char[] steps = s.toCharArray();
        int situation = 0; // sea level
        int valleyCount = 0;
        for(char step :  steps) {
            if(step == 'D') {
                --situation;
            } else {
                ++situation;
            }
            if(situation < 0 && step == 'D') {
                ++valleyCount;
            }
        }
        return valleyCount;
    }

    public static void main(String[] args) {
        System.out.println("Count: " + (1 == countingValleys(8, "DDUUUUDD")));
        System.out.println("Count: " + (1 == countingValleys(8, "UDDDUDUU")));
        System.out.println("Count: " + (2 == countingValleys(12, "DDUUDDUDUUUD")));
    }
}
