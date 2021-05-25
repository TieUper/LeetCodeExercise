package com.leecode.exercise.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{3, 4, 5, 6});
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(nums, length, 0, deque, used, res);
        return res;
    }

    private static void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, path, used, res);

            path.removeLast();
            used[i] = false;
        }
    }
}
