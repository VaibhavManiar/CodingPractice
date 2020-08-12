package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class UniversalTree {

    /**
     * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
     *
     * Given the root to a binary tree, count the number of unival subtrees.
     * @param root
     * @return
     */
    public static int solve(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.val);
            if (isUniversalTree(treeNode)) {
                count++;
            }
            if (treeNode.left != null)
                queue.add(treeNode.left);
            if (treeNode.right != null)
                queue.add(treeNode.right);
        }
        return count;
    }

    private static boolean isUniversalTree(TreeNode treeNode) {
        return ((treeNode == null) || ((treeNode.left == null || treeNode.left.val == treeNode.val) && (treeNode.right == null || treeNode.right.val == treeNode.val)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1, new TreeNode(1), new TreeNode(1));
        root.right.right = new TreeNode(0);

        int count = solve(root);
        System.out.println(count);
    }
}
