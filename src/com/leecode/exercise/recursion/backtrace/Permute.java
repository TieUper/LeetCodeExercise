package com.leecode.exercise.recursion.backtrace;

import java.util.*;

public class Permute {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1,1, 3});
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(nums, length, 0, path, used,res);
        return res;
    }

    private static void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] used,List<List<Integer>> res) {
        if (depth == length) {
            //递归到最底层了
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
