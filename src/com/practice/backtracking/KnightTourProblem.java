package com.practice.backtracking;

public class KnightTourProblem {

    private static final int[] xMoves = new int[]{2, 1, -1, -2, -2, -1, 1, 2} ;
    private static final int[] yMoves = new int[]{1, 2, 2, 1, -1, -2, -2, -1} ;
    private static final int N = 8;
    private static int move = 1;
    public static boolean solve(int[][] sol, Position position) {
        if(move == N*N) {
            return true;
        }
        for(int index = 0; index < N; index++) {
            int currX = position.x + xMoves[index];
            int currY = position.y + yMoves[index];
            Position nextPosition = new Position(currX, currY);
            if(isSafeMove(sol, nextPosition)) {
                sol[currX][currY] = move++;
                if(solve(sol, nextPosition)) {
                    return Boolean.TRUE;
                } else {
                    sol[currX][currY] = 0;
                }
            }
        }
        return Boolean.FALSE;
    }

    private static boolean isSafeMove(int[][] sol, Position position) {
        return position.x < N && position.x >=0 && position.y < N && position.y >=0 && sol[position.x][position.y] != 1;
    }

    private static class Position {
        final int x;
        final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[N][N], new Position(0,0)));
    }
}
