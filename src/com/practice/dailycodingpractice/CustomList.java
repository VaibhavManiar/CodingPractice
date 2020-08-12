package com.practice.dailycodingpractice;

public interface CustomList<T> {
    CustomList<T> add(T t);
    T get(int index);
    boolean remove(T t);
    boolean removeFromStart();
    boolean removeFromLast();
    int getSize();
    int getCapacity();
}
