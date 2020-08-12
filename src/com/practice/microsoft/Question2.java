package com.practice.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * Create tree from Preorder and inorder
 */
public class Question2 {
    private static int preOrderIndex = 0;
    private static Map<Integer, Integer> inOrderMap;

    public static Node buildTree(int[] inOrder, int[] preOrder, int inStart, int inEnd) {
        if(inStart > inEnd)
            return null;

        Node node = new Node(preOrder[preOrderIndex++]);

        if(inStart == inEnd)
            return node;

        //int inOrderIndex = findInOrderNodeIndex(inOrder, inStart, inEnd, node.data);
        int inOrderIndex = findInOrderNodeIndexUsingMap(node.data);

        node.left = buildTree(inOrder, preOrder, 0, inOrderIndex-1);
        node.right = buildTree(inOrder, preOrder, inOrderIndex+1, inEnd);

        return node;
    }

    private static int findInOrderNodeIndexUsingMap(int nodeData) {
        return inOrderMap.getOrDefault(nodeData, -1);
    }

    private static int findInOrderNodeIndex(int[] inOrder, int start, int end, int nodeData) {
        for (int index = start; index <= end; index++) {
            if (inOrder[index] == nodeData)
                return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        inOrderMap = inOrderMap(new int[]{4,2,5,1,3});
        Node root = buildTree(new int[]{4,2,5,1,3}, new int[]{1,2,4,5,3}, 0, 4);
        Question1.printPreOrderTraversal(root);
    }

    public static Map<Integer, Integer> inOrderMap(int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int index = 0; index < inOrder.length; index++) {
            map.put(inOrder[index], index);
        }
        return map;
    }
}