package com.practice.pb;

public class CloudJumpingProblem {

    private static int jumpingOnClouds(int[] c) {
        int lastPosition = c.length - 1;
        int currentPosition = 0;
        int stepCount = 0;
        while(currentPosition < lastPosition) {
            if((currentPosition + 2) <= lastPosition && c[currentPosition + 2] != 1 ) {
                currentPosition += 2;
            } else {
                currentPosition += 1;
            }
            stepCount++;
        }
        return stepCount;
    }

    public static void main(String[] args) {
        int[] c = {0,0,1,0,0,1,0};
        System.out.println(jumpingOnClouds(c));
    }
}
