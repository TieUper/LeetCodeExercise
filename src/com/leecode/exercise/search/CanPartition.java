package com.leecode.exercise.search;

import sun.font.TrueTypeFont;
import sun.security.util.Length;

/**
 * 416. 分割等和子集
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int numbers : nums) {
            sum += numbers;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                //不考虑当前元素
                dp[i][j] = dp[i - 1][j];

                //考虑当前元素
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

            }
        }
        return dp[nums.length - 1][target];
    }


    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int numbers : nums) {
            sum += numbers;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >=0 && nums[i] <= j; j--) {
                //考虑当前元素
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
