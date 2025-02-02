/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary;

/**
 *
 * @author kedk
 */
public class Node {

    private int value;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the leftChild
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(Node leftChild) {
        leftChild.setParent(this);
        this.leftChild = leftChild;
    }

    /**
     * @return the rightChild
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(Node rightChild) {
        rightChild.setParent(this);
        this.rightChild = rightChild;
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isSubTree() {
        return this.getLeftChild() != null || this.getRightChild() != null;
    }
}
