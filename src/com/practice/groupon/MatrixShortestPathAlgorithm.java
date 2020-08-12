package com.practice.groupon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixShortestPathAlgorithm {
    public static void findPath(int[][] m, int X, int Y) {
        if (X >= 0 && Y >= 0 && X <= m.length - 1 && Y <= m[0].length - 1) {
            int[][] cm = getCostMatrix(m, X, Y);
            List<String> path = getPath(cm, X, Y);
            path.forEach(System.out::println);
            return;
        }
        System.out.println("No path found for X = " + X + " and Y = " + Y);
    }

    private static int[][] getCostMatrix(int[][] m, int X, int Y) {
        int[][] cm = new int[m.length][m[0].length];

        for (int x = 0; x <= X; x++) {
            for (int y = 0; y <= Y; y++) {
                if (x - 1 >= 0 && y - 1 > 0) {
                    cm[x][y] = Math.min(cm[x - 1][y], cm[x][y - 1]) + m[x][y];
                } else if (x - 1 >= 0 && y - 1 < 0) {
                    cm[x][y] = cm[x - 1][y] + m[x][y];
                } else if (y - 1 >= 0 && x - 1 < 0) {
                    cm[x][y] = cm[x][y - 1] + m[x][y];
                } else {
                    cm[x][y] = m[x][y];
                }
            }
        }
        return cm;
    }

    private static List<String> getPath(int[][] cm, int x, int y) {
        List<String> path = new ArrayList<>();
        path.add(x + "," + y);

        while (x >= 0 || y >= 0) {
            if (x - 1 >= 0 && y - 1 >= 0) {
                if (cm[x - 1][y] > cm[x][y - 1]) {
                    path.add((x - 1) + "," + y);
                    x--;
                } else {
                    path.add(x + "," + (y - 1));
                    y--;
                }
            } else if ((x - 1) >= 0 && (y - 1) < 0) {
                path.add((x - 1) + "," + y);
                x--;
            } else if ((x - 1) < 0 && (y - 1) >= 0) {
                path.add(x + "," + (y - 1));
                y--;
            } else {
                //path.add(x+","+y);
                x--;
                y--;
            }
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] m = new int[3][3];
        m[0][0] = 1;
        m[0][1] = 3;
        m[0][2] = 1;
        m[1][0] = 2;
        m[1][1] = 4;
        m[1][2] = 1;
        m[2][0] = 8;
        m[2][1] = 8;
        m[2][2] = 1;
        System.out.println("------------");
        findPath(m, 1, 1);
        System.out.println("------------");
        findPath(m, 2, 2);
        System.out.println("------------");
        findPath(m, 3, 3);
    }
}
