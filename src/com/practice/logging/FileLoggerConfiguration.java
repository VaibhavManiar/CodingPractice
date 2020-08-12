package com.practice.logging;

import java.nio.file.Files;

public class FileLoggerConfiguration extends LoggerConfiguration {

    private final Files file;
    private final LoggerType loggerType;

    public FileLoggerConfiguration(Template template, Level enabledLogLevel, Files file) {
        super(template, enabledLogLevel);
        this.file = file;
        this.loggerType = LoggerType.FILE;
    }

    public Files getFile() {
        return file;
    }

    @Override
    public LoggerType getLoggerType() {
        return loggerType;
    }
}
