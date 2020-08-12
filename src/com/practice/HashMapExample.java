package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapExample<K, V> {
    Map<K, V> map = new HashMap<>();

    public void addData(K k, V v) {
        map.put(k, v);
    }

    public static class Emp {
        int id;
        String name;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Emp)) return false;
            Emp emp = (Emp) o;
            return id == emp.id &&
                    name.equals(emp.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static void main(String[] args) {
        HashMapExample<Emp, String> example = new HashMapExample<>();
        example.addData(new Emp(1, "ABC"), "");
    }
}
