package com.practice.ratelimit;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aayush
 * This is a thread safe static singleton class which maintains all
 * the rate limiting policies in the form of a concurrent hash map.
 * The key of the map is the instance id while the value is the Rate
 * Limit Executor object.
 * Based on the key supplied the appropriate Rate Limiter is invoked.
 */
public final class RateLimitManager {
    // Static singleton class which is thread safe from multiple instantiation race conditions in traiditonal sigletons
    public static final RateLimitManager _instance = new RateLimitManager();
    // Container for keeping track of all provisioned rate limits.
    private final ConcurrentHashMap<String, RateLimitExecutor> rateLimitMap = new ConcurrentHashMap<String, RateLimitExecutor>();
    // Thread pool initialization
    private final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // To provision a new Rate Limit Policy and executor. Callback interface to receive notifications
    public void provisionRateLimit(RateLimitExecutor executor, String instanceId, RateLimitListener callbackListener) {
        executor.setListener(callbackListener);
        rateLimitMap.put(instanceId, executor);
    }

    // To remove a rate limit policy
    public void deProvisionRateLimit(String instance_id) {
        try {
            rateLimitMap.remove(instance_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // API Call to peg traffic and evaluate the rate limit provisioned
    public void pegTraffic(String instance_id) {
        rateLimitMap.get(instance_id).evalute();
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }
}