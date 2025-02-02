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
public class InorderTraversalImperative implements BinaryTreeTraversal {

    BinaryTree tree;
    ArrayList<Node> arrayList;

    public InorderTraversalImperative(BinaryTree tree) {
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

    void traverseInOrderAction(Node node) {
        Node current = node;
        Stack<Node> stack = new Stack<>();
        while (current != null) {

            while (current.getLeftChild() != null) {
                stack.push(current);
                current = current.getLeftChild();
            }
            System.out.println("Node: " + current.getValue());
            this.arrayList.add(current);

            if (current.getRightChild() != null) {
                current = current.getRightChild();
            } else if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.println("Node: " + current.getValue());
                this.arrayList.add(current);
                if (current.getRightChild() != null) {
                    current = current.getRightChild();
                }

            } else {
                break;
            }

//            if (current.isSubTree()) {
//                stack.push(current);
//            }
//            if (current.getLeftChild() != null) {
//                stack.push(current);
//                current = current.getLeftChild();
//            } else {
//                System.out.println("Current: " + current.getValue());
//                this.arrayList.add(current);
//                if (!stack.isEmpty()) {
//                    current = stack.pop();
//                    this.arrayList.add(current);
//                    if (current.getRightChild() != null) {
//                        current = current.getRightChild();
//                    }
//                } else {
//                    break;
//                }
//            }
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
            return currentIndex <= arrayList.size();
        }

        @Override
        public Node next() {
            return arrayList.get(currentIndex++);
        }

    }

}
