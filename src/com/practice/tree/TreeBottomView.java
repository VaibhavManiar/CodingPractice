package com.practice.tree;

import java.util.*;

/**
 *         1
 *     2       3
 * 5     4 6      7
 */
public class TreeBottomView {



    public static Collection<TreeNode> getBottomView(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<QNode> q = new LinkedList<>();
        q.add(new QNode(root, 0));

        while (!q.isEmpty()) {
            QNode currQNode = q.poll();
            TreeNode currTreeNode = currQNode.node;

            map.put(currQNode.level, currTreeNode);

            if (currTreeNode.left != null) {
                q.offer(new QNode(currTreeNode.left, currQNode.level - 1));
            }

            if (currTreeNode.right != null) {
                q.offer(new QNode(currTreeNode.right, currQNode.level + 1));
            }
        }
        return map.values();
    }

    private static class QNode {
        private final TreeNode node;
        private final int level;

        public QNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode() {
            return node;
        }

        public int getLevel() {
            return level;
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
        getBottomView(root).forEach(node -> System.out.print(node.val + " | "));
    }


}
