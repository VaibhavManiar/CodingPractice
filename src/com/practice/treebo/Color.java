package com.practice.treebo;

public enum Color {
    White("W"), Black("B");
    private final String shortCode;
    Color(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public Color getNext() {
        if(Color.White.equals(this)) {
            return Color.Black;
        }
        return Color.White;
    }
}