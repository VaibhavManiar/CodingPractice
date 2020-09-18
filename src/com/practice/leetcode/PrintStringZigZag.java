package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PrintStringZigZag {

    public String convert(String s, int numRows) {
        List<StringBuilder> matrix = zigzag(s.toCharArray(), numRows);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.size(); i++) {
            result.append(matrix.get(i).toString());
        }
        return result.toString();
    }

    private List<StringBuilder> zigzag(char[] chArr, int numRows) {
        List<StringBuilder> rowWiseCharacters = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            rowWiseCharacters.add(new StringBuilder());
        }

        int k = 0;
        while (k < chArr.length) {
            int i = 0;
            for (; i < numRows; i++) {
                if (k < chArr.length) {
                    rowWiseCharacters.get(i).append(chArr[k++]);
                } else {
                    break;
                }
            }
            --i;
            while (i > 1) {
                if (k < chArr.length) {
                    rowWiseCharacters.get(--i).append(chArr[k++]);
                } else {
                    break;
                }
            }
            if (k >= chArr.length) {
                break;
            }
        }
        return rowWiseCharacters;
    }

    public static void main(String[] args) {
        PrintStringZigZag o = new PrintStringZigZag();
        System.out.println(o.convert("PAYPALISHIRING", 4));
    }

}