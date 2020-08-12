package com.practice.dailycodingpractice;

import com.practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem was asked by Dropbox.
 * <p>
 * Given the root to a binary search tree, find the second largest node in the tree.
 */
public class Q36 {

    public static int sol(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        solUtil(root, inorder);
        if(inorder.size() > 1) {
            return inorder.get(inorder.size()-2);
        }
        return -1;
    }

    private static void solUtil(TreeNode root, List<Integer> inorder) {
        if(root == null)
            return;
        solUtil(root.left, inorder);
        inorder.add(root.val);
        solUtil(root.right, inorder);
    }

    private static int sol1(TreeNode root) {
        TreeNode parent = null;
        solUtil1(root, parent);
        return parent.val;
    }

    private static void solUtil1(TreeNode root, TreeNode parent) {
        if(root.right != null) {
            solUtil1(root.right,  root);
        } else if(root.left != null) {
            solUtil1(root.left, root);
        }
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        System.out.println(sol(root));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        System.out.println(sol1(root));
    }

    public static void main(String[] args) {
        testCase2();
    }
}
