package com.practice.treebo;

public interface Move {
    default void move(Chessboard chessboard, Cell fromCell, Cell toCell) {
        if (isValidMove(chessboard, fromCell, toCell)) {
            toCell.setPiece(fromCell.getPiece());
            fromCell.setPiece(null);
            fromCell.setOccupied(false);
            toCell.setOccupied(true);
        } else {
            throw new RuntimeException("Not a valid move fromCell " + fromCell + " , toCell : " + toCell);
        }
    }

    boolean isValidMove(Chessboard chessboard, Cell fromCell, Cell toCell);

    default boolean isCheck(Chessboard chessboard, Cell fromCell, Cell toCell) {
        Cell kingCell = chessboard.getKingPieceCell(fromCell.getPiece().getColor().getNext());
        return isValidMove(chessboard, fromCell, kingCell);
    }
}
