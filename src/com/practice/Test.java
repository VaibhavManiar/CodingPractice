package com.practice;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT*/

        //Scanner
        Scanner s = new Scanner(System.in);
        String value = s.nextLine();
        System.out.println(reduce(value));


        // Write your code here

    }

    public static String reduce(String str) {

        int len = str.length();
        int mid = len/2;

        String s1 = str.substring(0, mid);
        String s2 = str.substring(mid);

        while(s2.charAt(s2.length()-1) == s1.charAt(0)) {
            String s = getReducedString(s1, s2);
            mid = s.length()/2;
            s2 = s.substring(0, mid);
            s1 = s.substring(mid);
        }
        return s1 + s2;
    }

    private static String getReducedString(String s1, String s2) {
        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(s2.length()-1);
        if(ch1 == ch2) {
            int c1 = 0;
            int index1 = 0;
            while(s1.charAt(index1++) == ch1) {
                c1++;
            }

            int c2 = 0;
            int index2 = s2.length()-1;
            while(s2.charAt(index2--) == ch2) {
                c2++;
            }

            s1 = s1.substring(index1-1);
            s2 = s2.substring(0, s2.length()-c2);
        }
        return s2 + s1;
    }
}
