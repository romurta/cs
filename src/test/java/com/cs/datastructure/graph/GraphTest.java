package com.cs.datastructure.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private Graph graph;

    @BeforeEach
    public void setup() {
        graph = new Graph(5);
    }

    @Test
    public void shouldCreateAGraphCorrectly() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }

    @Test
    public void shouldFindTheCycleInAGraph(){
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);

        assertTrue(graph.hasCycleUndirected());
    }

    @Test
    public void shouldNotFindTheCycleInAGraph(){
        graph = new Graph(5,false);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);


        assertFalse(graph.hasCycleUndirected());
    }
}