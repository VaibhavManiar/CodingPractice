package com.practice.dailycodingpractice;

import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LinkedCustomList<T> implements CustomList<T> {

    private final int capacity;
    private int size;
    private Node<T> start;
    private Node<T> last;
    private final ReentrantReadWriteLock lock;

    public LinkedCustomList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.start = null;
        this.last = null;
        this.lock = new ReentrantReadWriteLock();
    }

    @Override
    public CustomList<T> add(T t) {
        if (size >= capacity) {
            throw new RuntimeException("Linked list size has reached to it's max capacity.");
        }
        this.lock.writeLock().lock();
        Node<T> newNode = new Node<>(t);
        if (this.start == null) {
            this.start = newNode;
            this.last = this.start;
            return this;
        }

        this.last.next = newNode;
        newNode.prev = this.last;
        this.last = newNode;
        this.size++;
        this.lock.writeLock().unlock();
        return this;
    }

    @Override
    public T get(int index) {
        return getNode(index).t;
    }

    public Node<T> getNode(int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("Index : " + index);
        }

        int temp = index;
        Node<T> tempNode = this.start;
        while (temp-- > 0) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    public Optional<Node<T>> getNode(T t) {
        Node<T> tempNode = this.start;
        while (tempNode != null) {
            if (tempNode.t.equals(t)) {
                return Optional.of(tempNode);
            }
            tempNode = tempNode.next;
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(T t) {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        Optional<Node<T>> optNode = this.getNode(t);
        if (optNode.isPresent()) {
            this.remove(optNode.get());
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean removeFromStart() {
        Node<T> node = this.getLast();
        Node<T> prev = node.prev;
        prev.next = null;
        node.prev = null;
        return Boolean.TRUE;
    }

    @Override
    public boolean removeFromLast() {
        Node<T> node = this.getStart();
        Node<T> next = node.next;
        next.prev = null;
        node.next = null;
        return Boolean.TRUE;
    }

    public CustomList<T> remove(Node<T> node) {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        this.lock.writeLock().lock();
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
        this.size--;
        this.lock.writeLock().unlock();
        return this;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getSize() {
        return size;
    }

    public Node<T> getStart() {
        return start;
    }

    public Node<T> getLast() {
        return last;
    }

    public static class Node<T> {
        private T t;
        private Node<T> next, prev;

        public Node(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrev() {
            return prev;
        }
    }
}
