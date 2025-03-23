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
class GraphAMatrix {

    List<String> vertices = new ArrayList<>();
    int[][] matrix;

    void setVertice(String a) {
        if (!this.vertices.contains(a)) {
            this.vertices.add(a);
        }
    }

    void build() {
        int n = this.vertices.size();
        matrix = new int[n][n];
    }

    void addEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        this.matrix[fromIndex][toIndex] = 1;
        this.matrix[toIndex][fromIndex] = 1;
    }

    boolean existEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        int toIndex = this.vertices.indexOf(to);
        return this.matrix[fromIndex][toIndex] != 0;
    }

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

    List<String> depthFirstSearch() {
        List<String> visited = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        String root = this.vertices.get(0);
        stack.push(root);

        while (!stack.isEmpty()) {
            String currentVertex = stack.pop();
            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);
            }
            List<String> adjVertexs = this.getAdjacentVertex(currentVertex);
            //Collections.reverse(adjVertexs);
            for (int i = adjVertexs.size() - 1; i >= 0; i--) {
                String adjVertex = adjVertexs.get(i);
                if (!visited.contains(adjVertex)) {
                    stack.push(adjVertex);
                }
            }
        }

        return visited;
    }

}
