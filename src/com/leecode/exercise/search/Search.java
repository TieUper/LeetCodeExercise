package com.leecode.exercise.search;

public class Search {

    public static void main(String[] args) {
        int search = search(new int[]{3,1}, 1);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                //左侧有序
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            } else {
                //右侧有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
