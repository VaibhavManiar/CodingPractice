package com.practice.dictionary;

public abstract class TrieNode {
    boolean isLastNode = false;
    TrieNode[] childNode = new TrieNode[getMaxChar()];

    public TrieNode() {
    }

    public abstract int getMaxChar();
    public abstract char getFirstChar();
}
