/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary;

import java.util.Iterator;

/**
 *
 * @author kedk
 */
public class BinaryTree{
    
    Node root;
    
    public BinaryTree(Node root) {
        this.root = root;
    }
    
    public Node search(int i) {
        //! Loop implementation
//        Node current = this.root;
//        while (current != null) {
//            if (current.getValue() == i) {
//                return current;
//            } else if (current.getValue() > i) {
//                current = current.getLeftChild();
//            } else {
//                current = current.getRightChild();
//            }
//        }
//        return null;

        //! Recursive implementation
        return this.searchUsingRecursive(i, this.root);
    }
    
    public Node searchUsingRecursive(int item, Node current) {
        if (current == null) {
            return null;
        }
        if (current.getValue() == item) {
            return current;
        } else if (current.getValue() < item) {
            return this.searchUsingRecursive(item, current.getRightChild());
        } else if (current.getValue() > item) {
            return this.searchUsingRecursive(item, current.getLeftChild());
        } else {
            return null;
        }
    }
    
    public Node insert(int i) {
        Node nodeToInsert = new Node(i);
        Node current = this.root;
        Node parent = current;
        while (current != null) {
            parent = current;
            if (current.getValue() < i) {
                current = current.getRightChild();
            } else {
                current = current.getLeftChild();
            }
        }
        
        if (parent.getValue() < i) {
            parent.setRightChild(nodeToInsert);
        } else {
            parent.setLeftChild(nodeToInsert);
        }
        return nodeToInsert;
    }
    
    
}
