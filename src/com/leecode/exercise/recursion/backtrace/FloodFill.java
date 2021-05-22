package com.leecode.exercise.recursion.backtrace;

import java.util.*;

/**
 * 733. 图像渲染
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] res = floodFill2(new int[][]{{0,0,0}, {0,1,1}}, 1, 1, 1);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc,  int newColor, int oldColor) {
        if (sc < 0 || sr > image.length - 1 || sr <0 || sc > image[0].length - 1 ||
                image[sr][sc] != oldColor || newColor == oldColor) {
            return;
        }

        image[sr][sc] = newColor;

        dfs(image, sr+ 1, sc, newColor, oldColor);
        dfs(image, sr- 1, sc,newColor, oldColor);
        dfs(image, sr, sc + 1,newColor, oldColor);
        dfs(image, sr, sc - 1,newColor, oldColor);
    }

    static int[] dx = {0, -1, 1 , 0};
    static int[] dy = {-1, 0, 0, 1};



    //广度优先遍历 BFS
    public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        int m = image.length, n = image[0].length;
        queue.add(new int[]{sr, sc});
        int oldValue = image[sr][sc];
        if (oldValue == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < m && my >= 0 && my < n && image[mx][my] == oldValue) {
                    queue.add(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
