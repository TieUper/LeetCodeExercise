package com.leecode.exercise.recursion.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Pattern;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(nums, length, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && used[i - 1])) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);

            dfs(nums, length, depth + 1, path, used, res);

            path.removeLast();
            used[i] = false;
        }
    }
}
