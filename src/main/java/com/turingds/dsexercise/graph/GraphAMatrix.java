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
class VertexDistance implements Comparable<VertexDistance> {

    String vertex;
    double totalDistance;

    public VertexDistance(String vertex, double totalDistance) {
        this.vertex = vertex;
        this.totalDistance = totalDistance;
    }

    @Override
    public int compareTo(VertexDistance o) {
        return (int) (this.totalDistance - o.totalDistance);
    }

}

class GraphAMatrix extends Graph {

    int[][] matrix;

    double[] weights;
    String[] previous;

    @Override
    void build() {
        int n = this.vertices.size();
        matrix = new int[n][n];
        this.weights = new double[n];
        this.previous = new String[n];
    }

    @Override
    void addEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        this.matrix[fromIndex][toIndex] = 1;
        this.matrix[toIndex][fromIndex] = 1;
    }

    void addEdge(String from, String to, int weight) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);

        this.matrix[fromIndex][toIndex] = weight;
        this.matrix[toIndex][fromIndex] = weight;
    }

    @Override
    boolean existEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        return this.matrix[fromIndex][toIndex] != 0 || this.matrix[toIndex][fromIndex] != 0;
    }

    @Override
    List<String> getAdjacentVertex(String from) {
        List<String> vertexs = new ArrayList<>();
        for (String currentVertex : this.vertices) {
            if (!from.equals(currentVertex)) {
                if (this.existEdge(from, currentVertex)) {
                    vertexs.add(currentVertex);
                }
            }
        }
        return vertexs;
    }

    double getTotalDistance(String vertex) {
        Integer vertexIndex = this.vertices.indexOf(vertex);
        String previousVertex;
        double distance = 0;
        do {
            distance += this.weights[vertexIndex];
            previousVertex = this.previous[vertexIndex];
            if (previousVertex != null) {
                vertexIndex = this.vertices.indexOf(previousVertex);
            }
        } while (previousVertex != null);
        return distance;
    }

    VertexDistance getVerticesWithSmallestDistanceFromUnvisited(List<String> unvisited) {
        List<VertexDistance> vertexAndDistanceArray = new ArrayList<>();
        for (String vtx : unvisited) {
            double totalDistance = getTotalDistance(vtx);
            VertexDistance vtxDistance = new VertexDistance(vtx, totalDistance);
            vertexAndDistanceArray.add(vtxDistance);
        }

        Collections.sort(vertexAndDistanceArray);
        return vertexAndDistanceArray.get(0);
    }

    public void initDijkstra() {
        for (int i = 0; i < this.weights.length; i++) {
            this.weights[i] = Double.POSITIVE_INFINITY;
        }
        this.weights[0] = 0;
    }

    public void addTotalWeightToVertex(String vertex, double weight) {
        int vtxIndex = this.vertices.indexOf(vertex);
        this.weights[vtxIndex] = weight;
    }

    void addTotalWeightToVerticeWithPrevious(String vertice, double weight, String previous) {
        int index = this.vertices.indexOf(vertice);
        this.weights[index] = weight;
        this.previous[index] = previous;
    }

    List<String> getUnvisitedNeighborOfVertex(String from, List<String> unvisited) {
        List<String> unvisitedNeighbor = new ArrayList<>();
        for (String vertex : this.vertices) {
            if (unvisited.contains(vertex) && this.existEdge(from, vertex)) {
                unvisitedNeighbor.add(vertex);
            }
        }
        return unvisitedNeighbor;
    }

    public String[] dijkstraAlgorithm() {
        this.initDijkstra();
        List<String> unvisited = new ArrayList<>();
        for (String vertex : this.vertices) {
            unvisited.add(vertex);
        }
        while (!unvisited.isEmpty()) {
            VertexDistance vtxDistance = this.getVerticesWithSmallestDistanceFromUnvisited(unvisited);
            unvisited.remove(vtxDistance.vertex);

            List<String> neighbors = this.getUnvisitedNeighborOfVertex(vtxDistance.vertex, unvisited);
            for (String neighbor : neighbors) {
                int index = this.vertices.indexOf(vtxDistance.vertex);
                int neighborIndex = this.vertices.indexOf(neighbor);
                double alt = this.weights[index] + this.matrix[index][neighborIndex];

                if (alt < this.weights[neighborIndex]) {
                    this.weights[neighborIndex] = alt;
                    this.previous[neighborIndex] = vtxDistance.vertex;
                }
            }
        }
        return this.previous;
    }

}
