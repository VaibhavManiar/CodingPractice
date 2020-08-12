package com.practice.treebo;

public class BishopMove implements Move {
    @Override
    public boolean isValidMove(Chessboard chessboard, Cell fromCell, Cell toCell) {
        if(!fromCell.isValidChessBoardCell() || !toCell.isValidChessBoardCell()) {
            return false;
        }

        if(fromCell.getPiece() == null) {
            return false;
        }

        int fromRow = fromCell.getRow();
        int toRow = toCell.getRow();
        char fromCol = fromCell.getCol();
        char toCol = toCell.getCol();

        // Move diagonal down right
        if(toCell.getRow() > fromCell.getRow() && toCell.getCol() > fromCell.getCol()) {
            while(fromRow != toRow && fromCol != toCol) {
                if(fromRow > 7 || fromCol > 'H') {
                    return false;
                }
                if(chessboard.getCells()[fromRow][(int)fromCol].isOccupied()) {
                    return false;
                }
                fromRow++;
                fromCol = (char)(fromCol + 1);
            }
            return true;
        }

        // Move diagonal down left
        if(toCell.getRow() > fromCell.getRow() && toCell.getCol() < fromCell.getCol()) {

            while(fromRow != toRow && fromCol != toCol) {
                if(fromRow > 7 || fromCol < 'A') {
                    return false;
                }
                if(chessboard.getCells()[fromRow][(int)fromCol].isOccupied()) {
                    return false;
                }
                fromRow++;
                fromCol = (char)(fromCol - 1);
            }
            return true;
        }


        // Move diagonal up left
        if(toCell.getRow() < fromCell.getRow() && toCell.getCol() < fromCell.getCol()) {
            while(fromRow != toRow && fromCol != toCol) {
                if(fromRow < 7 || fromCol < 'A') {
                    return false;
                }
                if(chessboard.getCells()[fromRow][(int)fromCol].isOccupied()) {
                    return false;
                }
                fromRow--;
                fromCol = (char)(fromCol - 1);
            }
            return true;
        }

        // Move diagonal up right
        if(toCell.getRow() < fromCell.getRow() && toCell.getCol() > fromCell.getCol()) {
            while(fromRow != toRow && fromCol != toCol) {
                if(fromRow < 7 || fromCol > 'H') {
                    return false;
                }
                if(chessboard.getCells()[fromRow][(int)fromCol].isOccupied()) {
                    return false;
                }
                fromRow--;
                fromCol = (char)(fromCol + 1);
            }
            return true;
        }
        return false;
    }
}
