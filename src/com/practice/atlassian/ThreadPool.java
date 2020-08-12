package com.practice.atlassian;

public class ThreadPool extends ObjectPool<Thread> {

    private final Runnable runnable;
    public ThreadPool(int capacity, int blockingQueueSize, Runnable runnable) {
        super(capacity);
        this.runnable = runnable;
    }

    public ThreadPool(int capacity, Runnable runnable) {
        super(capacity);
        this.runnable = runnable;
    }

    @Override
    protected Thread get() {
        return new Thread(this.runnable);
    }
}
