package com.practice.atlassian;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LimitCounter {

    // User id vs TimeCounter
    private Map<Integer, TimeCounter> map = new ConcurrentHashMap<>();

    private final int duration = 1;
    private final int limit = 2;

    public boolean rateLimit(int customerId) {
        if(map.containsKey(customerId)) {
            TimeCounter timeCounter = map.get(customerId);
            LocalDateTime localDateTime = timeCounter.getStartTime();
            if(localDateTime.plusSeconds(duration).compareTo(LocalDateTime.now()) > 0) {
                if (isRateLimitReached(timeCounter))
                    return Boolean.FALSE;
            } else {
                System.out.println("Reseting the counter");
                map.remove(customerId);
                return rateLimit(customerId);
            }
        } else {
            map.put(customerId, new TimeCounter(LocalDateTime.now(), new AtomicInteger()));
            return rateLimit(customerId);
        }
        return Boolean.TRUE;
    }

    public boolean rateLimit1(int customerId) {
        if(map.containsKey(customerId)) {
            Boolean x = isRateLimitReachedForCust(customerId);
            if (x != null) return x;
        } else {
            map.put(customerId, new TimeCounter(LocalDateTime.now(), new AtomicInteger()));
            return rateLimit(customerId);
        }
        return Boolean.TRUE;
    }

    private Boolean isRateLimitReachedForCust(int customerId) {
        TimeCounter timeCounter = map.get(customerId);
        LocalDateTime localDateTime = timeCounter.getStartTime();
        if(localDateTime.plusSeconds(duration).compareTo(LocalDateTime.now()) > 0) {
            if (isRateLimitReached(timeCounter))
                return Boolean.FALSE;
        } else {
            map.put(customerId, new TimeCounter(LocalDateTime.now(), new AtomicInteger()));
            return rateLimit(customerId);
        }
        return Boolean.TRUE;
    }

    private void insertAnEntry(int customerId) {
        map.put(customerId, new TimeCounter(LocalDateTime.now(), new AtomicInteger()));
    }
    private boolean isRateLimitReached(TimeCounter timeCounter) {
        int val = timeCounter.getCounter().incrementAndGet();
        if (val > limit) {
            return true;
        }
        return false;
    }

    private static class TimeCounter {
        private final LocalDateTime startTime;
        private final AtomicInteger counter;

        public TimeCounter(LocalDateTime startTime, AtomicInteger counter) {
            this.startTime = startTime;
            this.counter = counter;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public AtomicInteger getCounter() {
            return counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LimitCounter counter = new LimitCounter();
        int custId1 = 1;

        System.out.println("Inserting entry for customer 1 : " + counter.rateLimit(custId1));

        for(int index = 0; index < 10; index++) {
            System.out.println("Inserting entry for customer 1 : " + counter.rateLimit(custId1));
            Thread.sleep(200);
        }
    }
}

