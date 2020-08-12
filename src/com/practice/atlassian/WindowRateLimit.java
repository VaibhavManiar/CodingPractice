package com.practice.atlassian;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class WindowRateLimit {

    Map<String, Counter> rateLimitMap = new ConcurrentHashMap<>();
    RateLimit rateLimit;

    public WindowRateLimit(RateLimit rateLimit) {
        this.rateLimit = rateLimit;
    }

    public boolean isLimitBreached(String clientId) {
        Counter counter = rateLimitMap.getOrDefault(clientId, new Counter());
        rateLimitMap.put(clientId, counter);
        try {
            counter.getLock().lock();

            if (counter.startTime.plusSeconds(this.rateLimit.getDuration().getValue()).compareTo(LocalDateTime.now()) > 0) {
                System.out.println("Time limit is not breached");
                if (isCounterLimitBreached(counter)) return Boolean.TRUE;
            } else {
                System.out.println("Time limit is breached");
                counter.reset();
                if (isCounterLimitBreached(counter)) return Boolean.TRUE;
            }
        } finally {
            counter.getLock().unlock();
        }
        return Boolean.FALSE;
    }

    private boolean isCounterLimitBreached(Counter counter) {
        int count = counter.getCounter().incrementAndGet();
        if (count > rateLimit.getCount()-1) {
            return true;
        }
        return false;
    }


    private static class Counter {
        private LocalDateTime startTime;
        private AtomicInteger counter;
        private ReentrantLock lock;

        public Counter() {
            this.startTime = LocalDateTime.now();
            this.counter = new AtomicInteger(0);
            this.lock = new ReentrantLock();
        }

        public void reset() {
            this.startTime = LocalDateTime.now();
            this.counter = new AtomicInteger(0);
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public AtomicInteger getCounter() {
            return counter;
        }

        public ReentrantLock getLock() {
            return lock;
        }
    }

    private static void testCase1() {
        RateLimit rateLimit = new RateLimit(0, new RateLimit.Duration(1, TimeUnit.SECONDS));
        WindowRateLimit windowRateLimit = new WindowRateLimit(rateLimit);
        windowRateLimit.isLimitBreached("192.168.0.1");
    }

    private static void testCase2() {
        RateLimit rateLimit = new RateLimit(5, new RateLimit.Duration(1, TimeUnit.SECONDS));
        WindowRateLimit windowRateLimit = new WindowRateLimit(rateLimit);
        windowRateLimit.isLimitBreached("192.168.0.1");
    }

    private static void testCase3() {
        RateLimit rateLimit = new RateLimit(5, new RateLimit.Duration(1, TimeUnit.SECONDS));
        WindowRateLimit windowRateLimit = new WindowRateLimit(rateLimit);
        for(int index = 0; index < 10; index++) {
            windowRateLimit.isLimitBreached("192.168.0.1");
        }
    }

    private static void testCase4() {
        RateLimit rateLimit = new RateLimit(5, new RateLimit.Duration(1, TimeUnit.SECONDS));
        WindowRateLimit windowRateLimit = new WindowRateLimit(rateLimit);
        for(int index = 0; index < 10; index++) {
            if(windowRateLimit.isLimitBreached("192.168.0.1")) {
                System.out.println("Limit Breached putting on sleep for 1 sec");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        /*System.out.println("Test Case 1");
        testCase1();

        System.out.println("Test Case 2");
        testCase2();

        System.out.println("Test Case 3");
        testCase3();*/

        testCase4();
    }

}
