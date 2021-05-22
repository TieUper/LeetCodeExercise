package com.leecode.exercise.recursion.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 */
public class Combine {

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k,1,path, res);
        return res;
    }

    private static void dfs(int n, int k,int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < n + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
