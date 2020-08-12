package com.practice.treebo;

public class RookMove implements Move {

    @Override
    public boolean isValidMove(Chessboard chessboard, Cell fromCell, Cell toCell) {
        if(!fromCell.isValidChessBoardCell() || !toCell.isValidChessBoardCell()) {
            return false;
        }

        if(fromCell.getPiece() == null) {
            return false;
        }

        if (toCell.getRow() <= fromCell.getRow() && toCell.getCol() != fromCell.getCol()) {
            return false;
        }

        int fromRow = fromCell.getRow();
        int toRow = toCell.getRow();
        char fromCol = fromCell.getCol();

        while(fromRow != (toRow-1)) {
            if(chessboard.getCells()[fromRow] [fromCol].isOccupied() ) {
                return false;
            }
            fromRow ++;
        }
        return true;
    }
}
