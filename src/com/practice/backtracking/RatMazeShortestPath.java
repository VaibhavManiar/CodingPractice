package com.practice.backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Get rat in at x, y and get out from maze[maze.length -1][y] || maze[x][maze[0].length -1].
 * Find the shortest from source to destination.
 */
public class RatMazeShortestPath {
    private static final int[] ROW = new int[]{1, 0, 0, -1};
    private static final int[] COL = new int[]{0, 1, -1, -0};

    public static int solve(int[][] maze, Point source) {
        QNode qNode = new QNode(source, 0);
        Queue<QNode> q = new LinkedList<>();
        q.add(qNode);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[source.x][source.y] = Boolean.TRUE;

        while (!q.isEmpty()) {
            QNode node = q.poll();
            Point curr = node.point;
            int dist = node.dist;

            if (isReachedDestination(maze, curr)) {
                return dist;
            }

            for (int index = 0; index < ROW.length; index++) {
                int x = curr.x + ROW[index];
                int y = curr.y + COL[index];
                Point next = new Point(x, y);
                if(isSafeMove(maze, next) && !visited[x][y]) {
                    visited[x][y] = Boolean.TRUE;
                    q.add(new QNode(next, dist+1));
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
        return (point.x == maze.length - 1 || point.y == maze[0].length - 1) && maze[point.x][point.y] == 1;
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

    public static void main(String[] args) {
        int dist = solve(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1}
        }, new Point(0, 0));
        System.out.println(dist);
    }
}

