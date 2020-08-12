package com.practice.dailycodingpractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This problem was asked by Microsoft.
 * <p>
 * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
 * If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
 * <p>
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
 * you should return ['the', 'quick', 'brown', 'fox'].
 * <p>
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
 * return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class Q22 {

    public static boolean sol(Set<String> dictionary, String sentence, List<String> words) {
        if (sentence == null || sentence.isEmpty()) {
            return true;
        }

        for (int index = 1; index <= sentence.length(); index++) {
            if (dictionary.contains(sentence.substring(0, index)) && sol(dictionary, sentence.substring(index), words)) {
                words.add(sentence.substring(0, index));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Set<String> dictionary = dictionary();
        String sentence = "theyarethebest";
        if (sol(dictionary, sentence, words)) {
            System.out.println("Words found");
            words.forEach(System.out::println);
        } else {
            System.out.println("Words not found");
        }
    }

    private static Set<String> dictionary() {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("the");
        dictionary.add("they");
        dictionary.add("are");
        dictionary.add("best");
        return dictionary;
    }

}
