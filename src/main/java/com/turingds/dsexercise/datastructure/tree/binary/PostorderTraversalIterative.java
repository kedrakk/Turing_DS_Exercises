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
public class PostorderTraversalIterative implements BinaryTreeTraversal {

    BinaryTree tree;
    ArrayList<Node> arrayList;

    public PostorderTraversalIterative(BinaryTree tree) {
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

    void traversePostOrderAction(Node node) {
        Node current = node;
        Stack<Node> recursiveStack = new Stack<>();
        Stack<Node> reverseStack = new Stack<>();

        recursiveStack.add(current);
        while (!recursiveStack.empty()) {
            Node item = recursiveStack.pop();
            reverseStack.push(item);

            if (item.getLeftChild() != null) {
                recursiveStack.push(item.getLeftChild());
            }
            if (item.getRightChild() != null) {
                recursiveStack.push(item.getRightChild());
            }
        }

        while (!reverseStack.empty()) {
            this.arrayList.add(reverseStack.pop());
        }

//        ArrayList<Node> visited = new ArrayList<>();
//        while (current != null) {
//
//            while (current.getLeftChild() != null) {
//                recursiveStack.push(current);
//                current = current.getLeftChild();
//            }
//
//            this.arrayList.add(current);
//
//            if (!recursiveStack.isEmpty()) {
//                Node backTrack = recursiveStack.pop();
//
//                if (!visited.contains(backTrack)) {
//                    recursiveStack.push(backTrack);
//                    visited.add(backTrack);
//                } else {
//                    this.arrayList.add(backTrack);
//                    if (!recursiveStack.empty()) {
//                        current = recursiveStack.pop();
//                        continue;
//                    } else {
//                        break;
//                    }
//                }
//
//                if (backTrack.getRightChild() != null) {
//                    current = backTrack.getRightChild();
//                    visited.add(backTrack.getRightChild());
//                }else{
//                    this.arrayList.add(backTrack);
//                    break;
//                }
//            } else {
//                break;
//            }
//        }
    }

    class TreeIterator implements Iterator<Node> {

        int currentIndex = 0;

        TreeIterator() {
            arrayList = new ArrayList<>();
            traversePostOrder();
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
