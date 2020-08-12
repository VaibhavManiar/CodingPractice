package com.practice.ola;

import java.util.HashMap;
import java.util.Map;

public class CountBTCircularLeaves {

    private Map<Node, Integer> map = new HashMap<>();

    private static int count(CountBTLeaves.Node root, int count) {
        if (root.left == null || root.right == null)
            return ++count;
        return count(root.right, count(root.left, count));
    }

    private static int count(CountBTLeaves.Node root) {
        int count = 0;
        count = count(root, count);
        return count;
    }

    public static void main(String[] args) {
        CountBTLeaves.Node root = new CountBTLeaves.Node(new CountBTLeaves.Node(new CountBTLeaves.Node(null, null, 10),
                new CountBTLeaves.Node(null, null, 11), 1),
                new CountBTLeaves.Node(new CountBTLeaves.Node(null, null, 10),
                        new CountBTLeaves.Node(null, null, 11), 1), 20);
        System.out.println(count(root));
    }

    static class Node {
        final CountBTLeaves.Node left;
        final CountBTLeaves.Node right;
        final int data;

        public Node(CountBTLeaves.Node left, CountBTLeaves.Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}
