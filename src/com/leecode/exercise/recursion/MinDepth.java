package com.leecode.exercise.recursion;

import com.leecode.exercise.TreeNode;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
}
