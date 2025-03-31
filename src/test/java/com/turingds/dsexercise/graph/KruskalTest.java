/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class KruskalTest {

    GraphEdgeRep graph = new GraphEdgeRep();

    @Test
    public void testAddEdge() {
        Edge edge = graph.addEdge("A", "B", 10);
        assertEquals("A", edge.start);
        assertEquals("B", edge.end);

        edge = graph.addEdge("B", "A", 10);
        assertEquals("A", edge.start);
        assertEquals("B", edge.end);
    }

    @Test
    public void testKrusalAlgorithm() {
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 4);
        graph.addEdge("B", "D", 9);
        graph.addEdge("B", "E", 6);
        graph.addEdge("B", "F", 2);
        graph.addEdge("C", "F", 3);
        graph.addEdge("D", "E", 2);
    }
}
