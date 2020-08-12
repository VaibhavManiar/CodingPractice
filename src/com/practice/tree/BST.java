package com.practice.tree;

public class BST {

    public final Node root;

    public BST(int data) {
        root = new Node(data, null, null);
    }

    private static class Node {
        public final int data;
        public Node left;
        public Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void add(int data) {
        add(data, this.root);
    }

    private void add(int data, Node root) {
        if(root.data > data) {
            if(root.left == null) {
                root.left = new Node(data, null, null);
                return;
            }
            add(data, root.left);
        }

        if(root.data < data) {
            if(root.right == null) {
                root.right = new Node(data, null, null);
                return;
            }
            add(data, root.right);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(1);
        bst.add(2);
        bst.add(3);
        bst.add(4);
    }

}
