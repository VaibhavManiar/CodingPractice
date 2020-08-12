package com.practice.backtracking;

/**
 *
 */
public class MatrixShortestPath {

    private static Pair[] possibleMoves() {
        return new Pair[]{new Pair(-1, 0), new Pair(1, 0), new Pair(0, 1), new Pair(0, -1)};
    }

    public static int shortestPath(int[][] matrix, Pair currentLocation) {
        Pair[] moves = possibleMoves();
        int[][] tempMatrix = new int[matrix.length][matrix[0].length];
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        return shortestPathFromLocation(matrix, currentLocation, tempMatrix, moves, isVisited);
    }

    public static int shortestPathFromLocation(int[][] matrix, Pair currentLocation,
                                               int[][] tempMatrix,
                                               Pair[] moves,
                                               boolean[][] isVisited) {
        // if current move is out of matrix then return zero 0, this will stop to get into loop for invalid location
        if ((currentLocation.x < 0 || currentLocation.x >= matrix.length) ||
                (currentLocation.y < 0 || currentLocation.y >= matrix.length)) {
            return 0;
        }

        // to stop visit on the same location again , else it will get into stack over flow
        isVisited[currentLocation.x][currentLocation.y] = Boolean.TRUE;

        // Allowed moves are left, right, top and down (4 moves from each location)
        for (Pair move : moves) {

            // if next move is out of matrix then return zero
            if ((currentLocation.x + move.x < 0 || currentLocation.x + move.x >= matrix.length) ||
                    (currentLocation.y + move.y < 0 || currentLocation.y + move.y >= matrix.length)) {
                return 0;
            }

            // Check if is valid move
            if (matrix[currentLocation.x + move.x][currentLocation.y + move.y] == 0 &&
                    !isVisited[currentLocation.x + move.x][currentLocation.y + move.y]) {
                Pair nextLocation = new Pair(currentLocation.x + move.x, currentLocation.y + move.y);
                isVisited[currentLocation.x + move.x][currentLocation.y + move.y] = Boolean.TRUE;
                int pathLength = shortestPathFromLocation(matrix, nextLocation, tempMatrix, moves, isVisited)
                        + tempMatrix[currentLocation.x + move.x][currentLocation.y + move.y] + 1;


                // In first move, when tempMatrix value at x,y is 0 then assign the value else if value is more then 0 then
                // check that the value is less then the current value (to get shortest path)
                if (tempMatrix[currentLocation.x][currentLocation.y] > 0 && pathLength < tempMatrix[currentLocation.x][currentLocation.y])
                    tempMatrix[currentLocation.x][currentLocation.y] = pathLength;
                else
                    tempMatrix[currentLocation.x][currentLocation.y] = pathLength;
            }
        }
        return tempMatrix[currentLocation.x][currentLocation.y] + 1;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1}, {1, 0, -1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}
        };
        System.out.println(shortestPath(matrix, new Pair(1, 2)));
    }
}
