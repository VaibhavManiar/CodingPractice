package com.practice.dictionary;

public class EnglishDictionaryTrieNode extends TrieNode {

    public EnglishDictionaryTrieNode() {
        super();
    }

    @Override
    public int getMaxChar() {
        return 26;
    }

    @Override
    public char getFirstChar() {
        return 'a';
    }
}
