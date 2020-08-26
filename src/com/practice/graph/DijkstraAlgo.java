package com.practice.graph;

import java.util.HashMap;
import java.util.Map;

public class DijkstraAlgo {
    private final boolean[] visited;
    private final int[] distance;
    private final Map<Integer, Integer> shortestPath;
    private final int[][] graph;

    public DijkstraAlgo(int[][] graph) {
        this.graph = graph;
        this.distance = new int[graph.length];
        this.visited = new boolean[graph.length];
        this.shortestPath = new HashMap<>();
    }

    private void init(int srcIndex) {
        for (int index = 0; index < this.distance.length; index++) {
            this.distance[index] = srcIndex == index ? 0 : Integer.MAX_VALUE;
        }
    }

    private int getMinDistVertexIndex() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int index = 0; index < distance.length; index++) {
            if (distance[index] < min && !visited[index]) {
                min = distance[index];
                minIndex = index;
            }
        }
        return minIndex;
    }

    public void solve(int srcIndex) {
        init(srcIndex);
        int u = srcIndex;
        for (int index = 0; index < graph.length; index++) {
            u = getMinDistVertexIndex();
            visited[index] = true;
            for (int v = 0; v < graph[u].length; v++) {
                if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                    shortestPath.put(v, u);
                }
            }
        }
        System.out.println(shortestPath);
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
        DijkstraAlgo d = new DijkstraAlgo(graph);
        d.solve(0);
    }

}
