package com.leecode.exercise.search;

public class FindMin {

    public static void main(String[] args) {
        int min = findMin(new int[]{11,13,15,17});
        System.out.println(min);
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        int min = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                //左边有序
                min = Math.min(nums[left], min);
                left = mid + 1;
            }else {
                //右边有序
                min = Math.min(nums[mid], min);
                right = mid - 1;
            }
        }
        return min;
    }
}
