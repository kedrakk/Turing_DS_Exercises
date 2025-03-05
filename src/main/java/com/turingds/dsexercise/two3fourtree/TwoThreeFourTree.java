/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.two3fourtree;

/**
 *
 * @author kedk
 */
public class TwoThreeFourTree {

    Node root;

    protected Node insert(int i) {
        if (root == null) {
            root = this.createTwoNodes(root, i);
            return root;
        } else {
            Node node = this.root.searchForInsert(i);
            if (node.noOfNode != 4) {
                return node.insert(i);
            } else { //split 
                Node splitParent = node.splitNode(node);
                if (node.parent == null) {
                    this.root = splitParent;
                }
                node = this.root.searchForInsert(i);
                return node.insert(i);
            }
        }
    }

    protected Node getRoot() {
        return this.root;
    }

    public Node createTwoNodes(Node parent, int values) {
        Node node = new Node();
        node.keys[0] = values;
        node.parent = parent;
        node.noOfNode++;
        return node;
    }
}
