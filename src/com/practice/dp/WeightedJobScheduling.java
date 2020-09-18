package com.practice.dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given N jobs where every job is represented by following three elements of it.
 * <p>
 * Start Time
 * Finish Time
 * Profit or Value Associated (>= 0)
 * Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 */
public class WeightedJobScheduling {

    public static int sol(List<Job> jobs) {
        jobs.sort(Comparator.comparing(j -> j.end));

        List<Profit> profits = new ArrayList<>();
        for (Job job : jobs) {
            profits.add(new Profit(-1, job.profit));
        }

        for (int i = 1; i < jobs.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (jobs.get(j).end <= jobs.get(i).start) {
                    profits.get(i).setProfit(Math.max(profits.get(i).profit, profits.get(j).profit + jobs.get(i).profit));
                    profits.get(i).setPreJobIndex(j);
                }
            }
        }

        Profit maxProfit = maxProfit(profits);
        return maxProfit.profit;
    }

    private static Profit maxProfit(List<Profit> profits) {
        Profit maxProfit = new Profit(-1, Integer.MIN_VALUE);
        for (Profit profit : profits) {
            if (maxProfit.getProfit() < profit.getProfit()) {
                maxProfit.setProfit(profit.getProfit());
            }
        }
        return maxProfit;
    }

    public static class Job {
        private final Integer start;
        private final Integer end;
        private final Integer profit;

        public Job(Integer start, Integer end, Integer profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        public Integer getStart() {
            return start;
        }

        public Integer getEnd() {
            return end;
        }

        public Integer getProfit() {
            return profit;
        }
    }

    public static class Profit {
        private int preJobIndex;
        private int profit;

        public Profit(int preJobIndex, int profit) {
            this.preJobIndex = preJobIndex;
            this.profit = profit;
        }

        public int getPreJobIndex() {
            return preJobIndex;
        }

        public void setPreJobIndex(int preJobIndex) {
            this.preJobIndex = preJobIndex;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }
    }

    //Job arr[] = {{3, 10, 20}, {1, 2, 50}, {6, 19, 100}, {2, 100, 200}};
    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(3, 10, 20));
        jobs.add(new Job(1, 2, 50));
        jobs.add(new Job(6, 19, 100));
        jobs.add(new Job(2, 100, 200));
        System.out.println(sol(jobs));
    }
}

