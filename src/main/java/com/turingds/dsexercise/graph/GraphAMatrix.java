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
class GraphAMatrix extends Graph{
    int[][] matrix;

    @Override
    void build() {
        int n = this.vertices.size();
        matrix = new int[n][n];
    }

    @Override
    void addEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        this.matrix[fromIndex][toIndex] = 1;
        this.matrix[toIndex][fromIndex] = 1;
    }

    @Override
    boolean existEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        return this.matrix[fromIndex][toIndex] != 0;
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

}
