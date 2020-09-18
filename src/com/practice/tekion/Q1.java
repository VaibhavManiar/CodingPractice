package com.practice.tekion;

import java.util.concurrent.atomic.AtomicInteger;

public class Q1 {

    private final AtomicInteger atomicInteger;

    public Q1(AtomicInteger integer) {
        this.atomicInteger = integer;
    }

    public void print() {
        while (this.atomicInteger.get() <= 20) {
            synchronized (this) {
                //System.out.println("In synchronized block");
                if (Thread.currentThread().getName().equals("T" +( (this.atomicInteger.get() % 4) + 1))) {
                    System.out.println(Thread.currentThread().getName() + " : " + this.atomicInteger.getAndIncrement());
                }
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Q1 q1 = new Q1(atomicInteger);

        new Thread(q1::print, "T1").start();
        new Thread(q1::print, "T2").start();
        new Thread(q1::print, "T3").start();
        new Thread(q1::print, "T4").start();
    }
}
