/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kedk
 */
public class GraphWithEdgeDFSTest {

    GraphEdgeRep graph = new GraphEdgeRep();

    public GraphWithEdgeDFSTest() {
        graph.setVertice("A");
        graph.setVertice("B");
        graph.setVertice("C");
        graph.setVertice("D");
        graph.setVertice("E");
        graph.setVertice("F");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "E", 6);
        graph.addEdge("B", "F", 2);
        graph.addEdge("D", "E", 2);
    }

    @Test
    public void testGetAdjacentEdges() {
        List<Edge> adjEdges = graph.getAdjacentEdges("A");
        assertEquals(2, adjEdges.size());

        Edge edge = adjEdges.get(0);
        assertEquals("A-B=5", edge.toString());

        edge = adjEdges.get(1);
        assertEquals("A-C=1", edge.toString());
    }

    @Test
    public void testGetAdjacentEdgesComplex() {
        List<Edge> adjEdges = graph.getAdjacentEdges("E");
        assertEquals(2, adjEdges.size());

        Edge edge = adjEdges.get(0);
        assertEquals("B-E=6", edge.toString());

        edge = adjEdges.get(1);
        assertEquals("D-E=2", edge.toString());
    }

    @Test
    public void testNonVisitedNonAdjacentEdges() {
        Edge visited = graph.edges.get(0);
        graph.markedVisited(visited);

        List<Edge> nonVisitedEdges = graph.getAdjacentEdgesWhichNotVisited("A");
        assertEquals(1, nonVisitedEdges.size());

        Edge edge = nonVisitedEdges.get(0);
        assertEquals("A-C=1", edge.toString());
    }

    @Test
    public void testNonVisitedNonAdjacentVertices() {
        List<String> nonVisitedvertices = graph.getAdjacentVerticesWhichNotVisited("E");
        assertEquals(2, nonVisitedvertices.size());

        assertEquals("B", nonVisitedvertices.get(0));
        assertEquals("D", nonVisitedvertices.get(1));
    }

    @Test
    public void testDFS() {
        List<Edge> edges = graph.dfsAlgorithm();
        assertEquals(5, edges.size());

        Iterator<Edge> iterator = edges.iterator();
        assertEquals("A-B=5", iterator.next());
        assertEquals("B-E=6", iterator.next());
        assertEquals("E-D=2", iterator.next());
        assertEquals("B-F=2", iterator.next());
        assertEquals("A-C=1", iterator.next());
    }
}
