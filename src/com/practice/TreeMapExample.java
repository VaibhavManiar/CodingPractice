package com.practice;

import java.util.*;

public class TreeMapExample<K extends Comparable<K>, V> {

    Map<K, V> map = new TreeMap<>();
    public void addData(K k, V v) {
        map.put(k, v);
    }

    public static void main(String[] args) {
        /*TreeMapExample<Emp, String> treeMapExample = new TreeMapExample<>();
        treeMapExample.addData(new Emp(1, "ABC"), "");

        List<String> possibleFeatures = new ArrayList<>();
        possibleFeatures.add("ABC");
        possibleFeatures.add("BCD");
        possibleFeatures.add("DEF");
        List<String> featureRequests = new ArrayList<>();
        featureRequests.add("ABC");
        featureRequests.add("BCD");
        featureRequests.add("BCD");
        featureRequests.add("DEF");
        featureRequests.add("ABC");
        featureRequests.add("BCD");

        ArrayList<String> li = popularNFeatures(0, 2, possibleFeatures, 0, featureRequests);
        System.out.println(li.size());*/

        List<Character> characterList = new ArrayList<>();
        characterList.add('a');
        characterList.add('b');
        characterList.add('c');
        characterList.add('d');
        characterList.add('a');
        characterList.add('e');
        characterList.add('f');
        characterList.add('g');
        characterList.add('i');
        characterList.add('j');
        lengthEachScene(characterList);
    }

    public static ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        ArrayList<String> result = new ArrayList<>();
        Set<String> possibleFeatureSet = new HashSet<>();

        for(String feature : possibleFeatures) {
            possibleFeatureSet.add(feature.toLowerCase());
        }


        Map<String, Integer> map = new HashMap<>();
        for(String featureRequest : featureRequests) {
            for(String feature : featureRequest.split(" ")) {
                feature = feature.toLowerCase();
                if(possibleFeatureSet.contains(feature)) {
                    map.put(feature, (map.getOrDefault(feature, 0) + 1));
                }
            }
        }



        Map<String, Integer> treeMap = new TreeMap<>((f1, f2)->{
            if(map.get(f2).compareTo(map.get(f1)) == 0) {
                return f1.compareTo(f2);
            }
            return map.get(f2).compareTo(map.get(f1));
        });



        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }


        Set<Map.Entry<String, Integer>> entrySet =  treeMap.entrySet();
        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
        while(topFeatures>0) {
            if(it.hasNext()) {
                result.add(it.next().getKey());
            } else {
                break;
            }
            topFeatures--;
        }

        char ch = 'a';
        int v = ch;
        System.out.println(v);
        return result;
    }


    public static class Emp implements Comparable<Emp>{
        int id;
        String name;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Emp o) {
            return this.name.compareTo(o.name);
        }
    }


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<Integer> lengthEachScene(List<Character> inputList) {
        // Very much unclear question
        // Trying my best.
        List<Integer> result = new ArrayList<>();
        Character prev = inputList.get(0);
        Set<Character> set = new HashSet<>();
        for(Character ch : inputList) {
            if(set.size() <= 0) {
                set.add(ch);
                continue;
            }

            if(set.contains(ch) || isNearBy(ch, prev)) {
                set.add(ch);
            } else {
                result.add(set.size());
                set.clear();
            }
        }

        return result;
    }

    static boolean isNearBy(Character ch, Character prev) {
        int val = ch;
        int prevVal = prev;
        return prevVal == val || prevVal-1 == val || prevVal+1 == val;
    }
    // METHOD SIGNATURE ENDS
}
