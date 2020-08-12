package com.practice.array;

public class RolercosterRideQueue {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int length = q.length;
        int i = length-1;
        int swapCount = 0;
        while(i > 0) {
            for(int j=0; j<2 && i > 0; j++) {
                q = swap(q, i);
                i--;
                swapCount++;
            }
            i--;
        }
        System.out.println(swapCount);
        if(length > 3) {
            System.out.println("Too chaotic");
        }
    }

    private static int[] swap(int[] q, int i) {
        if(i>0) {
            int t = q[i];
            q[i] = q[i-1];
            q[i-1] = t;
        }
        return q;
    }

    public static void main(String[] args) {
        minimumBribes(new int[] {1,2,3,4,5});
    }
}
