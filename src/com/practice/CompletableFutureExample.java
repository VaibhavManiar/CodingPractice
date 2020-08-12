package com.practice;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    private static void print() {
        try {
            CompletableFuture.supplyAsync(() -> "ABC").thenAccept(System.out::println);
            System.out.println("Main");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        print();
    }
}
