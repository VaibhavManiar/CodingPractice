package com.practice.atlassian;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public abstract class ObjectPool<T> {

    protected final List<T> assignedObjectList;
    protected final int capacity;
    protected final BlockingQueue<T> blockingQueue;

    public ObjectPool(int capacity) {
        this.capacity = capacity;
        this.assignedObjectList = new LinkedList<>();
        this.blockingQueue = new ArrayBlockingQueue<>(capacity);
        this.preInit();
    }

    public ObjectPool(BlockingQueue<T> blockingQueue) {
        this.capacity = blockingQueue.size();
        this.assignedObjectList = new LinkedList<>();
        this.blockingQueue = blockingQueue;
        this.preInit();
    }

    private void preInit() {
        for (int index = 0; index < this.capacity; index++) {
            this.blockingQueue.offer(get());
        }
    }

    protected abstract T get();

    public T assign() {
        try {
            if ((this.blockingQueue.size() + this.assignedObjectList.size()) < this.capacity) {
                this.blockingQueue.offer(get());
            }
            T t = this.blockingQueue.take();
            this.assignedObjectList.add(t);
            return t;
        } catch (Exception e) {
            throw new RuntimeException("Error while assigning object : " + e.getMessage(), e);
        }
    }

    public void release(T t) {
        if (this.assignedObjectList.remove(t)) {
            this.blockingQueue.offer(t);
        }
    }
}
