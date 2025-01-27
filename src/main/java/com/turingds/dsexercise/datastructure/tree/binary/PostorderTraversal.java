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
public class PostorderTraversal implements BinaryTreeTraversal {

    BinaryTree tree;
    ArrayList<Node> arrayList;

    public PostorderTraversal(BinaryTree tree) {
        this.tree = tree;
    }

    @Override
    public Iterator<Node> iterator() {
        return new TreeIterator();
    }

    public void traversePostOrder() {
        Node current = this.tree.root;
        this.traversePostOrderAction(current);
    }

    void traversePostOrderAction(Node current) {
        if (current.getLeftChild() != null) {
            this.traversePostOrderAction(current.getLeftChild());
        }
        if (current.getRightChild() != null) {
            this.traversePostOrderAction(current.getRightChild());
        }
        if (current != null) {
            System.out.println("Node: " + current.getValue());
            this.arrayList.add(current);
        }
    }

    class TreeIterator implements Iterator<Node> {

        int currentIndex = 0;

        TreeIterator() {
            arrayList = new ArrayList<>();
            traversePostOrder();
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
