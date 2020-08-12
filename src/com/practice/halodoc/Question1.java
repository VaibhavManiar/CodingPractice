package com.practice.halodoc;

public class Question1 {

    static int solve(int[] p) {
        // Write your code here
        boolean[] included = new boolean[p.length];
        int maxProfit = 0;
        int currMaxProfit = p[0];
        for(int i=0; i<p.length; i++) {
            if(included[i]) {
                continue;
            }
            int prevIndex = i;
            included[i] = true;
            currMaxProfit = p[prevIndex];
            for(int j=i+1; j<p.length;j++) {
                if(p[prevIndex] < p[j] && p[j] % p[prevIndex] == 0) {
                    prevIndex = j;
                    included[j] = true;
                    currMaxProfit = currMaxProfit + p[j];
                }
            }
            if(maxProfit < currMaxProfit) {
                maxProfit = currMaxProfit;
            }
            currMaxProfit = 0;
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int maxProfit = solve(new int[] {2,3,10,21});
        System.out.println(maxProfit);
    }

}
