package com.practice;

import java.time.Duration;
import java.util.Map;

public class TimedEntry<K, V> implements Map.Entry<K, V> {
    final K key;
    V value;
    Duration duration;


    public TimedEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.duration = duration;
    }

    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public V setValue(V value) {
        return null;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
