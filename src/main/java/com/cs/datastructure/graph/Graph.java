package com.cs.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V;
    private List<List<Integer>> adjacencyList;
    private boolean isDirectedGraph;

    public Graph(int V, boolean isDirectedGraph) {
        this.V = V;
        this.isDirectedGraph = isDirectedGraph;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public Graph(int V) {
        this(V, false);
    }

    public void addEdge(int fromV, int toV) {
        this.adjacencyList.get(fromV).add(toV);
        if (!isDirectedGraph) {
            this.adjacencyList.get(toV).add(fromV);
        }
    }

    public boolean hasCycleDirected() {
        List<Integer> visited = new ArrayList<>();
        List<Integer> stackFlag = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (hasCycleDirected(i, visited, stackFlag)) {
                return true;
            }
        }
        return false;

    }

    private boolean hasCycleDirected(Integer v, List<Integer> visited, List<Integer> stackFlag) {
        if (stackFlag.contains(v)) {
            return true;
        }

        if (visited.contains(v)) {
            return false;
        }

        visited.add(v);
        stackFlag.add(v);

        for (Integer i : adjacencyList.get(v)) {
            if (hasCycleDirected(i, visited, stackFlag)) {
                return true;
            }
        }
        stackFlag.remove(v);
        return false;
    }

    public boolean hasCycleUndirected() {
        boolean result = false;

        //visited array
        boolean[] visited = new boolean[V];
        //do DFS, from each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (hasCycleUndirected(i, visited, -1)) {
                    return true;
                }
            }
        }
        return result;
    }

    private boolean hasCycleUndirected(int currVertex, boolean[] visited, int parent) {
        //add this vertex to visited vertex
        visited[currVertex] = true;

        //visit neighbors except its direct parent
        for (int i = 0; i < adjacencyList.get(currVertex).size(); i++) {
            int vertex = adjacencyList.get(currVertex).get(i);
            //check the adjacent vertex from current vertex
            if (vertex != parent) {
                //if destination vertex is not its direct parent then
                if (visited[vertex]) {
                    //if here means this destination vertex is already visited
                    //means cycle has been detected
                    return true;
                } else {
                    //recursion from destination node
                    if (hasCycleUndirected(vertex, visited, currVertex)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public void printGraph() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("\nAdjacency list of vertex -> " + i);
            System.out.print("head");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(" -> " + adjacencyList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
