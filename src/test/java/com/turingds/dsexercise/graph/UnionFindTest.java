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
public class UnionFindTest {

    UnionFind unionFind = new UnionFind();
    
    @Test
    public void testFind() {

        unionFind.setVertice("A");
        unionFind.setVertice("B");
        unionFind.setVertice("C");
        unionFind.setVertice("D");
        unionFind.setVertice("E");
        unionFind.setVertice("F");

        unionFind.addEdge("A", "C", 1);
        unionFind.addEdge("B", "F", 2);
        unionFind.addEdge("D", "E", 2);
        unionFind.addEdge("C", "F", 3);

        List<ArrayList<String>> disjointSet = unionFind.getDisjointSet();
        assertEquals(2, disjointSet.size());

        //[A,B,C,F]
        List<String> set0 = disjointSet.get(0);
        for (String vertice : set0) {
            System.out.println("Set 0 " + vertice);
        }
        assertEquals(4, set0.size());

        //[D,E]
        List<String> set1 = disjointSet.get(1);
        assertEquals(2, set1.size());

        for (String vertice : set1) {
            System.out.println("Set 1 " + vertice);
        }
    }
    
    public void testFindBaseCase() {

        unionFind.setVertice("A");
        unionFind.setVertice("B");
        unionFind.setVertice("C");
        unionFind.setVertice("D");
        unionFind.setVertice("E");
        unionFind.setVertice("F");

        unionFind.addEdge("A", "C", 1);
        unionFind.addEdge("E", "F", 3);
        unionFind.addEdge("C", "D", 2);
        unionFind.addEdge("B", "E", 2);

        /*
 		 * [A,C,D]
 		 * [B,E,F]
 		 * */
        List<ArrayList<String>> disjointSet = unionFind.getDisjointSet();
        assertEquals(2, disjointSet.size());

        List<String> set0 = disjointSet.get(0);
        assertEquals(3, set0.size());

        List<String> set1 = disjointSet.get(1);
        assertEquals(3, set1.size());
    }

    //@Test
    public void testDFSInConnectedGraph() {

        unionFind.setVertice("A");
        unionFind.setVertice("B");
        unionFind.setVertice("C");
        unionFind.setVertice("D");
        unionFind.setVertice("E");
        unionFind.setVertice("F");

        unionFind.addEdge("A", "C", 1);
        unionFind.addEdge("A", "E", 2);
        unionFind.addEdge("E", "F", 3);
        unionFind.addEdge("C", "D", 2);
        unionFind.addEdge("B", "E", 2);
        List<Edge> edges = unionFind.dfsAlgorithmForDisjoint(unionFind.vertices, unionFind.edges);
        assertEquals(5, edges.size());
        for (Edge edge : edges) {
            System.out.println("Edge DFS " + edge);
        }
    }
    
    
    public void testDFSInDisConnectedGraph() {
        unionFind.setVertice("A");
        unionFind.setVertice("B");
        unionFind.setVertice("C");
        unionFind.setVertice("D");
        unionFind.setVertice("E");
        unionFind.setVertice("F");

        unionFind.addEdge("A", "C", 1);
        //unionFind.addEdge("A","E",2);
        unionFind.addEdge("E", "F", 3);
        unionFind.addEdge("C", "D", 2);
        unionFind.addEdge("D", "E", 2);
        List<Edge> edges = unionFind.dfsAlgorithmForDisjoint(unionFind.vertices, unionFind.edges);
        assertEquals(4, edges.size());

        for (Edge edge : edges) {
            System.out.println("Edge DFS Disconnected graph " + edge);
        }
    }
}
