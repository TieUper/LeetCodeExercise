package com.leecode.exercise.search;

public class MySqrt {

    public static void main(String[] args) {
        int i = mySqrt(8);
        System.out.println(i);
    }

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
