package com.practice.treebo;

public class KnightMove implements Move {

    private static final int rowMove[] = {2, 2, 1, -1, -2, -2, 1, -1};
    private static final int colMove[] = {1, -1, 2, 2, 1, -1, -2, -2};

    @Override
    public boolean isValidMove(Chessboard chessboard, Cell fromCell, Cell toCell) {
        if (!fromCell.isValidChessBoardCell() || !toCell.isValidChessBoardCell()) {
            return false;
        }

        if (fromCell.getPiece() == null) {
            return false;
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ( ((char)(fromCell.getCol() + colMove[col])) == toCell.getCol() &&
                        fromCell.getRow() + rowMove[row] == toCell.getRow()) {
                    return true;
                }
            }
        }
        return false;
    }
}
