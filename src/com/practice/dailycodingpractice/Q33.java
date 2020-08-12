package com.practice.dailycodingpractice;

import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * This problem was asked by Microsoft.
 * <p>
 * Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.
 * <p>
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 * <p>
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 * <p>
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 */
public class Q33 {

    private static final Object dummy = new Object();
    private static final TreeMap<Integer, Object> balancedBinaryTree = new TreeMap<>();

    public static void printMedian(IntStream intStream) {
        intStream.forEach((val) -> {
            System.out.println("Val : " + val);
            balancedBinaryTree.put(val, dummy);
            Class<?> animalClass = null;
            try {
                animalClass = Class.forName("java.util.TreeMap");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
           /* final int first = balancedBinaryTree.;
            int median = first;
            if (balancedBinaryTree.size() % 2 == 0) {
                int second = Optional.ofNullable(balancedBinaryTree.higher(first)).
                        orElseGet(() -> Optional.ofNullable(balancedBinaryTree.lower(first)).
                                orElse(0));
                median += second;
                median /= 2;
            }
            System.out.println(median);*/
        });
    }

    public static void main(String[] args) {
        IntStream intStream = IntStream.generate(() -> (int) Math.round(Math.random() * 1000));
        printMedian(intStream);
    }

}
