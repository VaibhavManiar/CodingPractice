package com.practice.backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Get rat in at x, y and get out from maze[maze.length -1][maze[0].length-1].
 * Find the shortest from source to destination.
 */
public class RatAndMazeShortestPath {

    private static final int[] row = new int[]{-1, 0, 0, 1};
    private static final int[] col = new int[]{0, -1, 1, 0};

    public static int solve(int[][] maze, Point source) {
        QNode qNode = new QNode(source, 0);
        Queue<QNode> q = new LinkedList<>();
        q.add(qNode);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[source.x][source.y] = Boolean.TRUE;

        while (!q.isEmpty()) {
            QNode node = q.poll();
            int dist = node.dist;
            Point point = node.point;
            if (isReachedDestination(maze, point)) {
                return node.dist;
            }
            for (int i = 0; i < row.length; i++) {
                int nextX = point.x + row[i];
                int nextY = point.y + col[i];
                if (isSafeMove(maze, new Point(nextX, nextY)) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = Boolean.TRUE;
                    q.add(new QNode(new Point(nextX, nextY), dist + 1));
                }
            }
        }
        return -1;
    }

    private static boolean isSafeMove(int[][] maze, Point point) {
        return (point.x >= 0 && point.x < maze.length) &&
                (point.y >= 0 && point.y < maze[0].length) &&
                maze[point.x][point.y] == 1;
    }

    private static boolean isReachedDestination(int[][] maze, Point point) {
        return point.x == maze.length - 1 && point.y == maze[0].length - 1 && maze[point.x][point.y] == 1;
    }

    public static void main(String[] args) {
        int dist = solve(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1}
        }, new Point(0, 0));
        System.out.println(dist);
    }

    static class QNode {
        int dist;
        Point point;

        public QNode(Point point, int dist) {
            this.dist = dist;
            this.point = point;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

