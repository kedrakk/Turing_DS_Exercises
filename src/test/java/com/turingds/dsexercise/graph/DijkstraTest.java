/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kedk
 */
public class DijkstraTest {

    GraphAMatrix graph = new GraphAMatrix();

    public DijkstraTest() {
        graph.setVertice("A");
        graph.setVertice("B");
        graph.setVertice("C");
        graph.setVertice("D");
        graph.setVertice("E");
        graph.setVertice("F");
        graph.setVertice("G");

        graph.build();

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 5);
        graph.addEdge("A", "D", 1);

        graph.addEdge("B", "C", 2);

        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "G", 4);

        graph.addEdge("D", "E", 1);
        graph.addEdge("D", "F", 6);

        graph.addEdge("E", "F", 3);
        graph.addEdge("E", "G", 3);

        graph.initDijkstra();
    }

    @Test
    public void getMinDistVertexFromUnvisitedBaseCase() {
        List<String> unvisited = new ArrayList<>();
        for (String vertex : graph.vertices) {
            unvisited.add(vertex);
        }

        VertexDistance vtxDist = graph.getVerticesWithSmallestDistanceFromUnvisited(unvisited);

        assertEquals("A", vtxDist.vertex);
    }

    @Test
    public void getMinDistVertexFromUnvisitedCase1() {
        List<String> unvisited = new ArrayList<>();
        for (String vertex : graph.vertices) {
            unvisited.add(vertex);
        }
        unvisited.remove("A");

        graph.addTotalWeightToVertex("B", 3);
        graph.addTotalWeightToVertex("C", 5);
        graph.addTotalWeightToVertex("D", 1);

        VertexDistance vtxDist = graph.getVerticesWithSmallestDistanceFromUnvisited(unvisited);

        assertEquals("D", vtxDist.vertex);
    }

    @Test
    public void getMinDistVertexFromUnvisitedCasePrevious() {
        List<String> unvisited = new ArrayList<>();
        for (String vertex : graph.vertices) {
            unvisited.add(vertex);
        }
        unvisited.remove("A");

        graph.addTotalWeightToVertex("B", 7);
        graph.addTotalWeightToVertex("C", 9);
        graph.addTotalWeightToVerticeWithPrevious("D", 4, "A");
        graph.addTotalWeightToVerticeWithPrevious("E", 2, "D");

        VertexDistance vtxDist = graph.getVerticesWithSmallestDistanceFromUnvisited(unvisited);

        assertEquals("D", vtxDist.vertex);
        assertEquals(4, vtxDist.totalDistance);

//        graph.addTotalWeightToVerticeWithPrevious("F", 2, "A");
//        assertEquals("F", vtxDist.vertex);
//        assertEquals(2, vtxDist.totalDistance);
    }

    @Test
    public void testUnvisitedNeighbor() {
        List<String> unvisited = new ArrayList<>();
        for (String vertex : graph.vertices) {
            unvisited.add(vertex);
        }

        List<String> neighbors = graph.getUnvisitedNeighborOfVertex("A", unvisited);
        assertTrue(neighbors.contains("B"));
        assertTrue(neighbors.contains("C"));
        assertTrue(neighbors.contains("D"));
    }

    @Test
    public void testUnvisitedNeighborCase1() {
        List<String> unvisited = new ArrayList<>();
        for (String vertex : graph.vertices) {
            unvisited.add(vertex);
        }
        unvisited.remove("B");

        List<String> neighbors = graph.getUnvisitedNeighborOfVertex("A", unvisited);
        assertFalse(neighbors.contains("B"));
        assertTrue(neighbors.contains("C"));
        assertTrue(neighbors.contains("D"));
    }
}
