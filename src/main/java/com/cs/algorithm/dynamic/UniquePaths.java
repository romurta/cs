package com.cs.algorithm.dynamic;

/**
 * A robot is located at the top-left corner of a m x n grid. It can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 * <p>
 * How many possible unique paths are there?
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * <p>
 * [1,1,1],
 * [1,2,3],
 * [1,3,6]
 */
public class UniquePaths {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0},
        };

        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {

        int r = board.length;
        int c = board[0].length;

        int[][] dp = new int[r][c];

        boolean isBlocked = false;
        for (int i = 0; i < r; i++) {
            if(board[i][0] == 1){
                isBlocked = true;
            }
            if(!isBlocked) {
                dp[i][0] = 1;
            }
        }

        isBlocked = false;
        for (int i = 0; i < c; i++) {
            if(board[0][i] == 1){
                isBlocked = true;
            }
            if(!isBlocked) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if(board[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[r - 1][c - 1];
    }
}
