package com.practice.sixt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2 {
    public static int solution(String S) {
        int count = 0;

        List<Integer> list = Arrays.stream(S.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for(int j = 0; j<list.size();j++) {
            int maxUptoNow = list.get(0);
            int currCount = 0;
            for (int index = 0; index < list.size(); index++) {
                if (index == j) {
                    continue;
                }
                if (index > 0 && maxUptoNow < list.get(index)) {
                    maxUptoNow = list.get(index);
                    currCount++;
                }
            }
            if (count < currCount) {
                count = currCount;
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 6 2 3 7 4 10"));
    }
}
