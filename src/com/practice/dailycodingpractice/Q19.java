package com.practice.dailycodingpractice;

/**
 * This problem was asked by Facebook.
 * <p>
 * A builder is looking to build a row of N houses that can be of K different colors.
 * He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 * <p>
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
 * return the minimum cost which achieves this goal.
 */
public class Q19 {

    /*private static int[] X = new int[]{1, 1};
    private static int[] Y = new int[]{-1, 1};

    public static int sol(int[][] costMatrix) {
        int numberOfHouses = costMatrix.length;
        int numberOfColors = costMatrix[0].length;
        int[][] solMatrix = new int[costMatrix.length][costMatrix[0].length];
        Arrays.stream(solMatrix).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));
        System.arraycopy(costMatrix[0], 0, solMatrix[0], 0, numberOfColors);

        for (int i = 0; i < numberOfColors; i++) {
            solUtil(costMatrix, new Point(0, i), solMatrix);
        }
        Stack<Point> points = new Stack<>();
        Point minPoint = new Point(solMatrix.length-1, min(solMatrix[solMatrix.length-1]));
        points.push(new Point(minPoint.x, minPoint.y));

        backtrackUtil(solMatrix, costMatrix, points);
        System.out.println();
        while(!points.isEmpty()) {
            Point p = points.pop();
            System.out.println(p.x + ", " + p.y);
        }
        System.out.println();
        return costMatrix[minPoint.x][minPoint.y];
    }

    private static void backtrackUtil(int[][] solMatrix, int[][] costMatrix, Stack<Point> points) {
        Point point = points.peek();
        int diff = solMatrix[point.x][point.y] - costMatrix[point.x][point.y];

        Point nextPoint = new Point(point.x - X[0], point.y + -Y[0]);

        if(nextPoint.x < 0) {
            return;
        }

        if(isSafeMove(costMatrix, nextPoint) && solMatrix[nextPoint.x][nextPoint.y] == diff) {
            points.push(nextPoint);
            backtrackUtil(solMatrix, costMatrix, points);
        } else {
            points.push(new Point(point.x - X[1], point.y + -Y[1]));
            backtrackUtil(solMatrix, costMatrix, points);
        }
    }

    private static int min(int[] arr) {
        int minIndex = 0;
        for (int index = 0; index < arr.length; index++) {
            if (arr[minIndex] > arr[index])
                minIndex = index;
        }
        return minIndex;
    }

    private static void solUtil(int[][] costMatrix, Point point, int[][] solMatrix) {
        for (int index = 0; index < X.length; index++) {
            Point nextPoint = new Point(point.x + X[index], point.y + Y[index]);
            if (isNotSafeMove(costMatrix, nextPoint)) {
                continue;
            }
            int newCost = costMatrix[nextPoint.x][nextPoint.y] + solMatrix[point.x][point.y];
            solMatrix[nextPoint.x][nextPoint.y] = Math.min(newCost, solMatrix[nextPoint.x][nextPoint.y]);
            solUtil(costMatrix, nextPoint, solMatrix);
        }
    }

    private static boolean isSafeMove(int[][] costMatrix, Point point) {
        return !(isNotSafeMove(costMatrix, point));
    }

    private static boolean isNotSafeMove(int[][] costMatrix, Point point) {
        return point.x < 0 ||
                point.x >= costMatrix.length ||
                point.y < 0 ||
                point.y >= costMatrix[0].length;
    }*/


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int sol(int[][] costMatrix) {
        int[] totalCost = new int[costMatrix[0].length];
        for (int j = 0; j < costMatrix[0].length; j++) {
            int cost = costMatrix[0][j];
            int col = j;
            for (int i = 0; i < costMatrix.length-1; i++) {
                Point minPoint = minPoint(costMatrix, new Point(i, col));
                col = minPoint.y;
                cost += costMatrix[minPoint.x][minPoint.y];
            }
            totalCost[j] = cost;
            cost = 0;
        }
        return minVal(totalCost);
    }

    private static int minVal(int[] totalCost) {
        int min = Integer.MAX_VALUE;
        for (int cost : totalCost) {
            if (min > cost) {
                min = cost;
            }
        }
        return min;
    }

    private static Point minPoint(int[][] costMatrix, Point point) {
        Point minPoint = new Point(point.x + 1, 0);
        for (int index = 1; index < costMatrix[0].length; index++) {
            if (index == point.y) {
                continue;
            }
            if (costMatrix[point.x + 1][index] < costMatrix[minPoint.x][minPoint.y]) {
                minPoint = new Point(point.x + 1, index);
            }
        }
        return minPoint;
    }

    public static void main(String[] args) {
        int v = sol(new int[][]{
                {4, 0, 3},
                {8, 3, 8},
                {4, 5, 0},
                {3, 4, 4},
                {8, 8, 0}
        });
        System.out.println(v);
    }
}
