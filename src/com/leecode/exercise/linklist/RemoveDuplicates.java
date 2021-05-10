package com.leecode.exercise.linklist;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates3(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                nums[currentIndex++] = nums[i];
            }
        }
        return currentIndex;
    }

    public static int removeDuplicates2(int[] nums) {
        int currentIndex = 0;
        Arrays.sort(nums);
        int lastValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (lastValue == nums[i]) {
                continue;
            }
            lastValue = nums[i];
            nums[currentIndex] = nums[i];
            currentIndex++;
        }
        return currentIndex;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public static int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
}
