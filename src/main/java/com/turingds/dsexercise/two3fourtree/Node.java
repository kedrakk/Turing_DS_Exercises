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
            return simpleInsert(item);
        } else {
            //spilt case
            Node splitParent = this.splitNode(this);

            //need to find leaf node to insert
        }
        return this;
    }

    private Node simpleInsert(int item) {
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
        return this;
    }

    protected Node splitNode(Node node) {
        //simple split
        if (node.parent == null) {
            return splitWithNoParent(node);
        }
        return node;
    }

    private Node splitWithNoParent(Node node) {
        Node current = new Node();
        current.insert(node.keys[1]);

        //spliting children
        Node child0 = new Node();
        child0.parent = current;
        child0.insert(node.keys[0]);

        Node child1 = new Node();
        child1.parent = current;
        child1.insert(node.keys[2]);

        current.children.add(child0);
        current.children.add(child1);

        return current;
    }

    Node search(int item) {
        Node current = this;
        int index = 0;
        while (index < current.keys.length && current.keys[index] != null) {
            if (current.keys[index] == item) {
                //found
                return current;
            }
            if (current.keys[index] > item) {
                break;
            }
            index++;
        }
        // go to deeper level
        if (current.children.isEmpty()) //leaf alr
        {
            return null;
        } else {
            System.out.println("Index:" + index);
            if (current.keys[index] == null) {
                return current.children.get(index);
            } else {
                return current.children.get(index);
            }
        }
//        return current;
    }
}
