package com.leecode.exercise.recursion;

import com.leecode.exercise.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {

    Map<Integer, Integer> map = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildMyTree(preorder, inorder,0, preorder.length, 0, inorder.length);
    }

    /**
     * 递归
     *
     * @param preorder
     * @param inorder
     * @param preOrderLeft
     * @param preOrderRight
     * @param inOrderLeft
     * @param inOrderRight
     * @return
     */
    private TreeNode buildMyTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {

        if (preOrderLeft > preOrderRight) {
            return null;
        }
        int val = preorder[preOrderLeft];
        TreeNode treeNode = new TreeNode(val);
        int rootIndex = map.get(val);

        treeNode.left = buildMyTree(preorder, inorder, preOrderLeft + 1, rootIndex - inOrderLeft + preOrderLeft, inOrderLeft, rootIndex - 1);
        treeNode.right = buildMyTree(preorder, inorder, rootIndex - inOrderLeft + preOrderLeft + 1, preOrderRight, rootIndex + 1, inOrderRight);

        return treeNode;
    }
}
