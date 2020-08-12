package com.practice.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreAndInOrder {

    public static TreeNode construct(int[] inOrder, int[] preOrder, int inStart, int inEnd, int preIndex) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode tNode = new TreeNode(preOrder[preIndex++]);
        if (inStart == inEnd) {
            return tNode;
        }

        int inIndex = search(tNode.val, inOrder);
        tNode.left = construct(inOrder, preOrder, inStart, inIndex - 1, preIndex);
        tNode.right = construct(inOrder, preOrder, inIndex + 1, inEnd, preIndex);

        return tNode;
    }

    public static TreeNode construct1(int[] inOrder, int[] preOrder, int inStart, int inEnd, int preIndex, Map<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode tNode = new TreeNode(preOrder[preIndex++]);
        if (inStart == inEnd) {
            return tNode;
        }

        int inIndex = map.get(tNode.val);
        tNode.left = construct1(inOrder, preOrder, inStart, inIndex - 1, preIndex, map);
        tNode.right = construct1(inOrder, preOrder, inIndex + 1, inEnd, preIndex, map);

        return tNode;
    }

    private static Map<Integer, Integer> generateMap(int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < inOrder.length; index++) {
            map.put(inOrder[index], index);
        }

        return map;
    }

    private static int search(int val, int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == val) {
                return index;
            }
        }
        return -1;
    }
}
