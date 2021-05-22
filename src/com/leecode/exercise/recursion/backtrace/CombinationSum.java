package com.leecode.exercise.recursion.backtrace;

import java.util.*;

/**
 * 39.组合总和
 */
public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{3,5,7,2}, 8);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(candidates, target, 0, path, 0, res);
        return res;
    }

    private static void dfs(int[] candidates, int target, int depth, Deque<Integer> path, int totalValue, List<List<Integer>> res) {
        if (totalValue >= target) {
            return;
        }

        for (int i = depth; i < candidates.length; i++) {
            path.add(candidates[i]);
            totalValue += candidates[i];
            System.out.println("递归前：" + path + "  depth:" + depth + "   totalValue:" + totalValue + "  i:"+ i  );
            if (totalValue == target) {
                res.add(new ArrayList<>(path));
            }
            dfs(candidates, target, i, path,totalValue, res);
            path.removeLast();
            totalValue -= candidates[i];
        }
    }

    private static void dfs2(int[] candidates, int target, int depth, Deque<Integer> path, int totalValue, List<List<Integer>> res) {
        if (totalValue == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = depth; i < candidates.length; i++) {

            int rs = candidates[i] + totalValue;
            if (rs <= target) {

                path.add(candidates[i]);
                System.out.println("递归前：" + path + "  depth:" + depth + "   totalValue:" + totalValue + "  i:"+ i  );
                dfs2(candidates, target, i, path,rs, res);
                path.removeLast();
            }else {
                break;
            }
        }
    }
}
