package com.practice.backtracking;

import java.util.HashMap;
import java.util.Map;

public class NQueensProblem {

    public static boolean sol(int n) {
        int[][] matrix = new int[n][n];
        Map<Integer, Position> positions = new HashMap<>();
        boolean b = sol(0, matrix, positions);
        positions.forEach((row, position)-> System.out.println("Row Number : " + row + " , position : " + position));
        return b;
    }

    public static boolean sol(int row, int[][] matrix, Map<Integer, Position> positions) {
        int n = matrix.length;

        if (row == n) {
            return Boolean.TRUE;
        }

        if(row < 0) {
            return Boolean.FALSE;
        }

        boolean isValidFound = Boolean.FALSE;
        int col = 0;
        if(positions.containsKey(row)) {
            col = positions.get(row).col + 1;
            positions.remove(row);
        }
        while (col < n) {
            if (validate(row, col, matrix)) {
                isValidFound = true;
                System.out.println("Row : " + row + " Col : " + col);
                matrix[row][col] = 1;
                positions.put(row, new Position(row, col));
                break;
            }
            col++;
        }

        if (!isValidFound) {
            row--;
            return sol(row, matrix, positions);
        } else {
            return sol(row + 1, matrix, positions);
        }
    }

    private static boolean validate(int row, int col, int[][] matrix) {
        int tempRow = row;
        int tempCol = col;

        while (tempCol > 0 && tempRow > 0) {
            if (matrix[tempRow - 1][tempCol - 1] == 1) {
                return Boolean.FALSE;
            }
            tempRow--;
            tempCol--;
        }

        tempRow = row;
        tempCol = col;

        while (tempCol < matrix.length-1 && tempRow > 0) {
            if (matrix[tempRow - 1][tempCol + 1] == 1) {
                return Boolean.FALSE;
            }
            tempRow--;
            tempCol++;
        }

        tempRow = row;
        tempCol = col;
        while (tempRow > 0) {
            if (matrix[tempRow - 1][tempCol] == 1) {
                return Boolean.FALSE;
            }
            tempRow--;
        }

        return Boolean.TRUE;
    }

    private static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(NQueensProblem.sol(4));
    }
}
