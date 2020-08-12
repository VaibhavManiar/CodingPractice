package com.practice.dailycodingpractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This problem was asked by Google.
 * <p>
 * Implement locking in a binary tree.
 * A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.
 * <p>
 * Design a binary tree node class with the following methods:
 * <p>
 * is_locked, which returns whether the node is locked
 * lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
 * unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
 * You may augment the node to add parent pointers or any other property you would like.
 * You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes.
 * Each method should run in O(h), where h is the height of the tree.
 */
public class Q24 {

    public static boolean isLocked(Node root, Node nodeToBeFound) {
        Stack<Node> stack = new Stack<>();
        if (find(root, nodeToBeFound, stack)) {
            return stack.firstElement().isLocked;
        }
        return false;
    }

    public static boolean unlock(Node root, Node nodeToBeFound) {
        Stack<Node> stack = new Stack<>();
        if (isParentNodesAreUnlocked(root, nodeToBeFound, stack) && isChildNodesAreUnlocked(stack.peek())) {
            stack.firstElement().isLocked = false;
            System.out.println("Unlocked");
            return true;
        }
        return false;
    }

    public static boolean lock(Node root, Node nodeToBeFound) {
        Stack<Node> stack = new Stack<>();
        if (isParentNodesAreUnlocked(root, nodeToBeFound, stack) && isChildNodesAreUnlocked(stack.peek())) {
            stack.firstElement().isLocked = true;
            System.out.println("Locked");
            return true;
        }
        return false;
    }

    private static boolean find(Node root, Node nodeToFound, Stack<Node> stack) {

        if (nodeToFound == null || root == null) {
            return false;
        }

        if (root.equals(nodeToFound)) {
            stack.push(root);
            return true;
        }

        if (find(root.left, nodeToFound, stack)) {
            stack.push(root);
            return true;
        }

        if (find(root.right, nodeToFound, stack)) {
            stack.push(root);
            return true;
        }
        return false;
    }

    private static class Node {
        int val;
        Node left, right;
        boolean isLocked;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return val == node.val;
        }
    }


    private static boolean isParentNodesAreUnlocked(Node root, Node nodeToBeFound, Stack<Node> stack) {
        if (find(root, nodeToBeFound, stack)) {
            return stack.stream().noneMatch(node -> {
                if (node.equals(nodeToBeFound))
                    return false;
                return node.isLocked;
            });
        }
        return false;
    }

    private static boolean isChildNodesAreUnlocked(Node node) {
        if (node.isLocked) {
            return false;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.left != null) {
                if (n.left.isLocked) {
                    return false;
                }
                q.offer(n.left);
            } else if (n.right != null) {
                if (n.right.isLocked) {
                    return false;
                }
                q.offer(n.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node nodeToBeFound = new Node(6);
        if (!isLocked(root, nodeToBeFound)) {
            System.out.println("Is Locked : " + isLocked(root, nodeToBeFound));
            lock(root, nodeToBeFound);
        }
        System.out.println("Is Locked : " + isLocked(root, nodeToBeFound));
        unlock(root, nodeToBeFound);
        System.out.println("Is Locked : " + isLocked(root, nodeToBeFound));
    }
}
