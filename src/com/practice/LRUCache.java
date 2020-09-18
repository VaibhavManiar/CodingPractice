package com.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final Map<K, List.Node<V>> map = new HashMap<>();
    private final List<V> linkedList = new LinkedList<>();

    public V get(K k) {
        List.Node<V> node = map.get(k);
        linkedList.remove(node);
        linkedList.addToStart(node.getValue());
        return node.getValue();
    }

    public void add(K k, V v) {
        List.Node<V> node = linkedList.addToStart(v);
        map.put(k, node);
    }

    private interface List<E> {
        List.Node<E> addToStart(E e);

        void removeFromEnd();

        void removeFromStart();

        void remove(List.Node<E> node);

        List.Node<E> addToEnd(E e);

        class Node<E> {
            private E value;
            private Node<E> prev, next;

            public Node(E value, Node<E> prev, Node<E> next) {
                this.value = value;
                this.prev = prev;
                this.next = next;
            }

            public Node(E value) {
                this.value = value;
            }

            public E getValue() {
                return value;
            }

            public Node<E> getPrev() {
                return prev;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setPrev(Node<E> prev) {
                this.prev = prev;
            }

            public void setNext(Node<E> next) {
                this.next = next;
            }
        }
    }

    private static class LinkedList<E> implements List<E> {

        private Node<E> start;
        private Node<E> end;

        @Override
        public LinkedList.Node<E> addToStart(E e) {
            Node<E> node = new Node<>(e);
            if (start == null) {
                start = node;
                end = node;
                return start;
            }

            node.setNext(start.getNext());
            start = node;
            return start;
        }

        @Override
        public void removeFromEnd() {
            Node<E> prev = end.prev;
            if(prev != null) {
                end.prev = null;
                prev.next = null;
                end = prev;
            }
        }

        @Override
        public void removeFromStart() {
            Node<E> next = start.next;
            if(next != null) {
                next.prev = null;
                start.next = null;
                start = next;
            }
        }

        @Override
        public void remove(Node<E> node) {
            Node<E> next = node.next;
            Node<E> prev = node.prev;
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
        }

        @Override
        public LinkedList.Node<E> addToEnd(E e) {
            Node<E> node = new Node<>(e);
            if (start == null) {
                start = node;
                end = node;
                return end;
            }

            node.setPrev(end.getPrev());
            end = node;
            return end;
        }
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>();
        cache.add("Key1", "Value1");
        cache.add("Key2", "Value2");
        cache.add("Key3", "Value3");

        String value = cache.get("Key1");
    }
}
