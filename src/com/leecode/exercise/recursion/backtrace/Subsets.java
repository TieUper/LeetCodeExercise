package com.leecode.exercise.recursion.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets {

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets2(new int[]{1,2,3});
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(nums, length, path, 0,used, res);
        res.add(new ArrayList<>());
        return res;
    }

    private static void dfs(int[] nums, int length, Deque<Integer> path, int begin, boolean[] used, List<List<Integer>> res) {
        if (path.size() == length) {
            return;
        }

        for (int i = begin; i < length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(nums, length, path, i + 1, used, res);
            used[i] = false;
            path.removeLast();
        }
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs2(0, nums, path, res);
        return res;
    }

    private static void dfs2(int cur, int[] nums, Deque<Integer> path, List<List<Integer>> res) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[cur]);
        dfs2(cur + 1, nums,path, res);
        path.removeLast();
        dfs2(cur + 1, nums,path, res);
    }
}
