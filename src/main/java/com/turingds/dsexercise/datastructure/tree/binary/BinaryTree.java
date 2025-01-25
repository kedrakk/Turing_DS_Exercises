/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary;

/**
 *
 * @author kedk
 */
public class BinaryTree {

    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node search(int i) {
        Node current = this.root;
        while (current != null) {
            if (current.getValue() == i) {
                return current;
            } else if (current.getValue() > i) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return null;
    }

}
