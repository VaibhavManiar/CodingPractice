package com.practice.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class SleepVsWaitTeat {

    public final AtomicInteger counter = new AtomicInteger(0);
    public void increment() {
        while (counter.get() < 1000 ) {
            synchronized (this) {
                if (counter.get() < 1000) {
                    System.out.println(Thread.currentThread().getName() + " : " + counter.incrementAndGet());
                    try {
                        this.notifyAll();
                        this.wait();
                    } catch (InterruptedException | IllegalMonitorStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SleepVsWaitTeat obj = new SleepVsWaitTeat();
        Thread t1 = new Thread(obj::increment, "T1");
        Thread t2 = new Thread(obj::increment, "T2");
        t1.start();
        t2.start();
    }
}
