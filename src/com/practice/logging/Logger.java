package com.practice.logging;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Logger implements ILogger {

    private final Class<?> clazz;
    private final Set<ILogger> loggers = new HashSet<>();
    private final Map<LoggerType, LoggerConfiguration> configurationMap;
    private final ILogFormatterFactory logFormatterFactory;

    public Logger(Map<LoggerType, LoggerConfiguration> configurationMap, ILogFormatterFactory logFormatterFactory, Class<?> clazz) {
        this.clazz = clazz;
        this.configurationMap = configurationMap;
        this.logFormatterFactory = logFormatterFactory;
        this.init(configurationMap, logFormatterFactory);
    }

    private void init(Map<LoggerType, LoggerConfiguration> configurationMap, ILogFormatterFactory logFormatterFactory) {
        for (Map.Entry<LoggerType, LoggerConfiguration> loggerConfigurationEntry : configurationMap.entrySet()) {
            loggers.add(create(loggerConfigurationEntry.getValue(), logFormatterFactory));
        }
    }

    private ILogger create(LoggerConfiguration loggerConfiguration, ILogFormatterFactory logFormatterFactory) {
        switch (loggerConfiguration.getLoggerType()) {
            case FILE:
                return new FileLogger(loggerConfiguration, logFormatterFactory.getFormatter(FormatterType.DEFAULT), clazz);
            case CONSOLE:
                return new ConsoleLogger(loggerConfiguration, logFormatterFactory.getFormatter(FormatterType.DEFAULT), this.clazz);
            default:
                throw new UnsupportedOperationException("Logger type not supported : " + loggerConfiguration.getLoggerType());
        }
    }

    @Override
    public void fatal(Map<String, String> values) {
        loggers.forEach(logger -> logger.fatal(values));
    }

    @Override
    public void error(Map<String, String> values) {
        loggers.forEach(logger -> logger.error(values));
    }

    @Override
    public void warn(Map<String, String> values) {
        loggers.forEach(logger -> logger.warn(values));
    }

    @Override
    public void info(Map<String, String> values) {
        loggers.forEach(logger -> logger.info(values));
    }

    @Override
    public void debug(Map<String, String> values) {
        loggers.forEach(logger -> logger.debug(values));
    }

    @Override
    public void trace(Map<String, String> values) {
        loggers.forEach(logger -> logger.trace(values));
    }

    @Override
    public Set<LoggerType> getLoggerType() {
        return this.configurationMap.keySet();
    }

    @Override
    public Class<?> getClazz() {
        return this.clazz;
    }

    public static class ConsoleLogger implements ILogger {

        private final Class<?> clazz;
        private final LoggerConfiguration loggerConfiguration;
        private final LoggerFormatter loggerFormatter;

        public ConsoleLogger(LoggerConfiguration loggerConfiguration, LoggerFormatter loggerFormatter, Class<?> clazz) {
            this.clazz = clazz;
            this.loggerConfiguration = loggerConfiguration;
            this.loggerFormatter = loggerFormatter;
        }

        private boolean canLog(Level level) {
            return loggerConfiguration.getEnabledLogLevel().getLevelInt() <= level.getLevelInt();
        }

        @Override
        public void fatal(Map<String, String> values) {
            if (canLog(Level.FATAL))
                System.out.println(loggerFormatter.parse(loggerConfiguration.getTemplate(), values));
        }

        @Override
        public void error(Map<String, String> values) {
            if (canLog(Level.ERROR))
                System.out.println(loggerFormatter.parse(loggerConfiguration.getTemplate(), values));
        }

        @Override
        public void warn(Map<String, String> values) {
            if (canLog(Level.WARN))
                System.out.println(loggerFormatter.parse(loggerConfiguration.getTemplate(), values));
        }

        @Override
        public void info(Map<String, String> values) {
            if (canLog(Level.INFO))
                System.out.println(loggerFormatter.parse(loggerConfiguration.getTemplate(), values));
        }

        @Override
        public void debug(Map<String, String> values) {
            if (canLog(Level.DEBUG))
                System.out.println(loggerFormatter.parse(loggerConfiguration.getTemplate(), values));
        }

        @Override
        public void trace(Map<String, String> values) {
            if (canLog(Level.TRACE))
                System.out.println(loggerFormatter.parse(loggerConfiguration.getTemplate(), values));
        }

        @Override
        public Set<LoggerType> getLoggerType() {
            Set<LoggerType> loggerTypes = new HashSet<>();
            loggerTypes.add(LoggerType.FILE);
            return loggerTypes;
        }

        @Override
        public Class<?> getClazz() {
            return this.clazz;
        }
    }

    public static class FileLogger implements ILogger {

        private final Class<?> clazz;
        private final LoggerConfiguration loggerConfiguration;
        private final LoggerFormatter loggerFormatter;

        public FileLogger(LoggerConfiguration loggerConfiguration, LoggerFormatter loggerFormatter, Class<?> clazz) {
            this.clazz = clazz;
            this.loggerConfiguration = loggerConfiguration;
            this.loggerFormatter = loggerFormatter;
        }

        @Override
        public void fatal(Map<String, String> values) {

        }

        @Override
        public void error(Map<String, String> values) {

        }

        @Override
        public void warn(Map<String, String> values) {

        }

        @Override
        public void info(Map<String, String> values) {

        }

        @Override
        public void debug(Map<String, String> values) {

        }

        @Override
        public void trace(Map<String, String> values) {

        }

        @Override
        public Set<LoggerType> getLoggerType() {
            Set<LoggerType> loggerTypes = new HashSet<>();
            loggerTypes.add(LoggerType.FILE);
            return loggerTypes;
        }

        @Override
        public Class<?> getClazz() {
            return this.clazz;
        }
    }
}
