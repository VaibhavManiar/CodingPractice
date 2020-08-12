package com.practice.microsoft;

import java.util.Objects;

/**
 * Are miror tree
 */
public class Question4 {
    public static boolean areMirrorTree(Node tree1, Node tree2) {
        if (Objects.isNull(tree1) && Objects.isNull(tree2))
            return true;
        if (Objects.isNull(tree1) || Objects.isNull(tree2))
            return false;

        return tree1.data == tree2.data && areMirrorTree(tree1.left, tree2.right) && areMirrorTree(tree1.right, tree2.left);
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);

        System.out.println(areMirrorTree(a, b) ? "Are mirror tree" : "Are not mirror tree");
    }
}
