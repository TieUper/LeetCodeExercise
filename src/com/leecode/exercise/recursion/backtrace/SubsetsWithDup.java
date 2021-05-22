package com.leecode.exercise.recursion.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 90. 子集 II
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        List<List<Integer>> lists = subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0,false, path, res);
        return res;
    }

    private static void dfs(int[] nums, int curr,boolean choosePre, Deque<Integer> path, List<List<Integer>> res) {
        if (curr == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, curr + 1, false, path, res);
        if (!choosePre && curr > 0 && nums[curr] == nums[curr - 1]) {
            return;
        }
        path.add(nums[curr]);
        dfs(nums, curr + 1, true, path, res);
        path.removeLast();
    }
}
