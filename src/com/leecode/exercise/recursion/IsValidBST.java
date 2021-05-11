package com.leecode.exercise.recursion;

import com.leecode.exercise.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归
     *  left < root.val < right
     * @param root  当前节点
     * @param minValue 最小值
     * @param maxValue 最大值
     * @return
     */
    private boolean _isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return _isValidBST(root.left, minValue, root.val) && _isValidBST(root.right, root.val, maxValue);
    }

    /**
     * 利用二叉搜索树的性质， 中序遍历是递增的
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        int lastValue = Integer.MIN_VALUE;
        while (root != null && !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            //当前遍历到的值 ， 和上一个值比较
            root = deque.pop();
            if (root.val < lastValue) {
                return false;
            }
            lastValue = root.val;
            root = root.right;
        }
        return true;
    }
}
