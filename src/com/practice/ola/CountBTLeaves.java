package com.practice.ola;

public class CountBTLeaves {

    private static int count(Node root, int count) {
        if (root.left == null || root.right == null)
            return ++count;
        return count(root.right, count(root.left, count));
    }

    private static int count(Node root) {
        int count = 0;
        count = count(root, count);
        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(new Node(new Node(null, null, 10),
                new Node(null, null, 11), 1),
                new Node(new Node(null, null, 10),
                        new Node(null, null, 11), 1), 20);
        System.out.println(count(root));
    }

    static class Node {
        final Node left;
        final Node right;
        final int data;

        public Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}