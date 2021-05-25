package com.leecode.exercise.recursion;

import java.util.*;

public class SubsetsWithDup {

    public static void main(String[] args) {

        List<List<Integer>> lists = subsetsWithDup(new int[]{4,4,4,1,4});
        System.out.println(lists);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        dfs(nums, length, 0, path, res);
        res.add(new ArrayList<>());
        return res;
    }

    private static void dfs(int[] nums, int length, int begin, Deque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < length; i++) {
            if (i != begin  && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);

            dfs(nums, length, i + 1, path, res);
            path.removeLast();
        }
    }
}
