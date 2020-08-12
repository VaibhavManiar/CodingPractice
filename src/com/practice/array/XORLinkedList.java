package com.practice.array;

public class XORLinkedList {
    private static final int NULL = Integer.MIN_VALUE;
    private Node head = new Node(NULL);

    public void add(int data) {
        if(NULL == data) {
            throw new RuntimeException(NULL + " string value is not allowed as data.");
        }

        if(head.data == NULL) {
            this.head = new Node(data);
            return;
        }
        Node temp = this.head;
        add(temp, data);
    }

    private void add(Node head, int data) {
        int prev = NULL;
        int next;
        while((next = Node.xor(head.xorPointer, prev)) != NULL) {
            prev = head.data;
            head = new Node(next);
        }
        head.xorPointer = Node.xor(prev, data);
    }

    private static class Node {
        final int data;
        int xorPointer;

        public Node(int data) {
            this.data = data;
            this.xorPointer = xor(NULL, NULL);
        }

        public static int xor(int prev, int next) {
            return prev^next;
        }
    }

    public static void main(String[] args) {
        XORLinkedList xorLinkedList = new XORLinkedList();
        xorLinkedList.add(1);
        xorLinkedList.add(2);
        xorLinkedList.add(3);
        xorLinkedList.add(4);
        xorLinkedList.add(5);
    }
}