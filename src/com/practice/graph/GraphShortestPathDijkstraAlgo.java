package com.practice.graph;

import java.util.HashMap;
import java.util.Map;

public class GraphShortestPathDijkstraAlgo {
    static Map<Integer, Integer> path = new HashMap<>();
    public static void solve(int[][] graph, int src) {
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];
        for (int index = 0; index < graph.length; index++) {
            visited[index] = Boolean.FALSE;
            dist[index] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for (int index = 0; index < graph.length; index++) {
            int u = getMinimumDistance(dist, visited);
            visited[u] = Boolean.TRUE;

            for (int v = 0; v < graph.length; v++) {
                if (!visited[v] && graph[u][v] > 0 && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + graph[u][v]) {
                    path.put(v, u);
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        for(int d : dist) {
            System.out.println(d);
        }
    }

    private static int getMinimumDistance(int[] dist, boolean[] visited) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int index = 0; index < dist.length; index++) {
            if (min > dist[index] && !visited[index]) {
                min = dist[index];
                minIndex = index;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        solve(graph, 0);
    }

}
