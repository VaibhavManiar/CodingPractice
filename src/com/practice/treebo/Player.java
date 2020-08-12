package com.practice.treebo;

public class Player {
    private final Color pieceColor;
    private final String name;

    public Player(Color pieceColor, String name) {
        this.pieceColor = pieceColor;
        this.name = name;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public String getName() {
        return name;
    }
}
