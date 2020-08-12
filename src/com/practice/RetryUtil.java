package com.practice;

import java.util.function.Function;

public class RetryUtil {
    private <T, R> R retry(String taskName, Function<T, R> function, T t, int retryCount, String tripId) {
        Throwable th = null;
        while (retryCount-- > 0) {
            try {
                return function.apply(t);
            } catch (Throwable e) {
                //log.error("Retry task [" + taskName + "] failed for trip id : ["+tripId+"]. Trying to perform again " + e.getMessage(), e);
                th = e;
            }
        }
        //log.error("Retry task [" + taskName + "] failed for trip id : [\"+tripId+\"]. trying to perform again");
        throw th != null ? new RuntimeException(th) : new RuntimeException("Something went wrong while retrying task : " + taskName);
    }

    public static void main(String[] args) {
        RetryUtil util = new RetryUtil();
        String s = "Hi";
        util.retry("ABC", (str) -> {
            if(false) {
                System.out.println("retrying");
                throw new RuntimeException();
            }
            System.out.println(str);
            return true;
        }, s, 3, "123");
    }
}
