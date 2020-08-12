package com.practice.microsoft;

import java.util.Objects;

/**
 * Idempotent tree
 */
public class Question3 {

    private static boolean areIdempotent(Node tree1, Node tree2) {
        if (Objects.isNull(tree1) && Objects.isNull(tree2))
            return true;
        if (Objects.isNull(tree1) || Objects.isNull(tree2))
            return false;

        return tree1.data == tree2.data && areIdempotent(tree1.left, tree2.left) && areIdempotent(tree1.right, tree2.right);
    }

    public static void main(String[] args) {
        Node tree1 = new Node(1);
        tree1.left = new Node(2);
        tree1.right = new Node(3);
        tree1.left.left = new Node(4);
        tree1.left.right = new Node(5);

        Node tree2 = new Node(1);
        tree2.left = new Node(2);
        tree2.right = new Node(3);
        tree2.left.left = new Node(4);
        tree2.left.right = new Node(5);

        boolean b = areIdempotent(tree1, tree2);
        System.out.println(b ? "Are idempotent" : "Are not idempotent");
    }

}
