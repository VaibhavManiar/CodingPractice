package com.practice.tree;

public class CompareTree {

    public static boolean compare(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) {
            return Boolean.TRUE;
        }
        if(tree1 == null || tree2 == null) {
            return Boolean.FALSE;
        }
        return (tree1.val == tree2.val && compare(tree1.left, tree2.left) && compare(tree1.right, tree2.right));
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, null))))));
        TreeNode tree2 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, null))))));
        System.out.println(compare(tree1, tree2)? "Same Tree" : "Different Tree");
    }

}
