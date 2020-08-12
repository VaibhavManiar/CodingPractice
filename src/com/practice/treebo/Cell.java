package com.practice.treebo;

public class Cell {
    private final int row;
    private final char col;
    private boolean isOccupied;
    private final Color color;
    private Piece piece;

    public Cell(int row, char col,  Color color) {
        this.row = row;
        this.col = col;
        this.isOccupied = false;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public char getCol() {
        return col;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Color getColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isValidChessBoardCell () {
        if ((this.getRow() >= 8 || this.getRow() < 0 ) || (this.getCol() < 'A' || this.getCol() > 'H')) {
            return false;
        }
        return true;
    }

    public void empty() {

    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", isOccupied=" + isOccupied +
                ", color=" + color +
                ", piece=" + piece +
                '}';
    }
}
