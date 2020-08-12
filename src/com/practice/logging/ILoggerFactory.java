package com.practice.logging;

public interface ILoggerFactory {
    ILogger getLogger(Class<?> clazz);
}
