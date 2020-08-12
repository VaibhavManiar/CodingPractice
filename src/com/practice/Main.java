package com.practice;

import com.practice.pb.FindRotationalPointInAnArray;
import com.practice.pb.GetMaxProfitArraySubset;
import com.practice.pb.GroupAnalogy;
import com.practice.tree.BTNodeFinderAndPathPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BTNodeFinderAndPathPrinter o = new BTNodeFinderAndPathPrinter();
        o.printPath();

        GetMaxProfitArraySubset o1 = new GetMaxProfitArraySubset();
        o1.findSubset();

        FindRotationalPointInAnArray o2 = new FindRotationalPointInAnArray();
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        o2.rotationalIndex(arr, 0, arr.length - 1);
        o2.findInRotationalArray(arr, 0, arr.length - 1, 6);

        List<String> list = new ArrayList<>();
        list.add("dog");
        list.add("god");
        list.add("doo");
        list.add("goo");
        System.out.println(GroupAnalogy.group(list));
    }
}
