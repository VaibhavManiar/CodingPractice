package com.practice.groupon;

class Result {

    /*
     * Complete the 'ways' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER total
     *  2. INTEGER k
     */

    public static int ways(int total, int k) {
        // Write your code here
        int count = 1;
        /*int j = 0;
        while(k > 1) {
            count += total/k;
            j = k;
            for(int i = k-1; i>1 && total > j; i--) {
                count += ((total-j)/i);
                j--;
            }
            k--;
        }*/
        while (k > 1) {
            int t = (total / k);
            if (k - 1 > 1) {
                t += ((total - k) / (k - 1));
            }
            count += t;
            k--;
        }
        return count;
    }

    public static void main(String[] args) {
        //int ways = ways(56, 23);
        int ways = ways(9, 4);
        System.out.println(ways);
    }

}