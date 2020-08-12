package com.practice.logging;

public abstract class Template {
    private final String pattern;
    private final String dateTimeFormat;

    public Template(String pattern, String dateTimeFormat) {
        this.pattern = pattern;
        this.dateTimeFormat = dateTimeFormat;
    }

    public String getPattern() {
        return pattern;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }
}
