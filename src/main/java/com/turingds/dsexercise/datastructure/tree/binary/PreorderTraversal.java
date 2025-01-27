/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kedk
 */
public class PreorderTraversal implements BinaryTreeTraversal {

    BinaryTree tree;
    ArrayList<Node> arrayList;

    public PreorderTraversal(BinaryTree tree) {
        this.tree = tree;
    }

    @Override
    public Iterator<Node> iterator() {
        return new TreeIterator();
    }

    public void traversePreOrder() {
        Node current = this.tree.root;
        this.traversePreOrderAction(current);
    }

    void traversePreOrderAction(Node current) {
        if (current != null) {
            System.out.println("Node: " + current.getValue());
            this.arrayList.add(current);
        }
        if (current.getLeftChild() != null) {
            this.traversePreOrderAction(current.getLeftChild());
        }
        if (current.getRightChild() != null) {
            this.traversePreOrderAction(current.getRightChild());
        }
    }

    class TreeIterator implements Iterator<Node> {

        int currentIndex = 0;

        TreeIterator() {
            arrayList = new ArrayList<Node>();
            traversePreOrder();
        }

        @Override
        public boolean hasNext() {
            return currentIndex <= arrayList.size();
        }

        @Override
        public Node next() {
            return arrayList.get(currentIndex++);
        }

    }

}
