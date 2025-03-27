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
class GraphAList extends Graph{

    List<List<String>> adjancencyList = new ArrayList<>();

    @Override
    void build() {
        for (String vertex : this.vertices) {
            List<String> adjList = new ArrayList<>();
            this.adjancencyList.add(adjList);
        }
    }

    @Override
    void addEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        List<String> adjList = this.adjancencyList.get(fromIndex);
        adjList.add(to);
        
        int toIndex = this.vertices.indexOf(to);
        adjList = this.adjancencyList.get(toIndex);
        adjList.add(from);
    }

    @Override
    boolean existEdge(String from, String to) {
        int fromIndex = this.vertices.indexOf(from);
        List<String> adjList = this.adjancencyList.get(fromIndex);
        return adjList.contains(to);
    }

    @Override
    List<String> getAdjacentVertex(String from) {
        int fromIndex = this.vertices.indexOf(from);
        List<String> adjList = this.adjancencyList.get(fromIndex);
        return adjList;
    }

}
