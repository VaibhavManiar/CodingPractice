package com.practice.pb;

import java.util.*;
import java.util.stream.Collectors;

public class SockMerchant {

    /**
     * John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
     *
     * For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
     *
     * Function Description
     *
     * Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
     *
     * sockMerchant has the following parameter(s):
     *
     * n: the number of socks in the pile
     * ar: the colors of each sock
     * Input Format
     *
     * The first line contains an integer , the number of socks represented in .
     * The second line contains  space-separated integers describing the colors  of the socks in the pile.
     *
     * Constraints
     *
     *  where
     * @param n
     * @param ar
     * @return
     */
    private static int sockMerchant(int n, int[] ar) {
        Map<Integer,Integer> tempMap = new HashMap<>();
        int count = 0;
        if(n>0) {
            Arrays.stream(ar).forEach(key-> tempMap.put(key, tempMap.getOrDefault(key, 0) + 1));

            for(Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                if(entry.getValue()/2 > 0) {
                    count += entry.getValue()/2;
                }
            }

            //Set<Integer> socksColorSet = tempMap.entrySet().parallelStream().filter((e)-> (e.getValue()/2) >0).map(Map.Entry::getKey).collect(Collectors.toSet());
            //tempMap.forEach((k, v)->System.out.println("Socks of color : " + k + " has pairs : " + (int) v/2 ));
            return count;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ar = {1,2,3,1,2,2,2,2,2,2};
        int size = sockMerchant(ar.length, ar);
        System.out.println(size);
    }
}
