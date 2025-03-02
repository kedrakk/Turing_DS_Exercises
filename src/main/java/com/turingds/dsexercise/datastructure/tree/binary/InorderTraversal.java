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
public class InorderTraversal implements BinaryTreeTraversal {

    BinaryTree tree;
    ArrayList<Node> arrayList;

    public InorderTraversal(BinaryTree tree) {
        this.tree = tree;
    }

    @Override
    public Iterator<Node> iterator() {
        return new TreeIterator();
    }

    public void traverseInOrder() {
        Node current = this.tree.root;
        this.traverseInOrderAction(current);
    }

    void traverseInOrderAction(Node current) {
        if (current.getLeftChild() != null) {
            this.traverseInOrderAction(current.getLeftChild());
        }
        if (current != null) {
            System.out.println("Node: " + current.getValue());
            this.arrayList.add(current);
        }
        if (current.getRightChild() != null) {
            this.traverseInOrderAction(current.getRightChild());
        }
    }

    class TreeIterator implements Iterator<Node> {

        int currentIndex = 0;

        TreeIterator() {
            arrayList = new ArrayList<>();
            traverseInOrder();
        }

        @Override
        public boolean hasNext() {
            return currentIndex <= arrayList.size() - 1;
        }

        @Override
        public Node next() {
            return arrayList.get(currentIndex++);
        }

    }

}
