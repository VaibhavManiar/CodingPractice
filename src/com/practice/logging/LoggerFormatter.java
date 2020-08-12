package com.practice.logging;

import java.util.Map;

public interface LoggerFormatter {
    String parse(Template template, Map<String, String> values);
}
