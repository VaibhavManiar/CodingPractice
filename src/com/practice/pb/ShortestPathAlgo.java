package com.practice.pb;

import javafx.util.Pair;

import java.util.*;

public class ShortestPathAlgo {

    Graph graph;

    public ShortestPathAlgo(Graph graph) {
        this.graph = graph;
    }

    public void solution() {
        int[] distances = getInitialDistancesArray();

        boolean[] spt = new boolean[this.graph.adjacentMatrix.length];

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(this.graph.adjacentMatrix.length, Comparator.comparingInt(Pair::getValue));

        pq.offer(new Pair<>(0, distances[0]));

        while(!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int currentVertex = pair.getKey();

            // non visited vertex
            if(!spt[currentVertex]) {

                List<Edge> edges = this.graph.adjacentMatrix[currentVertex];
                for(Edge edge: edges) {
                    int adjacentVertex = edge.destination;
                    if(!spt[adjacentVertex]) {
                        int adjacentVertexDistance = distances[adjacentVertex];
                        int newDistance = distances[currentVertex] + edge.distance;

                        if(adjacentVertexDistance > newDistance) {
                            pq.offer(new Pair<>(adjacentVertex, newDistance));
                            distances[adjacentVertex] = newDistance;
                        }
                    }
                }

                // now set as visited vertex
                spt[currentVertex] = true;
            }
        }
        System.out.println();
    }

    private int[] getInitialDistancesArray() {
        int[] distances = new int[this.graph.adjacentMatrix.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        return distances;
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        ShortestPathAlgo algo = new ShortestPathAlgo(graph);

        algo.solution();
    }
}

class Graph {
    private final int size;
    final LinkedList<Edge>[] adjacentMatrix;

    Graph(int size) {
        this.size = size;
        this.adjacentMatrix = new LinkedList[this.size];
        for(int i=0; i<this.size; i++) {
            this.adjacentMatrix[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination, int distance) {
        if (source >= size || source < 0 || destination >= size || destination < 0) {
            throw new IllegalArgumentException("source or destination must not be greater than size:" + size);
        }
        this.adjacentMatrix[source].add(new Edge(source, destination, distance));
    }
}

class Edge {
    final int source;
    final int destination;
    final int distance;

    Edge(int source, int destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }
}

