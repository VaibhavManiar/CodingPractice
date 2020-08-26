package com.practice.array;

import java.util.Arrays;

public class Equation {
    public static String MissingDigit(String str) {
        // code goes here
        String[] equations = str.split("=");
        return cal(equations[0], equations[1], equations[0].contains("x"));
    }
    private static final String[] operators = new String[]{"*", "/", "+", "-"};
    private static String cal(String leftEquation, String rightEquation,
                              boolean isLeftEquationContainsX) {
        int temp = 0;
        String strTemp = "";


        String finalLeftEquation = leftEquation;
        if (Arrays.stream(operators).noneMatch(finalLeftEquation::contains)) {
            String t = rightEquation;
            rightEquation = leftEquation;
            leftEquation = t;
        }

        if (leftEquation.contains("*")) {
            String[] leftEquationComps = leftEquation.split("\\*");
            if (leftEquationComps[0].contains("x")) {
                temp = Integer.parseInt(rightEquation) / Integer.parseInt(leftEquationComps[1]);
                strTemp = leftEquationComps[0];
            } else if (leftEquationComps[1].contains("x")) {
                temp = Integer.parseInt(rightEquation) / Integer.parseInt(leftEquationComps[0]);
                strTemp = leftEquationComps[1];
            } else {
                temp = Integer.parseInt(leftEquationComps[1]) * Integer.parseInt(leftEquationComps[0]);
                strTemp = rightEquation;
            }
        } else if (leftEquation.contains("/")) {
            String[] leftEquationComps = leftEquation.split("/");
            if (leftEquationComps[0].contains("x")) {
                temp = Integer.parseInt(rightEquation) * Integer.parseInt(leftEquationComps[1]);
                strTemp = leftEquationComps[0];
            } else if (leftEquationComps[1].contains("x")) {
                temp = Integer.parseInt(rightEquation) * Integer.parseInt(leftEquationComps[0]);
                strTemp = leftEquationComps[1];
            } else {
                temp = Integer.parseInt(leftEquationComps[0]) / Integer.parseInt(leftEquationComps[1]);
                strTemp = rightEquation;
            }
        } else if (leftEquation.contains("-")) {
            String[] leftEquationComps = leftEquation.split("-");
            if (leftEquationComps[0].contains("x")) {
                temp = Integer.parseInt(rightEquation) + Integer.parseInt(leftEquationComps[1]);
                strTemp = leftEquationComps[0];
            } else if (leftEquationComps[1].contains("x")) {
                temp = Integer.parseInt(rightEquation) + Integer.parseInt(leftEquationComps[0]);
                strTemp = leftEquationComps[1];
            } else {
                temp = Integer.parseInt(leftEquationComps[0]) - Integer.parseInt(leftEquationComps[1]);
                strTemp = rightEquation;
            }
        } else if (leftEquation.contains("+")) {
            String[] leftEquationComps = leftEquation.split("\\+");
            if (leftEquationComps[0].contains("x")) {
                temp = Integer.parseInt(rightEquation) - Integer.parseInt(leftEquationComps[1]);
                strTemp = leftEquationComps[0];
            } else if (leftEquationComps[1].contains("x")) {
                temp = Integer.parseInt(rightEquation) - Integer.parseInt(leftEquationComps[0]);
                strTemp = leftEquationComps[1];
            } else {
                temp = Integer.parseInt(leftEquationComps[1]) + Integer.parseInt(leftEquationComps[0]);
                strTemp = rightEquation;
            }
        }

        if (strTemp.length() > 1) {
            return String.valueOf(temp).charAt(strTemp.indexOf('x')) + "";
        } else {
            return String.valueOf(temp);
        }
    }

    public static void main(String[] args) {
        //System.out.println(MissingDigit("100*12=1x00"));
        System.out.println(MissingDigit("1x0*12=1200"));
        System.out.println(MissingDigit("100*12=1200"));
    }
}
