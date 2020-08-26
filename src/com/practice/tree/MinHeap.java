package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MinHeap {
    private final List<Integer> heap = new ArrayList<>();

    private static int leftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private static int rightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private static int parentIndex(int childIndex) {
        return childIndex / 2;
    }

    public void add(int val) {
        heap.add(val);
        heapifyBottomUp(heap.size() - 1);
    }

    private void heapifyBottomUp(int index) {
        if (index >= 0 && parentIndex(index) >= 0 && heap.get(parentIndex(index)) > heap.get(index)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
            heapifyBottomUp(index);
        }
    }

    private void heapifyTopDown(int index) {
        if((index >= 0 && leftChildIndex(index) >=0) &&
                (index < heap.size() && leftChildIndex(index) < heap.size()) &&
                heap.get(leftChildIndex(index)) < heap.get(index)) {
            swap(index, leftChildIndex(index));
            index = leftChildIndex(index);
            heapifyTopDown(index);
        }

        if((index >= 0 && rightChildIndex(index) >=0) &&
                (index < heap.size() && rightChildIndex(index) < heap.size()) &&
                heap.get(rightChildIndex(index)) < heap.get(index)) {
            swap(index, rightChildIndex(index));
            index = rightChildIndex(index);
            heapifyTopDown(index);
        }
    }

    public int removeAndGet() {
        if(!heap.isEmpty()) {
            int val = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            heapifyTopDown(0);
            return val;
        }
        throw new RuntimeException("Not found.");
    }

    private void swap(int index1, int index2) {
        int t = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, t);
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        IntStream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).forEach(heap::add);
        heap.heap.forEach(System.out::println);
        System.out.println( "Pop : " + heap.removeAndGet());
        heap.heap.forEach(System.out::println);
    }
}
