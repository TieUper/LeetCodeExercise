package com.leecode.exercise.greedy;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
