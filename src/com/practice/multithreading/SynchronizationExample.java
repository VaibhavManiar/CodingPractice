package com.practice.multithreading;

public class SynchronizationExample {


    private final Lock1 lock1;
    private final Lock2 lock2;
    SynchronizationExample() {
        lock1 = new Lock1();
        lock2 = new Lock2();
    }


    public void m1() {
        synchronized (lock1) {
            try {
                Thread.sleep(5000);
                System.out.println("M1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m2() {
        synchronized (lock2) {
            System.out.println("M2");
        }
    }

    public void m3() {
        System.out.println("M3");
    }

    public static void main(String[] args) {
        SynchronizationExample e = new SynchronizationExample();
        new Thread(e::m1).start();
        new Thread(e::m2).start();
        new Thread(e::m3).start();
    }


    public static class Lock1 {

    }

    public static class Lock2 {

    }
}
