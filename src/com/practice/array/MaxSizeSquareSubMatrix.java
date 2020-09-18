package com.practice.array;

public class MaxSizeSquareSubMatrix {

    /**
     * matrix =
     * {{0, 1, 1, 0, 1},
     * {1, 1, 0, 1, 0},
     * {0, 1, 1, 1, 0},
     * {1, 1, 1, 1, 0},
     * {1, 1, 1, 1, 1},
     * {0, 0, 0, 0, 0}}
     *
     * @param matrix
     * @return
     */
    public int calculate(int[][] matrix) {
        int[][] solutionMatrix = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;

        for (int y = 0; y < matrix[0].length; y++) {
            solutionMatrix[0][y] = matrix[0][y];
        }

        for (int x = 0; x < matrix.length; x++) {
            solutionMatrix[x][0] = matrix[x][0];
        }

        for (int x = 1; x < matrix.length; x++) {
            for (int y = 1; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) {
                    solutionMatrix[x][y] = min(solutionMatrix[x - 1][y - 1],
                            solutionMatrix[x][y - 1], solutionMatrix[x - 1][y]);
                    if (max < solutionMatrix[x][y]) {
                        max = solutionMatrix[x][y];
                    }
                }
            }
        }
        return max * 2;
    }

    private int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        MaxSizeSquareSubMatrix o = new MaxSizeSquareSubMatrix();
        System.out.println(o.calculate(matrix));
    }
}
