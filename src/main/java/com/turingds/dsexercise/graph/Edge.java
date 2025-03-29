/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.graph;

/**
 *
 * @author kedk
 */
public class Edge implements Comparable<Edge> {

    String start;
    String end;
    int weight;

    public Edge(String start, String end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge another) {
        return this.weight - another.weight;
    }

    @Override
    public String toString() {
        return start + "-" + end + "=" + weight;
    }
}
