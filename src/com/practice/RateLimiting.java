package com.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiting {

    AtomicInteger atomicInteger = new AtomicInteger();
    int count = 0;
    RateLimiting() {

    }
}
