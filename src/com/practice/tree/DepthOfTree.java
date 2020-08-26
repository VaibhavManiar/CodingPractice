package com.practice.tree;

public class DepthOfTree {
    public static int find(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        int leftDepth = find(treeNode.left);
        int rightDepth = find(treeNode.right);

        return (Math.max(leftDepth, rightDepth)) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)));
        System.out.println(height(root));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(2, null, null));
        System.out.println(height(root));
    }

    private static void testCase3() {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null),null);
        System.out.println(height(root));
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }



}
