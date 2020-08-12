package com.practice.tree;

import java.util.List;

public class BalanceBinaryTree {

    public static TreeNode balanceTree(TreeNode root) {
        List<Integer> inorder = new InOrder.Solution().inorderTraversal(root);
        return balancedTree(inorder, 0, inorder.size() - 1);
    }

    private static TreeNode balancedTree(List<Integer> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = balancedTree(inOrder, start, mid - 1);
        root.right = balancedTree(inOrder, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, null))))));
        TreeNode newRoot = balanceTree(root);
        List<Integer> list = new InOrder.Solution().inorderTraversal(newRoot);
        list.forEach(System.out::println);
    }
}
