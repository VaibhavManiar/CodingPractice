package com.practice;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    public static Set<String> print(String str) {
        String ans = "";
        Set<String> permutations = new HashSet<>();
        printUtil(str, ans, permutations);
        return permutations;
    }

    private static void printUtil(String str, String ans, Set<String> permutations) {

        if(str == null || str.isEmpty()) {
            permutations.add(ans);
            return;
        }

        for(int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            String restOfString = str.substring(0, index) + str.substring(index+1);
            printUtil(restOfString, ans + ch, permutations);
        }
    }

    public static void main(String[] args) {
        Set<String> permutations = print("aabc");
        for(String s : permutations) {
            System.out.println(s);
        }
        System.out.println(permutations.size());
    }
}
