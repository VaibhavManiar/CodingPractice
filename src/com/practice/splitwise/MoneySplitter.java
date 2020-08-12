package com.practice.splitwise;

import java.util.Arrays;

public class MoneySplitter {

    public MoneySplitter() {

    }
    static double[] expenseNeutralization = new double[4];
    public static void sol(double[] usersContribution) {
        int userCount = usersContribution.length;
        double totalAmount = Arrays.stream(usersContribution).sum();
        double perUserExpense = totalAmount/userCount;

        //double[] expenseNeutralization = new double[userCount];

        for(int index=0; index<userCount; index++) {
            double userContribution = usersContribution[index];
            expenseNeutralization[index] += userContribution - perUserExpense;
        }

        for(int index=0; index<userCount; index++) {
            System.out.println(expenseNeutralization[index]);
        }

    }

    public static void main(String[] args) {
        sol(new double[] {1000, 0, 0, 0});
        System.out.println("==================");
        sol(new double[] {0, 1000, 0, 0});
        System.out.println("==================");
        sol(new double[] {0, 0, 1200, 0});
        System.out.println("==================");
        sol(new double[] {0, 0, 0, 1000});
    }

}
