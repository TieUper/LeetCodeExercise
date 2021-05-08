package com.leecode.exercise.stack;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    private Stack<Integer> stacks;

    private Stack<Integer> minStacks;

    /** initialize your data structure here. */
    public MinStack() {
        stacks = new Stack<>();
        minStacks = new Stack<>();
        minStacks.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stacks.push(val);
        minStacks.push(Math.min(minStacks.peek(), val));

    }

    public void pop() {
        stacks.pop();
        minStacks.pop();
    }

    public int top() {
       return stacks.peek();
    }

    public int getMin() {
       return minStacks.peek();
    }
}
