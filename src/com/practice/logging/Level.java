package com.practice.logging;

public enum Level {
    OFF(0), FATAL(100), ERROR(200), WARN(300), INFO(400), DEBUG(500), TRACE(600), ALL(700);
    private int levelInt;

    Level(int levelInt) {
    }

    public int getLevelInt() {
        return levelInt;
    }
}
