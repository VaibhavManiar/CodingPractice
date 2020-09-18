package com.practice.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Greedy Algorithm
 */
public class FindMaxProfitByDuration {

    public int[] find(int[] profits, int[] deadline) {
        List<Job> jobs = new ArrayList<>();
        int maxDeadLine = 0;

        // Create jobs from input
        for (int i = 0; i < profits.length; i++) {
            jobs.add(new Job(profits[i], deadline[i]));
            if (deadline[i] > maxDeadLine) {
                maxDeadLine = deadline[i];
            }
        }

        // sort jobs descending order
        jobs.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.profit > o2.profit ? -1 : 1;
            }
        });

        // max deadline can be the max slots
        int[] maxProfitSlots = new int[maxDeadLine];

        // set the profit to deadline less priority first so first check as per the deadline we have the empty slot and then go backward.
        // here as per the example : sorted profits : {100, 27, 25, 19, 15},
        //                 and deadline as per that = {2,    2,  1,  1, 3}
        // maxDeadline = 3
        // so if (deadline - 1) < maxDeadline && (deadline - 1) >= 0
        // then slot = (deadline - 1)
        // slots = [100, 27, 15]
        for (Job job : jobs) {
            for (int slotIndex = (job.deadline - 1); slotIndex >= 0 && slotIndex < maxProfitSlots.length; slotIndex--) {
                if (maxProfitSlots[slotIndex] < 1) {
                    maxProfitSlots[slotIndex] = job.profit;
                    break; // found the correct slot for job so break the loop
                }
            }
        }
        return maxProfitSlots;
    }

    private static class Job {
        private final int profit;
        private final int deadline;

        public Job(int profit, int deadline) {
            this.profit = profit;
            this.deadline = deadline;
        }

        public int getProfit() {
            return profit;
        }

        public int getDeadline() {
            return deadline;
        }
    }

    public static void main(String[] args) {
        FindMaxProfitByDuration o = new FindMaxProfitByDuration();
        o.find(new int[]{100, 19, 27, 25, 15}, new int[]{2, 1, 2, 1, 3});
    }
}
