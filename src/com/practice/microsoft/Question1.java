package com.practice.microsoft;

/**
 * Preorder traversal
 */
public class Question1 {
    public static void printPreOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
    }

    public static void printInOrderTraversal(Node root) {
        if (root == null)
            return;

        printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversal(root.right);
    }

    public static void printPostOrderTraversal(Node root) {
        if (root == null)
            return;

        printPostOrderTraversal(root.left);
        printPostOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Pre order : ");
        printPreOrderTraversal(root);
        System.out.println("\n Inorder : ");
        printInOrderTraversal(root);
        System.out.println("\n post order : ");
        printPostOrderTraversal(root);
    }
}