package com.practice.dailycodingpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Given a stream of words, at any given point of time, get me 'n' most frequent words.
 */

public class FindNMostFrequentWords {

    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> sortedMap = new TreeMap<>((e1, e2) -> {
        int v = map.getOrDefault(e2, 0).compareTo(map.getOrDefault(e1, 0));
        if (v == 0) {
            return e1.compareTo(e2);
        }
        return v;
    });

    public void consume(String word) {
        map.put(word, map.getOrDefault(word, 0) + 1);
        sortedMap.remove(word);
        sortedMap.put(word, map.get(word));
    }

    public void sol(int n) {
        int counter = 0;
        for (Map.Entry<String, Integer> e : sortedMap.entrySet()) {
            if(++counter > n) {
                break;
            }
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

    public static void main(String[] args) {
        FindNMostFrequentWords o = new FindNMostFrequentWords();

        Thread t1 = new Thread(()-> {
            Stream.generate(Math::random).map(v-> v * 1000).map(Math::round).map(String::valueOf).forEach(o::consume);
        });
        Thread t2 = new Thread(()-> {
            while (true) {
                o.sol(3);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        //Arrays.stream(new String[]{"abc", "def", "efg", "def", "def", "abc", "abc"}).forEach(o::consume);
        o.sol(3);
    }


}
