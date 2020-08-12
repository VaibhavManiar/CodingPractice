package com.practice.paytm;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter extends Thread {

    private final AtomicInteger counter;
    public Counter(String name, AtomicInteger counter) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (counter) {
                System.out.println(this.getName() + " : " + counter.incrementAndGet());
                counter.notifyAll();
                try {
                    counter.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
