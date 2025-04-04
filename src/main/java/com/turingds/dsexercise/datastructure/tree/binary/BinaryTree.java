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
public class BinaryTree {

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

    public Node getMinNode() {
        Node node = this.root;
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    public Node getMaxNode() {
        Node node = this.root;
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node;
    }

    public Node getSuccessorOf(int item) {
        Node current = this.search(item);
        if (current.getRightChild() != null) {
            Node successor = current.getRightChild();
            while (successor.getLeftChild() != null) {
                successor = successor.getLeftChild();
            }
            return successor;
        }
        return null;
    }

    public Node deleteNode(int i) {
        Node nodeToDelete = this.search(i);
        if (nodeToDelete.isLeaf()) {
            deleteLeaf(nodeToDelete);
        } else if (nodeToDelete.isOnlyOneChild()) {
            if (nodeToDelete.getParent() == null)//root
            {
                deleteRoot(nodeToDelete);
            } else {
                nodeToDelete = deleteNodeWithOnlyChild(nodeToDelete);
            }
        } else {
            nodeToDelete = deleteNodeWithSuccessor(nodeToDelete);
        }
        return nodeToDelete;
    }

    private Node deleteNodeWithSuccessor(Node nodeToDelete) {
        Node nodeToReturn = new Node(nodeToDelete.getValue());
        Node successor = this.getSuccessorOf(nodeToDelete.getValue());
        int successorValue = successor.getValue();
        this.deleteNode(successorValue);
        nodeToDelete.setValue(successorValue);
        nodeToDelete = nodeToReturn;
        return nodeToDelete;
    }

    private Node deleteNodeWithOnlyChild(Node nodeToDelete) {
        //delete non-root
        if (nodeToDelete.leftChild != null) {
            
            Node nodeToReturn = new Node(nodeToDelete.getValue());
            
            nodeToDelete.setValue(nodeToDelete.leftChild.getValue());
            nodeToDelete.leftChild = null;
            
            nodeToDelete = nodeToReturn;
        } else if (nodeToDelete.rightChild != null) {
            
            Node nodeToReturn = new Node(nodeToDelete.getValue());
            
            nodeToDelete.setValue(nodeToDelete.rightChild.getValue());
            nodeToDelete.rightChild = null;
            
            nodeToDelete = nodeToReturn;
        }
        return nodeToDelete;
    }

    private void deleteRoot(Node nodeToDelete) {
        if (nodeToDelete.getLeftChild() != null) {
            this.root = nodeToDelete.getLeftChild();
        }
        if (nodeToDelete.getRightChild() != null) {
            this.root = nodeToDelete.getRightChild();
        }
    }

    private void deleteLeaf(Node nodeToDelete) {
        Node parent = nodeToDelete.getParent();
        if (parent.getLeftChild() == nodeToDelete) {
            parent.leftChild = null;
        }
        if (parent.getRightChild() == nodeToDelete) {
            parent.rightChild = null;
        }
    }

}
