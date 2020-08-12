package com.practice.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoBrokerTestQ1 {
    public static int lastStoneWeight(List<Integer> weights) {
        weights.sort(Collections.reverseOrder());
        int index = 1;
        int rem = 0;
        while (index < weights.size()) {
            int prev = rem != 0 ? rem : weights.get(index - 1);
            int curr = weights.get(index);
            rem = Math.abs(prev - curr);
            if (rem == 0) {
                index += 2;
            } else {
                index += 1;
            }
        }
        return rem;
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(Arrays.asList(46188086,
                339992587,
                742976890,
                801915058,
                393898202,
                717833291,
                843435009,
                361066046,
                884145908,
                668431192,
                586679703,
                792103686,
                85425451,
                246993674,
                134274127,
                586374055,
                923288873,
                292845117,
                399188845,
                842456591,
                410257930,
                333998862,
                16561419,
                624279391,
                459765367,
                969764608,
                508221973,
                82956997,
                437034793,
                553121267,
                554066040,
                199416087)));
    }
}
