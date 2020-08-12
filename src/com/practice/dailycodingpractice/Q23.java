package com.practice.dailycodingpractice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This problem was asked by Google.
 * <p>
 * You are given an M by N matrix consisting of booleans that represents a board.
 * Each True boolean represents a wall.
 * Each False boolean represents a tile you can walk on.
 * <p>
 * Given this matrix, a start coordinate, and an end coordinate,
 * return the minimum number of steps required to reach the end coordinate from the start.
 * <p>
 * Rules:
 * If there is no possible path, then return null.
 * You can move up, left, down, and right.
 * You cannot move through walls.
 * You cannot wrap around the edges of the board.
 * <p>
 * For example, given the following board:
 * <p>
 * [[f, f, f, f],
 * [t, t, f, t],
 * [f, f, f, f],
 * [f, f, f, f]]
 * and start = (3, 0) (bottom left) and end = (0, 0) (top left),
 * the minimum number of steps required to reach the end is 7,
 * since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */
public class Q23 {

    private static final int[] X = new int[]{-1, 0, 0, 1};
    private static final int[] Y = new int[]{0, -1, 1, 0};

    public static Integer sol(boolean[][] matrix, Point source, Point destination) {
        Queue<QNode> q = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        q.offer(new QNode(0, source));
        visited[source.x][source.y] = true;

        while (!q.isEmpty()) {
            QNode qNode = q.poll();
            if (isReachedDestination(qNode.point, destination)) {
                return qNode.dist;
            }

            for (int index = 0; index < X.length; index++) {
                int x = qNode.point.x + X[index];
                int y = qNode.point.y + Y[index];
                Point nextPoint = new Point(x, y);
                if (isSafeMove(nextPoint, visited, matrix)) {
                    visited[x][y] = true;
                    q.offer(new QNode(qNode.dist + 1, nextPoint));
                }
            }
        }
        return null;
    }

    private static boolean isSafeMove(Point point, boolean[][] visited, boolean[][] matrix) {
        return point.x >= 0 && point.x < visited.length &&
                point.y >= 0 && point.y < visited[0].length &&
                !matrix[point.x][point.y] &&
                !visited[point.x][point.y];
    }

    private static boolean isReachedDestination(Point point, Point dest) {
        return point.x == dest.x && point.y == dest.y;
    }

    static class QNode {
        int dist;
        Point point;

        public QNode(int dist, Point point) {
            this.dist = dist;
            this.point = point;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * [[f, f, f, f],
     * [t, t, f, t],
     * [f, f, f, f],
     * [f, f, f, f]]
     */
    public static void main(String[] args) {
        Integer stepCount = sol(new boolean[][]{
                {false, false, false, false},
                {true, true, false, true},
                {false, false, false, false},
                {false, false, false, false},
        }, new Point(3, 0), new Point(0, 0));
        if (stepCount != null) {
            System.out.println("Number of steps from source to destination : " + stepCount);
        } else {
            System.out.println("Source to destination is not reachable");
        }
    }
}
