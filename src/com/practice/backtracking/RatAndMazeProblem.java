package com.practice.backtracking;

/**
 * Problem: find all paths for rat to move out.
 * <p>
 * Rate is at position x, y
 * out location is maze[maze.length -1][maze[0].length -1]
 * here 1 means move and 0 means blocker
 * <p>
 * <p>
 * Rat starting location is maze[0][0]
 * Maze :
 * 1 0 0 0
 * 1 1 0 0
 * 1 1 1 1
 */
public class RatAndMazeProblem {

    public static boolean solve(int[][] maze, int x, int y, int[][] solMatrix) {

        if (isReachedDestination(maze, x, y)) {
            solMatrix[x][y] = 1;
            return Boolean.TRUE;
        }

        if (isSafeMove(maze, x, y)) {
            solMatrix[x][y] = 1;
            maze[x][y] = 0;
            if (solve(maze, x + 1, y, solMatrix))
                return Boolean.TRUE;

            if (solve(maze, x, y + 1, solMatrix))
                return Boolean.TRUE;

            if (solve(maze, x - 1, y, solMatrix))
                return Boolean.TRUE;

            if (solve(maze, x, y - 1, solMatrix))
                return Boolean.TRUE;

            maze[x][y] = 1;
            solMatrix[x][y] = 0;
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    public static void solve(int[][] maze, int x, int y) {
        int[][] solMatrix = new int[maze.length][maze[0].length];
        while (solve(maze, x, y, solMatrix)) {
            printPath(solMatrix);
            solMatrix = new int[maze.length][maze[0].length];
        }
    }

    private static boolean isReachedDestination(int[][] maze, int x, int y) {
        return x == maze.length - 1 && y == maze[0].length - 1 && maze[x][y] == 1;
    }

    private static boolean isSafeMove(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length) &&
                (y >= 0 && y < maze[0].length) &&
                maze[x][y] == 1;
    }

    private static void printPath(int[][] solMatrix) {
        for (int[] xD : solMatrix) {
            for (int v : xD) {
                System.out.print(" " + v + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve(new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 1}
        }, 0, 0);
    }
}
