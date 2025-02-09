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

//    void traversePostOrderAction(Node node) {
//        Stack<Node> stack = new Stack<>();
//        ArrayList<Node> visited = new ArrayList<Node>();
//        Node current = node;
//        while (current != null) {
//            while (current.getLeftChild() != null) {
//                System.out.println("push " + current.getValue());
//                stack.push(current);
//                current = current.getLeftChild();
//            }
//            if (current.getRightChild() != null) {
//                System.out.println("Right child case");
//            }
//            System.out.println("Node " + current.getValue());
//            arrayList.add(current);
//
//            if (!stack.empty())//left deadend or right deadend
//            {
//                Node backtrackNode = stack.pop();
//
//                if (!visited.contains(backtrackNode)) {
//                    System.out.println("Not visited, push " + backtrackNode.getValue());
//                    stack.push(backtrackNode);
//                    visited.add(backtrackNode);
//                } else //process root
//                {
//                    arrayList.add(backtrackNode);
//                    System.out.println("Backtrack node");
//                    System.out.println("Node " + backtrackNode.getValue());
//                    if (!stack.empty()) {
//                        current = stack.pop();
//                        continue;
//                    } else {
//                        break;
//                    }
//
//                }
//
//                if (backtrackNode.getRightChild() != null) {
//
//                    System.out.println("Go to right child of " + backtrackNode.getValue());
//
//                    current = backtrackNode.getRightChild();
//                    visited.add(backtrackNode.getRightChild());
//                } else //no right child process root
//                {
//                    System.out.println("This case " + backtrackNode.getValue());
//                    //current = backtrackNode;
//                    System.out.println("Node " + backtrackNode.getValue());
//                    arrayList.add(backtrackNode);
//                    break;
//                }
//            } else {
//                break;
//            }
//        }

    void traversePostOrderAction(Node node) {
        Node current = node;
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> visited = new ArrayList<>();
        while (current != null) {

            while (current.getLeftChild() != null) {
                stack.push(current);
                current = current.getLeftChild();
            }

            this.arrayList.add(current);

            if (!stack.isEmpty()) {
                Node backTrack = stack.pop();

                if (!visited.contains(backTrack)) {
                    stack.push(backTrack);
                    visited.add(backTrack);
                } else {
                    this.arrayList.add(backTrack);
                    if (!stack.empty()) {
                        current = stack.pop();
                        continue;
                    } else {
                        break;
                    }
                }

                if (backTrack.getRightChild() != null) {
                    current = backTrack.getRightChild();
                    visited.add(backTrack.getRightChild());
                }else{
                    this.arrayList.add(backTrack);
                    break;
                }
            } else {
                break;
            }
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
            return currentIndex <= arrayList.size() - 1;
        }

        @Override
        public Node next() {
            return arrayList.get(currentIndex++);
        }

    }

}
