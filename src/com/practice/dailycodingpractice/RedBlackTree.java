package com.practice.dailycodingpractice;

public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T val) {
        Node<T> node = new Node<>(val);
        if (root == null) {
            root = node;
            return;
        }

        addIntoBST(root, node);
        if (!correctBlackRedRelationship(node.parent)) {
            swapNodesCyclically(node);
        }
    }

    private void swapNodesCyclically(Node<T> node) {
        Node<T> parentNode = node.parent;
        if (parentNode != null && parentNode.color == Node.Color.RED) {
            Node<T> grandParentNode = parentNode.parent;
            if(grandParentNode != null) {
                Node<T> uncleNode;
                if (grandParentNode.val.compareTo(parentNode.val) >= 0) {
                    uncleNode = grandParentNode.right;
                } else {
                    uncleNode = grandParentNode.right;
                }

                if (uncleNode == null || uncleNode.color == Node.Color.BLACK) {
                    if(parentNode.left == node) {
                        clockwiseRotate(parentNode);
                    } else {
                        anticlockwiseRotate(parentNode);
                    }
                }
            }
        }
    }

    private void clockwiseRotate(Node<T> parentNode) {
        Node<T> grandParentNode = parentNode.parent;
        if(grandParentNode.parent != null) {
            if(grandParentNode.parent.left == grandParentNode) {
                grandParentNode.parent.left = parentNode;
            } else {
                grandParentNode.parent.right = parentNode;
            }
            parentNode.left = parentNode.right;
            parentNode.right = parentNode.parent;
            parentNode.parent = grandParentNode.parent;
        }
    }
    private void anticlockwiseRotate(Node<T> parentNode) {
        Node<T> grandParentNode = parentNode.parent;
        if(grandParentNode.parent != null) {
            if(grandParentNode.parent.left == grandParentNode) {
                grandParentNode.parent.left = parentNode;
            } else {
                grandParentNode.parent.right = parentNode;
            }
            parentNode.right = parentNode.left;
            parentNode.left = parentNode.parent;
            parentNode.parent = grandParentNode.parent;
        }
    }

    private boolean correctBlackRedRelationship(Node<T> parentNode) {
        boolean flag = Boolean.FALSE;
        while (parentNode != null && parentNode.color == Node.Color.RED) {
            Node<T> grandParent = parentNode.parent;
            if(grandParent != null) {
                Node<T> uncleNode;
                if (grandParent.val.compareTo(parentNode.val) >= 0) {
                    uncleNode = grandParent.right;
                } else {
                    uncleNode = grandParent.left;
                }

                if (uncleNode != null && uncleNode.color == Node.Color.RED) {
                    parentNode.color = Node.Color.BLACK;
                    uncleNode.color = Node.Color.BLACK;
                    flag = Boolean.TRUE;
                }
            }
            parentNode = grandParent;
        }
        return flag;
    }

    public void addIntoBST(Node<T> root, Node<T> node) {
        if(root == null)
            return;
        Node<T> parent = root;
        while (root != null) {
            if (root.val.compareTo(node.val) >= 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            if (root != null)
                parent = root;
        }

        if (parent.val.compareTo(node.val) >= 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        node.parent = parent;
        node.color = Node.Color.RED;
    }

    private static class Node<T extends Comparable<T>> {
        T val;
        Node<T> left, right, parent;
        Color color = Color.BLACK;

        public Node(T val) {
            this.val = val;
        }

        enum Color {
            RED, BLACK
        }
    }


    public Node<T> root() {
        return this.root;
    }


    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.add(10);
        tree.add(7);
        tree.add(15);
        tree.add(8);
        tree.add(5);
        tree.add(1);
        tree.add(2);
        System.out.println("Done");
    }
}
