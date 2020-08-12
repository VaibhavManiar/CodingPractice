package com.practice.prudential;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'taxiDriver' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY pickup
     *  2. LONG_INTEGER_ARRAY drop
     *  3. INTEGER_ARRAY tip
     */

    public static long taxiDriver(List<Long> pickup, List<Long> drop, List<Integer> tip) {
        // Write your code here
        long prevEarn = 0;
        long sum = 0;
        int prev = 0;

        List<Long> newPickup = new ArrayList<>(pickup);
        List<Long> newDrop = new ArrayList<>();
        List<Integer> tips = new ArrayList<>();
        Collections.sort(newPickup);

        for (int i = 0; i < newPickup.size(); i++) {
            int index = find(newPickup.get(i), pickup);
            newDrop.add(drop.get(index));
            tips.add(tip.get(index));
        }

        tip = tips;
        pickup = newPickup;
        drop = newDrop;

        for (int i = 0; i < pickup.size(); i++) {
            long earn = (drop.get(i) - pickup.get(i)) + tip.get(i);

            if (i > 0) {
                if (pickup.get(i) < drop.get(prev)) {
                    if (earn > prevEarn) {
                        sum = (sum - prevEarn) + earn;
                        prevEarn = earn;
                        prev = i;
                    }
                } else {
                    prevEarn = earn;
                    prev = i;
                    sum = sum + earn;
                }
            } else {
                prevEarn = earn;
                prev = i;
                sum = sum + earn;
            }
        }
        return sum;
    }

    private static int find(long val, List<Long> pickup) {
        for(int index = 0; index<pickup.size(); index++) {
            if(pickup.get(index) == val) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Long> pickup = new ArrayList<>();
        pickup.add(11L);
        pickup.add(30L);
        pickup.add(0L);
        pickup.add(21L);
        pickup.add(41L);
        pickup.add(19L);

        List<Long> drop = new ArrayList<>();
        drop.add(20L);
        drop.add(31L);
        drop.add(17L);
        drop.add(22L);
        drop.add(46L);
        drop.add(21L);


        List<Integer> tip = new ArrayList<>();
        tip.add(6);
        tip.add(1);
        tip.add(9);
        tip.add(0);
        tip.add(8);
        tip.add(0);

        long sum = taxiDriver(pickup, drop, tip);
        System.out.println(sum);
    }

}