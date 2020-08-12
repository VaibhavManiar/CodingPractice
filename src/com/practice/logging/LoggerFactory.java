package com.practice.logging;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class LoggerFactory implements ILoggerFactory {

    private static final Map<LoggerType, LoggerConfiguration> configurationMap = new ConcurrentHashMap<>();
    private static final LoggerFactory instance = new LoggerFactory();
    private static ILogFormatterFactory logFormatterFactory;

    private LoggerFactory() {
    }

    public static LoggerFactory getInstance() {
        return instance;
    }

    public static void registerLogger(LoggerConfiguration configuration, ILogFormatterFactory logFormatterFact) {
        configurationMap.put(configuration.getLoggerType(), configuration);
        logFormatterFactory = logFormatterFact;
    }

    @Override
    public ILogger getLogger(Class<?> clazz) {
        return new Logger(configurationMap, logFormatterFactory, clazz);
    }
}
