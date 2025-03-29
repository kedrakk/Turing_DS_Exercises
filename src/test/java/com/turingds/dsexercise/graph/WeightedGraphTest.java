/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class WeightedGraphTest {

    WeightedGraph graph = new WeightedGraph();

    public WeightedGraphTest() {
        graph.setVertice("A");
        graph.setVertice("B");
        graph.setVertice("C");
        graph.setVertice("D");
        graph.setVertice("E");
        graph.setVertice("F");

        graph.build();

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "D", 9);
        graph.addEdge("B", "E", 6);
        graph.addEdge("C", "F", 3);
        graph.addEdge("D", "E", 2);
    }

    @Test
    public void testGetAdjacentVertices() {
        List<String> vertices = new ArrayList<>();
        vertices.add("A");

        List<Edge> adjacentVertices = this.graph.getAdjencentVerticesForGraph(vertices);
        assertEquals(2, adjacentVertices.size());

        Edge edge0 = adjacentVertices.get(0);
        assertEquals("C", edge0.end);
        assertEquals(1, edge0.weight);

        Edge edge1 = adjacentVertices.get(1);
        assertEquals("B", edge1.end);
        assertEquals(5, edge1.weight);

    }

    @Test
    public void testGetAdjacentVerticesFromGraph() {
        List<String> vertices = new ArrayList<>();
        vertices.add("A");
        vertices.add("C");

        List<Edge> adjacentVertices = this.graph.getAdjencentVerticesForGraph(vertices);
        assertEquals(2, adjacentVertices.size());

        Edge edge0 = adjacentVertices.get(0);
        assertEquals("C-F=3", edge0.toString());

        Edge edge1 = adjacentVertices.get(1);
        assertEquals("A-B=5", edge1.toString());

    }

    @Test
    public void testGetAdjacentVerticesFromGraphComplex() {
        List<String> vertices = new ArrayList<>();
        vertices.add("A");
        vertices.add("C");
        vertices.add("F");

        List<Edge> adjacentVertices = this.graph.getAdjencentVerticesForGraph(vertices);
        assertEquals(1, adjacentVertices.size());

        Edge edge0 = adjacentVertices.get(0);
        assertEquals("A-B=5", edge0.toString());

    }

    @Test
    public void testGetAdjacentVerticesFromGraphComplex2() {
        List<String> vertices = new ArrayList<>();
        vertices.add("B");
        vertices.add("A");
        vertices.add("C");
        vertices.add("F");

        List<Edge> adjacentVertices = this.graph.getAdjencentVerticesForGraph(vertices);
        assertEquals(2, adjacentVertices.size());

        Edge edge0 = adjacentVertices.get(0);
        assertEquals("B-E=6", edge0.toString());

        Edge edge1 = adjacentVertices.get(1);
        assertEquals("B-D=9", edge1.toString());
    }

    @Test
    public void testPrimAlgorithm() {
        //D,E,B,A,C,F
        List<String> mst = this.graph.primAlgorithm();
        assertEquals(6, mst.size());

        Iterator<String> iterator = mst.iterator();
        assertEquals("D", iterator.next());
        assertEquals("E", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("A", iterator.next());
        assertEquals("C", iterator.next());
        assertEquals("F", iterator.next());

        assertFalse(iterator.hasNext());
    }
}
