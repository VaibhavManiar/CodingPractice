package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {

    public static void main(String[] args) {
        System.out.println("Test case 1");
        testCase1();
        System.out.println("Test case 2");
        testCase2();
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)));
        InOrder.Solution solution = new InOrder.Solution();
        solution.inorderTraversal(root).forEach(System.out::println);
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(2, null, null));
        InOrder.Solution solution = new InOrder.Solution();
        solution.inorderTraversal(root).forEach(System.out::println);
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorderTraversal(list, root);
            return list;
        }

        private void inorderTraversal(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversal(list, root.left);
            list.add(root.val);
            inorderTraversal(list, root.right);
        }
    }
}


