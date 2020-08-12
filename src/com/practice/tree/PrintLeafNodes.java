package com.practice.tree;

public class PrintLeafNodes {
    public static void print(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            System.out.println(treeNode.val);
        }

        print(treeNode.left);
        print(treeNode.right);
    }

    public static void main(String[] args) {
        print(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null), null),
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null)),
                        new TreeNode(8,
                                new TreeNode(9, null, null),
                                new TreeNode(10, null, null)))));
    }
}
