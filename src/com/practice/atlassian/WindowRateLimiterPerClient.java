package com.practice.atlassian;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WindowRateLimiterPerClient {

    private final Map<String, Counter> userVsRateLimitMap = new ConcurrentHashMap<>();
    private final RateLimit rateLimit;


    public WindowRateLimiterPerClient(RateLimit rateLimit) {
        this.rateLimit = rateLimit;
    }

    public boolean isLimitBreached(String clientId) {
        Counter counter = userVsRateLimitMap.get(clientId);
        if(counter == null) {
            counter = new Counter();
            userVsRateLimitMap.put(clientId, counter);
        }
        try {
            counter.writeLock.lock();
            boolean isRateLimitBreached = false;
            if (LocalDateTime.now().compareTo(counter.getStartTime().plusSeconds(this.rateLimit.getDuration().getSeconds())) > 0) {
                isRateLimitBreached = isRateLimitCounterBreached(counter);
            } else {
                counter.reset();
                isRateLimitBreached = isRateLimitCounterBreached(counter);
            }
            return isRateLimitBreached;
        } finally {
            counter.writeLock.unlock();
        }
    }

    private boolean isRateLimitCounterBreached(Counter counter) {
        if (counter.incrementAndGet() <= this.rateLimit.getRateLimitCount()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    public static class RateLimit {
        private final int rateLimitCount;
        private final Duration duration;

        public RateLimit(int rateLimitCount, long duration, ChronoUnit unit) {
            this.rateLimitCount = rateLimitCount;
            this.duration = Duration.of(duration, unit);
        }

        public int getRateLimitCount() {
            return rateLimitCount;
        }

        public Duration getDuration() {
            return duration;
        }
    }

    private static class Counter {
        private AtomicInteger counter;
        private LocalDateTime startTime;
        private ReentrantReadWriteLock.WriteLock writeLock;

        Counter() {
            this.counter = new AtomicInteger(0);
            this.startTime = LocalDateTime.now();
            this.writeLock = new ReentrantReadWriteLock().writeLock();
        }

        public void reset() {
            this.counter = new AtomicInteger(0);
            this.startTime = LocalDateTime.now();
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public int incrementAndGet() {
            return this.counter.incrementAndGet();
        }
    }

}
