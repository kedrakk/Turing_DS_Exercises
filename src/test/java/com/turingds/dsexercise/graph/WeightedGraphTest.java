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
public class WeightedGraphTest {

    WeightedGraph graph = new WeightedGraph();

    void buildAction() {
        graph.setVertice("A");
        graph.setVertice("B");
        graph.setVertice("C");
        graph.setVertice("D");
        graph.setVertice("E");
        graph.setVertice("F");

        graph.build();
    }

    @Test
    public void testGetAdjacentVertexStartWith() {
        this.buildAction();
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 9);
        graph.addEdge("B", "E", 6);
        graph.addEdge("C", "F", 3);
        graph.addEdge("D", "E", 2);

    }
}
