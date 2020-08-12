package com.practice.array;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Scheduler<R> {

    private final SchedulableTask<R> schedulableTask;
    private final long durationInMillis;
    private OnCompleteTask<R> onCompleteTask;

    private Scheduler(SchedulableTask<R> schedulableTask, long durationInMillis, OnCompleteTask<R> onCompleteTask) {
        this.schedulableTask = schedulableTask;
        this.durationInMillis = durationInMillis;
        this.onCompleteTask = onCompleteTask;
    }

    public void start() throws InterruptedException, ExecutionException {
        while (true) {
            CompletableFuture.supplyAsync(schedulableTask).thenAcceptAsync((r) -> {
                if (onCompleteTask != null)
                    onCompleteTask.apply(r);
            }).get();
            System.out.println("Putting thread on sleep mode.");
            System.out.println("Main thread : " + Thread.currentThread().getId());
            Thread.sleep(durationInMillis);
        }
    }

    public void stop() {
        Thread.currentThread().interrupt();
    }

    public interface OnCompleteTask<R> {
        void apply(R r);
    }

    public interface SchedulableTask<R> extends Supplier<R> {

    }

    public static class Builder<R> {
        private final SchedulableTask<R> schedulableTask;
        private final long durationInMillis;
        private OnCompleteTask<R> onCompleteTask;

        public Builder(SchedulableTask<R> schedulableTask, long durationInMillis) {
            this.schedulableTask = schedulableTask;
            this.durationInMillis = durationInMillis;
        }

        public Builder<R> onCompleteTask(OnCompleteTask<R> task) {
            this.onCompleteTask = task;
            return this;
        }

        public Scheduler<R> build() {
            return new Scheduler<>(schedulableTask, durationInMillis, onCompleteTask);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new Builder<>(new SchedulableTask<String>() {
            @Override
            public String get() {
                for(int i=0; i<1000; i++) {
                    String s = "";
                }
                System.out.println("Async task thread : " + Thread.currentThread().getId());
                return "Running scheduled tasks";
            }
        }, 1000L).onCompleteTask(new OnCompleteTask<String>() {
            @Override
            public void apply(String s) {
                System.out.println(s);
            }
        }).build().start();
    }
}
