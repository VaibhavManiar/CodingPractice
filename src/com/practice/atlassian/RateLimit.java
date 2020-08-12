package com.practice.atlassian;

import java.util.concurrent.TimeUnit;

public class RateLimit {
    private final int count;
    private final Duration duration;

    public RateLimit(int count, Duration duration) {
        this.count = count;
        this.duration = duration;
    }

    public static class Duration {
        private long value;
        private TimeUnit timeUnit;

        public Duration(long value, TimeUnit timeUnit) {
            this.value = value;
            this.timeUnit = timeUnit;
        }

        public long getValue() {
            return value;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }
    }

    public int getCount() {
        return count;
    }

    public Duration getDuration() {
        return duration;
    }
}
