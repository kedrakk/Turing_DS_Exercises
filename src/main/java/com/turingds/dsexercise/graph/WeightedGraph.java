/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kedk
 */
public class WeightedGraph extends GraphAMatrix {

    int MAX_WEIGHT = 9999;

    void build() {
        int n = this.vertices.size();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = MAX_WEIGHT;
            }
        }
    }

    void addEdge(String from, String to, int weight) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        this.matrix[fromIndex][toIndex] = weight;
        this.matrix[toIndex][fromIndex] = weight;
    }

    boolean existEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        return this.matrix[fromIndex][toIndex] != MAX_WEIGHT;
    }

    public void markVisited(List<String> visitedVertices) {
        if (visitedVertices.size() > 1) {
            for (int i = 0; i < visitedVertices.size() - 1; i++) {
                String from = visitedVertices.get(i);
                String to = visitedVertices.get(i + 1);
                this.markVisited(from, to);
            }
        }
    }

    void markVisited(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        this.matrix[fromIndex][toIndex] = MAX_WEIGHT;
        this.matrix[toIndex][fromIndex] = MAX_WEIGHT;
    }

    public List<Edge> getAdjencentVerticesForGraph(List<String> graphNodes) {
        this.markVisited(graphNodes);
        List<Edge> adjacentVertices = new ArrayList<>();
        if (graphNodes.size() == 1) {
            String startVertex = graphNodes.get(0);
            getAdjacentVertexFromNode(startVertex, adjacentVertices);
        } else if (graphNodes.size() > 1) {
            String startVertex = graphNodes.get(0);
            String endVertex = graphNodes.get(graphNodes.size() - 1);
            getAdjacentVertexFromNode(startVertex, adjacentVertices);
            getAdjacentVertexFromNode(endVertex, adjacentVertices);
        }
        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }

    private void getAdjacentVertexFromNode(String startVertex, List<Edge> adjacentVertices) {
        System.out.println("Start vertex " + startVertex);
        for (String vertex : vertices) {
            if (!startVertex.equals(vertex)) {
                int fromVertex = this.vertices.indexOf(startVertex);
                int toIndex = this.vertices.indexOf(vertex);
                if (this.existEdge(startVertex, vertex)) {
                    System.out.println("Edge start " + startVertex + " end " + vertex);
                    int weight = this.matrix[fromVertex][toIndex];
                    Edge edge = new Edge(startVertex, vertex, weight);
                    adjacentVertices.add(edge);
                }
            }
        }
    }

    public List<String> primAlgorithm() {
        List<String> visited = new ArrayList<>();
        String firstVertex = this.vertices.get(0);

        visited.add(firstVertex);

        int noOfVertices = this.vertices.size();
        int noOfEdge = 0;

        while (noOfEdge < noOfVertices - 1) {
            List<Edge> edgeList = this.getAdjencentVerticesForGraph(visited);
            Edge smallestEdge = edgeList.get(0);

            String startVertex = visited.get(0);
            String endVertex = visited.get(visited.size() - 1);

            if (smallestEdge.start.equals(endVertex)) {
                visited.add(smallestEdge.end);
            } else if (smallestEdge.start.equals(startVertex)) {
                visited.add(0, smallestEdge.end);
            }
            noOfEdge++;
        }

        return visited;
    }
}
