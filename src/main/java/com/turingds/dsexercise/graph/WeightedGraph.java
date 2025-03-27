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
    
    public List<String> primAlgorithm(){
        List<String> visited = new ArrayList<>();
        String firstVertex = this.vertices.get(0);
        
        visited.add(firstVertex);
        
        int noOfVertex = this.vertices.size();
        int noOfEdge = 0;
        
        return visited;
    }
}
