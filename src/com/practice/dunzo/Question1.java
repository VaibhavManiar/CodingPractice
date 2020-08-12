package com.practice.dunzo;

import java.util.ArrayList;
import java.util.List;

public class Question1 {


    public static List<String> sol(String str, int count) {
        List<String> list = new ArrayList<>();

        int len = str.length();
        int end = len-1;
        int start = 0;
        int tempCount = count;
        int tempStart = start;
        while(tempCount > 0) {
            if(end < 0 || tempStart > str.length()) {
                break;
            }
            int startIndex = -1;
            int endIndex = -1;

            while (tempStart < end) {
                if(str.charAt(tempStart) == str.charAt(end)) {
                    startIndex = startIndex == -1 ? tempStart : startIndex;
                    endIndex = endIndex == -1 ? end : endIndex;
                    tempStart++;
                } else if(startIndex >= 0) {
                    tempStart = start;
                    startIndex = -1;
                    endIndex = -1;
                }
                end--;
            }

            if(startIndex > -1 && endIndex > -1) {
                list.add(str.substring(startIndex, endIndex+1));
                tempCount--;
            }
            ++start;
            tempStart = endIndex > -1 ? endIndex+1 : start;
            end = len-1;
        }

        if(tempCount > 0) {
            list.clear();
            list.add("Impossible");
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> list = sol("tenet", 3);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
