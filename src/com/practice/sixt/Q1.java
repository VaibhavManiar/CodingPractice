package com.practice.sixt;

public class Q1 {
    private static int count = Integer.MAX_VALUE;

    public static int solution(String S, int i, String prev) {
        int t = 'a' + 'b' + 'c';

        /*if(isConcatable(S) && (S.length()-1) == i) {
            i--;
        }*/

        if(i > S.length()-1) {
            return S.length();
        }
        for (int index = i; index < S.length(); index++) {
            char ch1 = S.charAt(index);
            char ch0 = S.charAt(index - 1);
            if (ch1 != ch0) {
                char ch3 = (char)(t - (ch0 + ch1));
                String s = S.substring(0, index-1) + String.valueOf(ch3) + S.substring(index+1, S.length());
                System.out.println(s);

                return solution(s, i, S);
            }
        }
        if(count > S.length()) {
            count = S.length();
        }
        return solution(prev, ++i, prev);
    }

    private static boolean isConcatable(String s) {
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) != s.charAt(i+1)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        int val = solution("abcacbb", 1, "abcacbb");
        System.out.println(val);
    }
}
