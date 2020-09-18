package com.practice.tree;

public class MirrorTree {

    public static void mirror(TreeNode root, TreeNode mirrorRoot) {

        if (root == null) {
            return;
        }

        if (root.right != null)
            mirrorRoot.left = new TreeNode(root.right.val);
        if (root.left != null)
            mirrorRoot.right = new TreeNode(root.left.val);

        mirror(root.left, mirrorRoot.right);
        mirror(root.right, mirrorRoot.left);
    }

    public static void mirror(TreeNode root) {
        TreeNode mirrorRoot = new TreeNode(root.val);
        mirror(root, mirrorRoot);
        System.out.println(mirrorRoot);
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
        mirror(root);
    }

}
