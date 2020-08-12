package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class IsBinarySearchTree {

    public static boolean check(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        check(root, values);
        return isAscendingOrderSorted(values);
    }

    private static boolean isAscendingOrderSorted(List<Integer> values) {
        for (int index = 1; index < values.size(); index++) {
            if(values.get(index-1) > values.get(index))
                return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private static void check(TreeNode root, List<Integer> values) {
        if(root == null)
            return;
        check(root.left, values);
        values.add(root.val);
        check(root.right, values);
    }

    private static void testCase1() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)));
        System.out.println(check(root));
    }

    private static void testCase2() {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(2, null, null));
        System.out.println(check(root));
    }

    private static void testCase3() {
        TreeNode root = new TreeNode(1, new TreeNode(2),null);
        System.out.println(check(root));
    }

    private static void testCase4() {
        System.out.println(check(null));
    }

    private static void testCase5() {
        TreeNode root = new TreeNode(3, new TreeNode(2, new TreeNode(1), new TreeNode(5)), new TreeNode(4));
        System.out.println(check(root));
    }

    private static void testCase6() {
        TreeNode root = new TreeNode(3, new TreeNode(2, new TreeNode(1), new TreeNode(5)), new TreeNode(4));
        System.out.println(isBST(root, root.left, root.right));
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        //testCase6();
    }

    private static boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
        // Base condition
        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.val <= l.val)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.val >= r.val)
            return false;

        // check recursively for every node.
        return isBST(root.left, l, root) &&
                isBST(root.right, root, r);
    }

}
