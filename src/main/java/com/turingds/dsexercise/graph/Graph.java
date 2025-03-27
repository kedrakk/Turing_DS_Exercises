/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author kedk
 */
public abstract class Graph {

    List<String> vertices = new ArrayList<>();

    abstract void build();

    abstract List<String> getAdjacentVertex(String from);

    abstract void addEdge(String from, String to);

    abstract boolean existEdge(String from, String to);

    void setVertice(String a) {
        if (!this.vertices.contains(a)) {
            this.vertices.add(a);
        }
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

    List<String> breathFirstSearch() {
        List<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        String root = this.vertices.get(0);
        queue.add(root);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);
            }
            List<String> adjVertexs = this.getAdjacentVertex(currentVertex);
            for (String adjVertex: adjVertexs) {
                if (!visited.contains(adjVertex)) {
                    queue.add(adjVertex);
                }
            }
        }

        return visited;
    }

}
