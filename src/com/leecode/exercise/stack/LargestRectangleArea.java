package com.leecode.exercise.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 */
class LargestRectangleArea {

    public static void main(String[] args) {
        int i = largestRectangleArea(new int[]{2,4});  System.out.println(i);
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while (true) {
                left --;
                if (left < 0) {
                    break;
                }
                if (heights[left] < heights[i]) {
                    break;
                }
            }
            while (true) {
                right ++;
                if (right > heights.length - 1) {
                    break;
                }
                if (heights[right] < heights[i]) {
                    break;
                }
            }
//            System.out.println("left:" + left + "  right:" + right);
            maxArea = Math.max((right - left - 1) * heights[i], maxArea);
//            System.out.println("i:" + i + "  maxArea:" + maxArea);
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> valueStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!valueStack.isEmpty() && heights[valueStack.peek()] >= heights[i]) {
                valueStack.pop();
            }
            left[i] = (valueStack.isEmpty() ? -1 : valueStack.peek());
            valueStack.push(i);
        }
        valueStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!valueStack.isEmpty() && heights[valueStack.pop()] >= heights[i]) {
                valueStack.pop();
            }
            right[i] = (valueStack.isEmpty() ? n : valueStack.peek());
            valueStack.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }

    public static int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        //索引
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        //存索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                //需要出栈，确定出栈元素右边界
                right[stack.peek()] = i;
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;

    }

}
