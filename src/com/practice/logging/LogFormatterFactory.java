package com.practice.logging;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogFormatterFactory implements ILogFormatterFactory {

    Map<FormatterType, LoggerFormatter> logFormatterMap = new ConcurrentHashMap<>();

    public LogFormatterFactory(Map<FormatterType, LoggerFormatter> logFormatterMap) {
        this.logFormatterMap = logFormatterMap;
    }

    public LogFormatterFactory() {
        this.logFormatterMap = new ConcurrentHashMap<>();
        this.logFormatterMap.put(FormatterType.DEFAULT, new DefaultLoggerFormatter());
    }

    @Override
    public LoggerFormatter getFormatter(FormatterType formatterType) {
        switch (formatterType) {
            case DEFAULT:
                new DefaultLoggerFormatter();
            default:
                throw new UnsupportedOperationException("Formatter is not registered : " + formatterType.name());
        }
    }
}
