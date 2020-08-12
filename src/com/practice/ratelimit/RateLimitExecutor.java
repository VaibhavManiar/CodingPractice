package com.practice.ratelimit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author aayush
 * This class calculates the TPS and applies the throttling policy
 * It uses granular write locking for thread safety.
 */
public class RateLimitExecutor {
    // Defaults to seconds
    private TimeUnit timeUnit;
    // Current transactions counted
    private long transactions = 0L;
    // Transactions per second allOFowed
    private long threshold;
    // Timestamp for evaluation
    private final double timeStamp;
    // Thread Safety aids
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    ReentrantLock lock = new  ReentrantLock();
    private final WriteLock wLock = rwLock.writeLock();
    // Callback handle
    private RateLimitListener listener;

    private RateLimitExecutor() {
        this.timeStamp = System.currentTimeMillis();
    }

    public void evalute() {
        System.out.println("Starting Rate Limit evaluation. " + "Threshold set is: " + threshold);
        ++transactions;
        wLock.lock();
        // Take the current timestamp
        long currentTime = System.currentTimeMillis();
        // Get the delta time elapsed
        double deltaTime = (currentTime - timeStamp);
        System.out.println("Delta time elapsed: " + deltaTime);
        // Calculate transactions per second
        // Calculated Transactions per second
        long tps = (long) (transactions / deltaTime * 1000L);
        // Don’t print TPS on the very first hit as its misleading
        if (transactions != 1)
            System.out.println("TPS is — " + tps);
        // What is higher, TPS threshold or transactions per second?
        // Exclude the very first transaction to avoid false positives
        if (tps >= threshold && transactions != 1) {
            System.out.println("Rate limit has been breached, Transaction Number: " + transactions +
                    "in delta time(milliseconds): " + deltaTime + "Threshold: " + threshold);
            RateLimitManager._instance.getThreadPool().execute(new WorkerThread(listener));
        }
        // Leave write lock
        wLock.unlock();
    }

    public static RateLimitExecutor build(TimeUnit time, long threshold) {
        RateLimitExecutor executor = new RateLimitExecutor();
        executor.timeUnit = time;
        executor.threshold = threshold;
        return executor;
    }

    public void setListener(RateLimitListener listener) {
        this.listener = listener;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public Long getTransactions() {
        return transactions;
    }

    public long getThreshold() {
        return threshold;
    }
}