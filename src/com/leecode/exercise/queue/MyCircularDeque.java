package com.leecode.exercise.queue;

import java.util.LinkedList;

/**
 * 641. 设计循环双端队列
 */
public class MyCircularDeque {

    private int maxSize;
    LinkedList<Integer> list;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        list = new LinkedList<Integer>();
        maxSize = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (list.size() == maxSize) {
            return false;
        }
        list.addFirst(value);
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (list.size() == maxSize) {
            return false;
        }
        list.addLast(value);
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (list.isEmpty()) {
            return false;
        }
        return list.removeFirst() != null;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (list.isEmpty()) {
            return false;
        }
        return list.removeLast() != null;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.getFirst();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.getLast();
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return list.size() == maxSize;
    }
}
