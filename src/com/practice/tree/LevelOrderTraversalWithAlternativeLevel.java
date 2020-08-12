package com.practice.tree;

import java.util.*;

public class LevelOrderTraversalWithAlternativeLevel {
    private TreeNode root;

    public LevelOrderTraversalWithAlternativeLevel(TreeNode root) {
        this.root = root;
    }

    public void levelOrderTraversal(TreeNode root,
                                    Queue<SpecialTreeNode> queue,
                                    List<Integer> oddList,
                                    List<Integer> evenList) {
        queue.add(new SpecialTreeNode(root, true));
        while (!queue.isEmpty()) {
            SpecialTreeNode t = queue.poll();
            if (t.isOddLevel) {
                oddList.add(t.node.val);
            } else {
                evenList.add(t.node.val);
            }
            if (t.node.left != null) {
                queue.add(new SpecialTreeNode(t.node.left, !t.isOddLevel));
            }
            if (t.node.right != null) {
                queue.add(new SpecialTreeNode(t.node.right, !t.isOddLevel));
            }
        }

    }

    public void levelOrderTraversal() {
        if(Objects.isNull(root)){
            throw new RuntimeException("Root is null.");
        }
        Queue<SpecialTreeNode> queue = new LinkedList<>();
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        levelOrderTraversal(root, queue, oddList, evenList);

        System.out.println("Odd Level Node Data : ");
        for(Integer odd: oddList) {
            System.out.println(odd);
        }

        System.out.println("Even Level Node Data : ");
        for(Integer even: evenList) {
            System.out.println(even);
        }
    }

    static class SpecialTreeNode {
        public SpecialTreeNode(TreeNode node, boolean isOddLevel) {
            this.node = node;
            this.isOddLevel = isOddLevel;
        }
        TreeNode node;
        boolean isOddLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2,
                new TreeNode(4), new TreeNode(5)), new TreeNode(3, new
                TreeNode(6), new TreeNode(7)));
        LevelOrderTraversalWithAlternativeLevel tree = new LevelOrderTraversalWithAlternativeLevel(root);
        tree.levelOrderTraversal();
    }
}
