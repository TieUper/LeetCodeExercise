package com.leecode.exercise.queue;

/**
 * 239. 滑动窗口最大值
 */
class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1}, 1);
        for (int a :
                ints) {
            System.out.println(a);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxArray = new int[nums.length - k + 1];
        int firstIndex = 0;
        while (firstIndex < nums.length - k + 1) {
            int max = nums[firstIndex];
            for (int i = firstIndex + 1; i < firstIndex + k; i++) {
                max = Math.max(max, nums[i]);
            }
            maxArray[firstIndex] = max;
            firstIndex++;
        }
        return maxArray;
    }

}
