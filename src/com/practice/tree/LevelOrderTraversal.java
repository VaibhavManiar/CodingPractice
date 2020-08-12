package com.practice.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void print(TreeNode treeNode) {
        Queue<TreeNode> q = new LinkedList<>();
        if (treeNode != null) {
            q.add(treeNode);
        }
        print(q);
    }

    private static void print(Queue<TreeNode> q) {
        if (!q.isEmpty()) {
            TreeNode treeNode = q.poll();
            System.out.print(treeNode.val + " ");
            if (treeNode.left != null) {
                q.add(treeNode.left);
            }
            if (treeNode.right != null) {
                q.add(treeNode.right);
            }
            print(q);
        }
    }

    public static void printLeafNodes(TreeNode treeNode) {
        Queue<TreeNode> q = new LinkedList<>();
        if (treeNode != null) {
            q.add(treeNode);
        }
        printLeafNodes(q);
    }

    private static void printLeafNodes(Queue<TreeNode> q) {
        if (!q.isEmpty()) {
            TreeNode treeNode = q.poll();
            if (treeNode.left == null && treeNode.right == null) {
                System.out.print(treeNode.val + " ");
            }
            if (treeNode.left != null) {
                q.add(treeNode.left);
            }
            if (treeNode.right != null) {
                q.add(treeNode.right);
            }
            printLeafNodes(q);
        }
    }

    private static void printCircularlyConnectedLeafNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        printCircularlyConnectedLeafNodes(q, new HashMap<>());
    }

    private static void printCircularlyConnectedLeafNodes(Queue<TreeNode> q, Map<Integer, Integer> map) {
        if (!q.isEmpty()) {
            TreeNode treeNode = q.poll();
            if (map.containsKey(treeNode.val) && map.get(treeNode.val) > 2) {
                return;
            }
            if (map.containsKey(treeNode.val) && map.get(treeNode.val) > 1) {
                System.out.print(treeNode.val + " ");
            }
            if (treeNode.left != null) {
                if (map.containsKey(treeNode.left.val)) {
                    map.put(treeNode.left.val, map.get(treeNode.left.val) + 1);
                } else {
                    q.add(treeNode.left);
                    map.put(treeNode.left.val, 1);
                }
            }
            if (treeNode.right != null) {
                if (map.containsKey(treeNode.right.val)) {
                    map.put(treeNode.right.val, map.get(treeNode.right.val) + 1);
                } else {
                    q.add(treeNode.right);
                    map.put(treeNode.right.val, 1);
                }
            }
            printCircularlyConnectedLeafNodes(q, map);
        }
    }


    public static void main(String[] args) {
        System.out.println("Print level order traversal:");
        print(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null), null),
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null)),
                        new TreeNode(8,
                                new TreeNode(9, null, null),
                                new TreeNode(10, null, null)))));
        System.out.println();
        System.out.println("Print Leaf Nodes:");
        printLeafNodes(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null), null),
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null)),
                        new TreeNode(8,
                                new TreeNode(9, null, null),
                                new TreeNode(10, null, null)))));

        System.out.println();
        System.out.println("Print circularly connected leaf nodes:");
        TreeNode treeNode10 = new TreeNode(10, null, null);
        TreeNode treeNode9 = new TreeNode(9, null, treeNode10);
        TreeNode treeNode7 = new TreeNode(7, null, treeNode9);
        TreeNode treeNode6 = new TreeNode(6, null, treeNode7);
        TreeNode treeNode4 = new TreeNode(4, null, treeNode6);
        treeNode10.right = treeNode4;
        printCircularlyConnectedLeafNodes(new TreeNode(1,
                new TreeNode(2,
                        treeNode4, null),
                new TreeNode(3,
                        new TreeNode(5,
                                treeNode6,
                                treeNode7),
                        new TreeNode(8,
                                treeNode9,
                                treeNode10))));
    }
}
