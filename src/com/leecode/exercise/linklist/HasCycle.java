package com.leecode.exercise.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 */
public class HasCycle {

    /**
     * 哈希表
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
