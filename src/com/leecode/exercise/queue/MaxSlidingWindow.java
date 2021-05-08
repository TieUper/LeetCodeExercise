package com.leecode.exercise.queue;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 */
class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow2(new int[]{1}, 1);
        for (int a :
                ints) {
            System.out.println(a);
        }
    }

    /**
     * 暴力法， 超时。。。
     * @param nums
     * @param k
     * @return
     */
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

    /**
     * 优先队列 PriorityQueue
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            //数组第一个[0]存储值， [1]存储索引
            queue.add(new int[]{nums[i], i});
        }
        int[] result = new int[n - k + 1];
        result[0] = queue.peek()[0];

        for (int i = k; i < n; i++) {
            queue.add(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            result[i - k + 1] = queue.peek()[0];
        }
        return result;
    }

    /**
     * 双向队列
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int[] max = new int[n - k + 1];
        max[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            max[i - k + 1] = nums[deque.peekFirst()];
        }
        return max;
    }

}
