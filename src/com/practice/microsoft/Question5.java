package com.practice.microsoft;

import javafx.util.Pair;

import java.util.*;

/**
 * LRU using hashing
 * K must be always unique and must implement equals and hashcode
 */
public final class Question5<K extends Question5.Key, V> {
    private final Map<K, Pair<K, V>> map = new HashMap<>();
    private final int capacity;
    private final LinkedList<Pair<K, V>> q = new LinkedList<Pair<K, V>>();
    private final Callback<K, V> callback;

    public Question5(int capacity, Callback<K, V> callback) {
        this.capacity = capacity;
        this.callback = callback;
    }

    private void insert(K k, V v) {
        if (q.size() >= capacity) {
            q.removeLast();
        }
        Pair<K, V> pair = new Pair<>(k, v);
        q.addFirst(pair);
        map.put(k, pair);
    }

    public V get(K k) {
        return getIfAvailable(k).orElseGet(() -> getIfNotFound(k));
    }

    public Optional<V> getIfAvailable(K k) {
        Pair<K, V> pair = map.get(k);
        if(!q.getFirst().getKey().equals(pair.getKey()) ) {
            q.remove(pair);
            q.addFirst(pair);
        }
        return Optional.ofNullable(pair.getValue());
    }

    private V getIfNotFound(K k) {
        V v = callback.get(k);
        insert(k, v);
        return v;
    }

    @FunctionalInterface
    public interface Callback<K, V> {
        V get(K k);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return q.size();
    }

    public abstract class Key extends Object {

        @Override
        public int hashCode() {
            return getHashCode();
        }

        @Override
        public boolean equals(Object o) {
            return areEqual(o);
        }

        protected abstract int getHashCode();
        protected abstract boolean areEqual(Object o);
    }
}
