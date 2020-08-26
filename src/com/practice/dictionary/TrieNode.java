package com.practice.dictionary;

public abstract class TrieNode {
    protected boolean isLastNode = false;
    protected TrieNode[] childNode = new TrieNode[getMaxChar()];

    public TrieNode() {
    }

    public abstract int getMaxChar();
    public abstract char getFirstChar();
}
