package com.leecode.exercise.recursion;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 2; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
