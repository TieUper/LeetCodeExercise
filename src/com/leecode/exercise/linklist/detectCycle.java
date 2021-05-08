package com.leecode.exercise.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表2
 */
class detectCycle {

    /**
     * hash表
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast;
    }

    public ListNode detectCycle3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
