package com.practice.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    public static void sort(int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited.contains(graph[i][0])) {
                sortUtil(graph[i][0], graph, stack, visited);
            }
        }
        System.out.println();
        while (!stack.empty()) {
            System.out.print(stack.pop() + " , ");
        }
    }

    public static void sortUtil(int vertex, int[][] graph, Stack<Integer> stack, Set<Integer> visited) {
        int[] adjacentVertex = adjacentVertex(vertex, graph);
        for (int i = 0; i < adjacentVertex.length; i++) {
            if (visited.add(adjacentVertex[i])) {
                sortUtil(adjacentVertex[i], graph, stack, visited);
            }
        }
        stack.push(vertex);
    }

    private static int[] adjacentVertex(int vertex, int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i][0] == vertex) {
                return graph[i];
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        sort(new int[][] {
                {1, 2, 3},
                {3, 4, 8},
                {5, 6},
                {6, 3},
                {8, 11}
        });
    }
}
