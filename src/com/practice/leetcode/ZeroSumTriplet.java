package com.practice.leetcode;

import java.util.*;

public class ZeroSumTriplet {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Set<Pair>> pairs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j + 1 < nums.length) {
                    Integer sum = nums[j] + nums[j + 1];
                    Set<Pair> list = pairs.getOrDefault(sum, new HashSet<>());
                    list.add(new Pair(j, j + 1, sum));
                    pairs.put(sum, list);
                }
            }
        }

        Set<Triple> triples = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (pairs.containsKey((-1 * nums[i]))) {
                Set<Pair> pairList = pairs.get((-1 * nums[i]));
                for (Pair p : pairList) {
                    Triple triple = new Triple(nums[i], nums[p.index1], nums[p.index2]);
                    triples.add(triple);
                }
            }
        }

        for (Triple triple : triples) {
            List<Integer> l = new ArrayList<>();
            l.add(triple.val1);
            l.add(triple.val2);
            l.add(triple.val3);
            result.add(l);
        }

        return result;

    }


    static class Pair {
        int index1;
        int index2;
        int sum;

        public Pair(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }

        public int negativeValue() {
            return -1 * sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return index1 == pair.index1 &&
                    index2 == pair.index2 &&
                    sum == pair.sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index1, index2, sum);
        }
    }

    public static class Triple {
        int val1;
        int val2;
        int val3;

        public Triple(int val1, int val2, int val3) {
            this.val1 = val1;
            this.val2 = val2;
            this.val3 = val3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triple)) return false;
            Triple that = (Triple) o;
            List<Integer> list = new ArrayList<>();
            list.add(this.val1);
            list.add(this.val2);
            list.add(this.val3);

            if(list.contains(that.val1)) {
                list.remove(new Integer(that.val1));
            }
            if(list.contains(that.val2)) {
                list.remove(new Integer(that.val2));
            }
            if(list.contains(that.val3)) {
                list.remove(new Integer(that.val3));
            }
            return list.isEmpty();

            /*return this.val1 == that.val1 &&
                    this.val2 == that.val2 &&
                    this.val3 == that.val3;*/
        }

        @Override
        public int hashCode() {
            return Objects.hash(val1) + Objects.hash(val2) + Objects.hash(val3);
        }
    }

    public static void main(String[] args) {
        ZeroSumTriplet o = new ZeroSumTriplet();
        o.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).forEach(l -> {
            System.out.print("[");
            l.forEach(v -> System.out.print(v + ","));
            System.out.println("]");
        });

        /*o.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}).forEach(l -> {
            System.out.print("[");
            l.forEach(v -> System.out.print(v + ","));
            System.out.println("]");
        });*/

       /* o.threeSum(new int[]{12,5,-12,4,-11,11,2,7,2,-5,-14,-3,-3,3,2,-10,9,-15,2,14,-3,-15,-3,-14,-1,-7,11,-4,-11,12,-15,-14,2,10,-2,-1,6,7,13,-15,-13,6,-10,-9,-14,7,-12,3,-1,5,2,11,6,14,12,-10,14,0,-7,11,-10,-7,4,-1,-12,-13,13,1,9,3,1,3,-5,6,9,-4,-2,5,14,12,-5,-6,1,8,-15,-10,5,-15,-2,5,3,3,13,-8,-13,8,-5,8,-6,11,-12,3,0,-2,-6,-14,2,0,6,1,-11,9,2,-3,-6,3,3,-15,-5,-14,5,13,-4,-4,-10,-10,11}).forEach(l -> {
            System.out.print("[");
            l.forEach(v -> System.out.print(v + ","));
            System.out.print("], ");
        });*/
    }
}
