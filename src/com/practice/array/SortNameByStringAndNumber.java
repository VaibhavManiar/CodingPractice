package com.practice.array;

import java.lang.reflect.Array;
import java.util.*;

public class SortNameByStringAndNumber {
    private static final Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static List<String> sortRoman(List<String> names) {
        // Write your code here
        Map<String, String> namesWithInt = new HashMap<>();
        for(String name : names) {
            String[] s = name.split(" ");
            int num = romanToInt(s[1]);
            namesWithInt.put(s[0] + " " + num, name);
        }
        List<String> sortedNames = new ArrayList<>(namesWithInt.keySet());
        List<String> sortedRomanNames = new ArrayList<>();
        sortedNames.sort((s1, s2) -> {
            Integer i1 = Integer.parseInt(s1.split(" ")[1]);
            Integer i2 = Integer.parseInt(s2.split(" ")[1]);
            return i1.compareTo(i2);
        });
        sortedNames.sort(Comparator.comparing(s -> s.split(" ")[0]));
        sortedNames.forEach(System.out::println);
        System.out.println("||------------||");
        sortedNames.forEach(name-> sortedRomanNames.add(namesWithInt.get(name)));
        return sortedRomanNames;
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Bruce XVIII");
        names.add("Bruce XXVI");
        names.add("Bruce XXVII");
        names.add("Bruce XLI");
        names.add("Francois XX");
        names.add("Francois XXIII");
        names.add("Francois XXIV");
        names.add("Francois XXV");
        names.add("Francois XL");
        names.add("Francois VI");
        sortRoman(names).forEach(System.out::println);
    }


}
