package com.practice.tree;

public class TreeLeftView {
    private static int maxLevel = 0;

    private static void solve(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxLevel) {
            System.out.println(node.val);
            maxLevel = level;
        }
        solve(node.left, level + 1);
        solve(node.right, level + 1);
    }

    public static void solve(TreeNode node) {
        solve(node, 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        solve(root);
    }
}
