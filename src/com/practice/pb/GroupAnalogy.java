package com.practice.pb;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnalogy {

    static class Key {
        final List<Character> chars = new ArrayList<>();

        Key(String str) {
            for (char ch : str.toCharArray()) {
                chars.add(((Character) ch));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return chars.size() == key.chars.size() && chars.containsAll(key.chars) && key.chars.containsAll(chars);
        }

        @Override
        public int hashCode() {
            return chars.stream().map(character -> Objects.hashCode((char) character)).mapToInt(i -> i).sum();
        }
    }

    public static Set<Set<String>> group(List<String> strings) {
        Map<Key, Set<String>> map = new HashMap<>();
        for (String s : strings) {
            Key key = new Key(s);
            Set<String> set = map.getOrDefault(key, new HashSet<>());
            set.add(s);
            map.put(key, set);
        }
        return new HashSet<>(map.values());
    }
}
