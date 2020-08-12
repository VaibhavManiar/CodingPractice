package com.practice.treebo;

public class PawnMove implements Move {

    @Override
    public boolean isValidMove(Chessboard chessboard, Cell fromCell, Cell toCell) {

        if(!fromCell.isValidChessBoardCell() || !toCell.isValidChessBoardCell()) {
            return false;
        }

        if(fromCell.getPiece() == null) {
            return false;
        }

        if (toCell.getRow() == (fromCell.getRow() + 1) && toCell.getCol() == fromCell.getCol()) {
            return true;
        }
        else if (toCell.getRow() == (fromCell.getRow() + 1) && (((char) (fromCell.getCol() - 1)) == toCell.getCol() ||
                ((char) (fromCell.getCol() + 1)) == toCell.getCol()) &&
                (toCell.isOccupied() && toCell.getPiece() != null && toCell.getPiece().getColor() != fromCell.getPiece().getColor())) {
            return true;
        }
        return false;
    }
}
