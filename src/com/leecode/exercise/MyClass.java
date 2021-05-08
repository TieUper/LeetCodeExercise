package com.leecode.exercise;

import com.leecode.exercise.stack.MinStack;

public class MyClass {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        int min = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min1 = minStack.getMin();

        System.out.println("min:" + min + "  top:" + top + "  min1:" + min1);
    }
}