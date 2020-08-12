package com.practice.logging;

import java.util.Map;
import java.util.Set;

public interface ILogger {
    void fatal(Map<String, String> values);
    void error(Map<String, String> values);
    void warn(Map<String, String> values);
    void info(Map<String, String> values);
    void debug(Map<String, String> values);
    void trace(Map<String, String> values);
    Set<LoggerType> getLoggerType();
    Class<?> getClazz();
}
