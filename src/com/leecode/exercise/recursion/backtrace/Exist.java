package com.leecode.exercise.recursion.backtrace;

import java.util.*;

/**
 * 79. 单词搜索
 */
public class Exist {
    static char[][] arr = new char[][]{{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}};

    public static void main(String[] args) {
        boolean abcced = exist(arr, "ABCESEEEFS");
        System.out.println(abcced);
    }

    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
//                Map<Integer,Character> target = new HashMap<>();
//                dfs(board, i, j, 0, chars, target);
//                if (target.size() == chars.length) {
//                    return true;
//                }
                if (board[i][j] == word.charAt(0)) {
                    if (dfs2(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void dfs(char[][] board,int i, int j, int depth, char[] chars, Map<Integer,Character> characters) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || depth >= chars.length || board[i][j] != chars[depth]) {
            return;
        }

        char c = board[i][j];

        board[i][j] = '0';

        characters.put(depth, chars[depth]);

        dfs(board,i + 1, j,depth + 1, chars,characters);
        dfs(board,i - 1, j,depth + 1, chars,characters);
        dfs(board, i, j + 1, depth + 1,chars,characters);
        dfs(board, i, j - 1, depth + 1,chars,characters);
        board[i][j] = c;
    }

    private static boolean dfs2(char[][] board, String word, int i, int j, int depth) {
        if (depth == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (word.charAt(depth) != board[i][j]) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '0';
        boolean res = dfs2(board, word, i + 1, j, depth + 1) ||
                dfs2(board, word, i - 1, j, depth + 1) ||
                dfs2(board, word, i, j + 1, depth + 1) ||
                dfs2(board, word, i, j - 1, depth + 1);
        board[i][j] = c;
        return res;
    }
}
