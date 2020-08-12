package com.practice.tree;

public class IsBalancedBinaryTree {

    public static boolean isBalanced(TreeNode treeNode) {
        return treeNode == null ||
                Math.abs(DepthOfBTree.height(treeNode.left) - DepthOfBTree.height(treeNode.right)) < 2 &&
                isBalanced(treeNode.left) && isBalanced(treeNode.right);
    }

    public static boolean isBalanced1(TreeNode treeNode, int height) {
        if(treeNode == null) {
            return true;
        }

        isBalanced1(treeNode.left, height);

        return false;
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)));
        System.out.println(isBalanced(root));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(2, null, null));
        System.out.println(isBalanced(root));
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    static class Height {
        int height;
    }
}
