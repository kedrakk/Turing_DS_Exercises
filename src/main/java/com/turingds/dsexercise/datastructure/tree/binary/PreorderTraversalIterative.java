/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turingds.dsexercise.datastructure.tree.binary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author kedk
 */
public class PreorderTraversalIterative implements BinaryTreeTraversal {

    BinaryTree tree;
    ArrayList<Node> arrayList;

    public PreorderTraversalIterative(BinaryTree tree) {
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

    void traversePreOrderAction(Node node) {
        Node current = node;
        Stack<Node> stack = new Stack<>();
        while (current != null) {
            arrayList.add(current);
            if (current.getRightChild() != null) {
                stack.push(current.getRightChild());
            }
            if (current.getLeftChild() != null) {
                current = current.getLeftChild();
            } else if (!stack.isEmpty()) {
                current = stack.pop();
            } else {
                break;
            }
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
