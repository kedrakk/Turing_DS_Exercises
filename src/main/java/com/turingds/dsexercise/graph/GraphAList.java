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
class GraphAList {

    List<String> vertices = new ArrayList<>();
    List<List<String>> adjancencyList = new ArrayList<>();

    void setVertice(String a) {
        if (!this.vertices.contains(a)) {
            this.vertices.add(a);
        }
    }

    void build() {
        for (String vertex : this.vertices) {
            List<String> adjList = new ArrayList<>();
            this.adjancencyList.add(adjList);
        }
    }

    void addEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        List<String> adjList = this.adjancencyList.get(fromIndex);
        adjList.add(to);
    }

    boolean existEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        List<String> adjList = this.adjancencyList.get(fromIndex);
        return adjList.contains(to);
    }
}
