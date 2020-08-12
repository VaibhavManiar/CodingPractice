package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class BTNodeFinderAndPathPrinter {

    public boolean findAndTrackPath(Node root, int x, List<Integer> arr) {
        if(root ==  null)
            return false;

        arr.add(root.data);

        if(root.data == x)
            return true;

        if(findAndTrackPath(root.left, x, arr) || findAndTrackPath(root.right, x, arr))
            return true;

        arr.remove(arr.size()-1);
        return false;
    }

    public void printPath() {
        Node root=new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int x=5;

        List<Integer> arr = new ArrayList<>();

        if(findAndTrackPath(root, x, arr)) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + "->");
            }
        }
    }
}
