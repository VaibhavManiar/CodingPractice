package com.practice.paytm;

import java.util.concurrent.atomic.AtomicInteger;

public class Question1 {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        Counter counter1 = new Counter("T1", counter);
        Counter counter2 = new Counter("T2", counter);
        counter1.start();
        counter2.start();
    }
}
