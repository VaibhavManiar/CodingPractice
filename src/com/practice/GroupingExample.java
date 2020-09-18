package com.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void print(List<String> list) {
        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().
                stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> {
                    throw new RuntimeException();
                }, LinkedHashMap::new)).keySet().forEach(System.out::println);
    }

    private final List<Integer> list = new ArrayList<>();

    public int consume() throws InterruptedException {
        synchronized (list) {
            if (list.isEmpty()) {
                wait();
            }
            return list.get(0);
        }
    }

    public void produce(int value) {
        list.add(value);
        notifyAll();
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("ANS");
        l.add("NMS");
        l.add("MOH");
        l.add("MOH");
        print(new ArrayList<>(l));
    }
}
