package com.practice.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                left.equals(treeNode.left) &&
                right.equals(treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            TreeNode root = q.poll();
            sb.append(root.val).append(", ");
            if(root.left != null)
                q.offer(root.left);
            if(root.right != null)
                q.offer(root.right);
        }
        return sb.toString();
    }
}