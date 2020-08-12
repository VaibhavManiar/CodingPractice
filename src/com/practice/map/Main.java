package com.practice.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = 16;
        System.out.println(Objects.hashCode(s) & (n - 1));
        Map<String, String> map = new HashMap<>(10, 0.2F);
        System.out.println(1 << 30);
    }
}
