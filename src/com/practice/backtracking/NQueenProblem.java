package com.practice.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Here 1 means occupied
 * 0 means not occupied
 */
public class NQueenProblem {

    public static boolean solve(int[][] board, Square currSquare, Map<Integer, Square> positions) {

        if(currSquare.row < 0) {
            return Boolean.FALSE;
        }

        if (currSquare.row == board.length) {
            return Boolean.TRUE;
        }

        boolean isValidSquare=Boolean.FALSE;
        for (int colIndex = currSquare.col; colIndex < board.length; colIndex++) {
            if (isSafeSquare(positions, new Square(currSquare.row, colIndex), board.length, board[0].length)) {
                positions.put(currSquare.row, new Square(currSquare.row, colIndex));
                isValidSquare=true;
                break;
            }
        }
        if(isValidSquare) {
            return solve(board, new Square(currSquare.row+1, 0), positions);
        } else {
            Square preRowSquare = positions.get(currSquare.row-1);
            positions.remove(preRowSquare.row);
            return solve(board, new Square(preRowSquare.row, preRowSquare.col+1), positions);
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[4][4], new Square(0, 0), new HashMap<>()));
    }

    private static boolean isSafeSquare(Map<Integer, Square> positions, Square square, int ROW, int COL) {
        return isHorizontallySafe(positions, square) && isVerticallySafe(positions, square) && isDiagonallySafe(positions, square, ROW, COL);
    }

    private static boolean isHorizontallySafe(Map<Integer, Square> positions, Square square) {
        return !positions.containsKey(square.row);
    }

    private static boolean isVerticallySafe(Map<Integer, Square> positions, Square square) {
        return !positions.keySet().stream().anyMatch(r->positions.get(r).col == square.col);
    }

    private static boolean isDiagonallySafe(Map<Integer, Square> positions, Square square, int ROW, int COL) {
        int row = square.row;
        int col = square.col;

        while(row <ROW && col<COL && row>=0 && col>=0) {
            if(positions.containsKey(row) && positions.get(row).col == col) {
                return false;
            }
            row--;
            col--;
        }
        col = square.row;
        row = square.col;
        while(row <ROW && col<COL && row>=0 && col>=0) {
            if(positions.containsKey(row) && positions.get(row).col == col) {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    private static class Square {
        final int row;
        final int col;

        public Square(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
