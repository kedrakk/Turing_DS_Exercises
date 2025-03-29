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
}
