package com.practice;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static int availableIngredients = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numberOfDays = in.nextInt();
        int numberOfIngredients = in.nextInt();
        Map<String, List<String>> map = new HashMap<>();
        String result = "";
        int sixtyPercent = (int) Math.ceil(((double) (numberOfIngredients * 60)) / 100);

        for (int i = 0; i < numberOfDays; i++) {
            String ingredientId = in.next();
            availableIngredients++;
            if (map.containsKey(getNutritionType(ingredientId))) {
                map.get(getNutritionType(ingredientId)).add(ingredientId);
            } else {
                List<String> set = new ArrayList<>();
                set.add(ingredientId);
                map.put(getNutritionType(ingredientId), set);
            }
            if (availableIngredients >= numberOfIngredients) {
                String mainIngredient = getMainIngredient(map, sixtyPercent);
                if(mainIngredient.isEmpty()) {
                    result += "-";
                    continue;
                }
                Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator();
                if (it.hasNext()) {
                    List<String> ings = it.next().getValue();
                    if (ings.size() > 0) {
                        String s = ings.get(0);
                        result += mainIngredient + s;
                        ings.remove(s);
                        availableIngredients--;
                    }
                }
            } else {
                result += "-";
            }
        }
        System.out.println(result);
    }

    private static String getMainIngredient(Map<String, List<String>> map, int sixtyPercent) {
        String result = "";
        int t = sixtyPercent;
        List<String> l = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= sixtyPercent) {
                List<String> ingSet = map.get(entry.getKey());
                for (String s : ingSet) {
                    l.add(s) ;
                    availableIngredients--;
                    if (--t == 0) {
                        break;
                    }
                }
                ingSet.removeAll(l);
            }
        }
        for(String s : l) {
            result += (s + ":");
        }
        return result;
    }


    public static String getNutritionType(String ingredientId) {
        if (ingredientId.contains("FIBER")) {
            return "FIBER";
        }
        if (ingredientId.contains("CARB")) {
            return "CARB";
        }
        if (ingredientId.contains("FAT")) {
            return "FAT";
        }
        return "";
    }
}