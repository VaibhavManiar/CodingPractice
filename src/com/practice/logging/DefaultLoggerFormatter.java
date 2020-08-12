package com.practice.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class DefaultLoggerFormatter implements LoggerFormatter {

    @Override
    public String parse(Template template, Map<String, String> values) {
        String formattedLog = template.getPattern();
        if(formattedLog.contains("-X{nowDateTime}")) {
            formattedLog = formattedLog.replaceAll("-X\\{nowDateTime}",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern(template.getDateTimeFormat())));
        }
        return formattedLog;
    }
}
