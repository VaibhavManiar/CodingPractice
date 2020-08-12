package com.practice.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *          1
 *      2       3
 *   5     4 6     7
 */
public class TreeTopView {

    public static void solve(TreeNode node) {
        QNode qNode = new QNode(node, 0);
        Queue<QNode> queue = new LinkedList<>();
        queue.add(qNode);
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            QNode qN = queue.poll();
            if (set.add(qN.level))
                System.out.println(qN.node.val);

            if (qN.node.left != null)
                queue.add(new QNode(qN.node.left, qN.level + 1));

            if (qN.node.right != null)
                queue.add(new QNode(qN.node.right, qN.level - 1));

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        solve(root);
    }

    private static class QNode {
        TreeNode node;
        int level;

        public QNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

}