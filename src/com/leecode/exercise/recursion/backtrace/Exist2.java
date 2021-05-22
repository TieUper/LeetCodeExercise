package com.leecode.exercise.recursion.backtrace;

import java.util.PriorityQueue;

/**
 * 79. 单词搜索
 */
public class Exist2 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private int rows;
    private int cols;
    private int len;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;


    public boolean exist(char[][] board, String word) {

        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        len = word.length();
        charArray = word.toCharArray();
        this.board = board;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        if (begin == charArray.length - 1) {
            return board[x][y] == charArray[begin];
        }
        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true;
            for (int[] value : DIRECTIONS) {
                int mx = value[0] + x, my = value[1] + y;
                if (mx >= 0 && mx < rows && my >= 0 && my < cols && !visited[mx][my]) {
                    return dfs(mx, my, begin + 1);
                }
            }
            visited[x][y] = false;
        }
        return false;
    }
}
