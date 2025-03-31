/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author kedk
 */
public class GraphEdgeRep {

    List<String> vertices = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    private List<Edge> visitedEdges = new ArrayList<>();

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

    public List<Edge> getAdjacentEdges(String vertex) {
        List<Edge> adjacentEdges = new ArrayList<>();
        for (Edge edge : this.edges) {
            if (vertex.equals(edge.start) || vertex.equals(edge.end)) {
                adjacentEdges.add(edge);
            }
        }
        return adjacentEdges;
    }

    public List<Edge> getAdjacentEdgesWhichNotVisited(String vertex) {
        List<Edge> adjacentEdges = new ArrayList<>();
        for (Edge edge : this.edges) {
            if (!this.visitedEdges.contains(edge)) {
                if (vertex.equals(edge.start) || vertex.equals(edge.end)) {
                    adjacentEdges.add(edge);
                }
            }
        }
        return adjacentEdges;
    }

    public void markedVisited(Edge edge) {
        this.visitedEdges.add(edge);
    }

    public List<String> getAdjacentVerticesWhichNotVisited(String from) {
        List<String> adjVertices = new ArrayList<>();
        List<Edge> adjNonVisitedEdges = this.getAdjacentEdgesWhichNotVisited(from);
        for (Edge edge : adjNonVisitedEdges) {
            if (from.equals(edge.start)) {
                adjVertices.add(edge.end);
            } else {
                adjVertices.add(edge.start);
            }
        }
        Collections.sort(adjVertices);
        return adjVertices;
    }

    public List<Edge> dfsAlgorithm() {
        List<Edge> visited = new ArrayList<>();
        Stack<Edge> stack = new Stack<>();
        String current = this.vertices.get(0);

        List<Edge> adjEdges = this.getAdjacentEdgesWhichNotVisited(current);
        stack.push(adjEdges.get(0));

        while (!stack.isEmpty()) {
            Edge currentEdge = stack.pop();
            visited.add(currentEdge);
            this.markedVisited(currentEdge);

            adjEdges = this.getAdjacentEdgesWhichNotVisited(currentEdge.end);
            for (int i = adjEdges.size() - 1; i <= 0; i--) {
                stack.push(adjEdges.get(i));
            }
        }

        return visited;
    }
}
