package com.practice.prudential;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        /*int threshold = 612271938;
        List<Integer> arr = new ArrayList<>();
        arr.add(305709952);
        arr.add(617901827);
        arr.add(559066417);
        arr.add(846642314);
        arr.add(349430261);
        arr.add(930100012);
        arr.add(425149509);
        arr.add(50710994);
        arr.add(348655290);
        arr.add(207497545);
        arr.add(663923396);
        arr.add(873283308);
        arr.add(243509537);
        arr.add(657804153);
        arr.add(547001100);
        arr.add(203492670);
        arr.add(344685642);
        arr.add(808597188);
        arr.add(129005353);
        arr.add(142684482);
        arr.add(387013286);
        arr.add(58302119);
        arr.add(216770904);
        arr.add(793436542);
        arr.add(234999067);
        arr.add(471073451);
        arr.add(42602919);
        arr.add(10272918);
        arr.add(326437084);
        arr.add(774854236);
        arr.add(544470926);
        arr.add(507360048);

        int minimumDivisor = 0;
        long currSum = Long.MAX_VALUE;
        while (currSum > threshold) {
            long sum = 0;
            minimumDivisor++;
            for (int val : arr) {
                int v = (val / minimumDivisor);
                if(val % minimumDivisor > 0) {
                    v = v +1;
                }
                sum += v;
            }
            currSum = sum;
        }
        System.out.println(minimumDivisor);

        A a = new A() {
            public void foo() {}
        };*/
        int mask = 0x000F;
        int value = 0x2222;
        System.out.println(value & mask);
    }

    static class A {
        public void foo() {}
    }


}
