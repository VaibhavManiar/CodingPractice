package com.practice.logging;

public interface ILogFormatterFactory {
    LoggerFormatter getFormatter(FormatterType formatterType);
}
