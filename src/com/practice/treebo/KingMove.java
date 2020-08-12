package com.practice.treebo;

public class KingMove implements Move {
    @Override
    public boolean isValidMove(Chessboard chessboard, Cell fromCell, Cell toCell) {

        if (!fromCell.isOccupied() || fromCell.getPiece() == null) {
            return false;
        }

        if (!fromCell.isValidChessBoardCell() || !toCell.isValidChessBoardCell()) {
            return false;
        }

        if (isMoveUpValid(fromCell, toCell)
                ||
                isMoveDownValid(fromCell, toCell)
                ||
                isValidAdjacentMove(fromCell, toCell)) {
            return true;
        }
        return false;
    }

    private boolean isValidAdjacentMove(Cell fromCell, Cell toCell) {
        return (toCell.getRow() == fromCell.getRow()) &&
                (((char) (toCell.getCol() - 1)) == fromCell.getCol()) ||
                ((char) (toCell.getCol() + 1)) == fromCell.getCol();
    }

    private boolean isMoveUpValid(Cell fromCell, Cell toCell) {
        return (toCell.getRow() - 1 == fromCell.getRow()) &&
                (((char) (toCell.getCol() - 1)) == fromCell.getCol()) ||
                ((char) (toCell.getCol() + 1)) == fromCell.getCol() ||
                (toCell.getCol()) == fromCell.getCol();
    }

    private boolean isMoveDownValid(Cell fromCell, Cell toCell) {
        return (toCell.getRow() + 1 == fromCell.getRow()) &&
                (((char) (toCell.getCol() - 1)) == fromCell.getCol()) ||
                ((char) (toCell.getCol() + 1)) == fromCell.getCol() ||
                (toCell.getCol()) == fromCell.getCol();
    }
}
