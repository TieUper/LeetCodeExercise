package com.leecode.exercise.recursion.backtrace;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 200. 岛屿数量
 */
public class NumIslands {

    public static void main(String[] args) {
      char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        int i = numIslands(grid);
        System.out.println(i);
    }

    /**
     * dfs
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};


    //广度优先遍历
    private static void bfs(char[][] grid, int i, int j) {
        Deque<int[]> deque = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        deque.add(new int[]{i, j});
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int x = poll[0], y = poll[1];
            for (int k = 0; k < 4; k++) {
                int mx = x + dx[k], my = y + dy[k];
                if (mx >= 0 && mx < m && my >= 0 && my < n && grid[mx][my] == '1') {
                    deque.add(new int[]{mx, my});
                    grid[mx][my] = '0';
                }
            }
        }
    }
}
