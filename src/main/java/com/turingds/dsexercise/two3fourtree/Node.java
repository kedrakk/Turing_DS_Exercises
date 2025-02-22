/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.two3fourtree;

import java.util.ArrayList;

/**
 *
 * @author kedk
 */
public class Node {

    Node parent;
    Integer[] keys = new Integer[3];
    ArrayList<Node> children = new ArrayList<>();
    int noOfNode = 1;
    static int ORDER = 4;

    public Node insert(int item) {
        if (noOfNode != 4) {
            int index = 0;
            while (index < keys.length && keys[index] != null) {
                if (keys[index] > item) {
                    break;
                }
                index++;
            }

            for (int i = keys.length - 1; i > index; i--) {
                keys[i] = keys[i - 1];
            }
            keys[index] = item;
            noOfNode++;
        }
        return this;
    }
}
