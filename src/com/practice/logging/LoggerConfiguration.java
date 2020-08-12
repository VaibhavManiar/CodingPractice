package com.practice.logging;

public abstract class LoggerConfiguration {
    private final Template template;
    private final Level enabledLogLevel;

    public LoggerConfiguration(Template template, Level enabledLogLevel) {
        this.template = template;
        this.enabledLogLevel = enabledLogLevel;
    }

    public Template getTemplate() {
        return template;
    }

    public Level getEnabledLogLevel() {
        return enabledLogLevel;
    }

    public abstract LoggerType getLoggerType();
}
