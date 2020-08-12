package com.practice.atlassian;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelayedObjectPool {
    public static void main(String[] args) {
        ObjectPool<CustomObject> defaultObjectPool = new ObjectPool<CustomObject>(10) {
            @Override
            protected CustomObject get() {
                return new CustomObject();
            }
        };

        CustomObject co = defaultObjectPool.assign();
        defaultObjectPool.release(co);


        ObjectPool<CustomObject> delayedObjectPool = new DelayedObjectPool<CustomObject>(10) {
            @Override
            protected CustomObject get() {
                return new CustomObject(100);
            }
        };
        CustomObject o = delayedObjectPool.assign();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delayedObjectPool.release(o);
    }

    static class CustomObject implements Delayed {

        private long delayInMillis;

        public CustomObject(long delayInMillis) {
            this.delayInMillis = delayInMillis;
        }

        public CustomObject() {
            this.delayInMillis = 1L;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            switch (unit) {
                case MILLISECONDS:
                    return this.delayInMillis;
                case SECONDS:
                    return this.delayInMillis / 1000;
                case MINUTES:
                    return delayInMillis / (60 * 1000);
                case NANOSECONDS:
                    return delayInMillis * (1000 * 1000);
                default:
                    throw new UnsupportedOperationException("timeunit " + unit.name() + " is not supported");
            }
        }

        @Override
        public int compareTo(Delayed o) {
            long thatDelay = o.getDelay(TimeUnit.MILLISECONDS);
            return Long.compare(this.delayInMillis, thatDelay);
        }
    }
}
