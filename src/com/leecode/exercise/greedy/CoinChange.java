package com.leecode.exercise.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CoinChange {

    public static void main(String[] args) {
        int[] arr = {186,419,83,408};
        int i = coinChange(arr, 6249);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int total = 0;
        int count = 0;
        boolean isMatch = false;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            do {
                if (total + coin < amount) {
                    total += coin;
                    count++;
                } else if (total + coin == amount) {
                    total += coin;
                    count++;
                    isMatch = true;
                    break;
                } else {
                    break;
                }
            } while (total < amount);
            if (total == amount) {
                break;
            }
        }
        if (!isMatch) {
            return -1;
        }
        return count;
    }
}
