/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kedk
 */
public class GraphEdgeRep {

    List<String> vertices = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();

    public void setVertice(String a) {
        if (!this.vertices.contains(a)) {
            this.vertices.add(a);
        }
    }

    public Edge addEdge(String start, String end, int weight) {
        int comparatorResult = start.compareTo(end);
        String small = "", large = "";
        if (comparatorResult < 0) {
            small = start;
            large = end;
        } else if (comparatorResult > 0) {
            small = end;
            large = start;
        }
        Edge edge = new Edge(small, large, weight);
        this.edges.add(edge);
        return edge;
    }
}
