package com.practice.dailycodingpractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ToggleBinaryTree {
    private QNode root;

    public static int getMinToggleOperations(QNode root) {
        Queue<QNode> q = new LinkedList<>();
        q.offer(root);
        Stack<QNode> stack = new Stack<>();
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            QNode n = q.poll();
            stack.push(n);
            if (n.left != null) {
                n.left.level = level;
                q.offer(n.left);
            }
            if (n.right != null) {
                n.right.level = level;
                q.offer(n.right);
            }
        }
        while (!stack.isEmpty()) {
            int l = stack.peek().level;
            while (!stack.isEmpty() && stack.peek().level == l) {

            }
        }

        return 0;
    }

    private static class QNode {
        int data;
        int level;
        int nodesToToggle;
        int nodesNotToToggle;
        QNode left, right;

        QNode(int data) {
            this.data = data;
            this.level = level;
        }

        QNode(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }
}
