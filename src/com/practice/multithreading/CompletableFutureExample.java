package com.practice.multithreading;

import java.util.Map;
import java.util.concurrent.*;

public class CompletableFutureExample {

    Map<String, String> map = new ConcurrentHashMap<>();
    ExecutorService es = Executors.newFixedThreadPool(10);
    public void exec() throws ExecutionException, InterruptedException {
        /*CompletableFuture.runAsync(()->{
            System.out.println("Hello");
        }, es).thenAcceptAsync(System.out::println);*/

        System.out.println(CompletableFuture.supplyAsync(()-> "Hello", es).handleAsync((s, th)->{
            System.out.println("Return: " + s);
            map.put(s, s);
            return s;
        }, es).get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureExample o = new CompletableFutureExample();
        o.exec();
    }
}
