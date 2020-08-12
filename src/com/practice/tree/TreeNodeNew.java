package com.practice.tree;

public class TreeNodeNew<T> {
    T data;
    TreeNodeNew<T> left;
    TreeNodeNew<T> right;

    public TreeNodeNew(T data, TreeNodeNew<T> left, TreeNodeNew<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNodeNew(T data) {
        this.data = data;
    }
}
