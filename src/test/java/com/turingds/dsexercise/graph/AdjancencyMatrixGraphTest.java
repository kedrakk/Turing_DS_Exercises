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
public class AdjancencyMatrixGraphTest {

    //GraphAMatrix graph = new GraphAMatrix();
    GraphAList graph = new GraphAList();

    void buildAction() {
        graph.setVertice("A");
        graph.setVertice("B");
        graph.setVertice("C");
        graph.setVertice("D");
        graph.setVertice("E");
        graph.setVertice("F");

        graph.build();
    }

    //@Test
    public void testGraphEdgeExist() {
        this.buildAction();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");

        assertTrue(graph.existEdge("A", "B"));
        assertTrue(graph.existEdge("B", "A"));
    }

    //@Test
//    public void testDFSAdjacency() {
//        this.buildAction();
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "C");
//        graph.addEdge("B", "D");
//        graph.addEdge("B", "E");
//        graph.addEdge("C", "F");
//        graph.addEdge("D", "E");
//
//        List<String> adjVertext = graph.getAdjacentVertex("A");
//        Iterator<String> iterator = adjVertext.iterator();
//        assertEquals("B", iterator.next());
//        assertEquals("C", iterator.next());
//        assertFalse(iterator.hasNext());
//
//        adjVertext = graph.getAdjacentVertex("B");
//        iterator = adjVertext.iterator();
//        assertEquals("A", iterator.next());
//        assertEquals("D", iterator.next());
//        assertEquals("E", iterator.next());
//        assertFalse(iterator.hasNext());
//    }

//    @Test
//    public void testDFS() {
//        this.buildAction();
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "C");
//        graph.addEdge("B", "D");
//        graph.addEdge("B", "E");
//        graph.addEdge("C", "F");
//        graph.addEdge("D", "E");
//
//        List<String> dfsVertices = graph.depthFirstSearch();
//        Iterator<String> iterator = dfsVertices.iterator();
//
//        assertEquals("A", iterator.next());
//        assertEquals("B", iterator.next());
//        assertEquals("D", iterator.next());
//        assertEquals("E", iterator.next());
//        assertEquals("C", iterator.next());
//        assertEquals("F", iterator.next());
//    }
}
