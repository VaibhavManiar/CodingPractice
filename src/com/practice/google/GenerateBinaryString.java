package com.practice.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * input : 1??0?101
 */
public class GenerateBinaryString {

    public static void generate(String str) {
        Set<String> strings = new HashSet<>();
        List<Integer> indexes = indexesOfQuestionMark(str);
        for(Integer index : indexes) {
            char[] chars1 = str.toCharArray();
            char[] chars2 = str.toCharArray();
            chars1[index] = '0';
            chars2[index] = '1';
            strings.add(new String(chars1).replaceAll("\\?", "0"));
            strings.add(new String(chars1).replaceAll("\\?", "1"));
            strings.add(new String(chars2).replaceAll("\\?", "0"));
            strings.add(new String(chars2).replaceAll("\\?", "1"));
        }
        System.out.println("Generated Strings count : " + strings.size());
        strings.forEach(s-> System.out.println(s));
    }

    private static List<Integer> indexesOfQuestionMark(String str) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '?') {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        generate("1??0?101");
    }
}
