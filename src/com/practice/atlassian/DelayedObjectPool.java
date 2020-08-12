package com.practice.atlassian;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public abstract class DelayedObjectPool<T extends Delayed> extends ObjectPool<T> {

    private final int capacity;
    public DelayedObjectPool(int capacity) {
        super(new DelayQueue<>());
        this.capacity = capacity;
    }

    @Override
    public T assign() {
        try {
            if(this.blockingQueue.isEmpty() && this.assignedObjectList.size() < this.capacity) {
                this.blockingQueue.put(get());
            }
            T t = this.blockingQueue.take();
            this.assignedObjectList.add(t);
            return t;
        } catch (Exception e) {
            throw new RuntimeException("Error while assigning object : " + e.getMessage(), e);
        }
    }
}
