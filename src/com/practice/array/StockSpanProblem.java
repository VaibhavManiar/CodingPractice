package com.practice.array;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StockSpanProblem {

    public static int[] cal(int[] prices) {
        int[] sol = new int[prices.length];
        Stack<Integer> tempStack = new Stack<>();

        sol[0] = 1;
        tempStack.push(0);

        for (int index = 1; index < prices.length; index++) {

            while (!tempStack.isEmpty() && prices[tempStack.peek()] < prices[index]) {
                tempStack.pop();
            }

            sol[index] = tempStack.isEmpty() ? index + 1 : index - tempStack.peek();
            tempStack.push(index);
        }
        return sol;
    }

    public static void main(String[] args) {
        Arrays.stream(cal(new int[]{10, 4, 5, 90, 120, 80})).forEach(System.out::println);
    }
}
