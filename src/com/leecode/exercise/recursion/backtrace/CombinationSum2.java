package com.leecode.exercise.recursion.backtrace;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 40. 组合总和 II
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        Arrays.sort(candidates);
        dfs(candidates, length, target, 0, 0, path,used, res);
        return res;
    }

    private static void dfs(int[] candidates, int length, int target, int depth, int total, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (total >= target) {
            return;
        }

        for (int i = depth; i < length; i++) {

            if (used[i]) {
                continue;
            }
            if (i > depth && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            total += candidates[i];
            used[i] = true;
//            System.out.println("递归： i:" + i + "  path:" + path + "  depth:" + depth);
            if (total == target) {
                res.add(new ArrayList<>(path));
            }
            dfs(candidates, length, target, i + 1, total, path, used, res);

            path.removeLast();
            total -= candidates[i];
            used[i] = false;
        }
    }
}
