package com.practice.multithreading;

public class StaticSynchronizationExample {
    public static synchronized void foo() throws InterruptedException {
        System.out.println("static synchronized 1");
        Thread.sleep(10000);
    }

    public static synchronized void koo() throws InterruptedException {
        System.out.println("static synchronized 2");
        Thread.sleep(10000);
    }

    public synchronized void hoo() {
        System.out.println("non - static synchronized 1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void moo() {
        System.out.println("non - static synchronized 2");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void noo() {
        System.out.println("non - synchronized");
    }

    public static void main(String[] args) {
        StaticSynchronizationExample obj = new StaticSynchronizationExample();

        Thread t1 = new Thread(()-> {
            try {
                obj.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(obj::hoo);

        Thread t3 = new Thread(()-> {
            try {
                obj.koo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(obj::moo);

        Thread t5 = new Thread(obj::noo);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
