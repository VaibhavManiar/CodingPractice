package com.practice.dictionary;

import java.util.*;

/**
 * Trie data structure.
 */

public class Trie {

    private final TrieNode root;
    private static final char STAR = '*';
    boolean isPatternSearchEnabled = Boolean.FALSE;
    private final static Set<Character> patternCharSupported = new HashSet<>(Collections.singletonList(STAR));

    public Trie() {
        this.root = new EnglishDictionaryTrieNode();
    }

    public int insert(String word) {
        if (Objects.isNull(word)) {
            throw new RuntimeException("Null value can not be inserted.");
        }
        word = word.toLowerCase();
        char[] chArr = word.toCharArray();
        TrieNode temp = root;
        int insertedCharCount = 0;
        for (char ch : chArr) {
            int index = ch - root.getFirstChar();
            if (temp.childNode[index] == null) {
                insertedCharCount++;
                temp.childNode[index] = new EnglishDictionaryTrieNode();
            }
            temp = temp.childNode[index];
        }
        temp.isLastNode = Boolean.TRUE;
        return insertedCharCount;
    }

    public boolean isWordPresent(String word) {
        if (Objects.isNull(word)) {
            return Boolean.FALSE;
        }

        if (isPatternSearchEnabled)
            return isPatterPresent(word);

        word = word.toLowerCase();
        char[] chArr = word.toCharArray();
        TrieNode temp = root;
        for (char ch : chArr) {
            int index = ch - root.getFirstChar();
            if (index > root.getMaxChar() || index < 0) {
                return Boolean.FALSE;
            }
            if (temp == null || temp.childNode[index] == null) {
                return Boolean.FALSE;
            }
            temp = temp.childNode[index];
        }
        return temp != null && temp.isLastNode;
    }

    public boolean isPatterPresent(String pattern) {
        if (Objects.isNull(pattern)) {
            return Boolean.FALSE;
        }
        pattern = pattern.toLowerCase();
        char[] chArr = pattern.toCharArray();
        TrieNode temp = root;
        for (int k = 0; k < chArr.length; k++) {
            char ch = chArr[k];

            // if special character present
            if (patternCharSupported.contains(ch)) {
                if (ch == STAR && evalStarPattern(pattern, k)) return Boolean.TRUE;
            }

            // find index
            int index = ch - root.getFirstChar();

            // if index is out of supported characters then return false
            if (index > root.getFirstChar() || index < 0) {
                return Boolean.FALSE;
            }
            // if trie node is not present at character index return false
            if (temp == null || temp.childNode[index] == null) {
                return Boolean.FALSE;
            }
            temp = temp.childNode[index];
        }
        // if this is last trie node then pattern found
        return temp != null && temp.isLastNode;
    }

    /**
     * Eval '*' character and find pattern
     *
     * @param pattern
     * @param indexOfStarChar
     * @return
     */
    private boolean evalStarPattern(String pattern, int indexOfStarChar) {
        for (int i = 0; i < root.getMaxChar(); i++) {

            // Replace * with all supported characters. And find any of the word is present or not.
            String p = pattern.substring(0, indexOfStarChar) + (char) (root.getFirstChar() + i) + pattern.substring(indexOfStarChar + 1);

            if (isPatterPresent(p)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.insert("Hi"));
        System.out.println(trie.insert("Hello"));
        System.out.println(trie.insert("Hallo"));

        System.out.println(trie.isWordPresent("Hi"));
        System.out.println(trie.isPatterPresent("*allo"));
        System.out.println(trie.isPatterPresent("Ha***"));
        System.out.println(trie.isPatterPresent("He***"));
        System.out.println(trie.isPatterPresent("**l**"));

        System.out.println(trie.isWordPresent("Hii"));
        System.out.println(trie.isWordPresent(null));
        System.out.println(trie.isPatterPresent(null));
        System.out.println(trie.isPatterPresent("**l*"));
        System.out.println(trie.isPatterPresent("****#"));
    }
}