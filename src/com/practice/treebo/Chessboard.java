package com.practice.treebo;

import java.util.HashMap;
import java.util.Map;

public class Chessboard {
    private final Cell[][] cells;

    private final Map<Piece.Type, Move> moveMap;

    public Chessboard() {
        this.cells = new Cell[8][8];
        this.moveMap = new HashMap<>();
        this.init();
    }

    public void init() {
        Color color = Color.Black;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                this.cells[row][col] = new Cell(row, (char) ('A' + col), color);
                color = color.getNext();
            }
            color = color.getNext();
        }

        this.moveMap.put(Piece.Type.Bishop, new BishopMove());
        this.moveMap.put(Piece.Type.King, new KingMove());
        this.moveMap.put(Piece.Type.Pawn, new PawnMove());
        this.moveMap.put(Piece.Type.Rook, new RookMove());
        this.moveMap.put(Piece.Type.Knight, new KnightMove());
        //this.moveMap.put(Piece.Type.Queue, new QueenMove());
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getKingPieceCell(Color color) {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                if (this.cells[row][col].isOccupied() &&
                        this.cells[row][col].getPiece() != null &&
                        Piece.Type.King.equals(this.cells[row][col].getPiece().getType()) &&
                        this.cells[row][col].getPiece().getColor().equals(color)) {
                    return this.cells[row][col];
                }
            }
        }
        throw new RuntimeException("Invalid state exception king of color [" + color + "] not found");
    }

    public void move(Cell fromCell, Cell toCell) {
        if (!fromCell.isOccupied() || fromCell.getPiece() == null) {
            throw new RuntimeException("No piece found at cell :" + fromCell);
        }
        moveMap.get(fromCell.getPiece().getType()).move(this, fromCell, toCell);
    }
}
