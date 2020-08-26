package com.practice.multithreading;

import io.reactivex.Completable;

public class RxJavaExample {

    public void exec() throws InterruptedException {
        Completable.fromCallable(() -> {
            String s = "Callable Tread";
            return s;
        }).doOnComplete(() -> {
            System.out.println("Completed");;
        }).subscribe();
        System.out.println("Main Thread");
        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException {
        RxJavaExample o = new RxJavaExample();
        o.exec();
    }
}
