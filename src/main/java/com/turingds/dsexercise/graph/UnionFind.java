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
class UnionFind extends GraphEdgeRep {

    void addVertex(String a) {
        this.vertices.add(a);
    }

    public List<String> getAdjacentNotVisitedVerticesFrom(String vertices) {
        List<String> adjacentVertices = new ArrayList<>();
        return adjacentVertices;
    }

    public List<Edge> getEdgeRechableFromVertices(String vertex, List<Edge> edgeList) {
        List<Edge> adjEdges = new ArrayList<>();
        for (Edge edge : this.edges) {
            if (edge.start.equals(vertex) || edge.end.equals(vertex)) {
                adjEdges.add(edge);
            }
        }
        return adjEdges;
    }

    public List<Edge> getAdjacentEdgesWhichisNotVisited(String vertex, List<Edge> edgeList, List<Edge> visited) {
        List<Edge> reachableEdges = new ArrayList<>();

        for (Edge edge : edges) {
            if (!visited.contains(edge)) {
                if (vertex.equals(edge.start) || vertex.equals(edge.end)) {
                    reachableEdges.add(edge);
                }
            }
        }
        return reachableEdges;
    }

    public List<Edge> dfsAlgorithmForDisjoint(List<String> vertices, List<Edge> edges) {
        List<Edge> visited = new ArrayList<>();
        Stack<Edge> stack = new Stack<>();
        String current = edges.get(0).start;

        List<Edge> adjancetEdge = this.getAdjacentEdgesWhichisNotVisited(current, visited, edges);
        for (int i = adjancetEdge.size() - 1; i >= 0; i--) {
            stack.push(adjancetEdge.get(i));
        }

        while (!stack.empty()) {
            Edge currentEdge = stack.pop();
            visited.add(currentEdge);
            this.markedVisited(currentEdge);

            List<Edge> adjancetEdges = this.getAdjacentEdgesWhichisNotVisited(currentEdge.end, visited, edges);
            for (int i = adjancetEdges.size() - 1; i >= 0; i--) {
                stack.push(adjancetEdges.get(i));
            }
        }

        return visited;
    }

    public ArrayList<String> getAllVerticesFromEdges(List<Edge> edges) {
        ArrayList<String> curVertices = new ArrayList<>();
        for (Edge edge : edges) {
            if (!curVertices.contains(edge.start)) {
                curVertices.add(edge.start);
            }
            if (!curVertices.contains(edge.end)) {
                curVertices.add(edge.end);
            }
        }
        return curVertices;
    }

    public List<ArrayList<String>> getDisjointSet() {
        List<ArrayList<String>> disjointSet = new ArrayList<>();

        List<Edge> curEdges = new ArrayList<>();
        for (Edge edge : this.edges) {
            curEdges.add(edge);
        }

        while (!curEdges.isEmpty()) {
            List<Edge> dsfEdges = this.dfsAlgorithmForDisjoint(this.vertices, curEdges);
            ArrayList<String> disjointVertices = this.getAllVerticesFromEdges(dsfEdges);
            Collections.sort(disjointVertices);
            curEdges.removeAll(dsfEdges);

            if (!disjointVertices.isEmpty()) {
                disjointSet.add(disjointVertices);
            }
        }
        return disjointSet;
    }

}
