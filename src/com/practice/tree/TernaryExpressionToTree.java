package com.practice.tree;

import java.util.Objects;

public class TernaryExpressionToTree {

    public static TreeNodeNew<Character> constructTreeRecursively(String expression, int index) {
        if (Objects.isNull(expression) || expression.trim().isEmpty() || index >= expression.length()) {
            return null;
        }

        TreeNodeNew<Character> root = new TreeNodeNew<>(expression.charAt(index));
        index++;

        if (index < expression.length()) {
            if (expression.charAt(index) == '?') {
                root.left = constructTreeRecursively(expression, index + 1);
            } else if (expression.charAt(index) == ':') {
                root.right = constructTreeRecursively(expression, index + 1);
            } else {
                throw new RuntimeException("Invalid expression.");
            }
        }
        return root;
    }

    private static TreeNodeNew<Character> convertExpression(char[] expression, int i) {
        // Base case
        if (i >= expression.length)
            return null;

        // store current character of expression_string
        // [ 'a' to 'z']
        TreeNodeNew<Character> root = new TreeNodeNew<>(expression[i]);

        // Move ahead in str
        ++i;

        if(i < expression.length) {
            // if current character of ternary expression is '?'
            // then we add next character as a left child of
            // current node
            if (expression[i] == '?')
                root.left = convertExpression(expression, i + 1);

                // else we have to add it as a right child of
                // current node expression.at(0) == ':'
            else if (expression[i] == ':')
                root.right = convertExpression(expression, i + 1);
        }
        return root;
    }

    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        int e = 1;
        int f = 1;
        int g = 1;
        int h = 1;
        int i = 0;

        int r = a ? b ? c ? d ? e : f : h : g : i;

        //TreeNodeNew<Character> root = constructTreeRecursively("a?b?c:d:e"/*"a?b?c?d?e:f:h:g:i"*/, 0);
        TreeNodeNew<Character> treeNode = convertExpression(new char[]{'a', '?', 'b', '?', 'c', ':', 'd', ':', 'e'}, 0);
        System.out.println(treeNode);
    }
}
