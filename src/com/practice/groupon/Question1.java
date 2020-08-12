package com.practice.groupon;

import java.util.ArrayList;
import java.util.List;

public class Question1 {

    public static int minNum(int threshold, List<Integer> points) {
        if (points.size() > 0) {
            int min = points.get(0);
            int num = threshold + min;
            int questionToResolve = 1;
            for (int index = 0; index < points.size(); ) {
                if (index + 2 < points.size()) {
                    if ((points.get(index += 2) >= num)) {
                        return ++questionToResolve;
                    }
                } else if (index + 1 < points.size()) {
                    if (points.get(++index) >= num) {
                        return ++questionToResolve;
                    }
                } else {
                    ++index;
                }
                ++questionToResolve;
            }
        }
        return points.size();
    }

    public static void main(String[] args) {
        List<Integer> points = new ArrayList<>();
        points.add(1);
        points.add(2);
        /*points.add(3);
        points.add(5);
        points.add(8);*/
        System.out.println(minNum(4, points));
    }
}
