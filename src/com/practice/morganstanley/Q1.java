package com.practice.morganstanley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Conversion Rate:
 * 1 USD = 70 INR
 * 1 AUD = 2 USD
 * 1 EUR = 1.5 USD
 * 1 EUR = 2 AUD
 * 1 DIN = 3 USD
 * 1 DIN = 2.5 EUR
 * <p>
 * <p>
 * Input 1 EUR = INR
 * Expected output  = 280 INR
 * <p>
 * 1 EUR = 2 AUD = 4 USD = 280 INR
 * 1 EUR = 1.5 USD = 105 INR
 */
public class Q1 {
    private static Map<String, Map<String, Double>> conversionRates = new HashMap<>();

    static {
        Map<String, Double> m1 = new HashMap<>();
        m1.put("INR", 70D);
        conversionRates.put("USD", m1);

        m1 = conversionRates.getOrDefault("AUD", new HashMap<>());
        m1.put("USD", 2D);
        conversionRates.put("AUD", m1);

        m1 = conversionRates.getOrDefault("EUR", new HashMap<>());
        m1.put("USD", 1.5D);
        conversionRates.put("EUR", m1);

        m1 = conversionRates.getOrDefault("EUR", new HashMap<>());
        m1.put("AUD", 2D);
        conversionRates.put("EUR", m1);

        m1 = conversionRates.getOrDefault("DIN", new HashMap<>());
        m1.put("USD", 3D);
        conversionRates.put("DIN", m1);

        m1 = conversionRates.getOrDefault("DIN", new HashMap<>());
        m1.put("EUR", 2.5D);
        conversionRates.put("DIN", m1);
    }

    public static double getMaxConvertedValue(String fromCurr, String toCurr, double value) {
        List<Double> values = new ArrayList<>();
       // getMaxVal(fromCurr, toCurr, values);
        double maxVal = getMax(values);
        return maxVal * value;
    }

    private static double getMax(List<Double> list) {
        double max = Double.MIN_VALUE;
        for (double val : list) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    //static double maxValue = 1;
    static List<String> paths = new ArrayList<>();

    private static void getMaxVal(String fromCurr, String toCurr, List<List<String>> resultList) {

        if (conversionRates.get(fromCurr) == null || conversionRates.get(fromCurr).isEmpty()) {
            paths.remove(paths.get(paths.size() - 1));
            //maxValue = 1;
            return;
        }

        if (conversionRates.containsKey(fromCurr) && conversionRates.get(fromCurr).containsKey(toCurr)) {
            //maxValue *= conversionRates.get(fromCurr).get(toCurr);
            //values.add(maxValue);
            paths.forEach(path -> System.out.print(path + " -> "));
            paths.clear();
            //maxValue = 1;
            System.out.println();
            return;
        }

        for (Map.Entry<String, Double> internalMap : conversionRates.get(fromCurr).entrySet()) {
            if (paths.contains(fromCurr)) {
                continue;
            }
            //maxValue *= internalMap.getValue();
            paths.add(fromCurr);
            getMaxVal(internalMap.getKey(), toCurr, resultList);
        }
    }

    public static void main(String[] args) {
        System.out.println("Maximum Conversion Value : " + getMaxConvertedValue("EUR", "INR", 1));
        System.out.println("Maximum Conversion Value : " + getMaxConvertedValue("DIN", "INR", 1));
    }
}