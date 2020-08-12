package com.practice.tree;

public class DoubleSidedTree {

    public static DoubleSidedTreeNode create(TreeNode treeNode) {
        DoubleSidedTreeNode root = new DoubleSidedTreeNode();
        root.data = treeNode.val;
        DoubleSidedTreeNode temp = root;
        create(temp, treeNode);
        return root;
    }

    private static void create(DoubleSidedTreeNode root, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        if (root == null) {
            root = new DoubleSidedTreeNode();
            root.data = treeNode.val;
        }

        if (treeNode.left != null) {
            root.lNode = new DoubleSidedTreeNode();
            DoubleSidedTreeNode lNode = root.lNode;
            lNode.data = treeNode.left.val;
            lNode.pNode = root;
        }

        if (treeNode.right != null) {
            root.rNode = new DoubleSidedTreeNode();
            DoubleSidedTreeNode rNode = root.rNode;
            rNode.data = treeNode.right.val;
            rNode.pNode = root;
        }
        create(root.lNode, treeNode.left);
        create(root.rNode, treeNode.right);
    }


    public static class DoubleSidedTreeNode {
        int data;
        DoubleSidedTreeNode pNode;
        DoubleSidedTreeNode lNode;
        DoubleSidedTreeNode rNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(9, null, new TreeNode(10)))));
        DoubleSidedTreeNode node = create(root);
    }
}