package com.practice.leetcode;

public class ExperssionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray());
    }

    public boolean isMatch(char[] chArr, char[] pArr) {
        boolean[][] dp = new boolean[chArr.length + 1][pArr.length + 1];
        dp[0][0] = true;

        for(int i =1; i < dp[0].length; i++) {
            if(i-2 >=0 && pArr[i-1] == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(chArr[i-1] == pArr[j-1] || pArr[j-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (j-2>=0 && pArr[j-1] == '*') {
                    dp[i][j] = dp[i][j-2];
                    if((pArr[j-2] == chArr[i-1] || pArr[j-2] == '.')) {
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                } else {
                    dp[i][j] = false;
                }

                if(i>1 && j>2 && !(dp[1][1] || dp[0][2])) {
                    return false;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        boolean isMatch = new ExperssionMatching().isMatch("abc", "c*a*b*c*");
        System.out.println(isMatch);
    }
}
