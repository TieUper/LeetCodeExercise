package com.leecode.exercise.recursion;

import com.leecode.exercise.TreeNode;

/**
 * 生成一个二叉树
 */
public class TreeCreate {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root = createTree(root, 0);
    }

    /**
     * 维护构建二叉树的值和值索引
     */
    public static class TreeValue {
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[]{1,2,3,0,4,5,0,0,6,0,0,7,0,0,8,0,9,10,0,0,0};
    }

    /**
     * Create A Binary Tree with TreeValue
     *
     * @node: a tree node
     * @i: the index of tree value
     */
    public static TreeNode createTree(TreeNode node, int i) {
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null;
        } else {
            node.val = TreeValue.TREE_VALUE[i];
        }

        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++TreeValue.index);
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++TreeValue.index);

        return node;
    }
}
